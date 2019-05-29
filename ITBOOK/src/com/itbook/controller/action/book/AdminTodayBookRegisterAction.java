package com.itbook.controller.action.book;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.notice.NoticeListFormAction;
import com.itbook.dao.BookDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Book.BookBoardVO;
import com.itbook.vo.Notice.NoticeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminTodayBookRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
///*		BookBoardVO bVo = new BookBoardVO();
//		
//		
//		bVo.setBookBrdTitle(request.getParameter("bookBrdTitle"));
//		bVo.setBookBrdContent(request.getParameter("bookBrdContent"));
//		bVo.setBookTitle(request.getParameter("bookTitle"));
//		bVo.setWriter(request.getParameter("writer"));
//		bVo.setPublisher(request.getParameter("publisher"));
//		bVo.setBookNum(request.getParameter("bookNum"));
//		//bVo.setImgPath(request.getParameter("imgPath"));
//		
//		//섹션값 가져오기.
//		MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
//	      bVo.setMemNum(memVo.getMemNum());
//		
//	    
//		BookDAO bDao = BookDAO.getInstance();
//		
//		bDao.insertAdminTodayBookRegister(bVo);
//		
//		new AdminTodayBookListAction().execute(request, response);*/
	
		// 업로드 파일 사이즈
        int fileSize= 5*1024*1024;
        // 업로드될 폴더 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        
        System.out.println("============ uploadFilePath = " + uploadPath);
        
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

            BookDAO bDao = BookDAO.getInstance();
            BookBoardVO bVo = new BookBoardVO();
            
            bVo.setBookBrdTitle(multi.getParameter("bookBrdTitle"));
    		bVo.setBookBrdContent(multi.getParameter("bookBrdContent"));
    		bVo.setBookTitle(multi.getParameter("bookTitle"));
    		bVo.setWriter(multi.getParameter("writer"));
    		bVo.setPublisher(multi.getParameter("publisher"));
    		bVo.setBookNum(multi.getParameter("bookNum"));
    		bVo.setImgPath(multi.getFilesystemName("imgPath"));
    		
    		//섹션값 가져오기.
    		MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
    	      bVo.setMemNum(memVo.getMemNum());
            
            boolean result = bDao.insertAdminTodayBookRegister(bVo);
            
            if(result) {
            	
            	new AdminTodayBookListAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("글 작성 오류 : " + e.getMessage());
            }
        	
        
        }  
}