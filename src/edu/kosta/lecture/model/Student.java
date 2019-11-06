package edu.kosta.lecture.model;

import java.util.Date;

public class Student {

	private long StudentId;
	private String StudentName;
	private String RegisterationNumber;
	private String PhoneNumber;
	private String Address;
	private String Email;
	private Date CreateDate;
	private Date UpdateDate;
	
	
	
	public Student() {}
	public Student(long StudentId, String StudentName, String RegisterationNumber, String PhoneNumber, String Address, String Email) {
		this.StudentId = StudentId;
		this.StudentName = StudentName;
		this.RegisterationNumber = RegisterationNumber;
		this.PhoneNumber = PhoneNumber;
		this.Address = Address;
		this.Email = Email;
	}
	public long getStudentId() {
		return StudentId;
	}
	public void setStudentId(long studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getRegistrationNumber() {
		return RegisterationNumber;
	}
	public void setRegistrationNumber(String registerationNumber) {
		RegisterationNumber = registerationNumber;
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
	
}
