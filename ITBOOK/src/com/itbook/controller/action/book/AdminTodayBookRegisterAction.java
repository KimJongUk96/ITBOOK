package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BookBoardVO bVo = new BookBoardVO();
		
		
		bVo.setBookBrdTitle(request.getParameter("bookTitle"));
		bVo.setBookBrdContent(request.getParameter("bookContent"));
		
		int bookNum = Integer.parseInt(request.getParameter("bookNum"));
		bVo.setBookNum(bookNum);
		
		int memNum = Integer.parseInt(request.getParameter("memNum"));
		bVo.setMemNum(memNum);
		
		BookDAO bDao = BookDAO.getInstance();
		
		bDao.insertAdminTodayBookRegister(bVo);
		
		new AdminTodayBookListAction().execute(request, response);
		
	}

}
