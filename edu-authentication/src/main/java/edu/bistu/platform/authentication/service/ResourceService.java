package edu.bistu.platform.authentication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.resource.SysResourceMapper;
import edu.bistu.platform.authentication.orm.mapper.role.SysRoleResourceMapper;
import edu.bistu.platform.authentication.orm.model.resource.SysResource;

@Service
public class ResourceService {
    private final static Logger LOG = LoggerFactory.getLogger(ResourceService.class);

    @Autowired
    SysResourceMapper sysResourceMapper;
    @Autowired
    SysRoleResourceMapper sysRoleResourceMapper;

    // Resource 本身相关的
    public SysResource getResource(int resourceId) {
        SysResource resource = sysResourceMapper.selectByPrimaryKey(resourceId);
        return resource;
    }

    public SysResource addResource(SysResource resource) {
        sysResourceMapper.insertSelective(resource);
        return resource;
    }

    public SysResource updateResource(SysResource resource) {
        sysResourceMapper.updateByPrimaryKeySelective(resource);
        return resource;
    }

    public boolean deleteResource(int resourceId) {
        sysRoleResourceMapper.deleteByRoleId(resourceId);
        sysResourceMapper.deleteByPrimaryKey(resourceId);
        return true;
    }

}
