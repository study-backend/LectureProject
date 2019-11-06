package edu.kosta.lecture.model;

import java.util.Date;

public class Subject {

	private int SubjectCode;
	private String SubjectName;
	private Date CreateDate;
	private Date UpdateDate;
	
	
	
	public Subject() {}
	public Subject(int SubjectCode, String SubjectName) {
		this.SubjectCode = SubjectCode;
		this.SubjectName = SubjectName;
		}
	
	public int getSubjectCode() {
		return SubjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		SubjectCode = subjectCode;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}
	
	
}
