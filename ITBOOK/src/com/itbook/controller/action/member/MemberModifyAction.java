package com.itbook.controller.action.member;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class MemberModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO mVo = new MemberVO();
		mVo.setEmail(request.getParameter("email"));
		mVo.setAdr(request.getParameter("adr"));
		mVo.setPhone(request.getParameter("phone"));
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.memberUpdate(mVo);
		
		
		new LoginAction().execute(request, response);
		
		
	}

}
