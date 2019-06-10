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
		
		String host = "smtp.gmail.com"; // GMAIL = "smtp.gmail.com"
		
		final String username = "kofdlfma2574";  // 발신자 
		final String password = "whddnr80lj"; // 비밀번호
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
		  //.replace(",","")
		 String recipient = Arrays.toString(email).replace("[","").replace("]","");
		 String [] result = recipient.split(",");
		 
		 String subject = request.getParameter("subject"); 
		 String body = request.getParameter("body");
		 
		
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
		mimeMessage.setFrom(new InternetAddress("kofdlfma2574@gmail.com")); //발신자
		
		//mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));  //수신자
		
		InternetAddress[] toAddr = new InternetAddress[result.length];
		for(int i=0; i<result.length; i++) {
		toAddr[i] = new InternetAddress (result[i]);
		System.out.println("result : " + toAddr[i]);
		}
		
		mimeMessage.setRecipients(Message.RecipientType.TO, toAddr);
			
		mimeMessage.setSubject(subject); //제목셋팅
		System.out.println("subject : " + subject);
		mimeMessage.setText(body); //내용셋팅 
		System.out.println("body : " + body);
		Transport.send(mimeMessage); //javax.mail.Transport.send() 이용 }
		System.out.println("message sent successfully...");
	
	}


}

