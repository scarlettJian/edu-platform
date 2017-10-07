package edu.bistu.platform.authentication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import edu.bistu.platform.authentication.service.ChapterService;
import edu.bistu.platform.authentication.service.CoursesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="章节管理")
@RestController
@RequestMapping(value="/chapter")
public class ChapterController {

	@Autowired
	CoursesService coursesService;
	@Autowired
	ChapterService chapterService;
	
	@ApiOperation(value="查找某一课程下所有章节")
	@RequestMapping(value="/manager/selectChapter/{coursesId}",method= {RequestMethod.GET})
	@ResponseBody
	public List<SysChapter> getChapter(@PathVariable(value ="coursesId")Integer coursesId){
		List<SysChapter> list = chapterService.getChapterByCoursesId(coursesId);
		return list;
	}
	
	@ApiOperation(value="新增章节")
	@RequestMapping(value="/manager/managerChapter",method= {RequestMethod.POST})
	@ResponseBody
	public void addChapter(@RequestParam(name = "coursesId",required = true)Integer coursesId,
			@RequestParam(name = "chapterName",required = true)String chapterName,
			@RequestParam(name = "chapterTime",required = true)String chapterTime,
			@RequestParam(name = "vedioLink",required = true)String vedioLink,
			@RequestParam(name = "chapterInfo",required = true)String chapterInfo){
		
		SysChapter chapter = new SysChapter();
		chapter.setCoursesId(coursesId);
		chapter.setChapterName(chapterName);
		chapter.setChapterTime(chapterTime);
		chapter.setVedioLink(vedioLink);
		chapter.setChapterInfo(chapterInfo);
		chapter.setCreatetDate(new Date());
		
		chapterService.addChapter(chapter);
		
	}
	
	@ApiOperation(value="删除章节")
	@RequestMapping(value="/manager/managerChapter/{chapterId}",method= {RequestMethod.POST})
	@ResponseBody
	public boolean deleteChapter(@PathVariable("chapterId")Integer chapterId){
		chapterService.deleteChapter(chapterId);
		return true;
	}
	
	@ApiOperation(value="批量删除章节")
	@RequestMapping(value="/manager/managerChapter/doDelete",method= {RequestMethod.DELETE})
	@ResponseBody
	public Map<String, Object> batchDeleteClassification(String chapterId){//[1,2,4,5]
		Map<String, Object> map=new HashMap<String, Object>();
		chapterService.batchDeleteChapter(chapterId);
		map.put("message", "删除成功");
		return map;
	}
	@ApiOperation(value="修改章节页面显示")
	@RequestMapping(value="/manager/managerChapter/{chapterId}",method= {RequestMethod.GET})
	@ResponseBody
	public SysChapter getUpdateChapter(@PathVariable("chapterId")Integer chapterId){
		SysChapter chapter = chapterService.getChapterByChapterId(chapterId);
		return chapter;
	}
	
	@ApiOperation(value="修改章节")
	@RequestMapping(value="/manager/managerChapter/{chapterId}",method= {RequestMethod.PUT})
	@ResponseBody
	public void updateChapter(@PathVariable("chapterId")Integer chapterId,
			@RequestParam(name = "coursesId",required = true)Integer coursesId,
			@RequestParam(name = "chapterName",required = true)String chapterName,
			@RequestParam(name = "chapterTime",required = true)String chapterTime,
			@RequestParam(name = "vedioLink",required = true)String vedioLink,
			@RequestParam(name = "chapterInfo",required = true)String chapterInfo){
		
		SysChapter chapter = chapterService.getChapterByChapterId(chapterId);
		chapter.setCoursesId(coursesId);
		chapter.setChapterName(chapterName);
		chapter.setChapterTime(chapterTime);
		chapter.setVedioLink(vedioLink);
		chapter.setChapterInfo(chapterInfo);
		chapter.setCreatetDate(new Date());
		
		chapterService.updateChapter(chapter);
		
	}
	
	
	
	
}
