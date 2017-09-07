package edu.bistu.platform.authentication.orm.mapper.user;

import edu.bistu.platform.authentication.orm.model.user.SysUserResource;
import edu.bistu.platform.authentication.orm.model.user.SysUserResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserResourceMapper {
    long countByExample(SysUserResourceExample example);

    int deleteByExample(SysUserResourceExample example);

    int insert(SysUserResource record);

    int insertSelective(SysUserResource record);

    List<SysUserResource> selectByExample(SysUserResourceExample example);

    int updateByExampleSelective(@Param("record") SysUserResource record, @Param("example") SysUserResourceExample example);

    int updateByExample(@Param("record") SysUserResource record, @Param("example") SysUserResourceExample example);
}