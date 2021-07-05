package com.smirnovakv.products.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    @RequestMapping(value = {"/hello", "/hello/{name}"})
    public String sayHello(@PathVariable Optional<String> name) {
        if (name.isEmpty()) {
            name = Optional.of("friend");
        }
        return "Hello, " + name.get() + "!";
    }
}
