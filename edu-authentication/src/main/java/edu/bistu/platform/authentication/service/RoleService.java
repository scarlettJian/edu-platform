package edu.bistu.platform.authentication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.department.SysDepartmentMapper;
import edu.bistu.platform.authentication.orm.mapper.role.SysRoleMapper;
import edu.bistu.platform.authentication.orm.mapper.role.SysRoleResourceMapper;
import edu.bistu.platform.authentication.orm.mapper.role.SysRoleUserMapper;
import edu.bistu.platform.authentication.orm.mapper.user.SysUserMapper;
import edu.bistu.platform.authentication.orm.mapper.user.SysUserResourceMapper;
import edu.bistu.platform.authentication.orm.model.resource.SysResource;
import edu.bistu.platform.authentication.orm.model.role.SysRole;
import edu.bistu.platform.authentication.orm.model.role.SysRoleExample;
import edu.bistu.platform.authentication.orm.model.role.SysRoleResource;
import edu.bistu.platform.authentication.orm.model.user.SysUser;

@Service
public class RoleService {
    private final static Logger LOG = LoggerFactory.getLogger(RoleService.class);
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysDepartmentMapper sysDepartmentMapper;
    @Autowired
    SysRoleUserMapper sysRoleUserMapper;
    @Autowired
    SysRoleResourceMapper sysRoleResourceMapper;
    @Autowired
    SysUserResourceMapper sysUserResourceMapper;

    // role 本身相关的
    public SysRole getRole(int roleId) {
        SysRole role = sysRoleMapper.selectByPrimaryKey(roleId);
        return role;
    }

    public SysRole addRole(SysRole role) {
        SysRoleExample example = new SysRoleExample();
        example.getCriteria().andRoleNameEqualTo(role.getRoleName());
        long count = sysRoleMapper.countByExample(example);
        if (count > 0) {
            throw new IllegalArgumentException("The roleName " + role.getRoleName() + " exists");
        }
        role.setRoleId(null);
        sysRoleMapper.insertSelective(role);
        return role;
    }

    public SysRole updateRole(SysRole role) {
        SysRoleExample example = new SysRoleExample();
        example.getCriteria().andRoleNameEqualTo(role.getRoleName());
        long count = sysRoleMapper.countByExample(example);
        if (count > 0) {
            throw new IllegalArgumentException("The roleName " + role.getRoleName() + " exists");
        }
        sysRoleMapper.updateByPrimaryKeySelective(role);
        return role;
    }

    public boolean deleteRole(int roleId) {
        sysRoleResourceMapper.deleteByRoleId(roleId);
        sysRoleUserMapper.deleteByRoleId(roleId);
        sysRoleMapper.deleteByRoleId(roleId);
        return true;
    }

    // role -> user
    public List<SysUser> getAllUsers(int roleId) {
        List<SysUser> users = sysRoleUserMapper.selectByRoleId(roleId);
        users.stream().forEach(user -> user.setPassword(""));
        return users;
    }

    // role -> resource
    public List<SysResource> getAllResources(int roleId) {
        List<SysResource> resources = sysRoleResourceMapper.selectByRoleId(roleId);
        return resources;
    }

    public SysRoleResource addResource(int resourceId, int roleId) {
        SysRoleResource roleResource = new SysRoleResource();
        roleResource.setResourceId(resourceId);
        roleResource.setRoleId(roleId);
        if (null == sysRoleResourceMapper.selectByRoleIdAndResourceId(roleId, resourceId))
            return null;
        sysRoleResourceMapper.insertSelective(roleResource);
        return roleResource;
    }

    public SysRoleResource deleteResource(int resourceId, int roleId) {
        SysRoleResource roleResource = sysRoleResourceMapper.selectByRoleIdAndResourceId(roleId, resourceId);
        if (roleResource == null)
            return null;
        sysRoleResourceMapper.deleteByRoleIdAndResourceId(roleId, resourceId);
        return roleResource;
    }

}
