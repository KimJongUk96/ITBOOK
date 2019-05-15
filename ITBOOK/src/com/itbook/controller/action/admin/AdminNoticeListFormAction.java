package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;

public class AdminNoticeListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "admin/noticeList.jsp";
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		ArrayList<NoticeVO> list = nDao.noticeList();
		
		request.setAttribute("noticeList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
