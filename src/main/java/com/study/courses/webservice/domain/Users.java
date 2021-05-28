package com.study.courses.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class Users {
    @Id
    @NotNull(message = "Поле не может быть пустым")
    @Size(min = 2, max = 25, message = "Неподходячий логин")
    private String login;

    @NotNull(message = "Поле не может быть пустым")
    @Size(min = 2, max = 30, message = "Неподходячий пароль")
    private String password;
}
