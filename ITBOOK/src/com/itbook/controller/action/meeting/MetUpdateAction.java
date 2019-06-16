package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.book.AdminTodayBookListAction;
import com.itbook.dao.BookDAO;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Book.BookBoardVO;
import com.itbook.vo.Meeting.MeetingVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MetUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String metNum = request.getParameter("metNum");
//		String metName = request.getParameter("metName");
//		String metGreeting = request.getParameter("metGreeting");
//		String metIntro = request.getParameter("metIntro");
//		String metPlace = request.getParameter("metPlace");
//		String keyword = request.getParameter("keyword");
//		
//		
//		MeetingVO mVo = new MeetingVO();
//		
//		mVo.setMetNum(metNum);
//		mVo.setMetName(metName);
//		mVo.setMetGreeting(metGreeting);
//		mVo.setMetIntro(metIntro);
//		mVo.setMetPlace(metPlace);
//		mVo.setKeyword(keyword);
//		
//		MeetingDAO mDao = MeetingDAO.getInstance();
//		mDao.updateMeeting(mVo);
//		
//		new MeetingHomeAction().execute(request, response);
		
		
		
		int fileSize = 5 * 1024 * 1024;
		// 업로드될 폴더 경로
		String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());

			// 파라미터 값을 가져온다.
			String metNum = request.getParameter("metNum");
			String metName = request.getParameter("metName");
			String metGreeting = request.getParameter("metGreeting");
			String metIntro = request.getParameter("metIntro");
			String metPlace = request.getParameter("metPlace");
			String keyword = request.getParameter("keyword");
			String existFile = multi.getParameter("metImg"); // 기존첨부파일

			// 파라미터 값을 자바빈에 세팅한다.
			MeetingVO mVo = new MeetingVO();
			
			mVo.setMetNum(metNum);
			mVo.setMetName(metName);
			mVo.setMetGreeting(metGreeting);
			mVo.setMetIntro(metIntro);
			mVo.setMetPlace(metPlace);
			mVo.setKeyword(keyword);
			// 글 수정 시 업로드된 파일 가져오기
			
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);
				if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존파일명 세팅
					mVo.setMetImg(existFile);
				else
					mVo.setMetImg(updateFile);
			}

			
			
			MeetingDAO mDao = MeetingDAO.getInstance();
			boolean result = mDao.updateMeeting(mVo);

			if (result) {
				new MeetingHomeAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류 : " + e.getMessage());
		}
	}

}
