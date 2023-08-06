package com.example.ecommercedemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    //endpoint dinamico
    @GetMapping("/holi/{id}")
    public String helloWorld(@PathVariable Long id) {
        return "Holita >D "+ id;
    }

    //otra forma de escribirlo:
    //@PostMapping(path = "/chau")
    //@RequestMapping(path="/chau",method = RequestMethod.GET)
    @GetMapping("/chau")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String chau() throws Exception {
        //throw new UserNotFound();
        return "Bai >D";
    }

}