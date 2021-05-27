package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Language;
import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    Iterable<Subject> findAllByLanguage(Language language);

    Iterable<Subject> findAllByCEFR(String CEFR);

    Iterable<Subject> findAllByTeacher(Teacher teacher);

    Iterable<Subject> findAllByLanguageAndCEFR(Language language, String CEFR);

    Iterable<Subject> findAllByName(String name);
}
