package edu.kosta.lecture.model;

import java.util.Date;

public class Lecture {

	private long LectureId;
	private int RoomCode;
	private int SubjectCode;
	private int Time;
	private Date CreateDate;
	private Date UpdateDate;
	
	
	
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
	
		
	}

	

