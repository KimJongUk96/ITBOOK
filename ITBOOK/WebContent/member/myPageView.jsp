<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Wizixo | Creative Multipurpose Bootstrap Template</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Webestica.com">
<meta name="description"
   content="Creative Multipurpose Bootstrap Template">

<!-- Favicon -->
<link rel="shortcut icon" href="../assets/images/favicon.ico">

<!-- Google Font -->
<link
   href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700"
   rel="stylesheet">

<!-- Plugins CSS -->
<link rel="stylesheet" type="text/css"
   href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
   href="../assets/vendor/themify-icons/css/themify-icons.css" />
<link rel="stylesheet" type="text/css"
   href="../assets/vendor/animate/animate.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />

</head>
<body>
   <!--    <div class="preloader">
      <img src="../assets/images/preloader.svg" alt="Pre-loader">
   </div>  -->
   <header>
      <%@ include file="../include/header.jsp"%>
   </header>

	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">My page</h1>
					<h6 class="subtitle">We transform your perception into an excellent website</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="index.jsp"><i class="ti-home"></i> Home</a></li>
							<li class="breadcrumb-item">My page</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->


	<!-- =======================
	Table -->
	<section>
		<div class="container">
<form name = "frm" method = "post" action = "memeber?command=memberModify">
<input type ="hidden" name = "memId" value = "${LoginUser.memId}">
			<div class="row">
				<div class="col-sm-12 mb-5">
					<h5 class="text-center mb-4">My page</h5>
					<div class="table-responsive-sm">
							<c:if test ="${LoginUser.authority eq 1 or LoginUser.authority eq 2 or LoginUser.authority eq 3}">
						<table class="table table-lg table-noborder table-striped">
							<thead class="all-text-white bg-grad">
								  
								<tr>
									
									<th scope="col"></th>
									<th scope="col"></th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row"></th>
									<td>아이디</td>
									<td>${LoginUser.memId}</td>
									
								</tr>
								<tr>
									<th scope="row"></th>
									<td>이름</td>
									<td>${LoginUser.memName}</td>
									
								</tr>
								
								<tr>
									<th scope="row"></th>
									<td>생년월일</td>
									<td>${LoginUser.jumin}</td>
									
								</tr>
								<tr>
									<th scope="row"></th>
									<td>주소</td>
									<td><input type ="text" name ="adr" value = "${LoginUser.adr}"></td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td>핸드폰 번호</td>
									<td><input type ="text" name ="phone" value = "${LoginUser.phone}"></td>
								</tr>
							</tbody>
						</table>
						</c:if>
						<div class="col-6 text-right"><button type = "submit" class="btn btn-dark ">수정하기</button></div>
									</div>
					</div>
				</div>

					</form>

			</div>
	</section>
	<!-- =======================
	Table -->

	<!-- =======================
	footer  -->
	<footer>
	<%@ include file="../include/footer.jsp" %>
	</footer>
	<!-- =======================
	footer  -->

	<div> <a href="#" class="back-top btn btn-grad"><i class="ti-angle-up"></i></a> </div>

	<!--Global JS-->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/popper.js/umd/popper.min.js"></script>
	<script src="assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!--Template Functions-->
	<script src="assets/js/functions.js"></script>

</body>
</html>
