package com.study.courses.webservice.service;

import com.study.courses.webservice.domain.Language;
import com.study.courses.webservice.domain.Student;
import com.study.courses.webservice.domain.Subject;
import com.study.courses.webservice.domain.Teacher;

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

    Language findLanguage(Long id);

    Student findStudent(Long id);
}
