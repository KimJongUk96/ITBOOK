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

public class MetBoardUpdateAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // 답글 작성 후 원래 페이지로 돌아가기 위해 페이지 번호가 필요하다.
//      String pageNum = request.getParameter("page");
      
      // 업로드 파일 사이즈
      int fileSize= 5*1024*1024;
      // 업로드될 폴더 절대경로
      String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
      
      try {
          MultipartRequest multi = new MultipartRequest (request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
          
          // 파리미터 값을 가져온다.
          String metPostNum = multi.getParameter("metPostNum");    // 글 번호
          String metPostTitle= multi.getParameter("metPostTitle");    // 글 제목
          String metPostContent = multi.getParameter("metPostContent");    // 글 내용
          String existFile = multi.getParameter("existing_file");    // 기존 첨부 파일
          
          // 파라미터 값을 자바빈에 세팅한다.
          MetPostVO mVo = new MetPostVO();
          mVo.setMetPostNum(metPostNum);
          mVo.setMetPostTitle(metPostTitle);
          mVo.setMetPostContent(metPostContent);
          
          
          // 글 수정 시 업로드된 파일 가져오기
          Enumeration<String> fileNames = multi.getFileNames();
          if(fileNames.hasMoreElements())
          {
              String fileName = fileNames.nextElement();
              String updateFile = multi.getFilesystemName(fileName);
              
              if(updateFile == null)    // 수정시 새로운 파일을 첨부 안했다면 기존 파일명을 세팅
            	  mVo.setMetPostFile(existFile);
              else    // 새로운 파일을 첨부했을 경우
            	  mVo.setMetPostFile(updateFile);
          }
          
          MetPostDAO mDao =  MetPostDAO.getInstance();
          boolean result = mDao.updateMetPost(mVo);
          
          if(result){
              
              // 원래있던 페이지로 돌아가기 위해 페이지번호를 전달한다.
              //forward.setNextPath("BoardListAction.bo?page="+pageNum);
              
              new MetBoardListFormAction().execute(request, response);
          }
          
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("글 수정 오류 : " + e.getMessage());
      }
	}

}
