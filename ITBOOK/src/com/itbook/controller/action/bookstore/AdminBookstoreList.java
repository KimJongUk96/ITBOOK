package com.itbook.controller.action.bookstore;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookstoreDAO;
import com.itbook.vo.Bookstore.BookstoreVO;

public class AdminBookstoreList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
String url = "/bookstore/adminBookstoreList.jsp";
		
		BookstoreDAO bsDao = BookstoreDAO.getInstance();
		
		List<BookstoreVO> bookstoreList = bsDao.selectBookstoreList();
		request.setAttribute("bookstoreList", bookstoreList);
		
		System.out.println(bookstoreList + "adminbookList 출력완료.");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
