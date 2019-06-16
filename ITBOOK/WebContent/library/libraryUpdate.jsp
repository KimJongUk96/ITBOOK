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
					<h1 class="innerpage-title">우리동네 도서관</h1>
					<h6 class="subtitle">희망의 책 대전본부</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="index.html"><i
									class="ti-home"></i>Main</a></li>
							<li class="breadcrumb-item">도서관 수정</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<!-- 책 수정 폼 -->
					<form name="frm" method="post"
						action="library?command=libraryUpdate&libraryNum=${libraryList.libraryNum}">
						<input type="hidden" name="libraryNum" value="${libraryList.libraryNum}">
						
						<div class="form-group">
							<label>도서관 명</label> <input class="form-control" type="text"
								name="libraryTitle" value="${libraryList.libraryTitle}"
								placeholder="* 제목을 입력하세요.">
						</div>
					
						<div class="form-group">
							<label>URL</label> <input class="form-control" type="text"
								name="libraryUrl" value="${libraryList.libraryUrl}"
								placeholder="URL을 입력하세요.">
						</div>

						<div class="form-group">
							<label>도서관 위치</label> <input class="form-control" type="text"
								name="libraryContent"
								value="${libraryList.libraryContent}"
								placeholder="책방주소를 입력하세요.">
						</div>

						<button type="submit" class="btn btn-grad border-radius-left-0 mb-0">수정하기</button>
						
						<button type="button" class="btn btn-grad border-radius-left-0 mb-0"
							onclick="location.href='library?command=libraryDelete&libraryNum=${libraryList.libraryNum}'">
							삭제하기
						</button>
						<button type="button" class="btn btn-grad border-radius-left-0 mb-0"
							onclick="location.href='library?command=adminLibraryList'">
							목록보기
						</button>
					</form>
				</div>



			</div>

		</div>

	</section>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>