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

	<section class="service">

		<form name="frm" method="post" action="report?command=reportRegForm">
			<div class="col-md-12">
				<span style="float: right">
				

						<input
							class="form-control border-radius-right-0 border-right-0 bg-transparent text-white"
							type="text" name="search" placeholder="책 이름을 검색하세요">
						<button type="button"
							class="btn btn-grad border-radius-left-0 mb-0">검색</button>
							
				
					
				</span>
			</div>
			
			<div class="container">
				<div class="row">
				<div class="col-sm-12 text-center mt-5 mb-4">
				
							<div class="col-md-6 mb-4">
							
								<h5 class="mb-4"></h5>
								<blockquote class="blockquote" cite="#">
									<h5 class="mb-2 text-light-gray">
										책은 마음의 양식입니다. <br> <strong>자신의 생각을 자유롭게 표현해보세요!</strong>
									</h5>

								</blockquote>

							</div>
							<a href="report?command=Report_Reg_Form">
						<button type="button" class="btn btn-outline-primary">
							<i class="fa fa-check-circle-o"></i>등록하기
						</button>
					</a>
						</div>
					
					<div class="divider">
							<i class="ti-book"></i>
						</div>
					<c:forEach var="reportList" items="${reportList}">
					<input type="hidden" name="bookNum" value="${reportList.bookNum}">
					<input type="hidden" name="memNum" value="${LoginUser.memNum}">
						<h5 class="mb-2 mt-5"></h5>
						
						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">
									<a href="report?command=Report_Detail&reportNum=${reportList.reportNum}">
										${reportList.reportTitle}</a>
								</h3>

								<p class="feature-box-desc">${reportList.reportContent}</p>
							</div>
						</div>
					</c:forEach>
					
				</div>
			</div>
		</form>

	</section>
	
<!-- 페이징 처리 -->  
 <section class="pt-0">
      <div class="container">
         <div class="row justify-content-center">
            <div class="col-md-8">
               <nav>
                  <ul class="pagination justify-content-center">
                  <c:if test="${paging.pageNum > 1}">
                     <li class="page-item"><a class ="page-link" href="report?command=Report_List&pageNum=${paging.pageNum - 1}">Prev</a></li>
                  
                     
                  </c:if>   
                     <c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="report?command=Report_List&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
                  
                     <c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="report?command=Report_List&pageNum=${paging.pageNum + 1}">Next</a></li>   
                                    </c:if>
                     

                  </ul>
               </nav>
            </div>
         </div>
      </div>
   </section> 

	<%@ include file="../include/footer.jsp"%>
</body>
</html>