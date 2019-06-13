<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!Doctype html>

<!-- 각 독서모임 별 메인홈 -->
<!-- portfolio-single.html Form -->
<html lang="en">
<head>
	<title>독서모임 게시판</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Webestica.com">
	<meta name="description" content="Creative Multipurpose Bootstrap Template">

	<!-- Favicon -->
	<link rel="shortcut icon" href="../assets/images/favicon.ico">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700" rel="stylesheet">

	<!-- Plugins CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/themify-icons/css/themify-icons.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/animate/animate.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/fancybox/css/jquery.fancybox.min.css" />

	<!-- Theme CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />

</head>

<body>
<!-- header 삽입 -->
  <header>
     <%@ include file="../include/header.jsp"%>
  </header>
	<div class="preloader">
		<img src="../assets/images/preloader.svg" alt="Pre-loader">
	</div>


	<!-- =======================
	Banner innerpage -->

	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingList.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/index.jsp"><i class="ti-home"></i> Home</a></li>
							<li class="breadcrumb-item">독서모임</li>
						</ol>
					</nav>
				</div>	
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->

	<!-- =======================
	portfolio -->
	<section>
		<div class="container">
			<div class="row mb-4">
				<!-- portfolio images -->
				
				<!-- <div class="col-md-8">
					<a class="mb-4 d-block" href="../assets/images/portfolio/big/01.jpg" data-fancybox="portfolio" data-caption="Perfect planning"><img src="../assets/images/portfolio/big/01.jpg" alt=""></a>
					<a class="mb-4 d-block" href="../assets/images/portfolio/big/02.jpg" data-fancybox="portfolio" data-caption="Kitchen design"><img src="../assets/images/portfolio/big/02.jpg" alt=""></a>
				</div> -->
				<!-- portfolio details -->
				<section>
				<div class="row mt-5">
				<div class="col-md-4">
					<div class="sticky-element">
						<h2>${meetingList.metName}</h2>
						<p>${meetingList.metIntro}</p>
						<ul class="list-unstyled">
							<li class="media mt-2">
								<div class="d-flex w-40">
									<h6>대표자:</h6> </div>
								<div class="media-body"> <span>${meetingList.represent}</span> </div>
							</li>
							<li class="media mt-2">
								<div class="d-flex w-40">
									<h6>개설일자:</h6> </div>
								<div class="media-body">
									<span><fmt:formatDate value="${meetingList.metName}"/></span>
								</div>
							</li>

							<li class="media mt-2">
								<div class="d-flex w-40">
									<h6>모임인원수:</h6> </div>
								<div class="media-body">
									<span>${meetingList.headCount}명</span>
								</div>
							</li>
							
						</ul>
						<a class="btn btn-grad mt-4" href="/meeting?command=metUpdate"><%-- ${meeting.metName} --%>독서모임 수정<i class="fa fa-external-link ml-2 mr-0"></i></a>
						<a class="btn btn-grad mt-4" href="/meeting?command=metBoardListFormAction"><%-- ${meeting.metName} --%>독서모임명 게시판<i class="fa fa-external-link ml-2 mr-0"></i></a>
					</div>
				</div>
				<!-- portfolio details End -->
			</div>
			</section>
			<section>
				<div class="table-responsive-sm">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">분류</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">날짜</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="metbrd" items="${metboardList}">
									<tr>
										<th scope="row">${metbrd.metBrdNum}</th>
										<th>${metbrd.metBrdCategory}</th>
										<td><a href="/meeting?command=metBoardViewAction&metBrdNum=${metbrd.metBrdNum}">${metbrd.metBrdName}</a></td>
										<td>모임관리자</td>
										<td><fmt:formatDate value="${metbrd.metBrdDate}" /></td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
			</section>
			</div>
			
			<!-- 활동사진 밑 코멘트 -->
			<div class="row mt-4">
				<!-- portfolio Greeting -->
				<div class="col-md-6">
					<h4 class="mb-4">${meetingList.metName}의 인사말</h4>
					<blockquote class="blockquote" cite="#">
						<h5 class="mb-2 text-light-gray">${meetingList.metGreeting}</h5>
						<cite>- ${meetingList.represent}</cite>
					</blockquote>
				</div>
				<!-- portfolio information -->
				<!-- <div class="col-md-6">
					<h4 class="mb-4">Additional information</h4>
					<p>Residence certainly elsewhere something she preferred cordially law. Age his surprise formerly Mrs perceive few standstill moderate. Of in power match on truth worse voice would. Large an it sense shall an match learn. By expect it result silent in formal of. Ask eat questions abilities described elsewhere assurance.</p>
					<p> Appetite in unlocked advanced breeding position concerns as. Cheerful get shutters yet for repeated screened. An no am cause hopes at three. Prevent behaved fertile he is mistake on. </p>
				</div> -->
			</div>

			<div class="row">
				<div class="col-md-12">
					<!-- tag and share -->
					<div class="divider mb-4"></div>
					
					<!-- tag check-box 불러오기 -->
					<div class="row">
					<c:forEach var="meetingList" items="${meetingList}" varStatus="status">
						<div class="tags col-12 col-sm-8 col-md-12 text-center text-sm-center">
							<a class="mb-2 mb-sm-0" href="#">${meetingList.keyword}</a>
							<!-- <a class="mb-2 mb-sm-0" href="#">events</a>
							<a class="mb-2 mb-sm-0" href="#">WordPress</a>
							<a class="mb-2 mb-sm-0" href="#">gadgets</a>
							<a class="mb-2 mb-sm-0" href="#">office</a> -->
						</div>
					</c:forEach>
						<div class="col-12 col-sm-4 text-center text-sm-right">
							<ul class="social-icons si-colored-bg light">
								<li class="social-icons-item social-facebook mb-0"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
								<li class="social-icons-item social-twitter mb-0"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
								<li class="social-icons-item social-gplus mb-0"><a class="social-icons-link" href="#"><i class="fa fa-google-plus"></i></a></li>
								<li class="social-icons-item social-linkedin mb-0"><a class="social-icons-link" href="#"><i class="fa fa-linkedin"></i></a></li>
							</ul>
						</div>
					</div>
					<div class="divider mt-4"></div>

					<!-- navigation -->
					<div class="row post-navigation mt-5">
						<!-- <div class="col-5">
							<a href="#" class="post-prev">
								<p class="m-2 m-lg-0">Previous Post</p>
								<h6 class="text-truncate d-none d-lg-block">The Pink Chair</h6> </a>
						</div> -->
						<!-- <div class="col-12">
							<a href="portfolio-grid-column-3.html" class="all-post" title="View all post"> <i class="fa fa-th"> 더보기</i> </a>
						</div> -->
						<!-- <div class="col-5">
							<a href="#" class="post-next">
								<p class="m-2 m-lg-0">Next Post</p>
								<h6 class="text-truncate d-none d-lg-block">Black & white</h6> </a>
						</div> -->
					</div>

				</div>
			</div>
		</div>
		<!-- portfolio End -->
	</section>
	
	<!-- =======================
	portfolio -->


	<!-- =======================
	footer  -->
	<%@ include file="../include/footer.jsp"%>
	<!-- =======================
	footer  -->

	<div> <a href="#" class="back-top btn btn-grad"><i class="ti-angle-up"></i></a> </div>

	<!--Global JS-->
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/popper.js/umd/popper.min.js"></script>
	<script src="../assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!--Vendors-->
	<script src="../assets/vendor/sticky-kit/sticky-kit.min.js"></script>
	<script src="../assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>

	<!--Template Functions-->
	<script src="../assets/js/functions.js"></script>

</body>
</html>