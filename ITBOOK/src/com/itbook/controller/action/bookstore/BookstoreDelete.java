package com.itbook.controller.action.bookstore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookstoreDAO;

public class BookstoreDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookstoreNum = request.getParameter("bookstoreNum");
		
		BookstoreDAO bsDao = BookstoreDAO.getInstance();
		
		bsDao.deleteBookstore(bookstoreNum);
		new AdminBookstoreList().execute(request, response);
	}

}
