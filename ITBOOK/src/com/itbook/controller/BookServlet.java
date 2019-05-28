package com.itbook.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;


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
		
		
//		System.out.println("displayFile");
//	      
//	      String fileName = request.getParameter("fileName");
//	      
//	      System.out.println("fileName ====> " + fileName);
//	      String uploadFilePath = request.getServletContext().getRealPath("/") + "mlbFile/";
//	      
//	      String dFileName = request.getParameter("fileName");
//	      response.setHeader("Content-Type","image/png");
//	      java.io.File file = new java.io.File(uploadFilePath+dFileName);
//	      byte b[] = new byte[(int)file.length()];
//	      
//	      response.setHeader("Content-Disposition","attachement:filename="+new String(dFileName.getBytes("UTF-8"))+";");
//	      
//	      if(file.isFile()){
//	         
//	         System.out.println("isFile ");
//	         
//	          BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
//	          BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
//	          int read = 0;
//	          while ((read=fin.read(b))!=-1){
//	              outs.write(b,0,read);
//	          }
//	          outs.close();
//	          fin.close();
//	      }
	}


}
