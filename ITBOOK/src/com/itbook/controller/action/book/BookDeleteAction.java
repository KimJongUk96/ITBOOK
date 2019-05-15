package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;

public class BookDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookNum = request.getParameter("bookNum");
		
		BookDAO bDao = BookDAO.getInstance();
		
		bDao.deleteBook(bookNum);
		System.out.println("=====1====="+bookNum);
		new BookListAction().execute(request, response);
	
		
		
		
		
	}
	

}
