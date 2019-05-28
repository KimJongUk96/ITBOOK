package com.itbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

/**
 * Servlet implementation class MeetingListServlet
 */
@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String command = request.getParameter("command");
		System.out.println("meeting에서 요청받음을 확인 : " + command );
		
		MeetingActionFactory af = MeetingActionFactory.getInstance();
		
		//ActionFactory의 getAction() 메소드를 호출한다.
		Action action = af.getAction(command);
		
		//예외가 발생하지 않도록 하기 위해 null이 아닐 경우에만 execute()메소드를 호출한다.
		if(action != null) {
			action.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8"); //post방식으로 호출받으면 한글깨짐 방지
		doGet(request, response);
	}

}
