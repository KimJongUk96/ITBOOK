package com.itbook.controller.action.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.LibraryDAO;

/**
 * @author 수아
 */

public class LibraryDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String libraryNum = request.getParameter("libraryNum");
		
		LibraryDAO lDao = LibraryDAO.getInstance();
		
		lDao.deleteLibrary(libraryNum);
		new AdminLibraryList().execute(request, response);
	}

}