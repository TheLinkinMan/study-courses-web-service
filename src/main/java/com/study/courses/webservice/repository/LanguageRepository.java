package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<Language, String> {
}
