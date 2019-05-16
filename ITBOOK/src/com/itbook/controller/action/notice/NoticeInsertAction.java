package com.itbook.controller.action.notice;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeInsertAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 업로드 파일 사이즈
        int fileSize= 5*1024*1024;
        // 업로드될 폴더 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        
        System.out.println("============ uploadFilePath = " + uploadPath);
        
        try {
            
            // 파일업로드 
            MultipartRequest multi = new MultipartRequest
                    (request, uploadPath, fileSize, "euc-kr", new DefaultFileRenamePolicy());
 
            // 파일이름 가져오기
            String fileName = "";
            Enumeration<String> names = multi.getFileNames();
            if(names.hasMoreElements())
            {
                String name = names.nextElement();
                fileName = multi.getFilesystemName(name);
            }

            NoticeDAO nDao = NoticeDAO.getInstance();
            NoticeVO nVo = new NoticeVO();
            
            nVo.setNoticeTitle(multi.getParameter("noticeTitle"));
            nVo.setNoticeContent(multi.getParameter("noticeContent"));
            nVo.setNoticeFile(multi.getParameter("noticeFile"));
            
            boolean result = nDao.insertNotice(nVo);
            
            if(result) {
            	
            	new NoticeListFormAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("글 작성 오류 : " + e.getMessage());
            }

        
        }  
        
}

		
//		String noticeTitle = request.getParameter("noticeTitle");
//		String noticeContent = request.getParameter("noticeContent");
//
//		
//		
//		
//		NoticeVO nVo = new NoticeVO();
//		
//		nVo.setNoticeTitle(noticeTitle);
//		nVo.setNoticeContent(noticeContent);
//
//		
//		NoticeDAO nDao = NoticeDAO.getInstance();
//		nDao.insertNotice(nVo);
//		
//		System.out.println("방가");
//		
////		목록 화면으로 이동
//		new NoticeListFormAction().execute(request, response);
		
		
		
	

