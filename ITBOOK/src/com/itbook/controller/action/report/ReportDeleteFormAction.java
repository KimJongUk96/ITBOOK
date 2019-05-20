package com.itbook.controller.action.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;

public class ReportDeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ReportNum = request.getParameter("reportNum");

		ReportDAO rDao = ReportDAO.getInstance();
		rDao.deleteReport(ReportNum);

		new ReportListFormAction().execute(request, response);
	}

}
