package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MetBoardDAO;
import com.itbook.vo.Meeting.MetBoardVO;

public class MetBoardViewAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "meeting/metBoardView.jsp";
		String metBrdNum =request.getParameter("metBrdNum");
		
		//중간에 조회수를 1증가시키기
		//조회수 증가시켜 놓고 db에 저장해 놓기
		MetBoardDAO.getInstance().updateReadCount(metBrdNum);
		
		//뷰페이지 가기전에 뷰페이지에 뿌려야 될 데이터 내용을 가져와서 request에 담아 놓은 다음 뷰 페이지로 가자
		MetBoardVO mVo = MetBoardDAO.getInstance().selectOneMetBoardByNum(metBrdNum);
		
		
		request.setAttribute("metboard", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
