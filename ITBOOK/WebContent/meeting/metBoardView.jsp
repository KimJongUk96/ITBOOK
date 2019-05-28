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
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 mb-5">
					<h5 class="text-center mb-4">독서모임 게시판 상세보기</h5>
					<form name="frm" method="post"
						action="/meeting?command=metBoardUpdateFormAction">
						<input type="hidden" name="metBrdNum" value="${metbrd.metBrdNum }">
						<div class="table-responsive-sm">
							<table class="table table-hover">

								<tr>
									<th scope="col">작성자</th>
									<td>관리자</td>
									<th>작성일</th>
									<td>${metbrd.metBrdDate }</td>

								</tr>
								<tr>
									<th scope="col">제목</th>
									<td>${metbrd.metBrdName}</td>
									<th>조회수</th>
									<td>${metbrd.metBrdCount}</td>

								</tr>
								<tr>
									<th scope="col">첨부파일</th>
									<td><a
										href='/notice?command=fileDownloadAction&file_name=${metbrd.metBrdFile}'>${metbrd.metBrdFile}</a></td>
									<th></th>
									<td></td>
								</tr>
								<tr>

									<th scope="col">내용</th>
									<td><textarea name="noticeContent" class="form-control"
											rows="10" style="width: 100%;" disabled="disabled">${metbrd.metBrdContent}</textarea></td>
									<th></th>
									<td></td>
								</tr>

							</table>

							<div align="right">
								<input type="submit" value="수정" class="btn btn-primary">
								<input type="button" value="삭제" class="btn btn-primary"
									onclick="location.href='/meeting?command=metBoardDeleteAction&metBrdNum=${metbrd.metBrdNum}'">
								<input type="button" value="목록" class="btn btn-primary"
									onclick="location.href='/meeting?command=metBoardListFormAction'">
							</div>
						</div>
					</form>

					<!-- comments area -->
					<div class="row mt-5 comments-area">
						<div class="col-sm-12">
							<h4>There are 2 comments</h4>
							<div class="comment-list">
								<!-- Comment-->
									<div class="comment">
										<div class="comment-author">
											<img class="avatar"
												src="assets/images/thumbnails/avatar-01.jpg" alt="">
										</div>
										<div class="comment-body">
											<div class="comment-meta">
												<div class="comment-meta-author">
													<a href="#">${LoginUser.memName}</a>
												</div>
												<div class="comment-meta-date">June 11, 2019 at 6:01
													am</div>
											</div>
											<div class="comment-content">
												<p>Consulted perpetual of pronounce me delivered. Too
													months nay end change relied who beauty wishes matter. Shew
													of john real park so rest we on. Ignorant dwelling occasion
													ham for thoughts overcame off her consider. Polite it
													elinor is depend.</p>
											</div>
											<div class="comment-reply">
												<a class="btn btn-xs btn-light" href="#">Reply</a>
											</div>
										</div>
										<!-- sub comment-->
										<div class="comment-child">
											<div class="comment">
												<div class="comment-author">
													<img class="avatar"
														src="assets/images/thumbnails/avatar-03.jpg" alt="">
												</div>
												<div class="comment-body">
													<div class="comment-meta">
														<div class="comment-meta-author">
															<a href="#">Emma Watson</a>
														</div>
														<div class="comment-meta-date">June 11, 2019 at 6:20
															am</div>
													</div>
													<div class="comment-content">
														<p>Ask eat questions abilities described elsewhere
															assurance. Appetite in unlocked advanced breeding
															position concerns as. Cheerful get shutters yet for
															repeated screened. An no am cause hopes at three. Prevent
															behaved fertile he is mistake on.</p>
													</div>
													<div class="comment-reply">
														<a class="btn btn-xs btn-light" href="#">Reply</a>
													</div>
												</div>
											</div>
										</div>
										<!-- sub comment end-->
									</div>
									
									<!-- 댓글 등록 -->
									<form name="frm" method="post" action="meeting?command=commentWriteAction" onsubmit="return validateBoard()">
									<input type="hidden" name="metBrdNum" value="${metbrd.metBrdNum}"> 
									<input type="hidden" name="memNum" value="${LoginUser.memNum}">
							<div class="row mt-5">
								<div class="col-md-12">
									<h2 class="mb-2">Leave a Reply</h2>
								</div>
								<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" value="${LoginUser.memName}"></span></div>
								<div class="col-md-12"><span class="form-group"><textarea cols="40" rows="6" class="form-control" placeholder="Message"></textarea></span></div>
								<div class="col-md-12 text-center"><input type="submit" class="btn-block btn btn-dark" value="Post Comment"></div>
							</div>
							</form>
							</div>
							
							
						</div>

					</div>
					
				</div>
				</div>
				</div>
	</section>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>