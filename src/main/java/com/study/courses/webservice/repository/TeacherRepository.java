package com.study.courses.webservice.repository;

import com.study.courses.webservice.domain.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
