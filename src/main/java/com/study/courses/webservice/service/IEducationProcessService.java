package com.study.courses.webservice.service;

import com.study.courses.webservice.domain.*;

public interface IEducationProcessService {
    Avatar save(Avatar avatar);

    Language save(Language language);

    Subject save(Subject subject);

    Student save(Student student);

    Teacher save(Teacher teacher);

    Users save(Users user);


    void delete(Avatar avatar);

    void delete(Subject subject);

    void delete(Student student);

    void delete(Teacher teacher);

    void delete(Language language);
}
