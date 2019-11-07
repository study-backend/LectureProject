package edu.kosta.lecture.service;

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
	
	public void startScheduling() throws Exception {
		// �����ٷ� ����  // �Ŀ� �������̽��� ����
		// �����ٷ��� ���� ���̸� ������ ���´� ; 
		
		if(this.scheduler.state == Scheduler.State.Terminated) {
			SimpleDateFormat dateTime = new SimpleDateFormat("hh:mm:ss"); 
			Date d = dateTime.parse("00:00:00.0"); 
			Date p = dateTime.parse("23:00:00.0");
			
			this.scheduler = new Scheduler(this, d, p);
		}
		
	}
	
	public void endScheduling() throws Exception {
		// �����ٷ��� �������� �ƴ϶�� ���Ḧ ���´� 
		if(this.scheduler.state == Scheduler.State.Stop) {
			
		}
	}
	
	public void resumeScheduling() throws Exception {
		// �����ٷ��� �������̸� �簳 �ϴ� ���� ���´� 
		if(this.scheduler.state == Scheduler.State.Waiting) {
			
		}
	}
	
	public void stopScheduling() throws Exception {
		// �����ٷ��� �������� �ƴ϶�� ���ߴ� ���� ���´�
		if (this.scheduler.state == Scheduler.State.Running) {

		}
	}

	// �������̽��� ������ ���� // ������ ���� �κ��� Ȯ���� �Ѵ� 
	@Override
	public void periodEvent(Date date) throws Exception {
		try {
			List<Student> list = dao.selectSubscriptionStudent();
			
			// ���� �л����� ������ ��¥�� �����ٷ����� ������ ��¥�� ���ؼ� 
			// 1�� ���� ���񽺰� ���� ��� �ش� ������ ���� �����Ѵ� 
			// �������� ������ ������ ��Ų��
			
			dao.updatePeriod(list);
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	
	
}
