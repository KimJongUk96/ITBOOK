package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

public class MeetingApplyFormAction implements Action {

	//�������� ��û�� ���� ������ �̵��ϴ� �׼� Ŭ����
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingApplyForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
