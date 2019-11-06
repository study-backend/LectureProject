package edu.kosta.lecture.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.kosta.lecture.dao.SchedulerDAO;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.task.Job;
import edu.kosta.lecture.task.Scheduler;

public class SchedulerService implements Job {
	private SchedulerDAO dao = new SchedulerDAO();
	private Scheduler scheduler = null;
	
	public void startScheduling() throws ParseException {
		// 스케줄러 동작  // 후에 인터페이스로 뺀다
		// 스케줄러가 동작 중이면 시작을 막는다 ; 
		
		if(this.scheduler.state == Scheduler.State.Terminated) {
			SimpleDateFormat dateTime = new SimpleDateFormat("hh:mm:ss"); 
			Date d = dateTime.parse("00:00:00.0"); 
			Date p = dateTime.parse("23:00:00.0");
			
			this.scheduler = new Scheduler(this, d, p);
		}
		
	}
	
	public void endScheduling() {
		// 스케줄러가 동작중이 아니라면 종료를 막는다 
		if(this.scheduler.state == Scheduler.State.Stop) {
			
		}
	}
	
	public void resumeScheduling() {
		// 스케줄러가 동작중이면 재개 하는 것을 막는다 
		if(this.scheduler.state == Scheduler.State.Waiting) {
			
		}
	}
	
	public void stopScheduling() {
		// 스케줄러가 동작중이 아니라면 멈추는 것을 막는다
		if (this.scheduler.state == Scheduler.State.Running) {

		}
	}

	// 인터페이스에 동작할 서비스 // 구독과 같은 부분의 확인을 한다 
	@Override
	public void periodEvent(Date date) {
		List<Student> list = dao.selectSubscriptionStudent();
		
		// 현재 학생들이 시작한 날짜와 스케줄러에서 보내준 날짜를 비교해서 
		// 1달 구독 서비스가 끝날 경우 해당 구독에 대해 해지한다 
		// 연장하지 않으면 해지를 시킨다
		
		dao.updatePeriod(list);
	}
	
	
	
}
