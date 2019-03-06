package com.example.demo.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//  md5加密
public class SecurityTool {
    public static String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.getEncoder().encodeToString(md5.digest(str.getBytes("utf-8")));
    }
}
