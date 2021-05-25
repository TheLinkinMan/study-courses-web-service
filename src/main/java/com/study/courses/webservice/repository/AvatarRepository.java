package com.study.courses.webservice.repository;

import com.study.courses.webservice.model.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvatarRepository extends MongoRepository<Avatar, String> {
}
