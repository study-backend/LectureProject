package edu.kosta.lecture.model;

import java.util.Date;
import java.util.List;

public class Student {

	private long StudentId;
	private String StudentName;
	private String RegistrationNumber;
	private String PhoneNumber;
	private String Address;
	private String Email;
	private Date subscriptionDate;
	private Date unsubscriptionDate;
	private boolean isSubscription;
	
	private Date CreateDate;
	private Date UpdateDate;
	
	private List<Lecture> lectureList;
	
	
	public Student() {}
	public Student(long StudentId, String StudentName, String RegistrationNumber, String PhoneNumber, String Address, String Email) {
		this.StudentId = StudentId;
		this.StudentName = StudentName;
		this.RegistrationNumber = RegistrationNumber;
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
	 * @return the subscriptionDate
	 */
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	/**
	 * @param subscriptionDate the subscriptionDate to set
	 */
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	/**
	 * @return the unsubscriptionDate
	 */
	public Date getUnsubscriptionDate() {
		return unsubscriptionDate;
	}
	/**
	 * @param unsubscriptionDate the unsubscriptionDate to set
	 */
	public void setUnsubscriptionDate(Date unsubscriptionDate) {
		this.unsubscriptionDate = unsubscriptionDate;
	}
	/**
	 * @return the isSubscription
	 */
	public boolean isSubscription() {
		return isSubscription;
	}
	/**
	 * @param isSubscription the isSubscription to set
	 */
	public void setSubscription(boolean isSubscription) {
		this.isSubscription = isSubscription;
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
