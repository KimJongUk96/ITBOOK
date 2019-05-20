package com.itbook.controller.action.report;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.Report.ReportBoardVO;

public class ReportUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ReportBoardVO rVo = new ReportBoardVO();

		rVo.setReportTitle(request.getParameter("reportTitle"));
		rVo.setReportContent(request.getParameter("reportContent"));
		rVo.setBookNum(request.getParameter("bookNum"));
		rVo.setMemNum(request.getParameter("memNum"));

		ReportDAO rDao = ReportDAO.getInstance();
		rDao.updateReport(rVo);


		new ReportListFormAction().execute(request, response);
	}

}