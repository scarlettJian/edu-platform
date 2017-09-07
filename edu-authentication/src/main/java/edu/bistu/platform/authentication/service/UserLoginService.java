package edu.bistu.platform.authentication.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.model.LoginResult;
import edu.bistu.platform.authentication.orm.mapper.department.SysDepartmentMapper;
import edu.bistu.platform.authentication.orm.mapper.user.SysUserMapper;
import edu.bistu.platform.authentication.orm.model.department.SysDepartment;
import edu.bistu.platform.authentication.orm.model.user.SysUser;
import edu.bistu.platform.authentication.orm.model.user.SysUserExample;
import edu.bistu.platform.authentication.utils.MD5Util;

@Service
public class UserLoginService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysDepartmentMapper sysDepartmentMapper;

    public SysUser getUserWhoseLoginNameIs(String loginName) {
        if (StringUtils.isBlank(loginName))
            return null;
        SysUserExample example = new SysUserExample();
        example.getCriteria().andLoginNameEqualTo(loginName);
        List<SysUser> users = sysUserMapper.selectByExample(example);
        if (users == null || users.size() == 0)
            return null;
        SysUser user = users.get(0);
        user.setPassword("");
        return user;
    }

    public SysDepartment getDepartmentOf(SysUser user) {
        if (user == null)
            return null;
        SysDepartment department = sysDepartmentMapper.selectByPrimaryKey(user.getDepartmentId());
        return department;
    }

    public LoginResult login(String userName, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        password = MD5Util.MD5(password);
        LoginResult result = new LoginResult();
        result.setSuccess(false);
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            result.setMessage("用户名或密码不能为空");
            return result;
        }
        String message = "";
        // 验证用户有效性
        SysUser user = getUserWhoseLoginNameIs(userName);
        if (user == null) {
            result.setMessage("用户名或密码错误");
            return result;
        } else if (!user.getPassword().equals(password)) {
            user.loginFail();
            result.setMessage("用户名或密码错误");
        } else if (user.getStatus() != 1) {
            user.loginFail();
            result.setMessage("用户名被禁用，请联系管理员");
        }

        // 验证机构有效性
        SysDepartment department = getDepartmentOf(user);
        if (department == null) {
            result.setMessage("用户所属机构已被删除，请联系管理员");
        } else if (department.getExpiredDate().getTime() <= System.currentTimeMillis()) {
            result.setMessage("机构已失效，请联系管理员");
        } else if (department.getDepartmentStatus() != 1) {
            result.setMessage("机构被禁用，请联系管理员");
        }

        // 用户机构信息验证失败，更新用户登录成功次数和失败次数，以及最近登录时间
        if (!message.equals("")) {
            sysUserMapper.updateByPrimaryKeySelective(user);
            return result;
        }
        // 用户信息和机构信息验证通过
        user.loginSuccess();
        result.setSuccess(true);
        sysUserMapper.updateByPrimaryKeySelective(user);
        return result;
    }

    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 加密后的字符串
        String newstr = Base64.encodeBase64String(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    // private void loginSuccess(SysUser user) {
    // user.setLogindate(new Date());
    // if (user.getLogincount() == null)
    // user.setLogincount(0);
    // user.setLogincount(user.getLogincount() + 1);
    // }
    //
    // private void loginFail(SysUser user) {
    // user.setLogindate(new Date());
    // if (user.getFailcount() == null)
    // user.setFailcount(0);
    // user.setFailcount(user.getFailcount() + 1);
    // }
}
