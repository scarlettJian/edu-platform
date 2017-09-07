package edu.bistu.platform.authentication.orm.model.user;

import java.util.Date;

public class SysUser {
    private Integer userId;

    private String loginName;

    private String password;

    private String name;

    private Integer status;

    private Integer organId;

    private Integer departmentId;

    private String limitLoginIp;

    private Date lastLoginDate;

    private Integer loginCount;

    private Integer failCount;

    private String mobile;

    private String email;

    private Date createtDate;

    private Integer createUserId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getLimitLoginIp() {
        return limitLoginIp;
    }

    public void setLimitLoginIp(String limitLoginIp) {
        this.limitLoginIp = limitLoginIp == null ? null : limitLoginIp.trim();
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreatetDate() {
        return createtDate;
    }

    public void setCreatetDate(Date createtDate) {
        this.createtDate = createtDate;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public void loginSuccess() {
        this.setLastLoginDate(new Date());
        if (this.getLoginCount() == null)
            this.setLoginCount(0);
        this.setLoginCount(this.getLoginCount() + 1);
    }

    public void loginFail() {
        this.setLastLoginDate(new Date());
        if (this.getFailCount() == null)
            this.setFailCount(0);
        this.setFailCount(this.getFailCount() + 1);
    }
}
