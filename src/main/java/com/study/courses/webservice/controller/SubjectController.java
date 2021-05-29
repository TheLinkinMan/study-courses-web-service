package com.study.courses.webservice.controller;

import com.study.courses.webservice.domain.CEFR;
import com.study.courses.webservice.domain.Language;
import com.study.courses.webservice.domain.Subject;
import com.study.courses.webservice.domain.Teacher;
import com.study.courses.webservice.service.EducationProcessService;
import com.study.courses.webservice.service.EducationReaderService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
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
        subjects.forEach(s ->
                s.add(linkTo(methodOn(SubjectController.class).findSubject(s.getId())).withSelfRel())
                        .add(linkTo(methodOn(TeacherController.class).find(s.getTeacher().getId())).withRel("teacher")));
        return ResponseEntity.ok(CollectionModel.of(subjects));
    }

    @GetMapping("/language/{id}")
    public ResponseEntity<CollectionModel<Subject>> findAllByLanguage(@PathVariable Long id) {
        Language language = educationReaderService.findLanguage(id);
        List<Subject> subjects = educationReaderService.findAllSubjects(language);
        return addLinksSubjects(subjects);
    }

    @GetMapping("/cefr/{value}")
    public ResponseEntity<CollectionModel<Subject>> findAllByCEFR(@PathVariable CEFR value) {
        List<Subject> subjects = educationReaderService.findAllSubjects(value.name());
        return addLinksSubjects(subjects);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<CollectionModel<Subject>> findAllByTeacher(@PathVariable Long id) {
        Teacher teacher = educationReaderService.findTeacher(id);
        List<Subject> subjects = educationReaderService.findAllSubjects(teacher);
        return addLinksSubjects(subjects);
    }

    @GetMapping("/language/{id}/cefr/{value}")
    public ResponseEntity<CollectionModel<Subject>> findAll(@PathVariable Long id, @PathVariable String value) {
        Language Language = educationReaderService.findLanguage(id);
        List<Subject> subjects = educationReaderService.findAllSubjects(Language, value);
        return addLinksSubjects(subjects);
    }

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
        Subject currentSubject = educationProcessService.save(subject);
        if (currentSubject == null) {
            return ResponseEntity.badRequest().build();
        } else {
            Link link = linkTo(methodOn(SubjectController.class).findSubject(currentSubject.getId())).withSelfRel();

            return ResponseEntity.created(link.toUri()).build();
        }
    }

    @PutMapping("/subject")
    public ResponseEntity<Subject> update(@Valid @RequestBody Subject subject) {
        Subject currentSubject = educationReaderService.findSubject(subject.getId());
        if (currentSubject == null) {
            return ResponseEntity.badRequest().build();
        } else {
            educationProcessService.save(subject);
            return ResponseEntity.accepted().build();
        }
    }

    @DeleteMapping("/subject")
    public ResponseEntity<Object> delete(@RequestBody Subject subject) {
        Subject currentSubject = educationReaderService.findSubject(subject.getId());
        if (currentSubject == null) {
            return ResponseEntity.badRequest().build();
        } else {
            educationProcessService.delete(subject);

            return ResponseEntity.accepted().build();
        }
    }

    private ResponseEntity<CollectionModel<Subject>> addLinksSubjects(List<Subject> subjects) {
        subjects.forEach(s ->
                s.add(linkTo(methodOn(SubjectController.class).findSubject(s.getId())).withSelfRel())
                        .add(linkTo(methodOn(TeacherController.class).find(s.getTeacher().getId())).withRel("teacher"))
                        .add(linkTo(methodOn(SubjectController.class).findAll()).withRel("subjects")));
        return ResponseEntity.ok(CollectionModel.of(subjects));
    }
}
