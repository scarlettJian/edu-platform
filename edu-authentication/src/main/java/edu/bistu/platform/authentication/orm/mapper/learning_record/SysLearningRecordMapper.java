package edu.bistu.platform.authentication.orm.mapper.learning_record;

import edu.bistu.platform.authentication.orm.model.learning_record.SysLearningRecord;

public interface SysLearningRecordMapper {
	
	SysLearningRecord selectRocordByStudentChapterId(Integer studentId,Integer chapterId);
	int addRecord(SysLearningRecord record);
	int updateRecord(SysLearningRecord record);
}
