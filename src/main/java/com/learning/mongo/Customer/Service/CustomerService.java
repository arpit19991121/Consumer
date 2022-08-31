package com.learning.mongo.Customer.Service;

import com.learning.mongo.Customer.Collections.Customer;
import com.learning.mongo.Customer.Response.CustomerDTO;
import com.learning.mongo.Customer.Response.PersonDTO;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;

import java.util.List;

public interface CustomerService {
    String insertData(Customer customer);
    String updateData(String customerName, Customer customer);
    String deleteData(String customerName);
    List<CustomerDTO> showData();

    AggregateIterable<Document> usingAggregateShowData();
}
