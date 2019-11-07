package edu.kosta.lecture.controller;

import edu.kosta.lecture.service.SchedulerService;

public class SchedulerController {
	private static SchedulerService service = new SchedulerService();
	
	
	public static void startScheduling() throws Exception {
		service.startScheduling();

	}
	
	public static void endScheduling() throws Exception {
		service.endScheduling();
	}
	
	public static void resumeScheduling() throws Exception {
		service.resumeScheduling();
	}
	
	public static void stopScheduling() throws Exception {
		service.stopScheduling();
	}
	
	
	
}
