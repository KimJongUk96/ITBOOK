package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.admin.SendEmailAction;
import com.itbook.controller.action.member.InsertMemberAction;
import com.itbook.controller.action.member.LoginAction;
import com.itbook.controller.action.member.LogoutAction;
import com.itbook.controller.action.member.MemberIdCheckAction;
import com.itbook.controller.action.member.MemberModifyAction;
import com.itbook.controller.action.member.MemberModifyFormAction;

public class MemberActionFactory {
	private static MemberActionFactory instance = new MemberActionFactory();
	
	private MemberActionFactory() {
		super();
	}
	
	public static MemberActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("MemberActionFactory : " + command);
		
		if(command.equals("main")) {
			action = new MainAction();
			
		}else if(command.equals("insertMember")) {
			
			action = new InsertMemberAction();
			
		}else if(command.equals("memberIdCheck")) {
			
			action = new MemberIdCheckAction();
				
		}else if(command.equals("login")) {
			
			action = new LoginAction();
			
		}else if(command.equals("logout")) {
			
			action = new LogoutAction();
			
		}else if(command.equals("memberModifyForm")) {
			
			action = new MemberModifyFormAction();
			
		}else if(command.equals("memberModify")) {
			
			action = new MemberModifyAction();
		}
		return action;
	}
}
  