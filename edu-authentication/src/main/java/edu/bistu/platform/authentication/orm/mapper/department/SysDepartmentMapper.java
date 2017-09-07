package edu.bistu.platform.authentication.orm.mapper.department;

import edu.bistu.platform.authentication.orm.model.department.SysDepartment;
import edu.bistu.platform.authentication.orm.model.department.SysDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDepartmentMapper {
    long countByExample(SysDepartmentExample example);

    int deleteByExample(SysDepartmentExample example);

    int deleteByPrimaryKey(Integer departmentId);

    int insert(SysDepartment record);

    int insertSelective(SysDepartment record);

    List<SysDepartment> selectByExample(SysDepartmentExample example);

    SysDepartment selectByPrimaryKey(Integer departmentId);

    int updateByExampleSelective(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    int updateByExample(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    int updateByPrimaryKeySelective(SysDepartment record);

    int updateByPrimaryKey(SysDepartment record);
}