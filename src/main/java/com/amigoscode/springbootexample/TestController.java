package com.amigoscode.springbootexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class TestController {
    @GetMapping()
    public GreetResponse greet(@RequestParam(value = "names",required = false) String name) {
        String message = name == null || name.isBlank() ? "Hello" : "Hello " + name;
        GreetResponse response =new GreetResponse(message,
                List.of("Java","JavaScript","PHP"),
                new Person("Alex",66,30_000));
        return response;
    }

    record Person(String name,int age, double savings) {}
    record GreetResponse(
            String greet
            , List<String> favProgrammingLanguages,
            Person person) {

    }
}
