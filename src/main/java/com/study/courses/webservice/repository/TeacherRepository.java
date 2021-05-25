package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Teacher findBySubjectsIs(Subject subject);
}
