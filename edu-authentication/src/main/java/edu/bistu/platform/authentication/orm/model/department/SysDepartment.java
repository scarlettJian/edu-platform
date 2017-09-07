package edu.bistu.platform.authentication.orm.model.department;

import java.util.Date;

public class SysDepartment {
    private Integer departmentId;

    private Integer parentDepartmentId;

    private String departmentName;

    private Integer departmentLevel;

    private String departmentPidJoin;

    private Integer departmentStatus;

    private Integer isIllegalsite;

    private String contactUser;

    private String contactType;

    private Date createDate;

    private Date expiredDate;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getParentDepartmentId() {
        return parentDepartmentId;
    }

    public void setParentDepartmentId(Integer parentDepartmentId) {
        this.parentDepartmentId = parentDepartmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(Integer departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    public String getDepartmentPidJoin() {
        return departmentPidJoin;
    }

    public void setDepartmentPidJoin(String departmentPidJoin) {
        this.departmentPidJoin = departmentPidJoin == null ? null : departmentPidJoin.trim();
    }

    public Integer getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(Integer departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public Integer getIsIllegalsite() {
        return isIllegalsite;
    }

    public void setIsIllegalsite(Integer isIllegalsite) {
        this.isIllegalsite = isIllegalsite;
    }

    public String getContactUser() {
        return contactUser;
    }

    public void setContactUser(String contactUser) {
        this.contactUser = contactUser == null ? null : contactUser.trim();
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType == null ? null : contactType.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}