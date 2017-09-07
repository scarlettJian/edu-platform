package edu.bistu.platform.authentication;

import edu.bistu.platform.authentication.orm.model.user.SysUser;

public class AuthContextUtil {
    private final static ThreadLocal<SysUser> currentUser = new ThreadLocal<>();

    public static void setCuttenrUser(SysUser user) {
        AuthContextUtil.currentUser.set(user);
    }

    public static SysUser getUser() throws Exception {
        SysUser user = AuthContextUtil.currentUser.get();
        if (user == null)
            throw new Exception("用户还未登录");
        return AuthContextUtil.currentUser.get();
    }

    public static void remove() {
        AuthContextUtil.currentUser.remove();
    }
}
