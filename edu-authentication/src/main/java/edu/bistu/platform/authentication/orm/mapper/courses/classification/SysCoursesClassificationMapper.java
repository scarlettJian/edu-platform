package edu.bistu.platform.authentication.orm.mapper.courses.classification;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bistu.platform.authentication.orm.model.cources.classification.SysCoursesClassification;

public interface SysCoursesClassificationMapper {
	
	int insertClassification(SysCoursesClassification record);
	int insertClassificationSelective(SysCoursesClassification record);
	
	@Delete(value="delete from sys_courses_classification where classificationId=#{classificationId}")
	int deleteClassificationByPrimaryKey(Integer classificationId);
	int batchDeleteByPrimaryKey(String[] classificationId);
	
	int updateClassification(SysCoursesClassification record);
	
	SysCoursesClassification selectClassificationByPrimaryKey(Integer classificationId);
	List<SysCoursesClassification> selectClassificationByCoursesName(@Param("classificationName")String classificationName);
	List<SysCoursesClassification> selectClassification();
	
	
	

}
