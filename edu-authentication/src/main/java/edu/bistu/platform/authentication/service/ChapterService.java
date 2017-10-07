package edu.bistu.platform.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.chapter.SysChapterMapper;
import edu.bistu.platform.authentication.orm.model.chapter.SysChapter;

@Service
public class ChapterService {
	
	@Autowired
	SysChapterMapper chapterMapper;
	
	/**
	 * 由coursesId获取该课程下所有章节
	 * @param coursesId
	 * @return
	 */
	public List<SysChapter> getChapterByCoursesId(Integer coursesId){
		List<SysChapter> list = chapterMapper.selectChapterByCoursesId(coursesId);
		return list;
	}

	/**
	 * 查询一个章节
	 * @param chapterId
	 * @return
	 */
	public SysChapter getChapterByChapterId(Integer chapterId){
		SysChapter chapter = chapterMapper.selectByPrimaryKey(chapterId);
		return chapter;
	}
	/**
	 * 添加章节
	 * @param chapter
	 * @return
	 */
	public SysChapter addChapter(SysChapter chapter) {
		chapterMapper.insertChapterSelective(chapter);
		return chapter;
		
	}

	/**
	 * 删除章节
	 * @param coursesId
	 * @return
	 */
	public boolean deleteChapter(Integer chapterId) {
		chapterMapper.deleteByPrimaryKey(chapterId);
		return true;
	}
	
	/**
	 * 批量删除章节
	 * @param classificationId
	 * @return
	 */
	public boolean batchDeleteChapter(String chapterId){//[1,2,4,5]
		chapterMapper.batchDeleteByPrimaryKey(chapterId.split(","));//[1 2 4 5]
		return true;
	}
	

	/**
	 * 修改章节
	 * @param chapter
	 */
	public boolean updateChapter(SysChapter chapter) {
		chapterMapper.updateChapter(chapter);
		return true;
	}
	
	

}
