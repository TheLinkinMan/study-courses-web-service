package com.study.courses.webservice.service;

import com.study.courses.webservice.model.Language;
import com.study.courses.webservice.model.Student;
import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.model.Teacher;

import java.util.List;

public interface IEducationReaderService {
    List<Subject> findAllSubjects();

    List<Teacher> findAllTeachers();

    List<Subject> findAllSubjects(Language language);

    List<Subject> findAllSubjects(String CEFR);

    List<Subject> findAllSubjects(Teacher teacher);

    List<Subject> findAllSubjects(Language language, String CEFR);

    List<Subject> findAllSubjectsByName(String name);


    Subject findSubject(Long id);

    Teacher findTeacher(Long id);

    Teacher findTeacher(Subject subject);

    Language findLanguage(Long id);

    Student findStudent(Long id);
}
