package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BookBoardVO bVo = new BookBoardVO();
		
		
		bVo.setBookBrdTitle(request.getParameter("bookTitle"));
		bVo.setBookBrdContent(request.getParameter("bookBrdContent"));
		//bVo.setImgPath(request.getParameter("imgPath"));
		bVo.setWriter(request.getParameter("writer"));
		bVo.setPublisher(request.getParameter("publisher"));
		bVo.setBookNum(request.getParameter("bookNum"));
		
		//섹션값 가져오기.
		MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
	      bVo.setMemNum(memVo.getMemNum());
		
	    
		BookDAO bDao = BookDAO.getInstance();
		
		bDao.insertAdminTodayBookRegister(bVo);
		
		new AdminTodayBookListAction().execute(request, response);
		
	}

}
