package edu.bistu.platform.authentication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.department.SysDepartmentMapper;
import edu.bistu.platform.authentication.orm.mapper.role.SysRoleMapper;
import edu.bistu.platform.authentication.orm.mapper.role.SysRoleUserMapper;
import edu.bistu.platform.authentication.orm.mapper.user.SysUserMapper;
import edu.bistu.platform.authentication.orm.mapper.user.SysUserResourceMapper;
import edu.bistu.platform.authentication.orm.model.department.SysDepartment;
import edu.bistu.platform.authentication.orm.model.resource.SysResource;
import edu.bistu.platform.authentication.orm.model.role.SysRole;
import edu.bistu.platform.authentication.orm.model.role.SysRoleUser;
import edu.bistu.platform.authentication.orm.model.user.SysUser;
import edu.bistu.platform.authentication.orm.model.user.SysUserResourceExample;
import edu.bistu.platform.authentication.utils.MD5Util;

@Service
public class UserService {
    private final static Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SysDepartmentMapper sysDepartmentMapper;
    @Autowired
    SysRoleUserMapper sysRoleUserMapper;
    @Autowired
    SysUserResourceMapper sysUserResourceMapper;

    // user 本身相关的
    public SysUser getUser(int userId) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        if (user != null)
            user.setPassword("");
        return user;
    }

    public SysUser addUser(SysUser user, int creatorId) {
        if (user.getDepartmentId() == null)
            throw new IllegalArgumentException("The departmentId of the addedUser is null.");
        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(user.getDepartmentId());
        if (sysDepartment == null)
            throw new IllegalArgumentException("The department " + user.getDepartmentId() + " of the added user doesn't exist.");
        user.setUserId(null);
        user.setCreateUserId(creatorId);
        user.setPassword(MD5Util.MD5(user.getPassword()));
        sysUserMapper.insertSelective(user);
        user.setPassword("");
        return user;
    }

    public boolean updateUser(SysUser user) {
        if (user.getDepartmentId() != null) {
            SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(user.getDepartmentId());
            if (sysDepartment == null)
                throw new IllegalArgumentException("The department " + user.getDepartmentId() + " of the added user doesn't exist.");
        }
        user.setPassword(null);
        user.setCreateUserId(null);
        sysUserMapper.updateByPrimaryKeySelective(user);
        return true;
    }

    public boolean updatePassword(int userId, String oldPassword, String newPassword) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        if (!MD5Util.MD5(oldPassword).equals(user.getPassword())) {
            LOG.warn("The oldPassword of user {} doesn't corrent.", userId);
            return false;
        }
        SysUser updateUser = new SysUser();
        updateUser.setUserId(user.getUserId());
        updateUser.setPassword(MD5Util.MD5(newPassword));
        sysUserMapper.updateByPrimaryKeySelective(updateUser);
        return false;
    }

    public boolean forceUpdatePassword(int userId, String newPassword) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        SysUser updateUser = new SysUser();
        updateUser.setUserId(user.getUserId());
        updateUser.setPassword(MD5Util.MD5(newPassword));
        sysUserMapper.updateByPrimaryKeySelective(updateUser);
        return false;
    }

    public boolean deleteUser(int userId) {
        sysRoleUserMapper.deleteByUserId(userId);
        sysUserMapper.deleteByUserId(userId);
        return true;
    }

    // user -> role 相关的
    public List<SysRole> getAllRoles(int userId) {
        List<SysRole> sysRoles = sysRoleUserMapper.selectByUserId(userId);
        return sysRoles;
    }

    public boolean hasRole(int roleId, int userId) {
        int count = sysRoleUserMapper.countByRoleIdAndUserId(roleId, userId);
        if (count == 0)
            return false;
        return true;
    }

    public boolean addRole(int roleId, int userId) {
        int count = sysRoleUserMapper.countByRoleIdAndUserId(roleId, userId);
        if (count > 0)
            return true;
        SysRole role = sysRoleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            LOG.warn("The roleId {} doesn't exist", roleId);
            return false;
        }
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setUserId(userId);
        sysRoleUser.setRoleId(roleId);
        sysRoleUserMapper.insertSelective(sysRoleUser);
        return true;
    }

    public boolean deleteRole(int roleId, int userId) {
        sysRoleUserMapper.deleteByRoleIdAndUserId(roleId, userId);
        return true;
    }

    // user -> resource 相关的操作
    public List<SysResource> getAllResources(int userId) {
        List<SysResource> resources = sysUserResourceMapper.selectResourceByUserId(userId);
        return resources;
    }

    public boolean hasResource(int userId, String uri) {
        SysUserResourceExample example = new SysUserResourceExample();
        example.getCriteria().andUserIdEqualTo(userId);
        example.getCriteria().andUrlEqualTo(uri);
        long count = sysUserResourceMapper.countByExample(example);
        if (count > 0)
            return true;
        return false;
    }



}
