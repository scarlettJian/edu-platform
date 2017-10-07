package edu.bistu.platform.authentication;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bistu.platform.authentication.controller.ChapterController;
import edu.bistu.platform.authentication.orm.model.chapter.SysChapter;
import edu.bistu.platform.authentication.service.ChapterService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml", "classpath*:spring/spring-mybatis.xml"})

public class ChapterTest {

	@Autowired
	ChapterService chapterService;
	@Autowired
	ChapterController chapterController; 
	
	@Test
	public void test() {
		//List<SysChapter> list = chapterService.getChapterByCoursesId(1);
		//System.out.println(list);
//		chapterController.addChapter(4, "大数据第一章", "1232", "www.123.com", "章节简介");
		
//		 chapterController.updateChapter(10, 3, "chapter01", "12.5", "www.asadda.com/xzz.xml", "简介001");
		
		Map<String, Object> map = chapterController.batchDeleteClassification("3,4,5");
		System.out.println(map);
	}

}
