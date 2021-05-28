package com.study.courses.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Имя должно быть задано")
    @Size(min = 2, max = 20, message = "Неподходящие имя")
    private String name;

    @NotNull(message = "Фамилия должна быть задана")
    @Size(min = 2, max = 50, message = "Неподходящие фамилия")
    private String surname;

    private String address;

    @NotNull(message = "Номер телефона должен быть задан")
    @Pattern(regexp = "\\+38(\\d{3})\\d{3}-\\d{2}-\\d{2}",
            message = "Номер должен быть формата: +38(XXX)XXX-XX-XX")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "Email должен быть задан")
    @Pattern(regexp = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$",
    message = "Неправильный  формат email")
    private String email;

    @OneToOne(targetEntity = Avatar.class)
    @JoinColumn(name = "id_avatar")
    private Avatar avatar;

    @ManyToMany(targetEntity = Subject.class, fetch = FetchType.LAZY)
    @JoinTable(name = "student_program", joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private Set<Subject> subjects;

    @OneToOne(targetEntity = Users.class)
    @JoinColumn(name = "login")
    private Users user;
}
