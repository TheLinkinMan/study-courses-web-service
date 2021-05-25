package com.study.courses.webservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Language {

    @Id
    private String id;

    private String name;
}
