package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;


public class MeetingApplyFormAction implements Action {

	//�������� ��û�� ���� ������ �̵��ϴ� �׼� Ŭ����
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingApplyForm.jsp"; 
		
		//LoginUser�� Member���̺��� memName ��������
		String LoginUser = request.getParameter("memName");
		
		//private�� ����� DAO Ŭ������ �ν��Ͻ��� �������� getInstance() �Լ� ���
		MemberDAO mDao = MemberDAO.getInstance();
		
		request.setAttribute("LoginUser", LoginUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
