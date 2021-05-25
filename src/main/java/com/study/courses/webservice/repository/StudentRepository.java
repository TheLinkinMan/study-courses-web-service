package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
