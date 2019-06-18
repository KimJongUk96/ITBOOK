package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.BookVO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String[] bookBrdNum = request.getParameterValues("bookBrdNum");
			
			if(bookBrdNum != null) {
				
			for (int idx = 0; bookBrdNum.length > idx; idx++) {
				request.setAttribute("bookBrdNum", bookBrdNum[idx]);
	
				System.out.println("bookBrdNum : " + bookBrdNum[idx]);
	
				BookBoardVO bVO = new BookBoardVO();
	
				bVO.setBookBrdNum(bookBrdNum[idx]);
				
				BookDAO bDao = BookDAO.getInstance();
				bDao.todayBookDelete(bVO);
				
			}
			}
		new AdminTodayBookListFormAction().execute(request, response);
		
	}

}


