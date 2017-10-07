package edu.bistu.platform.authentication.orm.model.chapter;

import java.util.Date;

public class SysChapter {
	
	private Integer chapterId;
	
	private Integer coursesId;
	
	private String chapterName;
	
	private String chapterTime;
	
	private String vedioLink;
	
	private String chapterInfo;
	
	private Date createtDate;

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public Integer getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(Integer coursesId) {
		this.coursesId = coursesId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getChapterTime() {
		return chapterTime;
	}

	public void setChapterTime(String chapterTime) {
		this.chapterTime = chapterTime;
	}

	public String getVedioLink() {
		return vedioLink;
	}

	public void setVedioLink(String vedioLink) {
		this.vedioLink = vedioLink;
	}

	public String getChapterInfo() {
		return chapterInfo;
	}

	public void setChapterInfo(String chapterInfo) {
		this.chapterInfo = chapterInfo;
	}

	public Date getCreatetDate() {
		return createtDate;
	}

	public void setCreatetDate(Date createtDate) {
		this.createtDate = createtDate;
	}

	@Override
	public String toString() {
		return "SysChapter [chapterId=" + chapterId + ", coursesId=" + coursesId + ", chapterName=" + chapterName
				+ ", chapterTime=" + chapterTime + ", vedioLink=" + vedioLink + ", chapterInfo=" + chapterInfo
				+ ", createtDate=" + createtDate + "]";
	}
	

}
