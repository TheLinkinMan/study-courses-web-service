package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {
}
