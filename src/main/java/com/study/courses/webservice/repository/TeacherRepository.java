package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
