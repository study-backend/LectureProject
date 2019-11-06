package edu.kosta.lecture.model;

import java.util.Date;
import java.util.List;

public class Teacher {

	private long TeacherId;
	private String TeacherName;
	private String RegistrationNumber;
	private String PhoneNumber;
	private String Address;
	private String Email;
	private Date CreateDate;
	private Date UpdateDate;
	
	private List<Lecture> lectureList;
	
	
	public Teacher() {}
	public Teacher(long TeacherId, String TeacherName, String RegistrationNumber, String PhoneNumber, String Address, 
						String Email, Date CreateDate, Date UpdateDate) {
		this.TeacherId = TeacherId;
		this.TeacherName = TeacherName;
		this.RegistrationNumber = RegistrationNumber;
		this.PhoneNumber = PhoneNumber;
		this.Address = Address;
		this.Email = Email;
		this.CreateDate = CreateDate;
		this.UpdateDate = UpdateDate;
	}
	public long getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(long teacherId) {
		TeacherId = teacherId;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String studentName) {
		TeacherName = studentName;
	}
	public String getRegistrationNumber() {
		return RegistrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		RegistrationNumber = registrationNumber;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
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
	/**
	 * @return the lectureList
	 */
	public List<Lecture> getLectureList() {
		return lectureList;
	}
	/**
	 * @param lectureList the lectureList to set
	 */
	public void setLectureList(List<Lecture> lectureList) {
		this.lectureList = lectureList;
	}
	
	
	
}
