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
import com.itbook.controller.action.meeting.metBoardListFormAction;

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
		
		//�������� ����Ʈ
		if(command.equals("meetingList")) {
			
			action = new MeetingListAction();
		
		//�������� ��û������ �̵�
		} else if(command.equals("meetingApplyFormAction")) {
			
			action = new MeetingApplyFormAction();
		
		//�������� ��û
		} else if(command.equals("meetingApply")) {
			
			action = new MeetingApplyAction();
		
		//각각의 모임의 상세보기
		} else if(command.equals("meetingHome")) {
			
			action = new MeetingHomeAction();
			
			
		//모임에서 게시판보기를 클릭했을 때 전체 리스트 보여주기.
		} else if(command.equals("metBoardListFormAction")) {
						
			action = new metBoardListFormAction();
									
			
		//�������� ���� ������ �̵�
		} else if(command.equals("meetingUpdateForm")) {
			
			action = new MeetingUpdateFormAction();
		
		//�������� ����
		} else if(command.equals("metUpdate")) {
			
			action = new MeetingUpdateAction();
		
		//�������ӰԽ������� �̵�
		} else if(command.equals("metPostListFormAction")) {
			
			action = new MetPostListFormAction();
		
		//�������� �Խñ۾��������� �̵�
		} else if(command.equals("metPostWriteFormAction")) {
			
			action = new MetPostWriteFormAction();
		
		//�������� �Խñ۾���
		} else if(command.equals("metPostWriteAction")) {
			
			action = new MetPostWriteAction();
		
		//�������� �Խñ� �󼼺���
		} else if(command.equals("metPostViewAction")) {
			
			action = new MetPostViewAction();
		
		//�������� �Խñۼ��������� �̵�
		} else if(command.equals("metPostUpdateFormAction")) {
			
			action = new MetPostUpdateFormAction();
		
		//�������� �Խñ� ����
		} else if(command.equals("metPostUpdateAction")) {
			
			action = new MetPostUpdateAction();
		
		//�������� �Խñ� ����
		} else if(command.equals("metPostDeleteAction")) {
			
			action = new MetPostDeleteAction();
		
		//�������� �Խñ� ��� ����
		} else if(command.equals("commentWriteAction")) {
			
			action = new CommentWriteAction();
		
		//�������� �Խñ� ��� ����
		} else if(command.equals("commentDeleteAction")) {
			
			action = new CommentDeleteAction();
			
		}
		
		return action;
	}
}



