package org.example.securityapi.repository;

import org.example.securityapi.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface repojpa extends JpaRepository<user,Integer> {
    user findByUsername(String username);
}
