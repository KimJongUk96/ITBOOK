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
					<input type="hidden" name="reportNum"
						value="${reportList.reportNum}">

					<!-- Job positions -->
					<div class="col-md-8 mx-auto">
						<h2 class="mb-4">${reportList.reportTitle}</h2>
						<div class="post-item-desc">
							<span class="post-meta">${reportList.reportDate}</span>
							<%-- <span class="post-meta">${reportList.memName} </span> --%>
							<span class="post-meta"><i class="ti-comment-alt"></i></span>
						</div>
						<div class="col-md-4 sidebar">
							<div class="sticky-element">
								<h2 class="mt-3 mt-md-0 mb-3"></h2>
								<ul class="list-unstyled p-0">
									<li class="mb-3"><strong>저자:</strong>${reportList.writer}</li>
									<li class="mb-3"><strong>출판사:</strong>${reportList.publisher}</li>

								</ul>
							</div>
						</div>
						<br> <br>
						<h5>${reportList.reportContent}</h5>

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
				</form>

				<%-- 	<c:if test="${requestScope.commentList != null}">
					<c:forEach var="comment" items="${requestScope.commentList}"> --%>
				<div class="row mt-5 comments-area">
					<div class="col-sm-12">
						<h4>댓글</h4>
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
										<div class="comment-meta-date">${comment.reportComtDate}
										</div>
									</div>
									<div class="comment-content">
										<p>Consulted perpetual of pronounce me delivered. Too
											months nay end change relied who beauty wishes matter. Shew
											of john real park so rest we on. Ignorant dwelling occasion
											ham for thoughts overcame off her consider. Polite it elinor
											is depend.</p>
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
													assurance. Appetite in unlocked advanced breeding position
													concerns as. Cheerful get shutters yet for repeated
													screened. An no am cause hopes at three. Prevent behaved
													fertile he is mistake on.</p>
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
							<form name="frm" method="post"
								action="report?command=Report_Comment"
								onsubmit="return validateBoard()">
								<input type="hidden" name="reportNum"
									value="${reportList.reportNum}"> <input type="hidden"
									name="memNum" value="${LoginUser.memNum}">
								<div class="row mt-5">
									<div class="col-md-12">
										<h2 class="mb-2">Leave a Reply</h2>
									</div>
									<div class="col-md-6">
										<span class="form-group"><input type="text"
											class="form-control" value="${LoginUser.memName}"></span>
									</div>
									<div class="col-md-12">
										<span class="form-group"><textarea
												name="reportComtContent" cols="40" rows="6"
												class="form-control" placeholder="Message"></textarea></span>
									</div>
									<div class="col-md-12 text-center">
										<input type="submit" class="btn-block btn btn-dark"
											value="Post Comment">
									</div>
								</div>
							</form>
						</div>
					</div>


                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>

                        <div class="col-md-12 text-center">
                           <button type="button"
                              class="btn btn-grad border-radius-left-0 mb-0">이전 글</button>

                           <a href="report?command=Report_List">
                              <button type="button"
                                 class="btn btn-grad border-radius-left-0 mb-0">글 목록</button>
                           </a>

                           <button type="button"
                              class="btn btn-grad border-radius-left-0 mb-0">다음 글</button>
                        </div>
                     </div>
                  </div>
				</div>
            
   </section>

				<%-- </c:forEach>
				</c:if> --%>
	

	<%@ include file="../include/footer.jsp"%>
</body>
</html>