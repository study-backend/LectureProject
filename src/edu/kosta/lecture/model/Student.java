package edu.kosta.lecture.model;

import java.util.Date;
import java.util.List;

public class Student {

	private long studentId;
	private String studentName;
	private String registrationNumber;
	private String phoneNumber;
	private String address;
	private String email;
	private Date subscriptionDate;
	private Date unsubscriptionDate;
	private boolean isSubscription;
	
	private Date createDate;
	private Date updateDate;
	
	private List<Lecture> lectureList;
	
	
	public Student() {}
	public Student(long studentId, String studentName, String registrationNumber, String phoneNumber, String address, String email) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.registrationNumber = registrationNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
