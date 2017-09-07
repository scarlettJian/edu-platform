package edu.bistu.platform.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.user.SysUserResourceMapper;
import edu.bistu.platform.authentication.orm.model.user.SysUser;
import edu.bistu.platform.authentication.orm.model.user.SysUserResourceExample;

@Service
public class UserResourceService {

    @Autowired
    SysUserResourceMapper sysUserResourceMapper;

    public boolean hasResource(SysUser user, String uri) {
        SysUserResourceExample example = new SysUserResourceExample();
        example.getCriteria().andUserIdEqualTo(user.getUserId());
        example.getCriteria().andUrlEqualTo(uri);
        long count = sysUserResourceMapper.countByExample(example);
        if (count > 0)
            return true;
        return false;
    }

}
