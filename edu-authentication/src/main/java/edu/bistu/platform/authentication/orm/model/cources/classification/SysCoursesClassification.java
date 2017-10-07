package edu.bistu.platform.authentication.orm.model.cources.classification;

public class SysCoursesClassification {
	
	private Integer classificationId;
	
	private String classificationName;
	
	private String classificationInfo;

	public Integer getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public String getClassificationInfo() {
		return classificationInfo;
	}

	public void setClassificationInfo(String classificationInfo) {
		this.classificationInfo = classificationInfo;
	}

	@Override
	public String toString() {
		return "SysCoursesClassification [classificationId=" + classificationId + ", classificationName="
				+ classificationName + ", classificationInfo=" + classificationInfo + "]";
	}
	
	
	

}
