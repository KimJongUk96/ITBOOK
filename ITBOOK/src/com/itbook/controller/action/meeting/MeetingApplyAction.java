package com.itbook.controller.action.meeting;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class MeetingApplyAction implements Action{
	
	
		// MeetingApplyAction?command=meetingApply 요청을 받으면 독서모임 리스트 화면을 표시한다.
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			MeetingVO mVo = new MeetingVO();
			
			mVo.setMetName(request.getParameter("metName"));
			mVo.setMetIntro(request.getParameter("metIntro"));
			mVo.setRepresent(request.getParameter("represent"));
			mVo.setKeyword(request.getParameter("keyword"));
			
			MeetingDAO mDao = MeetingDAO.getInstance();
			mDao.insertMeeting(mVo);
			
			//데이터베이스에 저장된 정보는 리스트 화면에 뿌려진다.
			new MeetingListAction().execute(request, response);
			
		}

	}
