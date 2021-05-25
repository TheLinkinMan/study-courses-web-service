package com.study.courses.webservice.service;

import com.study.courses.webservice.model.*;

import java.util.List;

public interface IEducationProcessService {
    void save(Avatar avatar);

    void save(Language language);

    void save(Subject subject);

    void save(Student student);

    void save(Teacher teacher);

    void save(User user);


    void delete(Avatar avatar);

    void delete(Subject subject);

    void delete(Student student);

    void delete(Teacher teacher);

    void delete(Language language);

    void deleteAllSubjectByLanguage(Language language);
}
