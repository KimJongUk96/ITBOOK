package com.itbook.controller;

import com.itbook.controller.action.Action;

import com.itbook.controller.action.meeting.MeetingListAction;

public class MeetingActionFactory {

	private static  MeetingActionFactory instance = new MeetingActionFactory();
	
	
	public MeetingActionFactory() {
		super();
	}
	
	public static MeetingActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		//���� ���Ӹ���Ʈ
		if(command.equals("meetingList")) {
			action = new MeetingListAction();
		}
		
		return action;
	}
}
