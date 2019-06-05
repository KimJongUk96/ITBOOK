<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>희망의 책 모임게시판</title>
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
	<!-- =======================
	Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">모임게시판</h1>
					<h6 class="subtitle">함께 만드는 아름다운 소통과 교류의 장</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active">
							<a href="index.html"><i class="ti-home"></i> Home</a></li>
							<li class="breadcrumb-item">Table</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->
	<section class="portfolio pb-0">
		<div class="container">
			<div class="row">

				<div class="col-sm-12  p-0">
				<div class="nav justify-content-center">
						<ul class="nav-tabs nav-tabs-style-2 text-center px-2 p-md-0 m-0 mb-4">
							<li class="nav-filter active" data-filter="*">All Works</li>
							<li class="nav-filter" data-filter=".공지">공지</li>
							<li class="nav-filter" data-filter=".일반">일반</li>
							<li class="nav-filter" data-filter=".행사 및 세미나">행사 및 세미나</li>
							<li class="nav-filter" data-filter=".자료">자료</li>
							
						</ul>
					</div>

					<!-- 검색 폼 스타트 -->
					<div id="searchForm">
						<form name="frm" action="/meeting?command=metBoardListFormAction" method="post" onsubmit="return validateGalBoard()">
							<select name="opt">
								<option value="0">제목</option>
							</select> <input type="text" size="20" name="condition" />&nbsp; 
									<input type="submit" value="검색" />
						</form>
					</div>
					<!-- 검색 폼 마지막 -->

					<div class="table-responsive-sm">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">분류</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
									<th scope="col">조회수</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="metbrd" items="${metboardList}">
									<tr>
										<th scope="row">${metbrd.metBrdNum}</th>
										<th>${metbrd.metBrdCategory}</th>
										<td><a href="/meeting?command=metBoardViewAction&metBrdNum=${metbrd.metBrdNum}">${metbrd.metBrdName }</a></td>
										<td>관리자</td>
										<td><fmt:formatDate value="${metbrd.metBrdDate }" /></td>
										<td>${metbrd.metBrdCount }</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						<%-- <c:if test = ${LoginUser.authority eq '1' or LoginUser.authority eq '2' or LoginUser.authority eq '3'}> --%>
						<div align="right">
							<a class="btn btn-primary" href="/meeting?command=metBoardWriteFormAction">글쓰기</a>
						</div>
						<%-- </c:if> --%>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- 페이징 처리 스타트-->
	<section class="pt-0">
		<div class="container">
			<div class="row justify-content-center">
				<div id="pageForm" class="col-md-8">
					<nav>
						<ul class="pagination justify-content-center">

							<c:if test="${startPage != 1}">
								<li class="page-item">
								<a class="page-link" href="/meeting?command=metBoardListFormAction&page=${startPage-1}">Prev</a></li>
							</c:if>

							<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
								<c:if test="${pageNum == spage}">
									<li class="page-item active"><span class="page-link bg-grad">${pageNum}&nbsp;</span></li>
								</c:if>
								<c:if test="${pageNum != spage}">
									<a class="page-link" href='/meeting?command=metBoardListFormAction&page=${pageNum}'>${pageNum}&nbsp;</a>
								</c:if>
							</c:forEach>

							<c:if test="${endPage != maxPage }">
								<li class="page-item"><a class="page-link" href="/meeting?command=metBoardListFormAction&page=${endPage+1 }">Next</a></li>
							</c:if>

						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- 페이징 처리 마지막 -->



	<%@ include file="../include/footer.jsp"%>
</body>
</html>