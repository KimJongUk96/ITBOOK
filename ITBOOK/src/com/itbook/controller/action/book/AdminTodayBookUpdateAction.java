package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookBoardVO bVo = new BookBoardVO();
		
		bVo.setBookBrdNum(request.getParameter("bookBrdNum"));
		bVo.setBookBrdTitle(request.getParameter("bookBrdTitle"));
		bVo.setBookBrdContent(request.getParameter("bookBrdContent"));
		bVo.setBookNum(request.getParameter("bookNum"));
		bVo.setBookTitle(request.getParameter("bookTitle"));
		bVo.setWriter(request.getParameter("writer"));
		bVo.setPublisher(request.getParameter("publisher"));
		
		MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
		bVo.setMemNum(memVo.getMemNum());
		
		BookDAO bDao = BookDAO.getInstance();
		bDao.updateAdminTodayBook(bVo);
			
		new AdminTodayBookListAction().execute(request, response);
		
	}

}
