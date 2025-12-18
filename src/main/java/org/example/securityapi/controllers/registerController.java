package org.example.securityapi.controllers;

import org.example.securityapi.Entities.user;
import org.example.securityapi.dto.responsuserdto;
import org.example.securityapi.mapper.mapperuserdto;
import org.example.securityapi.repository.repository;
import org.example.securityapi.servers.serviesforregister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController {
    @Autowired
    serviesforregister serviesforregister;
    @PostMapping("/register")
    public responsuserdto postnewuser(@RequestBody user user)
    {

        System.out.println("postnewuser");
        serviesforregister.savedata(user);
        return mapperuserdto.userToDTO(user);
    }
    @GetMapping("/hello")
    public  String hello()
    {
        return "Hello World";
    }
}
