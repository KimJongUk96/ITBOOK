package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MetPostDAO;

public class MetBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String metPostNum = request.getParameter("metPostNum");

		MetPostDAO mDao = MetPostDAO.getInstance();
		mDao.deleteMetPost(metPostNum);
		
		new MetBoardListFormAction().execute(request, response);
	}

}
