package com.itbook.controller;

import com.itbook.controller.action.Action;

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

		//독후감
		if (command.equals("Report_List")) {

		}
		return action;
	}

}
