package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.meeting.MeetingApplyAction;
import com.itbook.controller.action.meeting.MeetingApplyFormAction;
import com.itbook.controller.action.meeting.MeetingListAction;
import com.itbook.controller.action.meeting.MetBoardListFormAction;
import com.itbook.controller.action.meeting.MetBoardViewAction;
import com.itbook.controller.action.meeting.MetBoardWriteAction;
import com.itbook.controller.action.meeting.MetBoardWriteFormAction;

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
		
		//독서모임 리스트
		if(command.equals("meetingList")) {
			
			action = new MeetingListAction();
		
		//독서모임 신청폼
		} else if(command.equals("meetingApplyFormAction")) {
			
			action = new MeetingApplyFormAction();
			
		//독서모임 신청
		} else if(command.equals("meetingApply")) {
			
			action = new MeetingApplyAction();
			
		} else if(command.equals("meetingHome")) {
			
		}
		else if(command.equals("metBoardListFormAction")) {
			
			action = new MetBoardListFormAction();
			
		} else if(command.equals("metBoardWriteFormAction")) {
			
			action = new MetBoardWriteFormAction();
			
		} else if(command.equals("metBoardWriteAction")) {
			
			action = new MetBoardWriteAction();
			
		} else if(command.equals("metBoardViewAction")) {
			
			action = new MetBoardViewAction();
		}
		
		return action;
	}
}
