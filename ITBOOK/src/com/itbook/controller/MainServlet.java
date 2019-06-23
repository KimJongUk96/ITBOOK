package com.itbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itbook.dao.BookDAO;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.main.MainDTO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MainServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String command = request.getParameter("command");
		System.out.println("MainServlet에서 요청을 받음을 확인 : " + command);

		// 메인화면에서 모임 보여주기
		MeetingDAO mDao = MeetingDAO.getInstance();
		List<MainDTO> meetingMainList = mDao.selectMainMeetings();
		request.setAttribute("meetingMainList", meetingMainList);
		
		// 메인화면에서 이달의 책 보여주기
		BookDAO bDao = BookDAO.getInstance();
		List<MainDTO> maintodayBookList = bDao.selectMainTodayBooks();
		request.setAttribute("maintodayBookList", maintodayBookList);

		if (command == null) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("loginForm")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
