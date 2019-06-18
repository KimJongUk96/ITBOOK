<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>희망의책 도서관</title>
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
<script type="text/javascript" src ="/js/report.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

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
					<h1 class="innerpage-title">독후감</h1>
					<h6 class="subtitle"> </h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="index.jsp"><i
									class="ti-home"></i> Home</a></li>

						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<%-- <section>
		<div class="container">
			<div class="row">
				<div class="col-md-2">

					<input type="hidden" name="bookNum" value="${reportList.bookNum}">
					<input type="hidden" name="memNum" value="${LoginUser.memNum}">
					<button type="button" class="form-control" name="bookTitle"
						onclick="openPopUp()">책 검색</button>
				</div>
			</div>

			<form name="frm" method="post"
				action="report?command=Report_Update&reportNum=${reportList.reportNum}">
				<div class="col-md-4">
					<div class="form-group">
						<label>분류</label> <select class="custom-select select-big mb-3"
							name="reportCategory">
							<option value="문학">문학</option>
							<option value="경제">경제</option>
							<option value="자연과학">자연과학</option>
							<option value="인문사회">인문사회</option>
						</select>
					</div>
					<div class="form-group">
						<label>책 제목</label> <input class="form-control" name="bookTitle"
							value="${bookList.bookTitle}" placeholder="책 제목을 입력하세요.">
					</div>
					<div class="form-group">
						<label>저자</label> <input class="form-control" type="text"
							value="${reportList.writer}" name="writer"
							placeholder="저자를 입력하세요.">
					</div>
					<div class="form-group">
						<label>출판사</label> <input class="form-control" type="text"
							value="${reportList.publisher}" name="publisher"
							placeholder="출판사를 입력하세요.">
					</div>
					<div class="form-group">
						<label>제목</label> <input class="form-control" name="reportTitle"
							value="${reportList.reportTitle}" placeholder="제목을 입력하세요.">
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="10" name="reportContent"
							placeholder="내용을 입력하세요.">${reportList.reportContent}</textarea>
					</div>
					<button type="submit" class="btn btn-success">
						<i class="fa fa-check-circle-o"></i>수정
					</button>
					<a class="btn btn-warning"
						href="report?command=Report_Detail&reportNum=${reportList.reportNum}"><i
						class="fa fa-close"></i>취소</a>
				</div>
			</form>
		</div>

	</section> --%>
	<section>
		<div class="container">
			<form name="frm" method="post" action="report?command=Report_Update&reportNum=${reportList.reportNum}">
				<input type="hidden" name="bookNum" value="${reportList.bookNum}">
					<input type="hidden" name="memNum" value="${LoginUser.memNum}">
				<div class="form-group">
					<div class="col-md-4 col-xs-4">
						<button type="button" class="form-control" onclick="openPopUp()">책
							검색</button>
						<div class="form-group">
							<label>분류</label> <select class="custom-select select-big mb-3"
								name="reportCategory">
								<option value="문학">문학</option>
								<option value="경제">경제</option>
								<option value="자연과학">자연과학</option>
								<option value="인문사회">인문사회</option>
							</select>
						</div>
					</div>
				</div>

				<!-- Comment-respond -->
				<div class="row mt-5">
					<div class="col-md-12">
						<h2 class="mb-2">글쓰기</h2>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<span class="form-group"><input type="text"
								class="form-control" placeholder="책 제목" name="bookTitle" value="${bookList.bookTitle}" ></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<span class="form-group"><input type="text"
								class="form-control" placeholder="저자" name="writer" value="${reportList.writer}"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<span class="form-group"><input type="text"
								class="form-control" placeholder="출판사" name="publisher" value="${reportList.publisher}"></span>
						</div>
					</div>
					<div class="col-md-7">
						<span class="form-group"><input type="text"
							class="form-control" placeholder="제목" name="reportTitle" value="${reportList.reportTitle}"></span>
					</div>
					<div class="col-md-12" style="min-height: 480px;">
						<span class="form-group"><textarea cols="40" rows="20"
								name="reportContent" class="form-control"
								placeholder="내용을 입력하세요.">${reportList.reportContent}</textarea></span>
					</div>

					<div class="col-md-12 text-right">
						<button type="submit"
							class="btn btn-grad border-radius-left-0 mb-0" onclick="return reportCheck()">수정</button>
						<a href="report?command=Report_List">
							<button type="button"
								class="btn btn-grad border-radius-left-0 mb-0">취소</button>
						</a>
					</div>
				</div>
			</form>
		</div>

	</section>
	<script>
		function openPopUp() {
			// window.name = "부모창 이름"; 
			window.name = "parentForm";
			// window.open("open할 window", "자식창 이름", "팝업창 옵션");
			var width = "650";
			var height = "300";
			var top = (window.screen.height - height) / 2;
			var left = (window.screen.width - width) / 2;
			var url = "../book/bookSearch.jsp";
			var title = "책";
			var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width="
					+ width
					+ ",height="
					+ height
					+ ",top="
					+ top
					+ ",left="
					+ left;

			window.open(url, title, status);
		}
		$(document).ready(function(){
			$('form').submit(function(){
		 	  var result = alert("수정되었습니다.");
		   
			   return result;
			})
			})
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>