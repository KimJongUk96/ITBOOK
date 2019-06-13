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

public class MetBoardWriteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드 파일 사이즈
        int fileSize= 5*1024*1024;
        // 업로드될 폴더 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        
        
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
            
            MetPostDAO mDao = MetPostDAO.getInstance();
            MetPostVO mVo = new MetPostVO();
            
            mVo.setMetPostTitle(multi.getParameter("metPostTitle"));
            mVo.setMetPostContent(multi.getParameter("metPostContent"));
            mVo.setMetPostCategory(multi.getParameter("metPostCategory"));
            mVo.setMetPostFile(multi.getFilesystemName("metPostFile"));
            
            boolean result = mDao.insertMetPost(mVo);
            
            
            if(result) {
            	
            	new MetBoardListFormAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("글 작성 오류 : " + e.getMessage());
            }
        	
        
        }  
		
	}
