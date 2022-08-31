package com.learning.mongo.Customer.Collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "consumerDB")
public class Customer {
    @Id
    private String _Id;
    private String customerName;
    private String customerEmail;
    private String customerMobile;
}
