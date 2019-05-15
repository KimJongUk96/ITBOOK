/**
 * 이달의 책 리스트  
 * @author 동준
 *
 */

package com.itbook.controller.action.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/book/adminTodayBookList.jsp";
		
		BookDAO bDao = BookDAO.getInstance();
		
		List<BookBoardVO> todayBookList = bDao.selectAdminTodayBookList();
		
		request.setAttribute("todayBookList", todayBookList);
		
		System.out.println(todayBookList + "나와랑");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);
		
		
		
	}
	
}
