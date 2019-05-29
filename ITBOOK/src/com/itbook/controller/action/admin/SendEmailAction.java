package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.SendEmail;
import com.itbook.vo.MemberVO;

public class SendEmailAction implements SendEmail{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AddressException, MessagingException {
		
		String host = "smtp.naver.com"; // GMAIL = "smtp.gmail.com"
		
		final String username = "kofdlfma2574";  // 발신자 
		final String password = "rlawhddnr80lj!@"; // 비밀번호
		int port = 465; //포트번호 25(일반적인) 465(SSL) 587(TSL)
		
		String[] email = request.getParameterValues("email"); 
		
		if(email != null) {
			
		for (int idx = 0; email.length > idx; idx++) {
			request.setAttribute("email", email[idx]);

			System.out.println("email : " + email[idx]);

			MemberVO mVO = new MemberVO();

			mVO.setEmail(email[idx]);
		}
		}
			
		String recipient = Arrays.toString(email).replace(",","").replace("[","").replace("]",""); //수신자 배열로받아와서 []제거
				
		
		/*
		 * String subject = request.getParameter("subject"); String body =
		 * request.getParameter("body");
		 */
		 
		
		
		
		String subject = "희망의책 입니다."; //제목 
		String body = "기부회원을 유지하시려면 결제를 해주세요!";//내용
		 	 		
		Properties props = System.getProperties(); 
		
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un = username;
			String pw = password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true); // for debug 
		
		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress("kofdlfma2574@naver.com")); //발신자
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));  //수신자
		mimeMessage.setSubject(subject); //제목셋팅
		System.out.println("subject : " + subject);
		mimeMessage.setText(body); //내용셋팅 
		System.out.println("body : " + body);
		Transport.send(mimeMessage); //javax.mail.Transport.send() 이용 }
		System.out.println("message sent successfully...");
		
		new AdminMemberEmailListFormAction().execute(request, response);

	}


}

