package priv.sunyj.sms.util;

import io.jsonwebtoken.*;

import java.util.Date;

public class JWTUtil {

    //过期时间
    private static int EXPIRE_TIME = 24 * 60 * 60 * 1000;//1天
    //密钥  最短4个字符
    private static String SECRET = "smskey";

    //生成token
    public static String createToken(String uNum) {
        JwtBuilder jwtBuilder = Jwts.builder().setIssuedAt(new Date())
                .setSubject(uNum)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET);
        String token = jwtBuilder.compact();
        return token;
    }

    //解析token
    public static String parserToken(String token) {
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String uNum = body.getSubject();
        return uNum;
    }
}
