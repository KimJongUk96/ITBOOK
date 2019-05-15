package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class AdminMemberDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] memNum = request.getParameterValues("memNum");
		
		if(memNum != null) {
			
		for (int idx = 0; memNum.length > idx; idx++) {
			request.setAttribute("memNum", memNum[idx]);

			System.out.println("memNum : " + memNum[idx]);

			MemberVO mVO = new MemberVO();

			mVO.setMemNum(memNum[idx]);
			
			MemberDAO mDao = MemberDAO.getInstance();
			mDao.memberDelete(mVO);
			
			new AdminMemberListFormAction().execute(request, response);
		}
		}
	}

}
