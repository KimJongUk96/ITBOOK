<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	</head>
	
<body>
<header>
				<%@ include file="../include/header.jsp"%>
			</header>
		<!-- =======================
	Banner innerpage -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 mb-5">
					<h5 class="text-center mb-4">공지사항 상세보기</h5>
					<form name="frm" method="post" action="/notice?command=noticeUpdateAction">
					<input type="hidden" name="noticeNum" value="${notice.noticeNum }">
					<div class="table-responsive-sm">
						<table class="table table-hover">
							
								<tr>
									<th scope="col">제목</th>
									<td><input type="text" name="noticeTitle" value="${notice.noticeTitle}"></td>
								</tr>
								<tr>
									<th scope="col">작성자</th>
									<td>아무개</td>
									<th>작성일</th>
									<td>${notice.noticeDate }</td>
									<th>조회수</th>
									<td>${notice.noticeCount}</td>
								</tr>
								<tr>
									<th scope="col">첨부파일</th>
									<td>첨부파일</td>
								</tr>
								<tr>
									<th scope="col">내용</th>
									<td colspan="5"><textarea name="noticeContent"
													rows="28" cols="93" style="margin: 0px; width: 1051px; height: 246px;" >
													${notice.noticeContent}</textarea></td>
								</tr>
								
						</table>
						<div align="right">
							<input type="submit" value="수정" class="btn btn-primary" >
							<input type="button" value="삭제" class="btn btn-primary" onclick="location.href='/notice?command=noticeDeleteAction&noticeNum=${notice.noticeNum}'">
							<input type="button" value="목록" class="btn btn-primary" onclick="location.href='/notice?command=noticeListFormAction'">
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</section>

<%@ include file="../include/footer.jsp"%>
</body>
</html>