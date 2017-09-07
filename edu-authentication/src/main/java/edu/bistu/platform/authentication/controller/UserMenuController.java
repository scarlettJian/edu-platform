package edu.bistu.platform.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bistu.platform.authentication.AuthContextUtil;
import edu.bistu.platform.authentication.orm.model.user.SysUser;
import edu.bistu.platform.authentication.orm.model.user.SysUserResource;
import edu.bistu.platform.authentication.service.UserMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user/menu")
@Api(tags = "用户导航菜单")
public class UserMenuController {

    @Autowired
    UserMenuService userMenuService;

    @ApiOperation(value = "获取")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<SysUserResource> getMenu() throws Exception {
        SysUser user = AuthContextUtil.getUser();
        List<SysUserResource> resources = userMenuService.getMenu(user);
        return resources;
    }

}
