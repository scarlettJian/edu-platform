package edu.bistu.platform.authentication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bistu.platform.authentication.orm.model.chapter.SysChapter;
import edu.bistu.platform.authentication.orm.model.cources.SysCourses;
import edu.bistu.platform.authentication.orm.model.cources.classification.SysCoursesClassification;
import edu.bistu.platform.authentication.service.ChapterService;
import edu.bistu.platform.authentication.service.CoursesClassificationService;
import edu.bistu.platform.authentication.service.CoursesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="课程管理")
@RestController
@RequestMapping(value="/courses")
public class CoursesController {
	
	@Autowired
	CoursesService coursesService;
	@Autowired
	ChapterService chapterService;
	@Autowired
	CoursesClassificationService classificationService;
	
	
	/**
	 * 【难点：进度 完成情况】
	 * @param studentClass
	 * @return
	 */
	@ApiOperation(value="当前学生的所有课程")//studentId
	@RequestMapping(value="/student/myCourses/{studentClass}",method= {RequestMethod.GET})
	@ResponseBody
	public List<SysCourses> getAllCourses(@RequestParam(value ="studentClass")String studentClass){
		//1.studentId--student--studentClass--coursesId--courses
		List<SysCourses> list = coursesService.getCourses(studentClass);
		return list;
	}
	
//	@ApiOperation(value="按指定条件查看课程，以及课程下所有章节")
//	@RequestMapping(value="/manager/selectCourses",method= {RequestMethod.GET})
//	@ResponseBody
//	public Map<SysCourses, List<SysChapter>> getCourses(@RequestParam(value ="coursesName")String coursesName,@RequestParam(value ="classificationName")String classificationName){
//		Map<SysCourses, List<SysChapter>> map = new HashMap<SysCourses, List<SysChapter>>();
//		List<SysCourses> coursesList = coursesService.getCourses(coursesName, classificationName);
//		for (SysCourses courses : coursesList) {
//			List<SysChapter> chapterList = chapterService.getChapterByCoursesId(courses.getCoursesId());
//			map.put(courses, chapterList);
//		}
//		return map;
//	}
	@ApiOperation(value="按指定条件查看课程【搜索栏查看课程】")
	@RequestMapping(value="/manager/selectCourses",method= {RequestMethod.GET})
	@ResponseBody
	public List<SysCourses> getCourses(@RequestParam(value ="coursesName")String coursesName,@RequestParam(value ="classificationName")String classificationName){
		List<SysCourses> coursesList = coursesService.getCourses(coursesName, classificationName);
		return coursesList;
	}
	
	@ApiOperation(value="查找某一分类下所有课程")
	@RequestMapping(value="/manager/selectCourses/{classificationId}",method= {RequestMethod.GET})
	@ResponseBody
	public List<SysCourses> getCourses(@PathVariable(value ="classificationId")Integer classificationId){
		SysCoursesClassification classification = classificationService.getClassification(classificationId);
		List<SysCourses> coursesList = coursesService.getCourses("", classification.getClassificationName());
		return coursesList;
	}

//	@ApiOperation(value="管理员端：查看所有课程")
//	@RequestMapping(value="/manager/managerCourses",method= {RequestMethod.GET})
//	@ResponseBody
//	public Map<SysCourses, List<SysChapter>> getCourses(){
//		Map<SysCourses, List<SysChapter>> map = new HashMap<SysCourses, List<SysChapter>>();
//		List<SysCourses> list = coursesService.getCourses();
//		for (SysCourses sysCourses : list) {
//			Integer coursesId = sysCourses.getCoursesId();
//			List<SysChapter> chapterList = chapterService.getChapterByCoursesId(coursesId);
//			map.put(sysCourses, chapterList);
//		}
//		return map;
//		
//	}
	@ApiOperation(value="查看所有课程")
	@RequestMapping(value="/manager/managerCourses",method= {RequestMethod.GET})
	@ResponseBody
	public List<SysCourses> getCourses(){
		List<SysCourses> list = coursesService.getCourses();
		return list;
	}
	
//	@RequestMapping(value="/manager/managerCourses",method= {RequestMethod.POST})
//	@ResponseBody
//	public void addCourses(@RequestParam(name = "coursesName",required = true)String coursesName,
//			@RequestParam(name = "classificationId",required = true)Integer classificationId,
//			@RequestParam(name = "coursesTime",required = true)String coursesTime,
//			@RequestParam(name = "coursesInfo",required = true)String coursesInfo){
//		SysCourses courses = new SysCourses();
//		courses.setCoursesName(coursesName);
//		courses.setClassificationId(classificationId);
//		courses.setCoursesTime(coursesTime);
//		courses.setCoursesInfo(coursesInfo);
//		
//		coursesService.addCourses(courses);
//	}
	
//	@ApiOperation(value="管理员端：新增课程")
//	@RequestMapping(value="/manager/managerCourses/{classificationId}",method= {RequestMethod.POST})
//	@ResponseBody
//	public void addCourses(@RequestParam(name = "coursesName",required = true)String coursesName,
//			@PathVariable(name = "classificationId",required = true)Integer classificationId,
//			@RequestParam(name = "coursesTime",required = true)String coursesTime,
//			@RequestParam(name = "coursesInfo",required = true)String coursesInfo){
//		SysCourses courses = new SysCourses();
//		courses.setCoursesName(coursesName);
//		courses.setClassificationId(classificationId);
//		courses.setCoursesTime(coursesTime);
//		courses.setCoursesInfo(coursesInfo);
//		
//		coursesService.addCourses(courses);
//	}
	@ApiOperation(value="新增课程")
	@RequestMapping(value="/manager/managerCourses",method= {RequestMethod.POST})
	@ResponseBody
	public void addCourses(@RequestParam(name = "coursesName",required = true)String coursesName,
			@RequestParam(name = "classificationId",required = true)Integer classificationId,
			@RequestParam(name = "coursesTime",required = true)String coursesTime,
			@RequestParam(name = "coursesInfo",required = true)String coursesInfo){
		SysCourses courses = new SysCourses();
		courses.setCoursesName(coursesName);
		courses.setClassificationId(classificationId);
		courses.setCoursesTime(coursesTime);
		courses.setCoursesInfo(coursesInfo);
		
		coursesService.addCourses(courses);
	}
	
	
	@ApiOperation(value="删除课程")
	@RequestMapping(value="/manager/managerCourses/{coursesId}",method= {RequestMethod.DELETE})
	@ResponseBody
	public boolean deleteCourses(@PathVariable("coursesId")Integer coursesId){
		List<SysChapter> chapterList = chapterService.getChapterByCoursesId(coursesId);
		if(chapterList == null || chapterList.isEmpty()){
			coursesService.deleteCourse(coursesId);
			return true;
		}else{
			return false;
		}
		
	}
	@ApiOperation(value="批量删除课程")
	@RequestMapping(value="/manager/managerCourses/doDelete",method= {RequestMethod.DELETE})
	@ResponseBody
	public Map<String, Object> batchDeleteCourses(String coursesId){
		Map<String, Object> map=new HashMap<String, Object>();
		//1.确定是否选中课程项
		if(coursesId.isEmpty() || coursesId == null){
			map.put("message", "未选中分类");
		}else{
			String[] split = coursesId.split(",");
			//2.对选中的每一个课程查询是否存在章节，存在则不予删除
			for (int i = 0; i < split.length; i++) {
				Integer id = Integer.parseInt(split[i]);
				List<SysChapter> chapterList = chapterService.getChapterByCoursesId(id);
				if (!chapterList.isEmpty()) {
					map.put("message", "存在课程下章节不为空，不予删除");
					return map;
				}
			}
			coursesService.batchDeleteChapter(coursesId);
			map.put("message", "删除成功");
		}
		return map;
	}
				
				
				
	
	
	@ApiOperation(value="修改课程页面显示")
	@RequestMapping(value="/manager/managerCourses/{coursesId}",method= {RequestMethod.GET})
	@ResponseBody
	public SysCourses getUpdateCourses(@PathVariable("coursesId")Integer coursesId){
		SysCourses courses = coursesService.getCourses(coursesId);
		return courses;
	}
	
	
	@ApiOperation(value="修改课程")
	@RequestMapping(value="/manager/managerCourses/{coursesId}",method= {RequestMethod.PUT})
	@ResponseBody
	public void updateCourses(@PathVariable("coursesId")Integer coursesId,
			@RequestParam(name = "coursesName",required = true)String coursesName,
			@RequestParam(name = "classificationId",required = true)Integer classificationId,
			@RequestParam(name = "coursesTime",required = true)String coursesTime,
			@RequestParam(name = "coursesInfo",required = true)String coursesInfo){
		
		SysCourses courses = coursesService.getCourses(coursesId);
		courses.setCoursesName(coursesName);
		courses.setClassificationId(classificationId);
		courses.setCoursesTime(coursesTime);
		courses.setCoursesInfo(coursesInfo);

		coursesService.updateCourse(courses);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
