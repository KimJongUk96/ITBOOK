<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title> 메일전송 </title>
</head>
<body>
	<h3>메일 전송</h3>
	<section id="error-section" class="error-section w100dt mb-50">
		<div class="container">
				<div class="col-12 col-md-7 col-xl-8 mx-auto my-5">
				<div class="row h-100">
				<div class="col-12 col-md-10 col-lg-5 text-left mx-auto d-flex align-items-center">
				<div class="w-100">
		<input type = "hidden" id="email" name = "email" value = "${email}">
		
		<div class="form mt-4">
					<div>
					<p class="text-left mb-2">제목</p>
					<span class="form-group"><input type ="text" name = "subject" id = "subject"class="form-control"/></span>
							</div>
							<p></p>
							<div class ="wrap">
					<span>내용  <textarea name = "body" id = "body"></textarea></span>
					</div>
					<button type="button" name="ajax" id="send" onclick="sendMessage()" class="btn btn-black" >발송</button>
		</div>
		
					</div>
					</div>
					</div>
					</div>
		</div>
		<!-- container -->
	</section>
	<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script>
	function sendMessage(){
		var email = $("#email").val();
		var subject = $("#subject").val();
		var body = $("#body").val();
	
/* 		var data = {"subject":subject, "body":body};
 */		
		$.ajax({
			url : '/email?command=senderEmail',
			type : 'post',
			data : {subject : subject,
					body : body,
					email : email},
			success : function(data){
				alert("메일 전송을 성공했습니다.");
				 self.close();
				opener.parent.location.reload();
				
			}
		});
	}
	</script>

</body>
</html>