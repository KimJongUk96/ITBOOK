<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<h1 class="innerpage-title">책 수정</h1>
					<h6 class="subtitle">희망의 책 대전본부</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="index.html"><i
									class="ti-home"></i>Main</a></li>
							<li class="breadcrumb-item">책 수정</li>
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
					<form name="updateFrm" method="post"
						action="book?command=bookUpdate">

						<input type="hidden" name="bookNum" value="${bookList.bookNum}">
						<!-- <input type="hidden" name="memNum" value=1> -->
						<div class="form-group">
							<label>제목</label> <input class="form-control" type="text"
								name="bookTitle" value = "${bookList.bookTitle}" placeholder="* 제목을 입력하세요.">
						</div>
						<div class="form-group">
                  <label>키워드</label> <input class="form-control" type="text" name = "bookKeyword1" value = "${bookList.bookKeyword1}"
                     placeholder="책에 관한 키워드를 입력하세요.">
                     <input class="form-control" type="text" name = "bookKeyword2" value = "${bookList.bookKeyword2}"
                     placeholder="책에 관한 키워드를 입력하세요.">
                     <input class="form-control" type="text" name = "bookKeyword3" value = "${bookList.bookKeyword3}"
                     placeholder="책에 관한 키워드를 입력하세요.">
                     
               </div>
						<div class="form-group">
							<label>저자</label> <input class="form-control" type="text"
								name="writer" value = "${bookList.writer}" placeholder="* 저자를 입력하세요.">
						</div>

						<div class="form-group">
							<label>출판사</label> <input class="form-control" type="text"
								name="publisher" value = "${bookList.publisher}" placeholder="* 출판사를 입력하세요.">
						</div>


						<button type="submit" class="btn btn-success"><i class="fa fa-check-circle-o"></i>수정</button>
							
						<button type="button" class="btn btn-warning" onclick="location.href='book?command=bookDelete&bookNum=${bookList.bookNum}'" >
						<i class="fa fa-close"></i>삭제</button>
						
						<button type = "button" class="btn btn-secondary" onclick="location.href='book?command=bookList'"><i class="fa fa-arrow-circle-right"></i>목록</button>
					</form>
				</div>

			</div>

		</div>
	</section>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>