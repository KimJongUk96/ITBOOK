package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.meeting.MeetingListAction;
//import com.itbook.controller.action.main.MainMeetingListAction;


public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("ActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();

			//메인 독서모임 
		} else if (command.equals("meetingList")) {
			action = new MeetingListAction();

		}
		return action;
	}
}