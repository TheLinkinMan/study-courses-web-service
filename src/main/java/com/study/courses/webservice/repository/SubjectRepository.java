package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Language;
import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubjectRepository extends MongoRepository<Subject, String> {
    void deleteAllByLanguage(Language language);

    List<Subject> findAllByLanguage(Language language);

    List<Subject> findAllByCEFR(String CEFR);

    List<Subject> findAllByTeacher(Teacher teacher);

    List<Subject> findAllByLanguageAndCEFR(Language language, String CEFR);

    List<Subject> findAllByName(String name);
}
