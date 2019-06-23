<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript" src="js/logout.js"></script>
<!doctype html>
<html>
<head>


</head>

<body>
	<!-- =======================
   header Start-->
	<header class="header-static navbar-sticky navbar-light">
		<!-- Search -->
		<div class="top-search collapse bg-light" id="search-open"
			data-parent="#search">
			<div class="container">
				<div class="row position-relative">
					<div class="col-md-8 mx-auto py-5">
						<form>
							<div class="input-group">
								<input class="form-control border-radius-right-0 border-right-0"
									type="text" name="search" autofocus
									placeholder="What are you looking for?">
								<button type="button"
									class="btn btn-grad border-radius-left-0 mb-0">Search</button>
							</div>
						</form>
						<p class="small mt-2 mb-0">
							<strong>e.g.</strong>희망의 책 대전본부 홈페이지
						</p>
					</div>
					<a class="position-absolute top-0 right-0 mt-3 mr-3"
						data-toggle="collapse" href="#search-open"><i
						class="fa fa-window-close"></i></a>
				</div>
			</div>
		</div>
		<!-- End Search -->

		<!-- Navbar top start-->
		<div class="navbar-top d-none d-lg-block">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<!-- navbar top Left-->
					<div class="d-flex align-items-center">
					
						<!-- Top info -->
						<ul class="nav list-unstyled ml-3">
							<li class="nav-item mr-3"><a class="navbar-link" href="#"><strong>전화:</strong>
									(042) 252-9540</a></li>
							<li class="nav-item mr-3"><a class="navbar-link" href="#"><strong>이메일:</strong>
									djbook21@hanmail.net</a></li>
						</ul>
					</div>

					<!-- navbar top Right-->
					<div class="d-flex align-items-center" id="navbar">
						<c:if
							test="${LoginUser.authority eq 1 or LoginUser.authority eq 2 or LoginUser.authority eq 3}">
							<span class="loginfo"> <span class="dept_of_top"></span> <b>${LoginUser.memName}</b>님
								반갑습니다.
							</span>
						</c:if>
						<!-- Top Account -->
						<div class="dropdown">
							<c:if
								test="${LoginUser.authority eq 1 or LoginUser.authority eq 2}">
								<a class="dropdown-toggle" href="" role="button"
									id="dropdownAccount" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"><i
									class="ti-user mr-2"></i>내정보 </a>
								<div class="dropdown-menu mt-2 shadow"
									aria-labelledby="dropdownAccount">
									<a class="dropdown-item" href="member/myPage.jsp">내 정보</a>
								</div>
							</c:if>

							<c:if test="${LoginUser.authority eq 3}">
								<a class="dropdown-toggle" href="#" role="button"
									id="dropdownAccount" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"><i
									class="ti-user mr-2"></i>내정보 </a>
								<div class="dropdown-menu mt-2 shadow"
									aria-labelledby="dropdownAccount">
									<a class="dropdown-item" href="member/myPage.jsp">내 정보</a> <a
										class="dropdown-item" onclick="logout();">로그아웃</a>
								</div>
							</c:if>
						</div>

						<div class="dropdown">
							<c:if test="${LoginUser.authority eq null}">
								<a class="nav-link" href="login.jsp">로그인</a>
							</c:if>
						</div>

						<!-- top link -->
						<ul class="nav">
							<li class="nav-item"><c:if
									test="${LoginUser.authority eq '1' or LoginUser.authority eq '2'}">
									<a class="nav-link" onclick="logout();">로그아웃</a>
								</c:if> <c:if test="${LoginUser.authority eq 3}">
									<a class="nav-link" href="admin?command=memberListForm">관리자
										화면</a>
								</c:if></li>
						</ul>
						<!-- top social -->
						<ul class="social-icons">
							<li class="social-icons-item social-facebook m-0"><a
								class="social-icons-link w-auto px-2"
								href="https://www.facebook.com/pages/category/Nonprofit-Organization/%ED%9D%AC%EB%A7%9D%EC%9D%98-%EC%B1%85-%EB%8C%80%EC%A0%84%EB%B3%B8%EB%B6%80-1913139302044535/"><i
									class="fa fa-facebook"></i></a></li>
						
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Navbar top End-->

		<!-- Logo Nav Start -->
		<nav class="navbar navbar-expand-lg">
			<div class="container">
				<!-- Logo -->
				<a class="navbar-brand" href="main?command=loginForm"> <!-- SVG Logo Start -->
				 <img src="https://i.ibb.co/9473b6T/image.jpg"
					width="170" height="150" alt="희망의 책 로고" /> <!-- SVG Logo End -->
				</a>
				<!-- Menu opener button -->
				<button class="navbar-toggler ml-auto" type="button"
					data-toggle="collapse" data-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"> </span>
				</button>
				<!-- Main Menu Start -->
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav ml-auto">
						<!-- Menu item 1 Pages-->
						<li class="nav-item dropdown"><a class="nav-link"
							href="/notice?command=introAction" id="pagesMenu"
							aria-haspopup="true" aria-expanded="false">희망의 책 알아보기</a> <!-- <ul class="dropdown-menu" aria-labelledby="pagesMenu"> -->
							

						<!-- Menu item 4 Portfolio-->

						<li class="nav-item dropdown">
							<!-- 관리자로 로그인을 했을 시 이달의 책 등록--> <c:if
								test="${LoginUser.authority eq 3}">
								<li><a class="nav-link"
									href="/book?command=adminTodayBookList" id="portfolioMenu"
									aria-haspopup="true" aria-expanded="false">이달의 책</a></li>
							</c:if> <!-- 사용자로 로그인을 했을 시 이달의 책 등록--> <c:if
								test="${LoginUser.authority ne 3}">
								<li><a class="nav-link" href="/book?command=todayBookList"
									id="portfolioMenu" aria-haspopup="true" aria-expanded="false">이달의
										책</a></li>
							</c:if> 
						</li>

						<!-- Menu item 3 Pages-->
						<li class="nav-item dropdown"><a class="nav-link"
							href="/meeting?command=meetingList" id="pagesMenu"
							aria-haspopup="true" aria-expanded="false">독서모임</a> <!-- <ul class="dropdown-menu" aria-labelledby="pagesMenu"> -->
							</li>

						<!-- Menu item 2 Blog-->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="blogMenu"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">독서
								생태계</a>
							<ul class="dropdown-menu" aria-labelledby="blogMenu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=noticeListFormAction">운영게시판</a> </li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/report?command=Report_List">독후감</a><li class="dropdown-submenu"><a
									class="dropdown-item dropdown-toggle" href="#">우리지역 책방</a>
									<ul class="dropdown-menu">

										<c:if test="${LoginUser.authority eq 3}">
											<li><a class="dropdown-item"
												href="/library?command=adminLibraryList">대전 도서관</a></li>
										</c:if>
										<c:if test="${LoginUser.authority ne 3}">
											<li><a class="dropdown-item"
												href="/library?command=libraryList">대전 도서관</a></li>
										</c:if>

										<!-- 관리자로 로그인을 했을 시 이달의 책 등록-->
										<c:if test="${LoginUser.authority eq 3}">
											<li><a class="dropdown-item"
												href="/bookstore?command=adminBookstoreList">대전 책방</a></li>
										</c:if>

										<!-- 사용자로 로그인을 했을 시 이달의 책 등록-->
										<c:if test="${LoginUser.authority ne 3}">
											<li><a class="dropdown-item"
												href="/bookstore?command=bookstoreList">대전 책방</a></li>
										</c:if>
									</ul></li>
							</ul></li>
						<!-- Menu item 5 Blog-->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="blogMenu"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">후원하기</a>
							<ul class="dropdown-menu" aria-labelledby="blogMenu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=introBusinessFormAction">사업소개</a> </li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=donationListFormAction">개인후원</a> </li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="#">법인후원</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="#">연말정산 영수증 신청</a></li>
							</ul></li>

						
					</ul>
				</div>
				<!-- Main Menu End -->
				<!-- Header Extras Start-->
				<div class="navbar-nav">
					<!-- extra item Search-->
					<div class="nav-item search border-0 pl-3 pr-0 px-lg-2" id="search">
						<a class="nav-link" data-toggle="collapse" href="#search-open"><i
							class="ti-search"> </i></a>
					</div>
					
				</div>
				<!-- Header Extras End-->
			</div>
		</nav>
		<!-- Logo Nav End -->
	</header>
	<!-- =======================
   header End-->
</body>
</html>