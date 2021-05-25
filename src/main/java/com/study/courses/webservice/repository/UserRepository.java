package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
