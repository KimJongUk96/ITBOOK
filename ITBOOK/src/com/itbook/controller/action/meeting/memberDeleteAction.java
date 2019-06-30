package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemListVO;

public class memberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String memNum = request.getParameter("memNum");
		String metNum = request.getParameter("metNum");
		request.setAttribute("metNum", metNum);
		MemListVO mVo = new MemListVO();
		mVo.setMemNum(memNum);
		mVo.setMetNum(metNum);
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.memberDelete(mVo);
		
		new ManageMemberAction().execute(request, response);
		
	}

}
