package com.learning.mongo.Customer.ServiceImplementation;

import com.learning.mongo.Customer.Collections.Customer;
import com.learning.mongo.Customer.Response.CustomerDTO;
import com.learning.mongo.Customer.Response.PersonDTO;
import com.learning.mongo.Customer.Service.CustomerService;
import com.learning.mongo.Customer.repo.CustomerRepo;
import com.learning.mongo.Customer.repo.PersonRepo;
import com.mongodb.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerImplementation implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    PersonRepo personRepo;
    @Override
    public String insertData(Customer customer) {
        customerRepo.save(customer);
        return "Customer record saved";
    }
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    MongoCollection<Document> mongoDatabase = mongoClient.getDatabase("myDB").getCollection("persons");
    @Override
    public String updateData(String customerName, Customer updatesNeeded) {
        Optional<Customer> userRecord = customerRepo.findByCustomerName(customerName);
        Customer updatedDetails = userRecord.get();
        updatedDetails.setCustomerEmail(updatesNeeded.getCustomerEmail());
        updatedDetails.setCustomerMobile(updatesNeeded.getCustomerMobile());
        customerRepo.save(updatedDetails);
        return "Customer records updated";
    }

    @Override
    public String deleteData(String customerName) {
        Optional<Customer> user = customerRepo.findByCustomerName(customerName);
        customerRepo.deleteById((user.get().get_Id()));
        return "Customer record deleted";
    }

    @Override
    public List<CustomerDTO> showData() {
        List<Customer> userList = customerRepo.findAll();
        List<CustomerDTO> showingList = new ArrayList<>();
        for (Customer user : userList) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setConsumerMobile(user.getCustomerMobile());
            customerDTO.setConsumerName(user.getCustomerName());
            showingList.add(customerDTO);
        }
        return showingList;
    }

    @Override
    public AggregateIterable<Document> usingAggregateShowData() {
        List<PersonDTO> showingList = new ArrayList<>();
        Document matchOperation = new Document("$match" , new Document("eyeColor", "green"));
        Document sortOperation = new Document("$sort", new Document("age",1));
        List<Document> pipeline = new ArrayList<>();
        pipeline.add(matchOperation);
        pipeline.add(sortOperation);
        AggregateIterable<Document> result = mongoDatabase.aggregate(pipeline);
        result.forEach(s -> System.out.println(s));
//       for (Person user : result) {
//            PersonDTO personDTO = new PersonDTO();
//         s   personDTO.setAge(user.getAge());
//            personDTO.setName(user.getName());
//            personDTO.setCompanyTitle(user.getCompany().getTitle());
//
//            showingList.add(personDTO);

//        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
//        }
        return result;
    }
}
