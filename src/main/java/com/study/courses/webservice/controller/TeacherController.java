package com.study.courses.webservice.controller;

import com.study.courses.webservice.domain.Teacher;
import com.study.courses.webservice.service.EducationProcessService;
import com.study.courses.webservice.service.EducationReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final EducationReaderService educationReaderService;

    private final EducationProcessService educationProcessService;

    @GetMapping("/")
    public ResponseEntity<List<Teacher>> findAll() {
        return ResponseEntity.ok(educationReaderService.findAllTeachers());
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> find(@PathVariable Long id) {
        return ResponseEntity.ok(educationReaderService.findTeacher(id));
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> save(@Valid @RequestBody Teacher teacher) {
        return ResponseEntity.ok(educationProcessService.save(teacher));
    }

    @PutMapping("/teacher")
    public ResponseEntity<Teacher> update(@Valid @RequestBody Teacher teacher) {
        return ResponseEntity.ok(educationProcessService.save(teacher));
    }
}
