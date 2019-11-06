package edu.kosta.lecture.model;


import java.util.Date;

public class ClassRoom {
	private int RoomCode;
	private int Capacity;
	private Date CreateDate;
	private Date UpdateDate;
	
	public ClassRoom() {}
	public ClassRoom(int RoomCode, int Capacity) {
		this.RoomCode = RoomCode;
		this.Capacity = Capacity;
		
	}

	public int getRoomCode() {
		return RoomCode;
	}

	public void setRoomCode(int roomCode) {
		this.RoomCode = roomCode;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		this.Capacity = capacity;
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
