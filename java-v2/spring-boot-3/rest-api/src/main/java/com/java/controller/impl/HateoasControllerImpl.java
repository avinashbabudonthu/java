package com.java.controller.impl;

import com.java.controller.HateoasController;
import com.java.model.Student;
import com.java.service.impl.HateoasService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class HateoasControllerImpl implements HateoasController {

    private final HateoasService hateoasService;

    @Override
    public List<Student> findAllStudents() {
        return hateoasService.findAllStudents();
    }

    @Override
    public Student findStudentById(@PathVariable("id") String id) {
        return hateoasService.findStudentById(id);
    }

    @Override
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = hateoasService.saveStudent(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public EntityModel<Student> saveStudents2(@RequestBody Student student) {
        Student savedStudent = hateoasService.saveStudent(student);
        EntityModel<Student> entityModel = EntityModel.of(savedStudent);

        WebMvcLinkBuilder webMvcLinkBuilder1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllStudents());
        Link link1 = webMvcLinkBuilder1.withRel("all-students");

        WebMvcLinkBuilder webMvcLinkBuilder2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass(), savedStudent.getId()).findStudentById(savedStudent.getId()));
        Link link2 = webMvcLinkBuilder2.withRel("this-student-by-id");

        entityModel.add(link1, link2);
        return entityModel;
    }

}