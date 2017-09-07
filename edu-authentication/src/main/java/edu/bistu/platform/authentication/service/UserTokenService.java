package edu.bistu.platform.authentication.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.model.LoginResult;
import edu.bistu.platform.authentication.orm.model.user.SysUser;

@Service
public class UserTokenService {
    @Autowired
    UserLoginService userLoginService;


    public LoginResult login(String userName, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        LoginResult result = userLoginService.login(userName, password);
        if (!result.isSuccess())
            return result;
        SysUser user = userLoginService.getUserWhoseLoginNameIs(userName);
        result.setToken("" + System.currentTimeMillis() + user.getUserId());
        return result;
    }

    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 加密后的字符串
        String newstr = Base64.encodeBase64String(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
