package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MetBoardDAO;
import com.itbook.dao.MetPostDAO;
import com.itbook.vo.Meeting.MetBoardVO;
import com.itbook.vo.Meeting.MetPostVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MetPostWriteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드 파일 사이즈
        int fileSize= 5*1024*1024;
        // 업로드될 폴더 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        String metNum = request.getParameter("metNum");
        
        System.out.println("metNum: " + metNum);
        
        try {
            
            // 파일업로드 
            MultipartRequest multi = new MultipartRequest
                    (request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
 
            // 파일이름 가져오기
            String fileName = "";
            Enumeration<String> names = multi.getFileNames();
            if(names.hasMoreElements())
            {
                String name = names.nextElement();
                fileName = multi.getFilesystemName(name);
            }
            
            MetBoardDAO mDao = MetBoardDAO.getInstance();
            MetBoardVO mVo = new MetBoardVO();
            
            mVo.setMetNum(multi.getParameter("metNum"));
            mVo.setMetBrdName(multi.getParameter("metPostTitle"));
            mVo.setMetBrdContent(multi.getParameter("metPostContent"));
            mVo.setMetBrdCategory(multi.getParameter("metPostCategory"));
            
            boolean result = mDao.insertMetBoard(mVo);
            
            
            if(result) {
            	
            	new MetPostListFormAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("글 작성 오류 : " + e.getMessage());
            }
        	
        
        }  
		
	}