package org.example.securityapi.servers;
import aj.org.objectweb.asm.ClassReader;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.securityapi.Entities.user;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JwtService {
private String SECRET_KEY;
 public String genratedtoken(user user)
    {Map<String,Object> claims=new HashMap<>();
        return  Jwts.builder()
                .claims(claims)
                .subject(user.getUsername())

                .issuer("DCB")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+5*60*1000))
                .signWith(getGenratkey())
                .compact();
    }
    private SecretKey getGenratkey() {
        byte[] encoded = Decoders.BASE64.decode(getSECRET_KEY());
        return   Keys.hmacShaKeyFor(encoded);}

    public String getSECRET_KEY()
    {
        return SECRET_KEY="21fgIs5U4LHuFIwfbnoJG+dJR3+Q4Bw+RJ7lJQU6Nhk=";
    }
    public String getusernamefromtoken(String jwtToken) {
        return extractClaims(jwtToken, Claims::getSubject);
    }
    private <T> T extractClaims(String jwtToken, Function<Claims, T> claimsResolver) {
        Claims claims = extractClaims(jwtToken);
        return claimsResolver.apply(claims);
    }
    private Claims extractClaims(String jwtToken) {
        return Jwts
                .parser()
                .verifyWith(getGenratkey())
                .build()
                .parseClaimsJws(jwtToken)
                .getPayload();
    }
    public boolean isvalid(UserDetails userDetails, String jwtToken) {
        String username = getusernamefromtoken(jwtToken);
        return (username.equals(userDetails.getUsername()) && !IsExpierd(jwtToken));
    }

    private boolean IsExpierd(String jwtToken) {
    return extactexpiration(jwtToken).before(new Date());
    }

    private Date extactexpiration(String jwtToken) {
        return extractClaims(jwtToken, Claims::getExpiration);
    }
}
