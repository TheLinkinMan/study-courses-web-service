package com.study.courses.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "study_license")
    private String studyLicense;

    @OneToOne(targetEntity = Avatar.class)
    @JoinColumn(name = "id_avatar")
    private Avatar avatar;

    @OneToMany(targetEntity = Subject.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    private List<Subject> subjects;

    @ManyToMany(targetEntity = Language.class, fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_languages", joinColumns = @JoinColumn(name = "id_teacher"),
            inverseJoinColumns = @JoinColumn(name = "id_language"))
    private List<Language> languages;

    @OneToOne(targetEntity = Users.class)
    @JoinColumn(name = "login")
    private Users user;
}
