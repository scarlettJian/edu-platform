package edu.bistu.platform.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.chapter.SysChapterMapper;
import edu.bistu.platform.authentication.orm.mapper.courses.SysCoursesMapper;
import edu.bistu.platform.authentication.orm.mapper.courses.classification.SysCoursesClassificationMapper;
import edu.bistu.platform.authentication.orm.model.chapter.SysChapter;
import edu.bistu.platform.authentication.orm.model.cources.SysCourses;

@Service
public class CoursesService {

	@Autowired
	SysCoursesClassificationMapper  ClassificationMapper;
	@Autowired
	SysCoursesMapper coursesMapper;
	@Autowired
	SysChapterMapper chapterMapper;

	
	/**
	 * 添加课程
	 * @param course
	 * @return
	 */
	public SysCourses addCourses(SysCourses course) {
		coursesMapper.insertCoursesSelective(course);
		return course;

	}
	
	/**
	 * 删除课程
	 * @param coursesId
	 * @return
	 */
	public boolean deleteCourse(Integer coursesId){
		coursesMapper.deleteByPrimaryKey(coursesId);
		return true;
	}
	
	/**
	 * 修改课程
	 * @param course
	 * @return
	 */
	public boolean updateCourse(SysCourses course){
		//course.getCoursesId();
		coursesMapper.updateCourses(course);
		return true;
	}
	
	/**
	 * 查询一个课程
	 * @param coursesId 课程ID
	 * @return
	 */
	public SysCourses getCourses(Integer coursesId){
	SysCourses courses = coursesMapper.selectByPrimaryKey(coursesId);
	return courses;
	}
	
	/**
	 * 获取所有课程信息
	 * @return
	 */
	public List<SysCourses> getCourses(){
		List<SysCourses> list = coursesMapper.selectAllCourses();
		return list;
	}
	
	/**
	 * 条件查询课程
	 * @param coursesName 课程名
	 * @param classificationName 课程所属分类名
	 * @return
	 */
	public List<SysCourses> getCourses(String coursesName,String classificationName){
		List<SysCourses> coursesList = coursesMapper.selectByCoursesName(coursesName, classificationName);
		return coursesList;
	}
	
	/**
	 * 由studentClass获取该学生所有课程List
	 * @return
	 */
	public List<SysCourses> getCourses(String studentClass){
		List<SysCourses> classList = coursesMapper.selectAllCoursesByStuClass(studentClass);
		return classList;
	}

	public boolean batchDeleteChapter(String coursesId) {
		coursesMapper.batchDeleteByPrimaryKey(coursesId.split(","));
		return true;
	}
	

}
