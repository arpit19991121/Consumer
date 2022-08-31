package com.learning.mongo.Customer.Collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "persons")
public class Person {
    @Id
    private String _id;
    private int index;
    private String name;
    private Boolean isActive;
    private Date registered;
    private int age;
    private String eyeColor;
    private String favoriteColor;
    private Company company;
}