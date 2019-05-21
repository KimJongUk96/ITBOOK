<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>

  <style>
    .wrap {
      width: 500px;
    }
    .wrap textarea {
      width: 100%;
      resize: none;
      overflow-y: hidden; /* prevents scroll bar flash */
      padding: 1.1em; /* prevents text jump on Enter keypress */
      padding-bottom: 0.2em;
      line-height: 1.6;
    }
  </style>
<script type="text/javascript" src="js/mailPopup.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title> 메일전송 </title>

<!-- css include -->
<link rel="stylesheet" type="text/css" href="css/materialize.css">
<link rel="stylesheet" type="text/css" href="css/icofont.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
<link rel="stylesheet" type="text/css"
	href="css/owl.theme.default.min.css">

<!-- my css include -->
<link rel="stylesheet" type="text/css" href="css/custom-menu.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">

</head>
<body>
	<h3>메일 전송</h3>
	<section id="error-section" class="error-section w100dt mb-50">
		<div class="container">
				<div class="col-12 col-md-7 col-xl-8 mx-auto my-5">
				<div class="row h-100">
				<div class="col-12 col-md-10 col-lg-5 text-left mx-auto d-flex align-items-center">
				<div class="w-100">
		<form name="frm" method="post" action="/admin?command=senderEmail&email=${MemberVO.email}"	>
		<input type = "hidden" name = "email" value = "${email}">
		<div class="form mt-4">
					<div>
					<p class="text-left mb-2">제목</p>
					<span class="form-group"><input type ="text" name = "subject" class="form-control"/></span>
							</div>
							<p></p>
							<div class ="wrap">
					<span>내용  <textarea name = "body" ></textarea></span>
					</div>
					<button type="button" class="btn btn-black" onclick = "goSubmit()">발송</button>
		</div>
		</form>
		
					</div>
					</div>
					</div>
					</div>
		</div>
		<!-- container -->
	</section>
	<!-- /#error-section -->
	<!-- ==================== error-section end ==================== -->





	<!-- ==================== instag leftram-section Start ==================== -->
	<!--   <section id="instagram-section" class="instagram-section w100dt">

			<div class="instagram-link w100dt">
				<a href="#">
					<span>FIND US ON INSTAGRAM</span>
					@SUJONMAJIDESIGN
				</a>
			</div>

		</section> -->
	<!-- /#instag leftram-section -->
	<!-- ==================== instag leftram-section End ==================== -->

	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.js"></script>
	<script type="text/javascript" src="js/owl.carousel.min.js"></script>

	<!-- my custom js -->
	<script type="text/javascript" src="js/custom.js"></script>

	<script type="text/javascript">
		
	</script>
</body>
</html>