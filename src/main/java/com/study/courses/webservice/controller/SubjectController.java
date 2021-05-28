package com.study.courses.webservice.controller;

import com.study.courses.webservice.model.Language;
import com.study.courses.webservice.model.Subject;
import com.study.courses.webservice.service.EducationProcessService;
import com.study.courses.webservice.service.EducationReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final EducationReaderService educationReaderService;

    private final EducationProcessService educationProcessService;

    @GetMapping("/")
    public ResponseEntity<List<Subject>> findAllSubject() {
        return ResponseEntity.ok(educationReaderService.findAllSubjects());
    }

    @GetMapping("/{idLanguage}")
    public ResponseEntity<List<Subject>> findAllSubByLanguage(@PathVariable long idLanguage) {
        Language currentLanguage = educationReaderService.findLanguage(idLanguage);
        return ResponseEntity.ok(educationReaderService.findAllSubjects(currentLanguage));
    }

//    @GetMapping("/{CEFR}")
//    public List<Subject> findAllSubByCEFR(@PathVariable String CEFR) {
//        return educationReaderService.findAllSubjects(CEFR);
//    }

    @GetMapping("/{idLanguage}&{CEFR}")
    public ResponseEntity<List<Subject>> findAllSubByLanguageAndCEFR(@PathVariable Long idLanguage, @PathVariable String CEFR) {
        Language currentLanguage = educationReaderService.findLanguage(idLanguage);
        return ResponseEntity.ok(educationReaderService.findAllSubjects(currentLanguage, CEFR));
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Subject> findSubject(@PathVariable Long id) {
        return ResponseEntity.ok(educationReaderService.findSubject(id));
    }

    @PostMapping("/subject")
    public ResponseEntity<Subject> save(@RequestBody Subject subject) {
        return ResponseEntity.ok(educationProcessService.save(subject));
    }

    @PutMapping("/subject")
    public ResponseEntity<Subject> update(@RequestBody Subject subject) {
        return ResponseEntity.ok(educationProcessService.save(subject));
    }

    @DeleteMapping("/subject")
    public void delete(@RequestBody Subject subject) {
        educationProcessService.delete(subject);
    }
}
