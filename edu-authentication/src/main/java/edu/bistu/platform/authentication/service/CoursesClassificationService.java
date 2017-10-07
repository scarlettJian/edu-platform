package edu.bistu.platform.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.chapter.SysChapterMapper;
import edu.bistu.platform.authentication.orm.mapper.courses.SysCoursesMapper;
import edu.bistu.platform.authentication.orm.mapper.courses.classification.SysCoursesClassificationMapper;
import edu.bistu.platform.authentication.orm.model.cources.classification.SysCoursesClassification;

@Service
public class CoursesClassificationService {
	
	@Autowired
	SysCoursesClassificationMapper  ClassificationMapper;
	@Autowired
	SysCoursesMapper coursesMapper;
	@Autowired
	SysChapterMapper chapterMapper;
	
	/**
	 * 添加分类
	 * @param classification
	 * @return
	 */
	public SysCoursesClassification addClassification(SysCoursesClassification classification){
		ClassificationMapper.insertClassificationSelective(classification);
		return classification;
	}
	
	/**
	 * 删除课程分类
	 * @param classificationId
	 * @return
	 */
	public boolean deleteClassification(Integer classificationId){
		ClassificationMapper.deleteClassificationByPrimaryKey(classificationId);
		return true;
	}
	
	/**
	 * 批量删除分类
	 * @param classificationId
	 * @return
	 */
	public boolean batchDeleteClassification(String classificationId){
		ClassificationMapper.batchDeleteByPrimaryKey(classificationId.split(","));
		return true;
	}
	
	/**
	 * 修改课程分类信息
	 * @param classification
	 * @return
	 */
	public boolean updateclassification(SysCoursesClassification classification){
		ClassificationMapper.updateClassification(classification);
		return true;
	}
	
	/**
	 * 查询一个分类
	 * @param classificationId
	 * @return
	 */
	public SysCoursesClassification getClassification(Integer classificationId){
		SysCoursesClassification classification = ClassificationMapper.selectClassificationByPrimaryKey(classificationId);
		return classification;
	}
	/**
	 * 查询一个分类
	 * @param classificationName
	 * @return
	 */
	public List<SysCoursesClassification> getClassification(String classificationName){
		List<SysCoursesClassification> list = ClassificationMapper.selectClassificationByCoursesName(classificationName);
		return list;
	}
//	public Map<SysCoursesClassification, List<Map>> getClassification(String classificationName){
//		Map<SysCoursesClassification, List<Map>> courMap = new HashMap<SysCoursesClassification,List<Map>>();
//		List<SysCoursesClassification> ClassificationList = ClassificationMapper.selectClassificationByCoursesName(classificationName);
//		for (SysCoursesClassification Classification : ClassificationList) {
//			Map<SysCourses, List<SysChapter>> chapMap = new HashMap<SysCourses,List<SysChapter>>();
//			//2.获取当前分类下所有的课程List
//			List<SysCourses> coursesList = coursesMapper.selectByclassificationId(Classification.getClassificationId());
//			for (SysCourses courses : coursesList) {
//				List<SysChapter> chapterList = chapterMapper.getChapterByCoursesId(courses.getCoursesId());
//				chapMap.put(courses, chapterList);
//			}
//			List<Map> courList = new ArrayList<Map>();
//			courList.add(chapMap);
//			courMap.put(Classification, courList);
//		}
//		
//		return courMap;
//	}
	
	/**
	 * 查询所有分类
	 * @return
	 */
	public List<SysCoursesClassification> getClassification(){
		List<SysCoursesClassification> classificationList = ClassificationMapper.selectClassification();
		return classificationList;
	}
//	public Map<SysCoursesClassification, List<Map>> getClassification(){
//		Map<SysCoursesClassification, List<Map>> courMap = new HashMap<SysCoursesClassification,List<Map>>();
//		//1.获取所有的分类List
//		List<SysCoursesClassification> ClassificationList = ClassificationMapper.selectClassification();
//		for (SysCoursesClassification Classification : ClassificationList) {
//			
//			Map<SysCourses, List<SysChapter>> chapMap = new HashMap<SysCourses,List<SysChapter>>();
//			//2.获取当前分类下所有的课程List
//			List<SysCourses> coursesList = coursesMapper.selectByclassificationId(Classification.getClassificationId());
//			for (SysCourses courses : coursesList) {
//				List<SysChapter> chapterList = chapterMapper.getChapterByCoursesId(courses.getCoursesId());
//				chapMap.put(courses, chapterList);
//			}
//			List<Map> courList = new ArrayList<Map>();
//			courList.add(chapMap);
//			courMap.put(Classification, courList);
//		}
//		
//		return courMap;
//	}
	
	
}
