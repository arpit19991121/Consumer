package com.learning.mongo.Customer.Controller;

import com.learning.mongo.Customer.Collections.Customer;
import com.learning.mongo.Customer.Response.CustomerDTO;
import com.learning.mongo.Customer.Response.PersonDTO;
import com.learning.mongo.Customer.ServiceImplementation.CustomerImplementation;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerImplementation customerImplementation;

    @GetMapping("/insertCustomer")
    public String insertInfo(@RequestBody Customer customer){
        return customerImplementation.insertData(customer);
    }
    @PutMapping("/updateCustomer/{customerName}")
    public String updateInfo(@PathVariable String customerName, @RequestBody Customer customer){
        return customerImplementation.updateData(customerName, customer);
    }
    @DeleteMapping("/deleteCustomer/{customerName}")
    public String deleteInfo(@PathVariable String customerName){
        return customerImplementation.deleteData(customerName);
    }
    @GetMapping("/")
    public List<CustomerDTO> showAllUsers(){
        return customerImplementation.showData();
    }
    //Showing all persons using dto
    @GetMapping("/persons")
    public AggregateIterable<Document> showAll(){
         return customerImplementation.usingAggregateShowData();
    }

}
