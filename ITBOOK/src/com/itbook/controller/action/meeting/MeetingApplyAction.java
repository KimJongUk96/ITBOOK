package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MeetingApplyAction implements Action{
	
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
		// 업로드 파일 사이즈
        int fileSize= 5*1024*1024;
        // 업로드될 폴더 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        
        System.out.println("============ MeetingImg = " + uploadPath);
        
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
            
            System.out.println("fileName : " + fileName);

            MeetingDAO mDao = MeetingDAO.getInstance();
            MeetingVO mVo = new MeetingVO();
            
            mVo.setMetName(multi.getParameter("metName"));
			mVo.setMetGreeting(multi.getParameter("metGreeting"));
			mVo.setMetIntro(multi.getParameter("metIntro"));
			mVo.setRepresent(multi.getParameter("represent"));
			mVo.setMetPlace(multi.getParameter("metPlace"));
			mVo.setKeyword(multi.getParameter("keyword"));
			mVo.setMetImg(multi.getFilesystemName("metImg"));
			
            boolean result = mDao.insertMeeting(mVo);
            
            if(result) {
            	
            	new MeetingListAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("글 작성 오류 : " + e.getMessage());
            }
        	
        
        }  
	}
