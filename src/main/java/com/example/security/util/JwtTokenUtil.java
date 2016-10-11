package com.example.security.util;


import com.example.security.model.AuthenticatedUser;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * Created by michael on 6/10/2016.
 */

@Component
public class JwtTokenUtil implements Serializable {

    @Value("${jwt.secret}")
    private String secret;




    public String generateToken(UserDetails userdetails){

        //Multiple claims can be added here with claims.put("user", ....)

        Claims claims = Jwts.claims().setSubject(userdetails.getUsername());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Claims getClaimsFromToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String getUsernameFromToken(String token){
        String username;
        try{
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            username = null;
        }
        return username;
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        AuthenticatedUser user =  (AuthenticatedUser) userDetails;
        final String username = getUsernameFromToken(token);

        return(username.equals(user.getUsername()));
    }

}
