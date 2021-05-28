package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, String> {
    Users findByLogin(String login);
}
