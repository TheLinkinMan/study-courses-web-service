package com.study.courses.webservice.service;

import com.study.courses.webservice.model.Language;
import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.model.Teacher;
import com.study.courses.webservice.repository.SubjectRepository;
import com.study.courses.webservice.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EducationReaderService implements IEducationReaderService {

    private final SubjectRepository subjectRepository;

    private final TeacherRepository teacherRepository;

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Subject> findAllSubjects(Language language) {
        return subjectRepository.findAllByLanguage(language);
    }

    @Override
    public List<Subject> findAllSubjects(String CEFR) {
        return subjectRepository.findAllByCEFR(CEFR);
    }

    @Override
    public List<Subject> findAllSubjects(Teacher teacher) {
        return subjectRepository.findAllByTeacher(teacher);
    }

    @Override
    public List<Subject> findAllSubjects(Language language, String CEFR) {
        return subjectRepository.findAllByLanguageAndCEFR(language, CEFR);
    }

    @Override
    public List<Subject> findAllSubjectsByName(String name) {
        return subjectRepository.findAllByName(name);
    }

    @Override
    public Subject findSubject(String id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher findTeacher(String id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher findTeacher(Subject subject) {
        return teacherRepository.findBySubjectsIs(subject);
    }
}
