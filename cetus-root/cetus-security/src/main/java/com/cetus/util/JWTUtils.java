package com.cetus.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTUtils {

    private final static String APPLICATION = "CETUS";

    private final static String SECRET_KEY = APPLICATION + "_2023";

//    public static String generateToken() {
//
//    }

    public static Jws<Claims> parse(String jwt) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt);

    }
}
