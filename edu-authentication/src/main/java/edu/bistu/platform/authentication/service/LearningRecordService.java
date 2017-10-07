package edu.bistu.platform.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bistu.platform.authentication.orm.mapper.learning_record.SysLearningRecordMapper;
import edu.bistu.platform.authentication.orm.model.learning_record.SysLearningRecord;

@Service
public class LearningRecordService {
	
	@Autowired
	SysLearningRecordMapper recordMapper;
	
	/**
	 * 获取学习记录
	 * @param studentId 
	 * @param chapterId
	 * @return
	 */
	public SysLearningRecord getRocordByStudentChapterId(Integer studentId,Integer chapterId){
		return recordMapper.selectRocordByStudentChapterId(studentId, chapterId);
	}
	
	/**
	 * 添加学习记录
	 * @param record
	 * @return
	 */
	public boolean addRecord(SysLearningRecord record){
		recordMapper.addRecord(record);
		return true;
	}

	/**
	 * 更新记录
	 * @param record
	 * @return
	 */
	public boolean updateRecord(SysLearningRecord record) {
		recordMapper.updateRecord(record);
		return true;
	}

}
