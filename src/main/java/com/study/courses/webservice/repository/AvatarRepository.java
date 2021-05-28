package com.study.courses.webservice.repository;

import com.study.courses.webservice.domain.Avatar;
import org.springframework.data.repository.CrudRepository;

public interface AvatarRepository extends CrudRepository<Avatar, Long> {
}
