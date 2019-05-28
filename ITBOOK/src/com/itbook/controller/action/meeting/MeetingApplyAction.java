package com.itbook.controller.action.meeting;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class MeetingApplyAction implements Action{
	
	
		// MeetingApplyAction?command=meetingApply ��û�� ������ �������� ����Ʈ ȭ���� ǥ���Ѵ�.
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			MeetingVO mVo = new MeetingVO();
			
			mVo.setMetName(request.getParameter("metName"));
			mVo.setMetIntro(request.getParameter("metIntro"));
			mVo.setRepresent(request.getParameter("represent"));
			mVo.setKeyword(request.getParameter("keyword"));
			
			MeetingDAO mDao = MeetingDAO.getInstance();
			mDao.insertMeeting(mVo);
			
			//�����ͺ��̽��� ����� ������ ����Ʈ ȭ�鿡 �ѷ�����.
			new MeetingListAction().execute(request, response);
			
		}

	}