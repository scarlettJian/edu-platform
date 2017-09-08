package edu.bistu.platform.authentication.orm.mapper.role;

import edu.bistu.platform.authentication.orm.model.resource.SysResource;
import edu.bistu.platform.authentication.orm.model.role.SysRoleResource;
import edu.bistu.platform.authentication.orm.model.role.SysRoleResourceExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysRoleResourceMapper {
    long countByExample(SysRoleResourceExample example);

    int deleteByExample(SysRoleResourceExample example);

    int deleteByPrimaryKey(Integer roleResourceId);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    List<SysRoleResource> selectByExample(SysRoleResourceExample example);

    SysRoleResource selectByPrimaryKey(Integer roleResourceId);

    int updateByExampleSelective(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    int updateByExample(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);

    @Delete("delete from sys_role_resource where roleId=#{roleId}")
    int deleteByRoleId(int roleId);

    @Delete("delete from sys_role_resource where resourceId=#{resourceId}")
    int deleteByResourceId(int resourceId);

    @Delete("delete from sys_role_resource where roleId=#{roleId} and resourceId=#{resourceId}")
    int deleteByRoleIdAndResourceId(@Param("roleId") int roleId, @Param("resourceId") int resourceId);

    @Select("select sys_resource.* from sys_resource "
            + "inner join sys_role_resource on sys_role_resource.resourceId = sys_resource.resoruceId "
            + "where sys_role_resource.roleId=#{roleId}")
    List<SysResource> selectByRoleId(int roleId);

    @Select("select * from sys_role_resource where roleId=#{roleId} and resourceId=#{resourceId}")
    SysRoleResource selectByRoleIdAndResourceId(@Param("roleId") int roleId, @Param("resourceId") int resourceId);
}
