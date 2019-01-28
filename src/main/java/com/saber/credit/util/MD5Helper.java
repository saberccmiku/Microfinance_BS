package com.saber.credit.util;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2019/1/22
 */
public class MD5Helper {
    /**
     * 字符加密
     * @param str 需要转换的字符
     * @return MD5字符
     * @throws NoSuchAlgorithmException 异常
     */
    public static String MD5Digest(String str) throws NoSuchAlgorithmException {
        return new BASE64Encoder().encode(DigestUtils.md5Digest(str.getBytes()));
    }

}
