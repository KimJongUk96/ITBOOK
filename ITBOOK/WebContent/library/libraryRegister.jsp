<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

	<header>
		<%@ include file="../include/header.jsp"%>
	</header>



	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">도서관 등록</h1>
					<h6 class="subtitle">희망의 책 대전본부</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="index.html"><i
									class="ti-home"></i>Main</a></li>
							<li class="breadcrumb-item">도서관 등록</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
   Banner innerpage -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<form name="frm" method="post" action="library?command=libraryReg">
						<input type="hidden" name="command" value="libraryRegister">
						<%-- <input type ="hidden" name = "memNum" value = "${LoginUser.memNum}"> --%>
						<div class="form-group">
							<label>제목</label> <input class="form-control" type="text"
								name="libraryTitle" placeholder="* 도서관 명을 입력하세요.">
						</div>

						<div class="form-group">
							<label>URL</label> <input class="form-control" type="text"
								name="libraryUrl" placeholder="URL을 입력하세요.">
						</div>

						<div class="form-group">
							<label>도서관 위치</label> <input class="form-control" type="text"
								name="libraryContent" placeholder="위치를 입력하세요.">
						</div>

						<button type="submit" class="btn btn-success">
							<i class="fa fa-check-circle-o"></i>등록하기
						</button>
						<button type="button" class="btn btn-warning"
							onclick="location.href='library?command=libraryList'">
							<i class="fa  fa-close"></i>취소하기
						</button>
					</form>
				</div>

			</div>

		</div>
	</section>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>