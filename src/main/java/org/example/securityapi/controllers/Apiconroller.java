package org.example.securityapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Apiconroller {
    @GetMapping("/index")
    public String index() {
        System.out.println("index");
        return "Hello World";
    }

}
