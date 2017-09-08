package edu.bistu.platform.authentication.orm.mapper.role;

import edu.bistu.platform.authentication.orm.model.role.SysRole;
import edu.bistu.platform.authentication.orm.model.role.SysRoleUser;
import edu.bistu.platform.authentication.orm.model.role.SysRoleUserExample;
import edu.bistu.platform.authentication.orm.model.user.SysUser;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysRoleUserMapper {
    long countByExample(SysRoleUserExample example);

    int deleteByExample(SysRoleUserExample example);

    int deleteByPrimaryKey(Integer roleUserId);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    List<SysRoleUser> selectByExample(SysRoleUserExample example);

    SysRoleUser selectByPrimaryKey(Integer roleUserId);

    int updateByExampleSelective(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByExample(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);

    @Select("select sys_role.* from sys_role left join sys_role_user on sys_role_user.roleId=sys_role.roleId where sys_role_user.userId=#{userId}")
    List<SysRole> selectByUserId(int userId);

    @Select("select sys_user.* from sys_user left join sys_role_user on sys_role_user.roleId=sys_role.roleId where sys_role_user.roleId=#{roleId}")
    List<SysUser> selectByRoleId(int roleId);

    @Select("select count(*) from sys_role_user where roleId=#{roleId} and userId=#{userId}")
    int countByRoleIdAndUserId(@Param("roleId") int roleId, @Param("userId") int userId);

    @Delete("delete from sys_role_user where roleId=#{roleId} and userId=#{userId}")
    int deleteByRoleIdAndUserId(@Param("roleId") int roleId, @Param("userId") int userId);

    @Delete("delete from sys_role_user where roleId=#{roleId}")
    int deleteByRoleId(Integer roleId);

    @Delete("delete from sys_role_user where userId=#{userId}")
    int deleteByUserId(Integer userId);
}
