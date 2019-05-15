package com.itbook.controller.action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;

public class NoticeInsertAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");

		
		
		
		NoticeVO nVo = new NoticeVO();
		
		nVo.setNoticeTitle(noticeTitle);
		nVo.setNoticeContent(noticeContent);

		
		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.insertNotice(nVo);
		
		System.out.println("방가");
		
//		목록 화면으로 이동
		new NoticeListFormAction().execute(request, response);
		
		
		
	}

}
