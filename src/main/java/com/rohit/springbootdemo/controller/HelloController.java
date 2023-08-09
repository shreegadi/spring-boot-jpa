package com.ait.springbootdemo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld(){
        return "Welcome";
    }
    @GetMapping("/hello1")
    public String helloWorld1(){
        return "Welcome helloworld RohitS";
    }
    @GetMapping("/hello2")
    public String helloWorld12(){
        return "Welcome helloworld RohitS2";
    }
}

