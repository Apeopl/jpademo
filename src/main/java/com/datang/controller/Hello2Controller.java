package com.datang.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello() {
        int a = 1/0;
        return "hello spring2!";
    }

}
