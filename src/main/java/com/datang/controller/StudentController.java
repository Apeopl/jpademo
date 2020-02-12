package com.datang.controller;

import com.datang.entity.Student;
import com.datang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE})
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
