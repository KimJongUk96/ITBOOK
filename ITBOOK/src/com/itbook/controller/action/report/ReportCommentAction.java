package com.itbook.controller.action.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.Report.ReportCommentVO;

public class ReportCommentAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        ReportDAO dao = ReportDAO.getInstance();
	        ReportCommentVO comment = new ReportCommentVO();
	        
	        // ��由щ�명�� 媛��� 媛��몄�⑤��.
	        String ReportNum = request.getParameter("reportNum");
	        String MemNum = request.getParameter("memNum");
	        String ReportComtContent = request.getParameter("reportComtContent");	       
	       
	        comment.setReportNum(ReportNum);
	        comment.setMemNum(MemNum); 
	        comment.setReportComtContent(ReportComtContent);	      
	              
		/* boolean result = dao.insertComment(comment); */
	 
		/*
		 * if(result){ response.setContentType("text/html;charset=euc-kr"); PrintWriter
		 * out = response.getWriter();
		 * 
		 * new ReportDetailFormAction().execute(request, response); out.close(); }
		 */
	        
	        
	    }
	
}
