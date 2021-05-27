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
    public Avatar save(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    @Transactional
    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }

    @Transactional
    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
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
}
