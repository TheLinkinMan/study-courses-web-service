package com.study.courses.webservice.service;

import com.study.courses.webservice.model.*;

import java.util.List;

public interface IEducationProcessService {
    Avatar save(Avatar avatar);

    Language save(Language language);

    Subject save(Subject subject);

    Student save(Student student);

    Teacher save(Teacher teacher);

    User save(User user);


    void delete(Avatar avatar);

    void delete(Subject subject);

    void delete(Student student);

    void delete(Teacher teacher);

    void delete(Language language);
}
