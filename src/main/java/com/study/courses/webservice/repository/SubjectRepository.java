package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, String> {
}
