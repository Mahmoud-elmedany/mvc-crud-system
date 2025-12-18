package org.example.securityapi.repository;

import org.example.securityapi.Entities.user;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class repository {
    @Autowired
    repojpa repository;

    public  void   savedata(user user){
        repository.save(user);
    }
}
