<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>희망의책 대전본부</title>
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
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/fancybox/css/jquery.fancybox.min.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/owlcarousel/css/owl.carousel.min.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/swiper/css/swiper.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />

</head>

<body>
	<div class="preloader">
		<img src="../assets/images/preloader.svg" alt="Pre-loader">
	</div>

	<!-- =======================
	header Start-->
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	<!-- =======================
	header End-->

	<!-- =======================
	Main Banner -->
	<section class="p-0">
		<div
			class="swiper-container height-700-responsive swiper-arrow-hover swiper-slider-fade">
			<div class="swiper-wrapper">
				<!-- slide 1-->
				<div class="swiper-slide bg-overlay-dark-2"
					style="background-image: url(https://i.ibb.co/qJR1sJv/book.jpg); background-position: center center; background-size: cover;">
					<div class="container h-100">
						<div class="row d-flex h-100">
							<div
								class="col-lg-8 col-xl-6 mr-auto slider-content justify-content-center align-self-center align-items-start text-left">
								<h2
									class="animated fadeInUp dealy-500 display-6 display-md-4 display-lg-3 font-weight-bold text-white"
									style="width: 700px">희망의 책 대전본부</h2>
								<h3
									class="animated fadeInUp dealy-1000 text-white display-8 display-md-7 alt-font font-italic mb-2 my-md-4"
									style="width: 600px">책으로 행복한 대전, 희망의 책</h3>
							</div>
						</div>
					</div>
				</div>
				<!-- slide 2-->
				<!-- <div class="swiper-slide bg-overlay-dark-2" style="background-image:url(assets/images/banner/02.jpg); background-position: center top; background-size: cover;">
					<div class="container h-100">
						<div class="row d-flex h-100">
							<div class="col-md-8 justify-content-center align-self-center align-items-start mx-auto">
								<div class="slider-content text-center ">
									<h3 class="animated fadeInUp dealy-500 display-8 display-md-7 text-white alt-font font-italic">Build a very unique and professional website</h3>
									<h2 class="animated fadeInUp dealy-1000 display-6 display-md-4 display-lg-3 font-weight-bold text-white">Weâre good. Just ask our moms.</h2>
									<div class="animated fadeInUp mt-3 dealy-1500"><a href="#" class="btn btn-grad">Contact us</a></div>
								</div>
							</div>
						</div>
					</div>
				</div> -->
			</div>
			<!-- Slider buttons -->
			<div class="swiper-button-next">
				<i class="ti-angle-right"></i>
			</div>
			<div class="swiper-button-prev">
				<i class="ti-angle-left"></i>
			</div>
			<div class="swiper-pagination"></div>
		</div>
	</section>
	<!-- =======================
	Main banner -->


	<!-- =======================
	service -->
	<section class="blog pb-0">
		<div class="container">
			<div class="row">
				<div class="col-12 col-lg-8 mx-auto">
					<div class="title text-center">
						<h2>독서모임</h2>

					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="owl-carousel arrow-dark arrow-hover" data-dots="false"
						data-items-xl="3" data-items-lg="3" data-items-md="2"
						data-items-sm="2" data-items-xs="1">
						<!-- post -->

						<!-- 독서모임리스트 시작 -->
				<c:forEach var="meetingMainList" items="${meetingMainList}" varStatus="status">
					
						<!-- portfolio-card -->
						<div class="portfolio-card isotope-item " >
							<div class="portfolio-card-body">
								<div class="portfolio-card-header">
								<!-- 이미지 -->
									 <div style="width:300px; height:180px; text-align:center"><a href="#"><img src="/displayFile?fileName=${meetingMainList.metImg}" alt=""></a></div>
									 
								</div>
								<div class="portfolio-card-footer">
									<a class="full-screen" href="/displayFile?fileName=${meetingMainList.metImg}" data-fancybox="portfolio" data-caption="${meetingMainList.metName}" ><i class="ti-fullscreen"></i></a>
									<div><h6 class="info-title"><b><a href="/meeting?command=meetingHome&metNum=${meetingMainList.metNum}" title="독서모임">${meetingMainList.metName}</a></b></h6></div>
								</div>
							</div>
						</div>
						</c:forEach>			
						</div>  
					</div>
				</div>
			</div>	
				
			<!-- 독서모임리스트 끝-->
	</section>
	
	<!-- =======================
	service -->
	<section class="service">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
				<div class="title text-center">
						<h2>추천도서</h2>
					</div>
					<div class="owl-carousel arrow-dark arrow-hover" data-dots="false"
						data-items-xl="3" data-items-lg="3" data-items-md="2"
						data-items-sm="2" data-items-xs="1">
						
						<c:forEach var="maintodayBookList" items="${maintodayBookList}" varStatus="status">		
						 <div class="item">
							<div class="post">
								<div class="post-info">
									<div class="post-author">
										<img src="/displayFile?fileName=${maintodayBookList.imgPath}" alt="" style="width:300px; height:400px;">
									</div>
									<div><h6 class="info-title"><b>${maintodayBookList.bookBrdTitle}</b></h6></div>
									</div>
								</div>
							</div>
						</c:forEach>
						
						</div>
						</div>
						</div>
						
			</div>
</section>
	<!-- =======================
	package -->
<section class="service">
		<div class="container">
			<div class="row">
				<div class="col-12 col-lg-8 mx-auto">
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 mt-30">
					<div class="feature-box f-style-2 icon-grad h-100">
						<div class="feature-box-icon">
							<i class="ti-agenda"></i>
						</div>
						<h3 class="feature-box-title">공지사항</h3>
						<p class="feature-box-desc">
							또 다른 소중한 만남이 있습니다. <br> <strong>운영게시판</strong>에서 만나보세요.

						</p>
						<a class="mt-3" href="/notice?command=noticeListFormAction">더보기</a>
					</div>
				</div>
				<div class="col-md-4 mt-30">
					<div class="feature-box f-style-2 icon-grad h-100">
						<div class="feature-box-icon">
							<i class="ti-agenda"></i>
						</div>
						<h3 class="feature-box-title">이달의 책</h3>
						<p class="feature-box-desc">
							이달의 <strong>추천도서</strong>를 알려드립니다. <br>가장 인기있는 도서를 확인해보세요.
						</p>
						<a class="mt-3" href="/book?command=todayBookList">더보기</a>
					</div>
				</div>
				<div class="col-md-4 mt-30">
					<div class="feature-box f-style-2 icon-grad h-100">
						<div class="feature-box-icon">
							<i class="ti-agenda"></i>
						</div>
						<h3 class="feature-box-title">독후감</h3>
						<p class="feature-box-desc">
							책은 <strong>마음의 양식</strong>입니다. <br>책에서 소중한 인연을 만나보세요.
						</p>
						<a class="mt-3" href="/report?command=Report_List">더보기</a>
					</div>
				</div>
			</div>
		</div>
	</section>	

	<!-- =======================
	footer  -->
	<footer class="footer bg-light pt-6">
		<div class="footer-content pb-3">
			<div class="container">
				<div class="row">
					<!-- Footer widget 1 -->
					<div class="col-md-4">
						<div class="widget">
							<a href="index.jsp" class="footer-logo"> <!-- footer SVG logo Start -->
								  <img src="https://i.ibb.co/5294fzR/Logo2.png"
								width="170" height="150" alt="희망의 책 로고" /> <!-- footer SVG logo End -->
							</a>
							<p class="mt-3">
								사람과의 만남이 중요하듯 또 다른 소중한 만남이 있습니다.<br> 바로 <strong>책과의
									만남</strong>입니다.
							</p>
						</div>
					</div>
					<!-- Footer widget 2 -->
					<div class="col-md-3 col-sm-6">
						<div class="widget address"
							style="background-image: url('assets/images/world-map.png'); background-position: 50% 20px; background-repeat: no-repeat; background-size: contain;">
							<ul class="list-unstyled">
								<li class="media mb-3"><i class="mr-3 display-8 ti-map-alt"></i>
									(301-010)대전광역시 중구 대흥로 109 종합문화복지관</li>
								<li class="media mb-3"><i
									class="mr-3 display-8 ti-headphone-alt"></i> (042) 252-9540</li>
								<li class="media mb-3"><i class="mr-3 display-8 ti-email"></i>
									djbook21@hanmail.net</li>
								<li class="media mb-3"><i class="mr-3 display-8 ti-time"></i>
									<p>
										Mon - Fri: <strong>09:00 - 18:00</strong> <br>Sat & Sun:
										<strong>Closed</strong>
									</p></li>
							</ul>
						</div>
					</div>
					<!-- Footer widget 3 -->
					<div class="col-md-2 col-sm-6">
						<div class="widget">
							<h6>Quick LInks</h6>
							<ul class="nav flex-column primary-hover">
								<li class="nav-item"><a class="nav-link"
									href="/notice?command=introAction">희망의책 소개</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/book?command=todayBookList">이달의책</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/meeting?command=meetingList">독서모임</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/notice?command=noticeListFormActionl">운영게시판</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/notice?command=introBusinessFormAction">후원하기</a></li>
							</ul>
						</div>
					</div>
					<!-- Footer widget 4 -->
					<div class="col-md-3">
						<div class="widget bg-grad p-4 all-text-white border-radius-3">
							<i class="ti-email newsletter-icon"></i>
							<p class="mb-2">
								여러분과 함께 만드는 <br>아름다운 소통과 교류의 장
							</p>
							<div class="form-group mb-0">
								<!-- 	<input class="form-control border-white mb-3" type="email"
									placeholder="Enter email..."> -->
								<a href="signup.jsp">
									<button class="btn btn-dark mb-0">가입하기</button>
								</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Footer widget 4 -->
			</div>
		</div>
		<div class="divider mt-3"></div>
		<!--footer copyright -->
		<div class="footer-copyright py-3">
			<div class="container">
				<div
					class="d-md-flex justify-content-between align-items-center py-3 text-center text-md-left">
					<!-- copyright text -->
					<div class="copyright-text-center">

						Â©2019 All Rights Reserved by <a href="index.jsp"> 희망의책</a>

					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- =======================
	footer  -->

	<div>
		<a href="#" class="back-top btn btn-grad"><i class="ti-angle-up"></i></a>
	</div>

	<!--Global JS-->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/popper.js/umd/popper.min.js"></script>
	<script src="assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!--Vendors-->
	<script src="assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>
	<script src="assets/vendor/owlcarousel/js/owl.carousel.min.js"></script>
	<script src="assets/vendor/swiper/js/swiper.js"></script>
	<script src="assets/vendor/wow/wow.min.js"></script>

	<!--Template Functions-->
	<script src="assets/js/functions.js"></script>

</body>
</html>