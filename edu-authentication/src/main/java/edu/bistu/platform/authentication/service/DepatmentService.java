package edu.bistu.platform.authentication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.department.SysDepartmentMapper;
import edu.bistu.platform.authentication.orm.model.department.SysDepartment;

@Service
public class DepatmentService {
    private final static Logger LOG = LoggerFactory.getLogger(DepatmentService.class);

    @Autowired
    SysDepartmentMapper sysDepartmentMapper;

    // department 本身相关的
    public SysDepartment getDepartment(int depatemntId) {
        SysDepartment department = sysDepartmentMapper.selectByPrimaryKey(depatemntId);
        return department;
    }

    public SysDepartment addDepartment(SysDepartment department) {
        sysDepartmentMapper.insertSelective(department);
        return department;
    }

    public SysDepartment updateDepartment(SysDepartment department) {
        sysDepartmentMapper.updateByPrimaryKeySelective(department);
        return department;
    }

    public boolean deleteDepartment(int depatemntId) {
        sysDepartmentMapper.deleteByPrimaryKey(depatemntId);
        return true;
    }
}
