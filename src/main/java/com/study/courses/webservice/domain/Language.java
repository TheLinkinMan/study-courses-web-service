package com.study.courses.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(targetEntity = Teacher.class, fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_languages", joinColumns = @JoinColumn(name = "id_language"),
            inverseJoinColumns = @JoinColumn(name = "id_teacher"))
    private List<Teacher> teachers;
}
