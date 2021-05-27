package com.study.courses.webservice.controller;

import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.service.EducationProcessService;
import com.study.courses.webservice.service.EducationReaderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final EducationReaderService educationReaderService;

    private final EducationProcessService educationProcessService;

    @GetMapping("/")
    public List<Subject> findAllSubject() {
        return educationReaderService.findAllSubjects();
    }

    @GetMapping("/{language}")
    public List<Subject> findAllSubByLanguage(@PathVariable Long language) {
        return educationReaderService.findAllSubjects(educationReaderService.findLanguage(language));
    }

    @GetMapping("/{CEFR}")
    public List<Subject> findAllSubByCEFR(@PathVariable String CEFR) {
        return educationReaderService.findAllSubjects(CEFR);
    }

    @GetMapping("/{language}&{CEFR}")
    public List<Subject> findAllSubByLanguageAndCEFR(@PathVariable Long language, @PathVariable String CEFR) {
        return educationReaderService.findAllSubjects(educationReaderService.findLanguage(language), CEFR);
    }

    @GetMapping("/subject/{id}")
    public Subject findSubject(@PathVariable Long id) {
        return educationReaderService.findSubject(id);
    }

    @PostMapping("/subject")
    public Subject save(@RequestBody Subject subject) {
        return educationProcessService.save(subject);
    }

    @PutMapping("/subject")
    public Subject update(@RequestBody Subject subject) {
        return educationProcessService.save(subject);
    }

    @DeleteMapping("/subject")
    public void delete(@RequestBody Subject subject) {
        educationProcessService.delete(subject);
    }
}
