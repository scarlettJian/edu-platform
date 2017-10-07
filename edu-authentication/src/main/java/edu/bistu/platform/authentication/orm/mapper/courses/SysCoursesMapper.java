package edu.bistu.platform.authentication.orm.mapper.courses;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bistu.platform.authentication.orm.model.cources.SysCourses;

public interface SysCoursesMapper {
	
	int insertCourses(SysCourses record);
	int insertCoursesSelective(SysCourses record);
	
	@Delete(value="delete from sys_courses where coursesId=#{coursesId}")
	int deleteByPrimaryKey(Integer coursesId);
	

	int updateCourses(SysCourses record);
	
	SysCourses selectByPrimaryKey(Integer coursesId);
	List<SysCourses> selectByCoursesName(@Param("coursesName")String coursesName,@Param("classificationName")String classificationName);
	List<SysCourses> selectAllCourses();
	List<SysCourses> selectByclassificationId(Integer classificationId);
	
	List<SysCourses> selectAllCoursesByStuClass(String studentClass);
	int batchDeleteByPrimaryKey(String[] coursesId);
	
	
	
}
