package com.itbook.controller;
import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.admin.AdminBookDeleteAction;
import com.itbook.controller.action.admin.AdminBookListFormAction;
import com.itbook.controller.action.admin.AdminFeePaymentListAction;
import com.itbook.controller.action.admin.AdminMeetingAcceptListAction;
import com.itbook.controller.action.admin.AdminMeetingDeleteAction;
import com.itbook.controller.action.admin.AdminMeetingListAction;
import com.itbook.controller.action.admin.AdminMeetingUpdateAction;
import com.itbook.controller.action.admin.AdminMemberDeleteAction;
import com.itbook.controller.action.admin.AdminMemberEmailListFormAction;
import com.itbook.controller.action.admin.AdminMemberListFormAction;
import com.itbook.controller.action.admin.AdminNoticeDeleteAction;
import com.itbook.controller.action.admin.AdminNoticeListFormAction;
import com.itbook.controller.action.admin.AdminReportDeleteAction;
import com.itbook.controller.action.admin.AdminReportListForm;
import com.itbook.controller.action.admin.AdminTodayBookListFormAction;
import com.itbook.controller.action.admin.MailPopupForm;
import com.itbook.controller.action.book.AdminTodayBookListAction;
import com.itbook.controller.action.book.AdminTodayBookRegisterFormAction;

public class AdminActionFactory {
	private static AdminActionFactory instance = new AdminActionFactory();
	
	private AdminActionFactory() {
		super();
	}
	
	public static AdminActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("AdminActionFactory : " + command);
		
		if(command.equals("main")) {
			action = new MainAction();
			//관리자 화면 회원정보로 이동
		}else if(command.equals("memberListForm")) {
			action = new AdminMemberListFormAction();
			//회원 삭제(탈퇴) 후 리스트로 이동
		}else if(command.equals("memberDelete")) {
			action = new AdminMemberDeleteAction();
			//등록된 책 목록으로 이동
		}else if(command.equals("bookListForm")) {
			action = new AdminBookListFormAction();
			//등록된 책 목록 삭제
		}else if(command.equals("bookDelete")) {
			action = new AdminBookDeleteAction();
			//공지사항 목록으로 이동
		}else if(command.equals("noticeListForm")) {
			action = new AdminNoticeListFormAction();
			//공지사항 글 삭제
		}else if(command.equals("noticeDelete")) {
			action = new AdminNoticeDeleteAction();
			//메일 전송폼으로 이동
		}else if(command.equals("senderEmailListFormAction")) {
			action = new AdminMemberEmailListFormAction();
			//독후감 리스트로 이동
		}else if(command.equals("mailPopupForm")) {
			action = new MailPopupForm();
		}
		else if(command.equals("reportListForm")) {
			action = new AdminReportListForm();
			//독후감 목록 삭제
		}else if(command.equals("reportDelete")) {
			action = new AdminReportDeleteAction();
			//이달의 책 관리자 화면으로 이동
		}else if(command.equals("todayBookList")) {
			action = new AdminTodayBookListFormAction();
			//모임 승인거절 화면으로 이동
		}else if(command.equals("meetingAcceptListForm")) {
			action = new AdminMeetingAcceptListAction();
			//모임 승인
		}else if(command.equals("meetingUpdate")) {
			action = new AdminMeetingUpdateAction();
			//모임 리스트(승인된 모임들) 삭제화면으로
		}else if(command.equals("meetingListForm")) {
			action = new AdminMeetingListAction();
			//모임 삭제
		}else if(command.equals("meetingDelete")) {
			action = new AdminMeetingDeleteAction();
			//후원 관리
		}else if(command.equals("feePaymentList")) {
			action = new AdminFeePaymentListAction();
		}
			return action;
	}
}