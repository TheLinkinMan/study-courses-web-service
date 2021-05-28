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
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    @OneToOne(targetEntity = Avatar.class)
    @JoinColumn(name = "id_avatar")
    private Avatar avatar;

    @ManyToMany(targetEntity = Subject.class, fetch = FetchType.LAZY)
    @JoinTable(name = "student_program", joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private List<Subject> subjects;

    @OneToOne(targetEntity = Users.class)
    @JoinColumn(name = "login")
    private Users user;
}
