package com.cetus;

import io.jsonwebtoken.*;

import java.util.Date;


public class JwtExample {

    public static void main(String[] args) {
        String jwt = generate();
        parse(jwt);
    }

    public static String generate() {
        String secretKey = "Cetus_2023";

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject("Cetus")
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .claim("username", "Evan");

        String jwt = jwtBuilder
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        System.out.println(jwt);
        return jwt;
    }

    public static void parse(String jwt) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey("Cetus_2023")
                    .parseClaimsJws(jwt);
            Claims claims = jws.getBody();
            System.out.println(jws.toString());
            System.out.println(claims.toString());
            System.out.println(jws.getSignature());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
