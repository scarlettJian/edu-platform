package edu.bistu.platform.authentication;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bistu.platform.authentication.orm.model.user.SysUser;
import edu.bistu.platform.authentication.orm.model.user.SysUserResource;
import edu.bistu.platform.authentication.service.UserMenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml", "classpath*:spring/spring-mybatis.xml"})
public class UserMenuServiceTest {
    @Autowired
    UserMenuService userMenuService;

    @Test
    public void test() {
        SysUser user = new SysUser();
        user.setUserId(1);
        getClass();
        List<SysUserResource> menus = userMenuService.getMenu(user);
    }
}
