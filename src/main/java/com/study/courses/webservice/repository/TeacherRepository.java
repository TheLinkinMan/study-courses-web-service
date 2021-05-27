package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Optional<Teacher> findBySubjectsIs(Subject subject);
}
