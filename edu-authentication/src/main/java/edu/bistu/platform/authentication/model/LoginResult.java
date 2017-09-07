package edu.bistu.platform.authentication.model;

import edu.bistu.platform.authentication.orm.model.user.SysUser;

public class LoginResult {
    public boolean success = false;
    public String message = "";
    public String token = "";
    public SysUser user = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

}
