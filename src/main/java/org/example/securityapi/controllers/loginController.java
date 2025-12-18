package org.example.securityapi.controllers;
import org.example.securityapi.Entities.user;
import org.example.securityapi.servers.serviesforregister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.management.remote.JMXAuthenticator;
@RestController
public class loginController {
@Autowired
serviesforregister serviesforregister;

    @PostMapping("/login")
    public String login(@RequestBody user user)
    {


        return serviesforregister.verfiy(user);
    }
}
