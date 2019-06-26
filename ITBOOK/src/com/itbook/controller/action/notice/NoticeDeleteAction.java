package com.itbook.controller.action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;

/**
 * 공지사항 삭제하는 액션 클래스
 * 
 * @author 김정민
 *
 */

public class NoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String noticeNum = request.getParameter("noticeNum");

		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.deleteNotice(noticeNum);

		new NoticeListFormAction().execute(request, response);
	}
}
