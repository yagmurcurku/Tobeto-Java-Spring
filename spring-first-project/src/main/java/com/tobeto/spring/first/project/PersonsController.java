package com.tobeto.spring.first.project;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/persons")
public class PersonsController {

    List<Person> inMemoryList = new ArrayList<>();

    @GetMapping
    public List<Person> get(){
        return inMemoryList;
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable int id){
        Person person = inMemoryList.stream().filter((p)->p.getId() == id).findFirst().orElseThrow();
        return person;
    }

    @PostMapping
    public void add(@RequestBody Person person){
        inMemoryList.add(person);
    }

    @PutMapping
    public void update(@RequestBody Person person){
        Person person1 = inMemoryList.stream().filter((p)->p.getId() == person.getId()).findFirst().orElseThrow();
        person1.setName(person.getName());
        person1.setSurname(person.getSurname());
        person1.setAge(person.getAge());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Person person2 = inMemoryList.stream().filter((p)->p.getId() == id).findFirst().orElseThrow();
        inMemoryList.remove(person2);
    }


}
