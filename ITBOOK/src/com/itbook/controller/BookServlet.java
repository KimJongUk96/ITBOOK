package com.itbook.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.book.AdminTodayBookRegisterAction;
import com.itbook.vo.Book.BookBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("BookServlet에서 요청을 받음을 확인 : " + command);
		//싱글턴 패턴
		BookActionFactory af = BookActionFactory.getInstance();
		
		Action action = af.getAction(command);
		if(action != null){
		action.execute(request, response);
		}else if(command.equals("adminTodayBookRegForm")) {
			
			ServletContext context = getServletContext();
			System.out.println("context: " + context.getContextPath());
			
			//imgPath라는 폴더 만들기!
			String path = context.getRealPath("imgPath");
			
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			
			String bookBrdNum = multi.getParameter("bookBrdNum");
			String bookBrdTitle = multi.getParameter("bookBrdTitle");
			String bookBrdContent = multi.getParameter("bookBrdContent");
			String writer = multi.getParameter("writer");
			String publisher = multi.getParameter("publisher");
			String imgPath = multi.getParameter("imgPath");
			String bookNum = multi.getParameter("bookNum");
			String memNum = multi.getParameter("memNum");
			
			BookBoardVO bVo = new BookBoardVO();

			
			bVo.setBookBrdNum(bookBrdNum);
			bVo.setBookBrdTitle(bookBrdTitle);
			bVo.setBookBrdContent(bookBrdContent);
			bVo.setWriter(writer);
			bVo.setPublisher(publisher);
			bVo.setImgPath(imgPath);
			bVo.setBookNum(bookNum);
			bVo.setMemNum(memNum);
			
			System.out.println("path: " + path);
			System.out.println("bookImgPath: " + imgPath);
			System.out.println("bVo: " + bVo);
			
			
			request.setAttribute("bVo", bVo);
			
			
			new AdminTodayBookRegisterAction().execute(request, response);
				
		}
		
    }
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		
		
		
	}


}
