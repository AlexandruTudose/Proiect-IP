package com.fiivirtualcatalog.test.controllers;

import com.fiivirtualcatalog.test.models.TestModel;
import com.fiivirtualcatalog.test.services.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alexandru on 4/27/2017.
 */

@RestController
@RequestMapping("/v1/test_models")
public class TestModelController {

    @Autowired
    private TestModelService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TestModel>> get() {
        List<TestModel> students = this.service.getAll();
        if (students.isEmpty()) {
            return new ResponseEntity<List<TestModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TestModel>>(students, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TestModel> addStudent(@RequestBody TestModel student) {
        TestModel savedStudent = this.service.save(student);
        return new ResponseEntity<TestModel>(savedStudent, HttpStatus.CREATED);
    }
}
