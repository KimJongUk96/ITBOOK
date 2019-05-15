package com.itbook.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main?command=loginForm";
		
		//세션 요청
		HttpSession session = request.getSession();
		
		if(session.getAttribute("LoginUser") != null) {
			RequestDispatcher disptcher = request.getRequestDispatcher(url);
			disptcher.forward(request, response);	
			
		} else {
			
			MemberVO memVO = new MemberVO();
			MemberDAO memDao = MemberDAO.getInstance();
			
			memVO.setMemId(request.getParameter("memId"));
			memVO.setMemPw(request.getParameter("memPw"));
		
			
			System.out.println(memDao.loginCheck(memVO));
		
			switch(memDao.loginCheck(memVO)) {
			
				case 1:
					
				{
						MemberVO sessionVO = memDao.getMemberInfo(memVO);
						session.setAttribute("LoginUser", sessionVO);
						System.out.println(sessionVO);
						break;
				}
				case 0:
				{
						request.setAttribute("message", "비밀번호를 확인하세요" );
						url = "main?command=loginForm";
						break;
				}
				case -1:
				{
						request.setAttribute("message", "존재하지않는 회원입니다.");
						url = "main?command=loginForm";
						break;
				}
				default : request.setAttribute("message", "오류가 발생했습니다.");
				}
			
					RequestDispatcher disptcher = request.getRequestDispatcher(url);
					disptcher.forward(request, response);
		}
			
		
	}

}
