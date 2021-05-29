package com.study.courses.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class Subject extends RepresentationModel<Subject> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Имя должно быть задано")
    @Size(min = 2, max = 90)
    private String name;

    @NotNull(message = "Часы долны быть заданы")
    private int hours;

    @NotNull(message = "Уровень должен быть выбран")
    private String CEFR;

    @ManyToOne(targetEntity = Teacher.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToMany(targetEntity = Student.class, fetch = FetchType.LAZY)
    @JoinTable(name = "student_program", joinColumns = @JoinColumn(name = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_student"))
    private List<Student> students;

    @ManyToOne(targetEntity = Language.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_language")
    private Language language;
}
