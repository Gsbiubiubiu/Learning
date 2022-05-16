package com.gs.common.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import sun.misc.IOUtils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

/**
 * @User远
 * @Date2022/4/21
 */
@Slf4j
public class RSAUtil {
    public static final String CHARSET = "UTF-8";
    public static final String RSA_ALGORITHM = "RSA";


    public static Map<String, String> createKeys(int keySize){
        //为RSA算法创建一个KeyPairGenerator对象（KeyPairGenerator，密钥对生成器，用于生成公钥和私钥对）
        KeyPairGenerator kpg;
        try{
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        }catch(NoSuchAlgorithmException e){
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded()); //返回一个publicKey经过二次加密后的字符串
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());//返回一个privateKey经过二次加密后的字符串

        Map<String, String> keyPairMap = new HashMap<String, String>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);
        log.info("pub:{}, pri:{}", publicKeyStr, privateKeyStr);
        return keyPairMap;
    }

    /**
     * 得到公钥
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * 得到私钥
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

    /**
     * 公钥加密
     * @param data
     * @param publicKey
     * @return
     */
    public static String publicEncrypt(String data, RSAPublicKey publicKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), publicKey.getModulus().bitLength()));
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * 私钥解密
     * @param data
     * @param privateKey
     * @return
     */

    public static String privateDecrypt(String data, RSAPrivateKey privateKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), privateKey.getModulus().bitLength()), CHARSET);
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * 私钥加密
     * @param data
     * @param privateKey
     * @return
     */

    public static String privateEncrypt(String data, RSAPrivateKey privateKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), privateKey.getModulus().bitLength()));
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * 公钥解密
     * @param data
     * @param publicKey
     * @return
     */

    public static String publicDecrypt(String data, RSAPublicKey publicKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), CHARSET);
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) throws IOException {
        int maxBlock = 0;
        if(opmode == Cipher.DECRYPT_MODE){
            maxBlock = keySize / 8;
        }else{
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try{
            while(datas.length > offSet){
                if(datas.length-offSet > maxBlock){
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                }else{
                    buff = cipher.doFinal(datas, offSet, datas.length-offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        }catch(Exception e){
            throw new RuntimeException("加解密阀值为["+maxBlock+"]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        out.close();
        return resultDatas;
    }

//    public static byte[] sign(byte[] data, PrivateKey privateKey)
//            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
//        Signature signature = Signature.getInstance(ALGORITHM);
//        signature.initSign(privateKey);
//        signature.update(data);
//        return signature.sign();
//    }
//
//    public static String sign(String data, PrivateKey privateKey)
//            throws InvalidKeyException, NoSuchAlgorithmException, SignatureException {
//        return Base64.encodeBase64URLSafeString(sign(data.getBytes(), privateKey)).trim();
//    }
//
//
//    /**
//     * 签名校验
//     *
//     * @param data      参与签名的数据
//     * @param sign      数字签名
//     * @param publicKey 公钥
//     * @return: {@link boolean }
//     * @author: Andy
//     * @time: 2019/5/10 17:22
//     */
//    public static boolean verify(byte[] data, byte[] sign, PublicKey publicKey)
//            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
//        Signature signature = Signature.getInstance(ALGORITHM);
//        signature.initVerify(publicKey);
//        signature.update(data);
//        return signature.verify(sign);
//    }
//
//    /**
//     * 签名校验
//     *
//     * @param data      参与签名的数据
//     * @param sign      数字签名
//     * @param publicKey 公钥
//     * @return: {@link boolean }
//     * @author: Andy
//     * @time: 2019/5/10 17:22
//     */
//    public static boolean verify(String data, String sign, PublicKey publicKey)
//            throws InvalidKeyException, NoSuchAlgorithmException, SignatureException {
//        return verify(data.getBytes(), Base64.decodeBase64(sign), publicKey);
//    }

    /**
     * 签名
     *
     * @param data 待签名数据
     * @param privateKey 私钥
     * @return 签名
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey key = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(key);
        signature.update(data.getBytes(CHARSET));
        return new String(Base64.encodeBase64(signature.sign()),CHARSET);
    }

    /**
     * 验签
     *
     * @param srcData 原始字符串
     * @param publicKey 公钥
     * @param sign 签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
        byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(key);
        signature.update(srcData.getBytes(CHARSET));
        return signature.verify(Base64.decodeBase64(sign.getBytes(CHARSET)));
    }

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
//        Map<String, String> keyMap = RSAUtil.createKeys(1024);
//        String  publicKey = keyMap.get("publicKey");
//        String  privateKey = keyMap.get("privateKey");
//        System.out.println("公钥: \n\r" + publicKey);
//        System.out.println("私钥： \n\r" + privateKey);
//
//        System.out.println("公钥加密——私钥解密");
//        String str = "寒山月初℃";
//        System.out.println("\r明文：\r\n" + str);
//        System.out.println("\r明文大小：\r\n" + str.getBytes().length);
//        String encodedData = RSAUtil.publicEncrypt(str, RSAUtil.getPublicKey(publicKey));
//        System.out.println("密文：\r\n" + encodedData);
//        String decodedData = RSAUtil.privateDecrypt(encodedData, RSAUtil.getPrivateKey(privateKey));
//        System.out.println("解密后文字: \r\n" + decodedData);
//        try {
//            String sign = sign(str, RSAUtil.getPrivateKey(privateKey));
//            System.out.println("签名数据" + sign);
//            boolean verify = verify(str, RSAUtil.getPublicKey(publicKey), sign);
//            System.out.println(verify);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        DecodedJWT token = JWTUtils.getToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1bmlxdWUiOiJxd2VyIiwic2lnbiI6IkppQ2IvK0NHVDBZZVgxcFVNVEJQTFI3WWN0MlprTVo2Q0NkZTU2RTRjK1ZwTDBCRUpvYk9PYWpON1ZLT1h1bk8rQy9WTnZ5SC9jWVlBbkVpdCtpL1lDQXRXcEtSb1hsS1lGMmxhaEExQzQyaUhWbDVsd0xNTEZMb1FueGxwcGRMajJRdE5TcVdMUmV3eDBTVHFzUGdER3lob05IcmNMbkoyeVRPZFNBdXhIST0iLCJleHAiOjE2NTIxNTAxMTksImlhdCI6MTY1MjA2MzcxOX0.EcVYRofzncR8YQODtZkk_B9aIeu8MlhLjwKcfP4gnlw");
        System.out.println(token.getExpiresAt().getTime());
        token.getExpiresAt().getTime();
    }
}
