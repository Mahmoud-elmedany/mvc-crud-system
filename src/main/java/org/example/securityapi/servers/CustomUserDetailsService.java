package org.example.securityapi.servers;

import org.example.securityapi.Entities.user;
import org.example.securityapi.repository.repojpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {


   private final repojpa database;
    public CustomUserDetailsService(repojpa database) {
        this.database = database;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        user u=database.findByUsername(username);
        System.out.println(u.getUsername());
        System.out.println("loadUserByUsername");
        if(Objects.isNull(u)){
            System.out.println("Username not found");
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(u);
    }
}
