package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class MeetingHomeAction implements Action {

//MeetingList에서 독서모임명 클릭하면 해당 MeetingHome.jsp 띄워주기	(metNum으로 연결)

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingHome.jsp";
		
		String metNum = request.getParameter("metNum");
		
		MeetingDAO mDao = MeetingDAO.getInstance();
		
		MeetingVO meeting = mDao.selectOneMeetingByNum(metNum);
		
		//MeetingVO mVo = mDao.uploadCheckbox(metNum);
		
		request.setAttribute("meeting", meeting);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
