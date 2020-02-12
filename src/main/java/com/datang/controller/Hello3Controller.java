package com.datang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello3Controller {

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello() {
        System.out.println("hello3...");
        return "hello spring3!";
    }

}
