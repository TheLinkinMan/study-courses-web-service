package com.study.courses.webservice.domain;

import com.study.courses.webservice.controller.TeacherController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TeacherAssembler implements SimpleRepresentationModelAssembler<Teacher> {
    @Override
    public void addLinks(EntityModel<Teacher> resource) {
        if (resource.getContent() != null) {
            Long id = resource.getContent().getId();
            resource.add(linkTo(methodOn(TeacherController.class).find(id)).withSelfRel());
            resource.add(linkTo(methodOn(TeacherController.class).findAllSubjects(id)).withRel("subjects"));
        }
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Teacher>> resources) {
        resources.add(linkTo(methodOn(TeacherController.class).findAll()).withSelfRel());
    }
}
