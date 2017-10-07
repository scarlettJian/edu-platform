package edu.bistu.platform.authentication.orm.mapper.chapter;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import edu.bistu.platform.authentication.orm.model.chapter.SysChapter;

public interface SysChapterMapper {
	
	List<SysChapter> selectChapterByCoursesId(Integer coursesId);
	SysChapter selectByPrimaryKey(Integer chapterId);

	Integer insertChapterSelective(SysChapter record);

	@Delete(value="delete from sys_courses_chapter where chapterId=#{chapterId}")
	Integer deleteByPrimaryKey(Integer chapterId);
	
	Integer updateChapter(SysChapter record);

	int batchDeleteByPrimaryKey(String[] chapterId);


	

}
