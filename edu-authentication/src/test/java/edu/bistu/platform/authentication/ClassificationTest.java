package edu.bistu.platform.authentication;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bistu.platform.authentication.controller.CoursesClassificationController;
import edu.bistu.platform.authentication.service.CoursesClassificationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml", "classpath*:spring/spring-mybatis.xml"})
public class ClassificationTest {
	
	@Autowired
	CoursesClassificationService ClassificationService;
	@Autowired
	CoursesClassificationController classificationController ;
	
	@Test
	public void test01(){
//		List<SysCoursesClassification> list = classificationController.getClassification("大数据");
//		System.out.println(list);
		
//		boolean b = classificationController.deleteClassification(4);
//		System.out.println(b);
		
		Map<String, Object> map = classificationController.batchDeleteClassification("14,15");
		System.out.println(map);
//		
//		SysCoursesClassification classification = new SysCoursesClassification();
//		classification.setClassificationName("语言课程");
//		ClassificationService.addClassification(classification);
		
//		SysCoursesClassification classification2 = ClassificationService.getClassification(4);
//		classification2.setClassificationInfo("关于课程的介绍");
//		ClassificationService.updateclassification(classification2);
//		Map<SysCoursesClassification, List<Map>> classification = ClassificationService.getClassification("学习");
//		System.out.println(classification);
		
	}
	

}
