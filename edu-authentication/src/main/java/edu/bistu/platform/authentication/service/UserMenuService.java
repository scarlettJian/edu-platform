package edu.bistu.platform.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bistu.platform.authentication.orm.mapper.user.SysUserResourceMapper;
import edu.bistu.platform.authentication.orm.model.user.SysUser;
import edu.bistu.platform.authentication.orm.model.user.SysUserResource;
import edu.bistu.platform.authentication.orm.model.user.SysUserResourceExample;

@Service
public class UserMenuService {
    @Autowired
    SysUserResourceMapper sysUserResourceMapper;

    @Transactional
    public List<SysUserResource> getMenu(SysUser user) {
        SysUserResourceExample example = new SysUserResourceExample();
        example.getCriteria().andUserIdEqualTo(user.getUserId());
        example.getCriteria().andIsNavbarEqualTo(1);
        example.getCriteria().andStatusEqualTo(1);
        List<SysUserResource> menus = sysUserResourceMapper.selectByExample(example);
        return menus;
    }
}
