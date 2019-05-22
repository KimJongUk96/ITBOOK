package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.meeting.MeetingApplyAction;
import com.itbook.controller.action.meeting.MeetingApplyFormAction;
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
		
		//독서 모임리스트
		if(command.equals("meetingList")) {
			
			action = new MeetingListAction();
			
		} else if(command.equals("meetingApplyFormAction")) {
			
			action = new MeetingApplyFormAction();
			
		} else if(command.equals("meetingApply")) {
			
			action = new MeetingApplyAction();
		}
		
		return action;
	}
}
