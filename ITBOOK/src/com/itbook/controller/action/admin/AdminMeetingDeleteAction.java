package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class AdminMeetingDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] metNum = request.getParameterValues("metNum");
		if(metNum != null) {
			for(int i = 0; i< metNum.length; i++) {
				request.setAttribute("metNum", metNum);
				
				MeetingVO mVO = new MeetingVO();
				mVO.setMetNum(metNum[i]);
				
				MeetingDAO mDao = MeetingDAO.getInstance();
				mDao.deleteMeeting(mVO);
			}
		}
		new AdminMeetingListAction().execute(request, response);
		
	}

}
