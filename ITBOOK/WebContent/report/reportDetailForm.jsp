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
					<h1 class="innerpage-title">희망의 책 독후감</h1>
					<h6 class="subtitle">I can find the answer in the book and the
						book is the way to help me.</h6>
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

	<section class="blog-page">
		<div class="container">
			<div class="row">
				<form name="frm" method="post"
					action="report?command=Report_Update_Form">
					<input type="hidden" name="reportNum" value="${reportNum}">
					<!-- Job positions -->
					<div class="col-md-8 mx-auto">
						<h2 class="mb-4">${reportTitle}</h2>
						<div class="post-item-desc">
							<span class="post-meta">${reportDate}</span> <span class="post-meta">${memName}

							</span> <span class="post-meta"><i class="ti-comment-alt"></i></span>
						</div>
						<div class="col-md-4 sidebar">
							<div class="sticky-element">
								<h2 class="mt-3 mt-md-0 mb-3"></h2>
								<ul class="list-unstyled p-0">
									<li class="mb-3"><strong>저자:</strong>${writer}</li>
									<li class="mb-3"><strong>출판사:</strong>${publisher}</li>	
																								
								</ul>
							</div>
						</div>
						<br> <br>
						<h5>${reportContent}</h5>

						<button type="submit" class="btn btn-success">
							<i class="fa fa-check-circle-o"></i>수정하기
						</button>
						<a class="btn btn-danger"
							href="report?command=Report_Delete&reportNum=${reportList.reportNum}"><i
							class="fa fa-chevron-right"></i>삭제하기</a>


					</div>

					<div class="row mt-5">
						<div class="col-12"></div>
					</div>

					<div class="row mt-5 comments-area">
						<div class="col-sm-12">
							<h4>댓글</h4>
							<div class="comment-list">
								<div class="comment">
									<div class="comment-body">
										<div class="comment-meta">
											<div class="comment-meta-author">
												<a href="#">글쓴이</a>
											</div>
											<div class="comment-meta-date">June 11, 2019 at 6:01 am</div>
										</div>
										<div class="comment-content">
											<p></p>
										</div>
										<div class="comment-reply">
											<a class="btn btn-xs btn-light" href="#">답글</a>
										</div>
									</div>
									<!-- sub comment-->
									<div class="comment-child">
										<div class="comment">
											<div class="comment-body">
												<div class="comment-meta">
													<div class="comment-meta-author">
														<a href="#">답글쓴이</a>
													</div>
													<div class="comment-meta-date">June 11, 2019 at 6:20
														am</div>
												</div>
												<div class="comment-content">
													<p></p>
												</div>
												<div class="comment-reply">
													<a class="btn btn-xs btn-light" href="#">답글</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>


							<div class="row mt-5">
								<div class="col-md-12">
									<h2 class="mb-2">댓글을 남겨주세요!</h2>
									<p>댓글은 회원만 가능합니다.</p>
								</div>
								<div class="col-md-6">
									<h5></h5>
								</div>
								<div class="col-md-12">
									<span class="form-group"><textarea cols="40" rows="6"
											class="form-control" placeholder="Message"></textarea></span>
								</div>
								<div class="col-md-12 text-center">
									<button class="btn-block btn btn-dark">댓글 등록</button>
								</div>
								
								<br><br><br><br><br><br>
								
								<div class="col-md-12 text-center">
									<button type="button"
										class="btn btn-grad border-radius-left-0 mb-0">이전 글</button>
										
										<a href="report?command=Report_List">
										<button type="button" class="btn btn-grad border-radius-left-0 mb-0">글 목록</button></a>
										
										<button type="button"
										class="btn btn-grad border-radius-left-0 mb-0">다음 글</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	
	<%@ include file="../include/footer.jsp"%>
</body>
</html>