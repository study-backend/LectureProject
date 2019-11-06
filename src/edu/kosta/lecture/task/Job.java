package edu.kosta.lecture.task;

import java.util.Date;

public interface Job {
	
	// 기간제 작업에 대한 처리하는 부분 
	public void periodEvent(Date date);
}
