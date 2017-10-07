package edu.bistu.platform.authentication;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bistu.platform.authentication.controller.CoursesController;
import edu.bistu.platform.authentication.orm.model.chapter.SysChapter;
import edu.bistu.platform.authentication.orm.model.cources.SysCourses;
import edu.bistu.platform.authentication.service.CoursesService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml", "classpath*:spring/spring-mybatis.xml"})
public class CoursesTest {

	@Autowired
	CoursesService coursesService;
	
	@Autowired
	CoursesController coursesController;
	
	@Test
	public void test() {
//		SysCourses course = new SysCourses();
//		course.setCoursesName("课程名0001");
		//course.setCoursesClassification("课程所在分类");
		//coursesService.addCourses(course);
		//coursesService.deleteCourse(3);
		//coursesService.updateCourse(3);
		//SysCourses courses = coursesService.getCourses(1);
		//coursesService.deleteCourse(5);
		
		Map<String, Object> map = coursesController.batchDeleteCourses("12,13");
		System.out.println(map);
		//System.out.println(courses);
		
//		SysCourses courses2 = coursesService.getCourses(4);
//		courses2.setCoursesName("机器学习课程");
//		courses2.setCoursesClassification("机器学习");
//		coursesService.updateCourse(courses2);
//		System.out.println(courses2);
		
//		Map<String, List<SysChapter>> map = coursesController.getAllCourses("1608");
//		System.out.println(map);
		
//		coursesController.deleteCourses(5);
		
//		coursesController.updateCourses(1, "英语六级课程", 2, "234.2", "六级简介");
		
		
	}

}
