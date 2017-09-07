package edu.bistu.platform.authentication.orm.model.user;

public class SysUserResource {
    private Integer userId;

    private String resourceName;

    private String url;

    private Integer isNavbar;

    private Integer status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getIsNavbar() {
        return isNavbar;
    }

    public void setIsNavbar(Integer isNavbar) {
        this.isNavbar = isNavbar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}