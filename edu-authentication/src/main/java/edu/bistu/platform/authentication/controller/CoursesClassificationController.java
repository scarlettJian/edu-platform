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

import edu.bistu.platform.authentication.orm.model.cources.SysCourses;
import edu.bistu.platform.authentication.orm.model.cources.classification.SysCoursesClassification;
import edu.bistu.platform.authentication.service.ChapterService;
import edu.bistu.platform.authentication.service.CoursesClassificationService;
import edu.bistu.platform.authentication.service.CoursesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
@Api(tags="课程分类管理")
@RestController
@RequestMapping(value="/classification/courses")
public class CoursesClassificationController {
	
	@Autowired
	CoursesClassificationService classificationService;
	@Autowired
	CoursesService coursesService;
	@Autowired
	ChapterService chapterService;
	
//	@ApiOperation(value="管理员端：查看所有课程分类")
//	@RequestMapping(value="/manager/managerClassification",method= {RequestMethod.GET})
//	@ResponseBody
//	public Map<SysCoursesClassification, List<Map>> getClassification(){
//		 Map<SysCoursesClassification, List<Map>> classification = classificationService.getClassification();
//		 return classification;
//	}
	@ApiOperation(value="查看所有课程分类")
	@RequestMapping(value="/manager/managerClassification",method= {RequestMethod.GET})
	@ResponseBody
	public List<SysCoursesClassification> getClassification(){
		List<SysCoursesClassification> list = classificationService.getClassification();
		 return list;
	}
		
//	@ApiOperation(value="管理员端：条件搜索课程分类")
//	@RequestMapping(value="/manager/selectClassification",method= {RequestMethod.POST})
//	@ResponseBody
//	public Map<SysCoursesClassification, List<Map>> getClassification(@RequestParam(value="classificationName")String classificationName){
//		Map<SysCoursesClassification, List<Map>> map = classificationService.getClassification(classificationName);
//		return map;
//	}
	@ApiOperation(value="搜索栏查看某一课程分类")
	@RequestMapping(value="/manager/selectClassification",method= {RequestMethod.POST})
	@ResponseBody
	public List<SysCoursesClassification> getClassification(@RequestParam(value="classificationName")String classificationName){
		List<SysCoursesClassification> list = classificationService.getClassification(classificationName);
		return list;
	}
	
	@ApiOperation(value="新增课程分类")
	@RequestMapping(value="/manager/managerClassification",method= {RequestMethod.POST})
	@ResponseBody
	public void addCourses(@RequestParam(name = "classificationName",required = true)String classificationName,
			@RequestParam(name = "classificationInfo",required = true)String classificationInfo){
		SysCoursesClassification classification = new SysCoursesClassification();
		classification.setClassificationName(classificationName);
		classification.setClassificationInfo(classificationInfo);
		
		classificationService.addClassification(classification);
	}
	
	@ApiOperation(value="删除课程分类")
	@RequestMapping(value="/manager/managerClassification/{classificationId}",method= {RequestMethod.DELETE})
	@ResponseBody
	public boolean deleteClassification(@PathVariable("classificationId")Integer classificationId){
		SysCoursesClassification classification = classificationService.getClassification(classificationId);
		List<SysCourses> coursesList = coursesService.getCourses("", classification.getClassificationName());
		if(coursesList == null || coursesList.isEmpty()){
			classificationService.deleteClassification(classificationId);
			return true;
		}else{
			return false;//不予删除
		}
	}
	
	@ApiOperation(value="批量删除分类")
	@RequestMapping(value="/manager/managerClassification/doDelete",method= {RequestMethod.DELETE})
	@ResponseBody
	public Map<String, Object> batchDeleteClassification(String classificationId){
		Map<String, Object> map=new HashMap<String, Object>();
		//1.确定是否选中分类项
		if(classificationId.isEmpty() || classificationId == null){
			map.put("message", "未选中分类");
		}else{
			String[] split = classificationId.split(",");
			//2.对选中的每一个分类查询是否存在课程，存在则不予删除
			for (int i = 0; i < split.length; i++) {
				Integer id = Integer.parseInt(split[i]);
				SysCoursesClassification classification = classificationService.getClassification(id);
				List<SysCourses> coursesList = coursesService.getCourses("", classification.getClassificationName());
				if(!coursesList.isEmpty()){//不予删除
					map.put("message", "存在分类下课程不为空，不予删除");
					return map;
				}
			}
			classificationService.batchDeleteClassification(classificationId);
			map.put("message", "删除成功");
		}
		return map;
	}
	
	@ApiOperation(value="修改课程分类页面显示")
	@RequestMapping(value="/manager/managerClassification/{classificationId}",method= {RequestMethod.GET})
	@ResponseBody
	public SysCoursesClassification getUpdateCourses(@PathVariable("classificationId")Integer classificationId){
		SysCoursesClassification classification = classificationService.getClassification(classificationId);
		return classification;
	}
	
	@ApiOperation(value="修改课程分类")
	@RequestMapping(value="/manager/managerClassification/{classificationId}",method= {RequestMethod.PUT})
	@ResponseBody
	public void updateCourses(@PathVariable("classificationId")Integer classificationId,
			@RequestParam(name = "classificationName",required = true)String classificationName,
			@RequestParam(name = "classificationInfo",required = true)String classificationInfo){
		
		SysCoursesClassification classification = classificationService.getClassification(classificationId);
		classification.setClassificationName(classificationName);
		classification.setClassificationInfo(classificationInfo);
		
		classificationService.updateclassification(classification);
	}
	
	

}
