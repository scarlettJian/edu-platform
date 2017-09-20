package edu.bistu.platform.authentication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bistu.platform.authentication.orm.model.role.SysRole;
import edu.bistu.platform.authentication.service.RoleService;
import edu.bistu.platform.authentication.service.UserMenuService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml", "classpath*:spring/spring-mybatis.xml"})
public class UserMenuServiceTest {
    @Autowired
    UserMenuService userMenuService;

    @Autowired
    RoleService roleService;

    @Test
    public void test() {
        SysRole role = new SysRole();
        role.setRoleName("test");
        roleService.addRole(role);
        System.out.println();
        
        System.out.println("新加的测试");
    }
}
