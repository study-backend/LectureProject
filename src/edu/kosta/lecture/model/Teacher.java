package edu.kosta.lecture.model;

import java.util.Date;

public class Teacher {

	private long TeacherId;
	private String StudentName;
	private String RegisterationNumber;
	private String PhoneNumber;
	private String Address;
	private String Email;
	private Date CreateDate;
	private Date UpdateDate;
	
	
	public Teacher() {}
	public Teacher(long TeacherId, String StudentName, String RegisterationNumber, String PhoneNumber, String Address, 
						String Email, Date CreateDate, Date UpdateDate) {
		this.TeacherId = TeacherId;
		this.StudentName = StudentName;
		this.RegisterationNumber = RegisterationNumber;
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
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getRegisterationNumber() {
		return RegisterationNumber;
	}
	public void setRegisterationNumber(String registerationNumber) {
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
