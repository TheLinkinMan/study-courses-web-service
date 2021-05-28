package com.study.courses.webservice.service;

import com.study.courses.webservice.domain.Language;
import com.study.courses.webservice.domain.Student;
import com.study.courses.webservice.domain.Subject;
import com.study.courses.webservice.domain.Teacher;
import com.study.courses.webservice.repository.LanguageRepository;
import com.study.courses.webservice.repository.StudentRepository;
import com.study.courses.webservice.repository.SubjectRepository;
import com.study.courses.webservice.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@AllArgsConstructor
@Service
public class EducationReaderService implements IEducationReaderService {

    private final SubjectRepository subjectRepository;

    private final TeacherRepository teacherRepository;

    private final LanguageRepository languageRepository;

    private final StudentRepository studentRepository;

    @Cacheable("subjects")
    @Override
    public List<Subject> findAllSubjects() {
        return (List<Subject>) subjectRepository.findAll();
    }

    @Cacheable("teachers")
    @Override
    public List<Teacher> findAllTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public List<Subject> findAllSubjects(Language language) {
        return (List<Subject>) subjectRepository.findAllByLanguage(language);
    }

    @Override
    public List<Subject> findAllSubjects(String CEFR) {
        return (List<Subject>) subjectRepository.findAllByCEFR(CEFR);
    }

    @Override
    public List<Subject> findAllSubjects(Teacher teacher) {
        return (List<Subject>) subjectRepository.findAllByTeacher(teacher);
    }

    @Override
    public List<Subject> findAllSubjects(Language language, String CEFR) {
        return (List<Subject>) subjectRepository.findAllByLanguageAndCEFR(language, CEFR);
    }

    @Override
    public List<Subject> findAllSubjectsByName(String name) {
        return (List<Subject>) subjectRepository.findAllByName(name);
    }

    @Override
    public Subject findSubject(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher findTeacher(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Language findLanguage(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher findTeacher(Subject subject) {
        return teacherRepository.findBySubjectsIs(subject).orElse(null);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
