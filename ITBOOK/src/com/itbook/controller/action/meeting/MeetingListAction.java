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

public class MeetingListAction implements Action {
	
	// MeetingListServlet?command=meetingList 요청을 받으면 독서모임 리스트 화면을 표시한다.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingList.jsp";
 
		MeetingDAO mDao = MeetingDAO.getInstance();
		
		List<MeetingVO> meetingList = mDao.selectAllMeetings();
		
		request.setAttribute("meetingList", meetingList);
		
		System.out.println(meetingList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
