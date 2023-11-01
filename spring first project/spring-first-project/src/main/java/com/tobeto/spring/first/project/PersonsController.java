package com.tobeto.spring.first.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persons")
public class PersonsController {

    @GetMapping
    public String get(){
        return "Get";
    }

    @GetMapping("get2")
    public String get2(){
        return "Get 2";
    }

    @PostMapping
    public String post(){
        return "Tobeto";
    }


}
