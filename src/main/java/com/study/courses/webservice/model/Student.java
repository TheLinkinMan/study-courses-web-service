package com.study.courses.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document
public class Student {
    @Id
    private String id;

    private String name;

    private String surname;

    private String email;

    @Field(name = "phone_number")
    private String phoneNumber;

    private User user;

    private Avatar avatar;
}
