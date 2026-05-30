// java
package com.yeyu.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 仍然使用原来的短密钥字符串
    private static final String SECRET = "eWV5dXNoZW5nZmFu";
    private static final Key KEY;

    static {
        try {
            // 对 SECRET 做 SHA-256 摘要以得到 32 字节密钥
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = md.digest(SECRET.getBytes(StandardCharsets.UTF_8));
            KEY = Keys.hmacShaKeyFor(keyBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String generateToken(Map<String, Object> claims, String subject, long expireSeconds) {
        Date now = new Date();
        // 修正：expireSeconds 单位为秒，乘以 1000 转为毫秒
        Date exp = new Date(now.getTime() + expireSeconds * 1000L);
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(KEY, SignatureAlgorithm.HS256);
        return builder.compact();
    }

    public static Claims parseToken(String token) throws JwtException {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
        return jws.getBody();
    }

    public static String generateToken(String subject, long expireSeconds) {
        return generateToken(null, subject, expireSeconds);
    }
}
