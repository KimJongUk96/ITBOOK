package com.itbook.controller.action.library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.LibraryDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.library.LibraryVO;

/**
 * @author 수아
 */

public class AdminLibraryList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/library/adminLibraryList.jsp";

		LibraryDAO lDao = LibraryDAO.getInstance();

		//페이징
		Paging paging = new Paging(10, 1);
		int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

		paging.setPageNum(pageNum);
		lDao.selectLibraryRowCount(paging);

		List<LibraryVO> libraryList = lDao.adminSelecLibraryList(paging);
		request.setAttribute("libraryList", libraryList);

		System.out.println(libraryList + "adminLibraryList 출력완료.");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
