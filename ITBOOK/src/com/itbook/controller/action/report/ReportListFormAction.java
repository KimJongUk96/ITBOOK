package com.itbook.controller.action.report;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.Report.ReportBoardVO;

public class ReportListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/report/reportListForm.jsp";
		
		ReportDAO rDao = ReportDAO.getInstance();
		
		List<ReportBoardVO> list = rDao.selectAllReports();
		
		
		 request.setAttribute("reportList", list);
		 
		  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		  dispatcher.forward(request, response);
		 
		
		//책 페이징
		
		/*
		 * Paging1 paging = new Paging1(10,1); int pageNum =
		 * request.getParameter("pageNum") == null ? 1 :
		 * Integer.parseInt(request.getParameter("pageNum"));
		 * 
		 * paging.setPageNum(pageNum); rDao.selectReportRowCount(paging); Paging1
		 * reportList = rDao.selectReportRowCount(paging);
		 * 
		 * 
		 * request.setAttribute("reportList", reportList);
		 * request.setAttribute("paging", paging); System.out.println(reportList);
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		 * dispatcher.forward(request, response);
		 */
		 
		
	}
}
