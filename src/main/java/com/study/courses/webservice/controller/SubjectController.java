package com.study.courses.webservice.controller;

import com.study.courses.webservice.domain.Subject;
import com.study.courses.webservice.domain.Teacher;
import com.study.courses.webservice.service.EducationProcessService;
import com.study.courses.webservice.service.EducationReaderService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final EducationReaderService educationReaderService;

    private final EducationProcessService educationProcessService;

    @GetMapping()
    public ResponseEntity<CollectionModel<Subject>> findAll() {
        List<Subject> subjects = educationReaderService.findAllSubjects();
        return addLinksSubjects(subjects);
    }

//    @GetMapping("/{idLanguage}")
//    public ResponseEntity<CollectionModel<Subject>> findAll(@PathVariable Long idLanguage) {
//        Language language = educationReaderService.findLanguage(idLanguage);
//        List<Subject> subjects = educationReaderService.findAllSubjects(language);
//        return addLinksSubjects(subjects);
//    }

//    @GetMapping("/{CEFR}")
//    public ResponseEntity<CollectionModel<Subject>> findAll(@PathVariable String CEFR) {
//        List<Subject> subjects = educationReaderService.findAllSubjects(CEFR);
//        return addLinksSubjects(subjects);
//    }

    @GetMapping("/{idTeach}")
    public ResponseEntity<CollectionModel<Subject>> findAllByTeacher(@PathVariable Long idTeach) {
        Teacher teacher = educationReaderService.findTeacher(idTeach);
        List<Subject> subjects = educationReaderService.findAllSubjects(teacher);
        return addLinksSubjects(subjects);
    }

//    @GetMapping("/{idLanguage}&{CEFR}")
//    public ResponseEntity<CollectionModel<Subject>> findAll(@PathVariable Long idLanguage, @PathVariable String CEFR) {
//        Language Language = educationReaderService.findLanguage(idLanguage);
//        List<Subject> subjects = educationReaderService.findAllSubjects(Language, CEFR);
//        return addLinksSubjects(subjects);
//    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<EntityModel<Subject>> findSubject(@PathVariable Long id) {
        Subject subject = educationReaderService.findSubject(id);
        if (subject == null) {
            return ResponseEntity.notFound().build();
        } else {
            subject.add(linkTo(methodOn(SubjectController.class).findSubject(id)).withSelfRel())
                    .add(linkTo(methodOn(TeacherController.class).find(subject.getTeacher().getId())).withRel("teacher"))
                    .add(linkTo(methodOn(SubjectController.class).findAll()).withRel("subjects"));

            return ResponseEntity.ok(EntityModel.of(subject));
        }
    }

    @PostMapping("/subject")
    public ResponseEntity<Subject> save(@Valid @RequestBody Subject subject) {
        return ResponseEntity.ok(educationProcessService.save(subject));
    }

    @PutMapping("/subject")
    public ResponseEntity<Subject> update(@Valid @RequestBody Subject subject) {
        return ResponseEntity.ok(educationProcessService.save(subject));
    }

    @DeleteMapping("/subject")
    public void delete(@RequestBody Subject subject) {
        educationProcessService.delete(subject);
    }

    private ResponseEntity<CollectionModel<Subject>> addLinksSubjects(List<Subject> subjects) {
        subjects.forEach(s ->
                s.add(linkTo(methodOn(SubjectController.class).findSubject(s.getId())).withSelfRel())
                        .add(linkTo(methodOn(TeacherController.class).find(s.getTeacher().getId())).withRel("teacher")));
        return ResponseEntity.ok(CollectionModel.of(subjects));
    }
}
