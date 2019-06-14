package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.BookVO;
import com.itbook.vo.Paging;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/todayBookList.jsp";
		
		BookDAO bDao = BookDAO.getInstance();
	
		
		//이달의 책 페이징
		  Paging paging = new Paging(10,1);
	      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

	      paging.setPageNum(pageNum);
	      bDao.selectTodayBookRowCount(paging);
	      ArrayList<BookBoardVO> bookBrdList = bDao.selectAdminTodayBookListPaging(paging);

	      
	      request.setAttribute("bookBrdList", bookBrdList);
	      request.setAttribute("paging", paging);
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
	      
	}

}
