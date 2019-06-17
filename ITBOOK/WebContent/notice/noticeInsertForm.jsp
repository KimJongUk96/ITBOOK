<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>희망의 책 공지사항</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Webestica.com">
	<meta name="description" content="Creative Multipurpose Bootstrap Template">

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
	
	<script type="text/javascript" src ="/js/notice.js"></script>
</head>
	<body>
		<header>
			<%@ include file="../include/header.jsp"%>
		</header>
	
	<!-- =======================
	Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">희망의 책 공지사항</h1>
					<h6 class="subtitle">We transform your perception into an
						excellent website</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="index.html"><i
									class="ti-home"></i> Home</a></li>
							<li class="breadcrumb-item">Table</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->
	
	<!-- =======================
	공지사항 글쓰기 폼 시작 -->
	<section>
		<div class="container">
			<form name="frm" action="/notice?command=noticeInsertAction" method="post" onsubmit="return validateGalBoard()" enctype="multipart/form-data">
				<input type="hidden" name="memNum" value="${list.memNum}">
		
							<div class="row mt-5">
								<div class="col-md-12">
									<h2 class="mb-2">글쓰기</h2>
								</div>
								<div class="col-md-2">
								<select class="custom-select select-big mb-3" name="noticeCategory">
									<option value="공지">공지</option>
									<option value="일반">일반</option>
									<option value="행사 및 세미나">행사 및 세미나</option>
									<option value="자료">자료</option>
								</select>
								</div>
								<div class="col-md-7"><span class="form-group"><input type="text" class="form-control" placeholder="제목" name="noticeTitle"></span></div>
								<!-- <div class="col-md-6"><span class="form-group"><input type="email" class="form-control" placeholder="E-mail"></span></div> -->
								
								<div class="col-md-3">
									<div class="form-group">
										<input type="file" name="noticeFile" class="form-control-file" id="exampleFormControlFile1">
									</div>
								</div>
								
								<div class="col-md-12" style="min-height:480px;"><span class="form-group"><textarea cols="40" rows="20"  name="noticeContent"
								class="form-control" placeholder="Message"></textarea></span></div>
								
							</div>
								<div align="right">
									<input type="submit" value="등록" class="btn btn-primary" onclick="return noticeCheck()"/>
									<input type="button" value="취소 " class="btn btn-primary" onclick="location.href='/notice?command=noticeListFormAction'"/>
								</div>
			   </form>
		</div>
	</section>
	<!-- =======================
	공지사항 글쓰기 폼 끝 -->
	
	<%@ include file="../include/footer.jsp"%>
	</body>
</html>