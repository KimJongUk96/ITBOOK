package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;

public class AdminTodayBookDeleteAction implements Action{
	
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookBrdNum = request.getParameter("bookBrdNum");
		
		BookDAO bDao = BookDAO.getInstance();
		
		bDao.deleteTodayBook(bookBrdNum);
		new AdminTodayBookListAction().execute(request, response);
		
	}
}