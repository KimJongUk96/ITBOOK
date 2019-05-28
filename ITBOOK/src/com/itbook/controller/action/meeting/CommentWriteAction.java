package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MetCommentDAO;
import com.itbook.vo.Meeting.MetCommentVO;

public class CommentWriteAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MetCommentDAO dao = MetCommentDAO.getInstance();
		MetCommentVO comment = new MetCommentVO();
		
		// 파리미터 값을 가져온다.
        String metBrdNum = request.getParameter("metBrdNum");
        String memNum = request.getParameter("memNum");
        String metComtContent = request.getParameter("metComtContent");
        
        comment.setMetBrdNum(metBrdNum);
        comment.setMemNum(memNum);
        comment.setMetComtContent(metComtContent);
        
        boolean result = dao.insertComment(comment);
        
        if(result){
            response.setContentType("text/html;charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("1");
            out.close();
        }
            


	}

}
