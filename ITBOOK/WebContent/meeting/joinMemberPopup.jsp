<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title> 멤버쉽 가입 </title>

	<!-- Favicon -->
	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700" rel="stylesheet">

	<!-- Plugins CSS -->
	<link rel="stylesheet" type="text/css" href="assets/vendor/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/vendor/themify-icons/css/themify-icons.css" />
	<link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.min.css" />

	<!-- Theme CSS -->
	<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
</head>
<body>
<!-- =======================
   Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/index.jsp"><i class="ti-home"></i>Home</a></li>
							<li class="breadcrumb-item">독서모임</li>
						</ol>
					</nav>
				</div>	
			</div>
		</div>
	</div>
   <!-- =======================
   Banner innerpage -->
	<h3>멤버쉽 가입</h3>
		<div class="container">
		<input type = "hidden" id="memNum" name = "memNum" value = "${LoginUser.memNum}">
		<input type = "hidden" id="metNum" name = "metNum" value = "${meetingVo.metNum}">
		
		<div class="form mt-4">
					<div>
					<p class="text-left mb-2">이름</p>
					<span class="form-group"><input type ="text" name = "memName" id = "memName" class="form-control" value="${LoginUser.memName}"/></span>
							</div>
							<p></p>
							<div class ="wrap">
					 아이디<span><input type ="text" name = "memId" id = "memId" class="form-control" value="${LoginUser.memId}"/></span>
					</div>
					<div>
					<button type="button" name="ajax" id="send" onclick="sendMessage()" class="btn btn-black" >가입</button>
					</div>
		</div>
		
		</div>
		<!-- container -->
	<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script>
	function sendMessage(){
		var memNum = $("#memNum").val();
		var metNum = $("#metNum").val();
		var memName = $("#memName").val();
		var memId = $("#memId").val();
	
		$.ajax({
			url : '/meeting?command=joinMeetingAction',
			type : 'post',
			data : {memNum : memNum,
					metNum : metNum,
					memName : memName,
					memId : memId},
			success : function(data){
				alert("신청되었습니다.");
				 self.close();
				opener.parent.location.reload();
				
			}
		});
	}
	</script>

</body>
</html>