package com.learning.mongo.Customer.repo;

import com.learning.mongo.Customer.Collections.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepo extends MongoRepository<Person,String> {
}
