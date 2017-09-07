package edu.bistu.platform.authentication.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bistu.platform.authentication.model.CodeImage;
import edu.bistu.platform.authentication.model.LoginResult;
import edu.bistu.platform.authentication.orm.model.user.SysUser;
import edu.bistu.platform.authentication.service.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户登录、登出")
@RestController
@RequestMapping(value = "/auth")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public LoginResult login(@RequestParam(name = "username", required = true) String username,
            @RequestParam(name = "password", required = true) String password,
            @RequestParam(name = "codes", required = false, defaultValue = "") String codes, HttpServletRequest request) throws Exception {
        LoginResult result = new LoginResult();
        // 验证码验证
        String codesinSession = request.getSession(true).getAttribute("codes").toString();
        if (!codesinSession.toLowerCase().equals(codes.toLowerCase())) {
            result.setMessage("验证码错误");
            return result;
        }
        // 用户名密码验证
        result = userLoginService.login(username, password);
        if (!result.isSuccess()) {
            return result;
        }
        SysUser user = userLoginService.getUserWhoseLoginNameIs(username);
        user.setPassword("");
        request.getSession(true).setAttribute("user", user);
        result.setUser(user);
        return result;
    }

    @ApiOperation(value = "登出")
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    @ResponseBody
    public boolean logout(HttpServletRequest request) {
        request.getSession(true).removeAttribute("user");
        return true;
    }

    @ApiOperation(value = "验证码")
    @RequestMapping(value = "/code", method = {RequestMethod.GET})
    @ResponseBody
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CodeImage codeImage = new CodeImage(92, 46);
        codeImage.setLineNum(6);
        codeImage.setCodeNum(4);
        codeImage.setFormat("jpeg");
        codeImage.draw();
        String codes = codeImage.getCodes();
        String imageBase64 = codeImage.getImageBase64();
        String format = codeImage.getFormat();
        request.getSession(true).setAttribute("codes", codes);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/" + format);
        response.getOutputStream().write(Base64.decodeBase64(imageBase64));
        response.flushBuffer();
    }
}
