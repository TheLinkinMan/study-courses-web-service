package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
