package com.gs.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @User远
 * @Date2022/5/9
 */
public class JWTUtils {
    private static String SIGNATURE = "token!@#$%^7890";

    /**
     * 生成token
     * @param map //传入payload
     * @return 返回token
     */
    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR_OF_DAY,24);
        builder.withExpiresAt(instance.getTime());
        System.out.println(instance.getTime().getTime()+"~~~~~~");
        builder.withIssuedAt(new Date());
        return builder.sign(Algorithm.HMAC256(SIGNATURE)).toString();
    }

    /**
     * 验证token
     * @param token
     */
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    /**
     * 获取token中payload
     * @param token
     * @return
     */
    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String data = "qwer";
        String data1 = "qwert";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCIDV8I1zpoazcFmv3VNtG/E9/QC14gDhBoW9Yq6o9UNLaOZC41yoGa7hjHqjuPOcmPJ61Wmv7i5UbB5BceGRl2i0pSyOzeAeYpoY5cNRStfQlXFlwV1Ig1P081rxBcCgkWZvhodsWp9yRdKOTTHUCj0FpgD94/2QhvqkxOaW9vAwIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIgNXwjXOmhrNwWa/dU20b8T39ALXiAOEGhb1irqj1Q0to5kLjXKgZruGMeqO485yY8nrVaa/uLlRsHkFx4ZGXaLSlLI7N4B5imhjlw1FK19CVcWXBXUiDU/TzWvEFwKCRZm+Gh2xan3JF0o5NMdQKPQWmAP3j/ZCG+qTE5pb28DAgMBAAECgYBihmxgFp0xqRL7eDaCBWT3nwjhvJm5VPYE3RzHj32kWVgq3dmpErGw5OQFE/51xj908CLTKQOUhL0tBGTJYxvQci8y9c0Ajt+epQt8wfe1pGJ/ORFP8AAFttMUYRqvjWX+kE+nmnM9jYe2Zqnj7PeUbNFCjwdUEhEeRDflYubzQQJBAMgsI6mWFJ4X7uS+hIemme5hgPQDg8aeoubdSOFYb34Em3wZO7lPHa/Y0UNFsmgE2NAfVuoWx7TNg/A2EbPhx6sCQQCt/zHV6nZNFcR5vfI60L7vd3cNAR4IY55C/n9TXZpihLT3WjOyo1yGyWDiD1o8Y4HKik8/JHeNK3Lv176EbD4JAkEAhYLrRnGTzt6nuGpaex/kC9t850Rw4Elu3g06TxNtSeBI1Lz/2NmsM12qNfSGylpxQl+k2P3Ytf9dwRpPNGujgQJAThhXXuMQXALkH5xQp3Nf741YQt74gt1rgDhIH7vIemWD7+1tfMVz1w91y6EGaEplS+oOLZIJkrQor1vPKBKJOQJAFRSzcW4F+GznqXVZ43o9UnyyqnZbEnDX+lssZdg3q5bJhvk1vjUTRq+uBLfNZX/x9kfVXAm6zn1YNMFXwEsRSg==";
        Map<String, String> map = MapUtils.createStrValue("unique", data,
                "sign", RSAUtil.sign(data, RSAUtil.getPrivateKey(privateKey)));
        System.out.println(map.get("sign"));
        boolean sign = RSAUtil.verify(data, RSAUtil.getPublicKey(publicKey), map.get("sign"));
        System.out.println(sign);
        String token = JWTUtils.getToken(map);
        System.out.println(token);

        DecodedJWT token1 = JWTUtils.getToken(token);
        String unique = token1.getClaim("unique").asString();
        System.out.println(unique);
        System.out.println(sdf.format(token1.getIssuedAt().getTime()));
        System.out.println(sdf.format(token1.getExpiresAt().getTime()));
        String format = sdf.format(token1.getExpiresAt().getTime());
        System.out.println(sdf.parse(format).getTime()+"++++++++++++");
        String s = "eyJ1bmlxdWUiOiJxd2VyIiwic2lnbiI6IkppQ2IvK0NHVDBZZVgxcFVNVEJQTFI3WWN0MlprTVo2Q0NkZTU2RTRjK1ZwTDBCRUpvYk9PYWpON1ZLT1h1bk8rQy9WTnZ5SC9jWVlBbkVpdCtpL1lDQXRXcEtSb1hsS1lGMmxhaEExQzQyaUhWbDVsd0xNTEZMb1FueGxwcGRMajJRdE5TcVdMUmV3eDBTVHFzUGdER3lob05IcmNMbkoyeVRPZFNBdXhIST0iLCJleHAiOjE2NTIxNjkxMjUsImlhdCI6MTY1MjA4MjcyNX0";
//        byte[] decode = Base64.decode(s);
//        String s1 = new String(decode);

        java.util.Base64.Decoder de = java.util.Base64.getUrlDecoder();
        byte[] s1 = de.decode(s);
        String s2 = new String(s1);
        JSONObject jsonObject = JSON.parseObject(s2);
        String string = jsonObject.get("exp").toString();
        System.out.println(string);


    }
}
