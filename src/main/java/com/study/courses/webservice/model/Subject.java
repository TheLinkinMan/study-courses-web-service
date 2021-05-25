package com.study.courses.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document
public class Subject {
    @Id
    private String id;

    private String name;

    private Language language;

    private String CEFR;

    @Field(name = "url_photo")
    private String urlPhoto;

    private String description;

    private Teacher teacher;
}
