package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.BookVO;

public class AdminTodayBookUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookVO bVo = new BookVO();
		
		bVo.setBookNum(Integer.parseInt(request.getParameter("bookNum")));
		bVo.setBookTitle(request.getParameter("bookTitle"));
		bVo.setWriter(request.getParameter("writer"));
		bVo.setPublisher(request.getParameter("publisher"));
		bVo.setPublisher(request.getParameter("bookKeyword1"));
		bVo.setPublisher(request.getParameter("bookKeyword2"));
		bVo.setPublisher(request.getParameter("bookKeyword3"));
		
		
		int memNum = Integer.parseInt(request.getParameter("memNum"));
		bVo.setMemNum(memNum);
		
		
		BookDAO bDao = BookDAO.getInstance();
		bDao.updateBook(bVo);
		
		new BookListAction().execute(request, response);
	}

}
