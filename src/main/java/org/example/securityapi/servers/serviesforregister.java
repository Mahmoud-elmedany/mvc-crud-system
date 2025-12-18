package org.example.securityapi.servers;
import org.example.securityapi.Entities.user;
import org.example.securityapi.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class serviesforregister {
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
   @Autowired
   BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    repository repository;
    public  void  savedata(user user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.savedata(user);
    }
    public   String  verfiy(user user)
    {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);

    return auth.isAuthenticated() ? jwtService.genratedtoken(user) : "no";
    }


}
