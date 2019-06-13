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
		
		//독서모임 리스트
		if(command.equals("meetingList")) {
			
			action = new MeetingListAction();
		
		//독서모임 신청폼으로 이동
		} else if(command.equals("meetingApplyFormAction")) {
			
			action = new MeetingApplyFormAction();
		
		//독서모임 신청
		} else if(command.equals("meetingApply")) {
			
			action = new MeetingApplyAction();
		
		//독서모임 별 메인 홈으로 이동
		} else if(command.equals("meetingHome")) {
			
			action = new MeetingHomeAction();
		
		//독서모임 수정 폼으로 이동
		} else if(command.equals("meetingUpdateForm")) {
			
			action = new MeetingUpdateFormAction();
		
		//독서모임 수정
		} else if(command.equals("metUpdate")) {
			
			action = new MeetingUpdateAction();
		
		//독서모임게시판으로 이동
		} else if(command.equals("metPostListFormAction")) {
			
			action = new MetPostListFormAction();
		
		//독서모임 게시글쓰기폼으로 이동
		} else if(command.equals("metPostWriteFormAction")) {
			
			action = new MetPostWriteFormAction();
		
		//독서모임 게시글쓰기
		} else if(command.equals("metPostWriteAction")) {
			
			action = new MetPostWriteAction();
		
		//독서모임 게시글 상세보기
		} else if(command.equals("metPostViewAction")) {
			
			action = new MetPostViewAction();
		
		//독서모임 게시글수정폼으로 이동
		} else if(command.equals("metPostUpdateFormAction")) {
			
			action = new MetPostUpdateFormAction();
		
		//독서모임 게시글 수정
		} else if(command.equals("metPostUpdateAction")) {
			
			action = new MetPostUpdateAction();
		
		//독서모임 게시글 삭제
		} else if(command.equals("metPostDeleteAction")) {
			
			action = new MetPostDeleteAction();
		
		//독서모임 게시글 댓글 쓰기
		} else if(command.equals("commentWriteAction")) {
			
			action = new CommentWriteAction();
		
		//독서모임 게시글 댓글 삭제
		} else if(command.equals("commentDeleteAction")) {
			
			action = new CommentDeleteAction();
			
		}
		
		return action;
	}
}



