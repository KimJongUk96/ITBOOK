package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class MeetingHomeAction implements Action {

//MeetingList���� �������Ӹ� Ŭ���ϸ� �ش� MeetingHome.jsp ����ֱ�	(metNum���� ����)

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingHome.jsp";
		
		String metNum = request.getParameter("metNum");
		
		MeetingDAO mDao = MeetingDAO.getInstance();
		
		MeetingVO mVo = mDao.selectOneMeetingByNum(metNum);
		
		//mDao.updateReadCount(metNum);
		
		//MeetingVO mVo = mDao.uploadCheckbox(metNum);
		
		request.setAttribute("meeting", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
