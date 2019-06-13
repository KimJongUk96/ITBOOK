package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MetPostDAO;
import com.itbook.vo.Meeting.MetPostVO;

public class MetBoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/meeting/metBoardUpdateForm.jsp";

		// 페이지 번호와 글 번호를 가져온다.
		String pageNum = request.getParameter("page");
		String metPostNum = request.getParameter("metPostNum");
		
		
		MetPostDAO mDao = MetPostDAO.getInstance();
		MetPostVO metpost = mDao.selectOneMetPostByNum(metPostNum);

		request.setAttribute("metpost", metpost);
		request.setAttribute("pageNum", pageNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
