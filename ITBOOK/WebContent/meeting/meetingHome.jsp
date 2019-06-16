<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />

		<style type="text/css">
			table{
			align:center;
			}
		</style>

		<script type="text/javascript">
			function joinPopup() {

			var popUrl = "/meeting?command=joinMemberPopup&metNum=${meetingVo.metNum}";
			var popOption = "width=650px, height=550px, resizable=no, location=no, top=300px, left=300px;"

			window.open(popUrl, "모임 가입신청 ", popOption);
			}
		</script>

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

	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/index.jsp"><i
									class="ti-home"></i>Home</a></li>
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
	<div class="container">
		<div class="row mb-4">

			<input type="hidden" name="metNum" value="${meetingVo.metNum}">
			<input type="hidden" name="metbrd" value="${metbrd.metBrdNum}">

		<div class="row mt-5">
			<div class="col-md-12">
				<!-- <div class="sticky-element is_stuck" style="top: 100px; width:369.96px; position: fixed;"> -->
					<ul class="list-unstyled">
						<li class="media mt-2">
							<div class="d-flex w-40">
								<h6>대표자:</h6>
							</div>
							<div class="media-body">
								<span> ${meetingVo.represent}</span>
							</div>
						</li>
						<li class="media mt-2">
							<div class="d-flex w-40">
								<h6>개설일자:</h6>
							</div>
							<div class="media-body">
								<span> ${meetingVo.metDate}</span>
							</div>
						</li>
						<li class="media mt-2">
							<div class="d-flex w-40">
								<h6>모임인원수:</h6>
							</div>
							<div class="media-body">
								<span> ${meetingVo.headCount}명</span>
							</div>
						</li>
					</ul>
				</div>
			<%-- <h5>대표자 : ${meetingVo.represent}</h5>
			<h5>개설일자 : ${meetingVo.metName}</h5>
			<h5>모임인원수 : ${meetingVo.headCount}명</h5> --%>
				<table>
					<%-- <tr>
						<td>대표자 : ${meetingVo.represent}</td>
						<td>개설일자 :  ${meetingVo.metDate}</td>
						<td>모임인원수 : ${meetingVo.headCount}명</td>
					</tr> --%>

					<tr>
						<td>
							<a class="btn btn-grad mt-4" onclick="joinPopup()">
								모임 가입하기
							<i class="fa fa-external-link ml-2 mr-0"></i></a>
						</td>
						<td>
							<a class="btn btn-grad mt-4" href="/meeting?command=metUpdate">
								<%-- ${meeting.metName} --%>독서모임 수정
							<i class="fa fa-external-link ml-2 mr-0"></i></a>
						</td>
					</tr>
				</table>
				<div class="divider mt-4"></div>

				<!-- portfolio details End -->
				</div>
		</div>
		
		<%-- <!-- sidebar start -->
		<div class="container">
		<div class="row">
		<aside class="col-md-3 sidebar order-last">
			<!-- Update button -->
			<div class="widget">
				<h5 class="widget-title">독서모임 도구모음</h5>
				<ul class="list-unstyled">
					<li class="media mt-2">
					<a class="btn btn-grad mt-4" href="/meeting?command=metUpdate">
								${meeting.metName}독서모임 수정
							<i class="fa fa-external-link ml-2 mr-0"></i></a>
					</li>
				</ul>
			</div>
			<div class="widget">
				<h5 class="widget-title">Keywords</h5>
				<div class="tags">
					<a class="mb-2 mb-sm-0">${meetingVo.keyword}</a>
				</div>
			</div>
		
		</aside>
		</div> --%>

			<div class="table-responsive-sm">
				<table class="table table-hover">
				<!-- 공지사항 링크연결 -->
				<div>
					<span style="font-size: 25px;">공지사항  </span>
					<span style="font-size: 15px;"><a href="/meeting?command=metBoardListFormAction&metNum=${meetingVo.metNum}">게시글 더보기
						<i class="fa fa-external-link ml-2 mr-0"></i></a></span>
				</div>
						
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
							<c:if test="${empty metboardList}">
								<tr>
									<th colspan="5" style="text-align: center; color: gray;">게시글이 없습니다.</th>
								</tr>
							</c:if>
						<c:forEach var="metbrd" items="${metboardList}" varStatus="var">
							
							<c:if test="${not empty metboardList }">
							<tr>
								<th scope="row">${var.count}</th>
								<th>${metbrd.metBrdCategory}</th>
								<td><a
									href="/meeting?command=metBoardViewAction&metBrdNum=${metbrd.metBrdNum}">${metbrd.metBrdName}</a></td>
								<!-- <td>모임관리자</td> -->
								<th></th>
								<td><fmt:formatDate value="${metbrd.metBrdDate}" /></td>
							</tr>
							</c:if>
						</c:forEach>
					</tbody>

				</table>
			</div>

		<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th colspan="3" style="text-align: center;">멤버쉽 신청내역</th>
				</tr>
				<tr>
					<th style="width: 50px; text-align: center;">신청자</th>
					<th style="width: 50px; text-align: center;">이름</th>
					<th style="width: 50px; text-align: center;">승인여부</th>
				</tr>
			</thead>
				<c:if test="${empty memList}">
					<tr>
						<th colspan="3" style="text-align: center; color: gray;">가입신청한 멤버가 없습니다.</th>
					</tr>
				</c:if>
			<c:forEach var="memList" items="${memList}">
				<c:if test="${memList.approval eq 'F' && memList.metNum eq meetingVo.metNum}">
					<input type="hidden" name="memNum" value="${memList.memNum}">
					<tr style="text-align: center;">
						<td>${memList.memId}</td>
						<td>${memList.memName}</td>
						<td>
							<a href="/member?command=approvalMeeting&memNum=${memList.memNum}&metNum=${meetingVo.metNum}">
							<button type="button" class="btn btn-primary btn-sm">승인</button></a>&nbsp;&nbsp;
							<a href="/member?command=refuseMemberShip&memNum=${memList.memNum}&metNum=${meetingVo.metNum}">
							<button type="button" class="btn btn-danger btn-sm">거절</button></a></td>
					</tr>
				</c:if>
			</c:forEach>
			</table>
		</div>

		<!-- 활동사진 밑 코멘트 -->
		<div class="row mt-4">
			<!-- portfolio Greeting -->
			<div class="col-md-6">
				<h4 class="mb-4">${meetingVo.metName}의 인사말</h4>
				<blockquote class="blockquote" cite="#">
					<h5 class="mb-2 text-light-gray">${meetingVo.metGreeting}</h5>
					<cite>- ${meetingVo.represent}</cite>
				</blockquote>
			</div>
		<!-- 독서모임 소개 -->
		<div class="col-md-6">
			<h4 class="mb-4">우리 독서모임은</h4>
			<h5 class="mb-2 text-light-gray">${meetingVo.metIntro}</h5>
		</div>
		</div>
	</div>

		<div class="row">
			<div class="col-md-12">
				<!-- tag and share -->
				<div class="divider mb-4"></div>

				<%-- <!-- tag check-box 불러오기 -->
				<div class="row">
					<div class="tags col-12 col-sm-8 text-center text-sm-left">
					<a class="mb-2 mb-sm-0">${meetingVo.keyword}</a>
					</div>
				</div> --%>
				
				<!-- <div class="divider mt-12"></div> -->
				<!-- navigation -->
				<div class="row post-navigation mt-5"></div>
			</div>
		</div>
	
		<!-- <script type="text/javascript">
			function joinPopup() {

			var popUrl = "/meeting?command=joinMemberPopup&metNum=${meetingVo.metNum}";
			var popOption = "width=650px, height=550px, resizable=no, location=no, top=300px, left=300px;"

			window.open(popUrl, "모임 가입신청 ", popOption);
			}
		</script> -->

	<%@ include file="../include/footer.jsp"%>

</body>
</html>