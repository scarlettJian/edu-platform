package edu.bistu.platform.authentication.orm.model.cources;

public class SysCourses {
	private Integer coursesId;
	
	private String coursesName;
	
	private Integer classificationId;
	
	private String coursesTime;
	
	private String coursesInfo;

	public Integer getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(Integer coursesId) {
		this.coursesId = coursesId;
	}

	public String getCoursesName() {
		return coursesName;
	}

	public void setCoursesName(String coursesName) {
		this.coursesName = coursesName == null ? null : coursesName.trim();
	}

	

	public Integer getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}

	public String getCoursesTime() {
		return coursesTime;
	}

	public void setCoursesTime(String coursesTime) {
		this.coursesTime = coursesTime == null ? null : coursesTime.trim();
	}

	public String getCoursesInfo() {
		return coursesInfo;
	}

	public void setCoursesInfo(String coursesInfo) {
		this.coursesInfo = coursesInfo;
	}
	
	


	@Override
	public String toString() {
		return "SysCourses [coursesId=" + coursesId + ", coursesName=" + coursesName + ", classificationId="
				+ classificationId + ", coursesTime=" + coursesTime + ", coursesInfo=" + coursesInfo + "]";
	}

	
	

	

}
