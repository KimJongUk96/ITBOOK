package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
//import com.itbook.dao.MemberDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class MeetingUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingUpdateForm.jsp";
		
		//로그인 세션값을 받아온다.
		// session = request.getSession();
		
		//독서모임번호를 가져온다.
		String metNum = request.getParameter("metNum");
		
		//회원명을 가져온다.
		//String memName = request.getParameter("metName");
		
		MeetingDAO mDao = MeetingDAO.getInstance();
		
		//metNum을 기준으로 독서모임을 수정하는 DAO의 sql문 ->MeetingUpdateAction으로 옮기기
		//mDao.updateMeeting(metNum);
		
		MeetingVO metVo = mDao.selectOneMeetingByNum(metNum);
		
		request.setAttribute("meeting", metVo);
		//request.setAttribute("LoginUser", memVo);
	}
}
