package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.meeting.CommentDeleteAction;
import com.itbook.controller.action.meeting.CommentWriteAction;
import com.itbook.controller.action.meeting.MeetingApplyAction;
import com.itbook.controller.action.meeting.MeetingApplyFormAction;
import com.itbook.controller.action.meeting.MeetingHomeAction;
import com.itbook.controller.action.meeting.MeetingListAction;
import com.itbook.controller.action.meeting.MeetingUpdateAction;
import com.itbook.controller.action.meeting.MeetingUpdateFormAction;
import com.itbook.controller.action.meeting.MetPostDeleteAction;
import com.itbook.controller.action.meeting.MetPostListFormAction;
import com.itbook.controller.action.meeting.MetPostUpdateAction;
import com.itbook.controller.action.meeting.MetPostUpdateFormAction;
import com.itbook.controller.action.meeting.MetPostViewAction;
import com.itbook.controller.action.meeting.MetPostWriteAction;
import com.itbook.controller.action.meeting.MetPostWriteFormAction;

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
		
		if(command.equals("meetingList")) {
			
			action = new MeetingListAction();
		
		} else if(command.equals("meetingApplyFormAction")) {
			
			action = new MeetingApplyFormAction();
			
		} else if(command.equals("meetingApply")) {
			
			action = new MeetingApplyAction();
			
		} else if(command.equals("meetingHome")) {
			
			action = new MeetingHomeAction();
			
		} else if(command.equals("meetingUpdateForm")) {
			
			action = new MeetingUpdateFormAction();
			
		} else if(command.equals("metUpdate")) {
			
			action = new MeetingUpdateAction();
			
		} else if(command.equals("metPostListFormAction")) {
			
			action = new MetPostListFormAction();
			
		} else if(command.equals("metPostWriteFormAction")) {
			
			action = new MetPostWriteFormAction();
			
		} else if(command.equals("metPostWriteAction")) {
			
			action = new MetPostWriteAction();
			
		} else if(command.equals("metPostViewAction")) {
			
			action = new MetPostViewAction();
			
		} else if(command.equals("metPostUpdateFormAction")) {
			
			action = new MetPostUpdateFormAction();
			
		} else if(command.equals("metPostUpdateAction")) {
			
			action = new MetPostUpdateAction();
			
		} else if(command.equals("metPostDeleteAction")) {
			
			action = new MetPostDeleteAction();
			 
		} else if(command.equals("commentWriteAction")) {
			
			action = new CommentWriteAction();
			
		} else if(command.equals("commentDeleteAction")) {
			
			action = new CommentDeleteAction();
			
		}
		
		return action;
	}
}



