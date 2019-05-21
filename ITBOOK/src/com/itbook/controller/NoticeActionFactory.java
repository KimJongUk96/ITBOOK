package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.notice.FileDownloadAction;
import com.itbook.controller.action.notice.NoticeDeleteAction;
import com.itbook.controller.action.notice.NoticeInsertAction;
import com.itbook.controller.action.notice.NoticeInsertFormAction;
import com.itbook.controller.action.notice.NoticeListFormAction;
import com.itbook.controller.action.notice.NoticeUpdateAction;
import com.itbook.controller.action.notice.NoticeUpdateFormAction;
import com.itbook.controller.action.notice.NoticeViewAction;

public class NoticeActionFactory {

	public static NoticeActionFactory instance = new NoticeActionFactory();
	
	private NoticeActionFactory() {
		super();
	}
	
	public static NoticeActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if (command.equals("main")) {
			action = new MainAction();
		}	else if (command.equals("noticeListFormAction")) {
			
			action = new NoticeListFormAction();
			
		} else if (command.equals("noticeInsertFormAction")) {
			
			action = new NoticeInsertFormAction();
			
		} else if (command.equals("noticeInsertAction")) {
			
			action = new NoticeInsertAction();
			
		} else if (command.equals("noticeViewAction")) {

			action = new NoticeViewAction();

		} else if (command.equals("noticeUpdateAction")) {

			action = new NoticeUpdateAction();

		} else if (command.equals("noticeUpdateFormAction")) {

			action = new NoticeUpdateFormAction();

		} else if (command.equals("noticeDeleteAction")) {

			action = new NoticeDeleteAction();

		} else if (command.equals("fileDownloadAction")) {

			action = new FileDownloadAction();

		}
		
		return action;
		
	}
	
}
