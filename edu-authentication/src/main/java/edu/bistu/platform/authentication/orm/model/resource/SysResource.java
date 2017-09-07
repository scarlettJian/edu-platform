package edu.bistu.platform.authentication.orm.model.resource;

import java.util.Date;

public class SysResource {
    private Integer resourceId;

    private String resourceName;

    private Integer parentResourceId;

    private String url;

    private Integer isCommResource;

    private Integer isButton;

    private Integer isNavbar;

    private Integer seqNo;

    private String innerCode;

    private Integer level;

    private Integer status;

    private Date updateDate;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public Integer getParentResourceId() {
        return parentResourceId;
    }

    public void setParentResourceId(Integer parentResourceId) {
        this.parentResourceId = parentResourceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getIsCommResource() {
        return isCommResource;
    }

    public void setIsCommResource(Integer isCommResource) {
        this.isCommResource = isCommResource;
    }

    public Integer getIsButton() {
        return isButton;
    }

    public void setIsButton(Integer isButton) {
        this.isButton = isButton;
    }

    public Integer getIsNavbar() {
        return isNavbar;
    }

    public void setIsNavbar(Integer isNavbar) {
        this.isNavbar = isNavbar;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode == null ? null : innerCode.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}