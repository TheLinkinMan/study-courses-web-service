package com.study.courses.webservice.service;

import com.study.courses.webservice.model.*;
import com.study.courses.webservice.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EducationProcessService implements IEducationProcessService{

    private final AvatarRepository avatarRepository;

    private final LanguageRepository languageRepository;

    private final StudentRepository studentRepository;

    private final SubjectRepository subjectRepository;

    private final TeacherRepository teacherRepository;

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void save(Avatar avatar) {
        avatarRepository.save(avatar);
    }

    @Transactional
    @Override
    public void save(Language language) {
        languageRepository.save(language);
    }

    @Transactional
    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Transactional
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }


    @Transactional
    @Override
    public void delete(Avatar avatar) {
        avatarRepository.delete(avatar);
    }

    @Transactional
    @Override
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Transactional
    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Transactional
    @Override
    public void delete(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public void delete(Language language) {
        languageRepository.save(language);
    }

    @Transactional
    @Override
    public void deleteAllSubjectByLanguage(Language language) {
        subjectRepository.deleteAllByLanguage(language);
    }
}
