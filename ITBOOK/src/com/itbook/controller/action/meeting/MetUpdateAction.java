package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class MetUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String metNum = request.getParameter("metNum");
		String metName = request.getParameter("metName");
		String metGreeting = request.getParameter("metGreeting");
		String metIntro = request.getParameter("metIntro");
		String metPlace = request.getParameter("metPlace");
		String keyword = request.getParameter("keyword");
		
		MeetingVO mVo = new MeetingVO();
		
		mVo.setMetNum(metNum);
		mVo.setMetName(metName);
		mVo.setMetGreeting(metGreeting);
		mVo.setMetIntro(metIntro);
		mVo.setMetPlace(metPlace);
		mVo.setKeyword(keyword);
		
		MeetingDAO mDao = MeetingDAO.getInstance();
		mDao.updateMeeting(mVo);
		
		new MeetingHomeAction().execute(request, response);
	}

}
