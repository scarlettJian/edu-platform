package edu.bistu.platform.authentication.orm.model.learning_record;

import java.util.Date;

public class SysLearningRecord {
	private Integer recordId;
	
	private Integer studentId;
	
	private Integer coursesId;
	
	private Integer chapterId;
	
	private String learningTime;
	
	private Date startTime;
	
	private Date lastTime;
	
	private String rate;

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(Integer coursesId) {
		this.coursesId = coursesId;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public String getLearningTime() {
		return learningTime;
	}

	public void setLearningTime(String learningTime) {
		this.learningTime = learningTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "SysLearningRecord [recordId=" + recordId + ", studentId=" + studentId + ", coursesId=" + coursesId
				+ ", chapterId=" + chapterId + ", learningTime=" + learningTime + ", startTime=" + startTime
				+ ", lastTime=" + lastTime + ", rate=" + rate + "]";
	}
	
	

}
