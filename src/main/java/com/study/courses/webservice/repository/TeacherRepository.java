package com.study.courses.webservice.repository;

import com.study.courses.webservice.domain.Subject;
import com.study.courses.webservice.domain.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Optional<Teacher> findBySubjectsIs(Subject subject);
}
