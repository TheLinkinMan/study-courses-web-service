package com.study.courses.webservice.controller;

import com.study.courses.webservice.domain.Subject;
import com.study.courses.webservice.domain.Teacher;
import com.study.courses.webservice.domain.TeacherAssembler;
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
@RequestMapping("/teachers")
public class TeacherController {

    private final EducationReaderService educationReaderService;

    private final EducationProcessService educationProcessService;

    private final TeacherAssembler teacherAssembler;

    @GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<Teacher>>> findAll() {
        return ResponseEntity.ok(teacherAssembler.toCollectionModel(educationReaderService.findAllTeachers()));
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<EntityModel<Teacher>> find(@PathVariable Long id) {
        Teacher teacher = educationReaderService.findTeacher(id);
        if (teacher == null) {
            return ResponseEntity.notFound().build();
        } else {
            EntityModel<Teacher> teacherRepresentation = teacherAssembler.toModel(teacher)
                    .add(linkTo(methodOn(TeacherController.class).findAll()).withRel("teachers"));

            return ResponseEntity.ok(teacherRepresentation);
        }
    }

    @GetMapping("/teacher/{id}/subjects")
    public ResponseEntity<CollectionModel<Subject>> findAllSubjects(@PathVariable Long id) {
        Teacher teacher = educationReaderService.findTeacher(id);
        List<Subject> subjects = educationReaderService.findAllSubjects(teacher);
        subjects.forEach(s ->
                s.add(linkTo(methodOn(SubjectController.class).findSubject(s.getId())).withSelfRel()));

        return ResponseEntity.ok(CollectionModel.of(subjects));
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> save(@Valid @RequestBody Teacher teacher) {
        Teacher currentTeacher = educationProcessService.save(teacher);
        if (currentTeacher == null) {
            return ResponseEntity.badRequest().build();
        } else {
            Link link = linkTo(methodOn(TeacherController.class).find(currentTeacher.getId())).withSelfRel();

            return ResponseEntity.created(link.toUri()).build();
        }
    }

    @PutMapping("/teacher")
    public ResponseEntity<Teacher> update(@Valid @RequestBody Teacher teacher) {
        Teacher currentTeacher = educationReaderService.findTeacher(teacher.getId());
        if (currentTeacher == null) {
            return ResponseEntity.badRequest().build();
        } else {
            educationProcessService.save(teacher);

            return ResponseEntity.accepted().build();
        }
    }

    @DeleteMapping("/teacher")
    private ResponseEntity<Object> delete(@RequestBody Teacher teacher) {
        Teacher currentTeacher = educationReaderService.findTeacher(teacher.getId());
        if (currentTeacher == null) {
            return ResponseEntity.badRequest().build();
        } else {
            educationProcessService.delete(teacher);

            return ResponseEntity.accepted().build();
        }
    }
}
