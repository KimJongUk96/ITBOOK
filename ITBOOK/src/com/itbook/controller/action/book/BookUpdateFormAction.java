/** 
 * 책 수정 화면으로 이동하게 하는 액션 클래스
 * 책 리스트 화면에서 책 번호를 클릭하게 되면 이동
 * @author DJ PARK
 * */
package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.BookVO;

public class BookUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/book/bookUpdate.jsp";
		
		String bookNum = request.getParameter("bookNum");
		
		BookDAO bDao = BookDAO.getInstance();
		
		BookVO bVo = bDao.selectOneBookNum(bookNum);
		
		request.setAttribute("bookList", bVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
