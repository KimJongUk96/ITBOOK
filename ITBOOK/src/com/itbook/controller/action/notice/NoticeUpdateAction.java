package com.itbook.controller.action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;

public class NoticeUpdateAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		NoticeVO nVo = new NoticeVO();
		
		
		
		nVo.setNoticeNum(request.getParameter("noticeNum"));
		
		
		nVo.setNoticeTitle(request.getParameter("noticeTitle"));
		nVo.setNoticeContent(request.getParameter("noticeContent"));
		
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.updateNotice(nVo);
		
		new NoticeListFormAction().execute(request, response);
		
	}

}
