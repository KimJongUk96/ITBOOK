<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>희망의 책 모임게시판</title>
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
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">희망의 책 모임게시판</h1>
					<h6 class="subtitle">We transform your perception into an
						excellent website</h6>
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
	<!-- =======================
	Banner innerpage -->
	
	<!-- =======================
	공지사항 글쓰기 폼 시작 -->
	<section>
		<div class="container">
		 <form name="frm" action="/meeting?command=metBoardWriteAction" method="post" onsubmit="return validateGalBoard()" enctype="multipart/form-data">
		<input type="hidden" name="memNum" value="${list.memNum}">
		<!-- Comment-respond -->
							<div class="row mt-5">
								<div class="col-md-12">
									<h2 class="mb-2">글쓰기</h2>
								</div>
								<div class="col-md-2">
								<select class="custom-select select-big mb-3" name="metBrdCategory">
									<option value="공지">공지</option>
									<option value="일반">일반</option>
									<option value="행사 및 세미나">행사 및 세미나</option>
									<option value="자료">자료</option>
								</select>
								</div>
								<div class="col-md-7"><span class="form-group"><input type="text" class="form-control" placeholder="제목" name="metBrdName"></span></div>
								<!-- <div class="col-md-6"><span class="form-group"><input type="email" class="form-control" placeholder="E-mail"></span></div> -->
								
								<div class="col-md-3">
									<div class="form-group">
										<input type="file" name="metBrdFile" class="form-control-file" id="exampleFormControlFile1">
									</div>
								</div>
								
								<div class="col-md-12" style="min-height:480px;"><span class="form-group"><textarea cols="40" rows="20"  name="metBrdContent"
								class="form-control" placeholder="Message"></textarea></span></div>
								
								<!-- 첨부파일 시작 -->
								<!-- <div class="col-md-12">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text">Upload</span>
										</div>
										<div class="custom-file">
											<input type="file" name="noticeFile" class="custom-file-input" id="inputGroupFile01">
											<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
										</div>
									</div>
								</div> -->
								
								<div class="col-md-2 text-center">
								<input type="submit" value="등록" class="btn-block btn btn-dark" onclick="return noticeCheck()"/> </div>
								<div class="col-md-2 text-center">
								<input type="button" value="돌아가기 " class="btn-block btn btn-dark" onclick="location.href='/meeting?command=metBoardListFormAction'"/></div>
								
							</div>
		<%-- <table class="table table-bordered">
   	 	<tbody>
   	    
            <tr>
                <th>제목: </th>
                <td><input type="text" placeholder="제목을 입력하세요. " name="metBrdName" class="form-control"/></td>
            </tr>
            
             <tr>
                <th>작성자: </th>
                <td><input type="text" placeholder="관리자" value = "${LoginUser.memName}" class="form-control"/></td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea placeholder="내용을 입력하세요. " name="metBrdContent" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>첨부파일: </th>
                <td><input type="file" name="metBrdFile"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="등록" class="pull-right" onclick="return noticeCheck()" >
                    <input type="reset" value="취소" onclick="location.href='/meeting?command=metBoardListFormAction'" class="pull-left"/>
                    <input type="button" value="돌아가기 " class="pull-right" onclick="location.href='/meeting?command=metBoardListFormAction'"/>
                    
                </td>
            </tr>
     
    	</tbody>
			</table> --%>
			   </form>
		</div>
		
	</section>
	<!-- =======================
	공지사항 글쓰기 폼 끝 -->
	<%@ include file="../include/footer.jsp"%>
	</body>
</html>