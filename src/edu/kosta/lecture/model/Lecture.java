package edu.kosta.lecture.model;

import java.util.Date;
import java.util.List;

public class Lecture {

	private long LectureId;
	private int RoomCode;
	private int SubjectCode;
	private int Time;
	private Date CreateDate;
	private Date UpdateDate;
	
	private List<Student> studentList;
	private List<Teacher> teacherList;
	
	
	public Lecture() {}
	public Lecture(long LectureId, int RoomCode, int SubjectCode,
					int Time, Date CreateDate, Date UpdateDate) {
		
		this.LectureId = LectureId;
		this.RoomCode = RoomCode;
		this.SubjectCode = SubjectCode;
		this.Time = Time;
		this.CreateDate = CreateDate;
		this.UpdateDate = UpdateDate;
		
	}
	public long getLectureId() {
		return LectureId;
	}
	public void setLectureId(long lectureId) {
		LectureId = lectureId;
	}
	public int getRoomCode() {
		return RoomCode;
	}
	public void setRoomCode(int roomCode) {
		RoomCode = roomCode;
	}
	public int getSubjectCode() {
		return SubjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		SubjectCode = subjectCode;
	}
	public int getTime() {
		return Time;
	}
	public void setTime(int time) {
		Time = time;
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
	 * @return the studentList
	 */
	public List<Student> getStudentList() {
		return studentList;
	}
	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	/**
	 * @return the teacherList
	 */
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	/**
	 * @param teacherList the teacherList to set
	 */
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	
		
}

	

