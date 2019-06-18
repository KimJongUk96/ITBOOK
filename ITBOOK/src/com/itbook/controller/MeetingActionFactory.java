package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.meeting.CommentDeleteAction;
import com.itbook.controller.action.meeting.CommentWriteAction;
import com.itbook.controller.action.meeting.JoinMeetingAction;
import com.itbook.controller.action.meeting.JoinMemberPopupAction;
import com.itbook.controller.action.meeting.MeetingApplyAction;
import com.itbook.controller.action.meeting.MeetingApplyFormAction;
import com.itbook.controller.action.meeting.MeetingHomeAction;
import com.itbook.controller.action.meeting.MeetingListAction;
import com.itbook.controller.action.meeting.MetBoardDeleteAction;
import com.itbook.controller.action.meeting.MetBoardUpdateAction;
import com.itbook.controller.action.meeting.MetBoardUpdateFormAction;
import com.itbook.controller.action.meeting.MetBoardViewAction;
import com.itbook.controller.action.meeting.MetBoardWriteAction;
import com.itbook.controller.action.meeting.MetBoardWriteFormAction;
import com.itbook.controller.action.meeting.MetUpdateAction;
import com.itbook.controller.action.meeting.MetUpdateFormAction;
import com.itbook.controller.action.meeting.metBoardListFormAction;

public class MeetingActionFactory {

	private static MeetingActionFactory instance = new MeetingActionFactory();

	public MeetingActionFactory() {
		super();
	}

	public static MeetingActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);

		// �������� ����Ʈ
		if (command.equals("meetingList")) {

			action = new MeetingListAction();

			// �������� ��û������ �̵�
		} else if (command.equals("meetingApplyFormAction")) {

			action = new MeetingApplyFormAction();

			// �������� ��û
		} else if (command.equals("meetingApply")) {

			action = new MeetingApplyAction();

			// 각각의 모임의 상세보기
		} else if (command.equals("meetingHome")) {

			action = new MeetingHomeAction();

			// 모임에서 게시판보기를 클릭했을 때 전체 리스트 보여주기.
		} else if (command.equals("metBoardListFormAction")) {

			action = new metBoardListFormAction();

			// 독서모임 수정 폼으로 이동
		} else if (command.equals("metUpdateFormAction")) {

			action = new MetUpdateFormAction();

			// 독서모임 수정
		} else if (command.equals("metUpdateAction")) {

			action = new MetUpdateAction();

			// �������ӰԽ������� �̵�
		} else if (command.equals("metBoardListFormAction")) {

			action = new metBoardListFormAction();

			// �������� �Խñ۾��������� �̵�
		} else if (command.equals("metBoardWriteFormAction")) {

			action = new MetBoardWriteFormAction();

			// �������� �Խñ۾���
		} else if (command.equals("metBoardWriteAction")) {

			action = new MetBoardWriteAction();

			// �������� �Խñ� �󼼺���
		} else if (command.equals("metBoardViewAction")) {

			action = new MetBoardViewAction();

			// �������� �Խñۼ��������� �̵�
		} else if (command.equals("metBoardUpdateFormAction")) {

			action = new MetBoardUpdateFormAction();

			// �������� �Խñ� ����
		} else if (command.equals("metBoardUpdateAction")) {

			action = new MetBoardUpdateAction();

			// �������� �Խñ� ����
		} else if (command.equals("metBoardDeleteAction")) {

			action = new MetBoardDeleteAction();

			// �������� �Խñ� ��� ����
		} else if (command.equals("commentWriteAction")) {

			action = new CommentWriteAction();

			// �������� �Խñ� ��� ����
		} else if (command.equals("commentDeleteAction")) {

			action = new CommentDeleteAction();

		} else if (command.equals("joinMemberPopup")) {
			action = new JoinMemberPopupAction();
			
		} else if (command.equals("joinMeetingAction")) {
			action = new JoinMeetingAction();
		}

		return action;
	}
}
