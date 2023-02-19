package com.lylastudio.learn.controller;

import com.lylastudio.learn.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Second {

    @GetMapping("getStudent1")
    public String getStudent(){

        log.info("HIT_____");

//        Student student = new Student();
//        student.setName("Elfathan");
//        student.setAddress("Dayeuh Kolot");
//        student.setBod("01-01-2022");
//
//        return student;

        return "Hello";
    }

}
