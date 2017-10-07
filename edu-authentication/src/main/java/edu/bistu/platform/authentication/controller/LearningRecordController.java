package edu.bistu.platform.authentication.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.xmlrpc.base.Data;

import edu.bistu.platform.authentication.orm.model.chapter.SysChapter;
import edu.bistu.platform.authentication.orm.model.learning_record.SysLearningRecord;
import edu.bistu.platform.authentication.service.ChapterService;
import edu.bistu.platform.authentication.service.CoursesService;
import edu.bistu.platform.authentication.service.LearningRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="学习记录管理")
@RestController
@RequestMapping(value="/learningRecord/courses")
public class LearningRecordController {
	
	@Autowired
	LearningRecordService recordService;
	@Autowired
	CoursesService coursesService;
	@Autowired
	ChapterService chapterService;
	
	@ApiOperation(value="添加学习")
	@RequestMapping(value="/student/managerRecode/{chapterId}",method= {RequestMethod.POST})
	@ResponseBody
	public SysLearningRecord addRecord(@PathVariable(name = "chapterId",required = true)Integer chapterId,
			@RequestParam(name = "studentId",required = true)Integer studentId,
			@RequestParam(name = "learningTime",required = true)String learningTime){
		SysLearningRecord record = recordService.getRocordByStudentChapterId(studentId, chapterId);
		//1.由studentId和chapterId查找record表中是否已存在该章节的学习记录
		if(record == null){
			//不存在add
			SysChapter chapter = chapterService.getChapterByChapterId(chapterId);
			SysLearningRecord learningRecord = new SysLearningRecord();
			learningRecord.setStudentId(studentId);
			learningRecord.setCoursesId(chapter.getCoursesId());
			learningRecord.setChapterId(chapterId);
			learningRecord.setLearningTime(learningTime);//JS获取视频时长
			learningRecord.setStartTime(new Date());
			learningRecord.setLastTime(new Date());
//			learningRecord.setRate(rate);
			recordService.addRecord(learningRecord);
			
			return learningRecord;
		}else{
			//存在则update
			record.setLearningTime(learningTime);
			record.setLastTime(new Date());
			recordService.updateRecord(record);
			
			return recordService.getRocordByStudentChapterId(studentId, chapterId);
		}
	}
	
	
	
}
