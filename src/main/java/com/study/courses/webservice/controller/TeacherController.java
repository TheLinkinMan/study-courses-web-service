package com.study.courses.webservice.controller;

import com.study.courses.webservice.model.Teacher;
import com.study.courses.webservice.service.EducationProcessService;
import com.study.courses.webservice.service.EducationReaderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final EducationReaderService educationReaderService;

    private final EducationProcessService educationProcessService;

    @GetMapping("/")
    public List<Teacher> findAll() {
        return educationReaderService.findAllTeachers();
    }

    @GetMapping("/teacher/{id}")
    public Teacher find(@PathVariable Long id) {
        return educationReaderService.findTeacher(id);
    }

    @PostMapping("/teacher")
    public Teacher save(@RequestBody Teacher teacher) {
        return educationProcessService.save(teacher);
    }

    @PutMapping("/teacher")
    public Teacher update(@RequestBody Teacher teacher) {
        return educationProcessService.save(teacher);
    }
}
