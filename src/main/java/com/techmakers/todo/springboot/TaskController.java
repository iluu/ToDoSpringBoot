package com.techmakers.todo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class TaskController {

    private List<String> tasks = new ArrayList<String>();

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    List<String> tasks() {
        return tasks;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<?> add(@RequestBody String task){
        tasks.add(task);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String hello() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TaskController.class, args);
    }


}
