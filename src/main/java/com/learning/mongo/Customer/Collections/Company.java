package com.learning.mongo.Customer.Collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "company")
public class Company {
    @Id
    private int companyId;
    private String title;
    private String email;
    private String phone;
    private Location location;
}
