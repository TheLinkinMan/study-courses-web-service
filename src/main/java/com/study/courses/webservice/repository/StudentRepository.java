package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
