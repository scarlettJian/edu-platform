package edu.bistu.platform.authentication.orm.mapper.user;

import edu.bistu.platform.authentication.orm.model.resource.SysResource;
import edu.bistu.platform.authentication.orm.model.user.SysUserResource;
import edu.bistu.platform.authentication.orm.model.user.SysUserResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserResourceMapper {
    long countByExample(SysUserResourceExample example);

    int deleteByExample(SysUserResourceExample example);

    int insert(SysUserResource record);

    int insertSelective(SysUserResource record);

    List<SysUserResource> selectByExample(SysUserResourceExample example);

    int updateByExampleSelective(@Param("record") SysUserResource record, @Param("example") SysUserResourceExample example);

    int updateByExample(@Param("record") SysUserResource record, @Param("example") SysUserResourceExample example);

    @Select("select sys_resource.* from sys_resource "
            + "inner join sys_role_resource on sys_role_resource.resourceId = sys_resource.resourceId"
            + "inner join sys_role on sys_role.roleId = sys_role_resource.roleId"
            + "inner join sys_role_user on sys_role_user.roleId = sys_role.roleId"
            + "inner join sys_user on sys_user.userId = sys_role_user.userId" + "where sys_user.userId= #{userId}")
    List<SysResource> selectResourceByUserId(@Param("userId") int userId);
}
