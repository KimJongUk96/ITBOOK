<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">희망의 책 공지사항</h1>
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
		 <form name="frm" action="/notice?command=noticeInsertAction" method="post" onsubmit="return validateGalBoard()">
		<input type="hidden" name="memNum" value="${list.memNum}">
		<table class="table table-bordered">
   	 	<tbody>
   	    
            <tr>
                <th>제목: </th>
                <td><input type="text" placeholder="제목을 입력하세요. " name="noticeTitle" class="form-control"/></td>
            </tr>
            
           <!--  <tr>
                <th>작성자: </th>
                <td><input type="text" placeholder="파일을 선택하세요. " name="noticeName" class="form-control"/></td>
            </tr> -->
            <tr>
                <th>내용: </th>
                <td><textarea cols="10" placeholder="내용을 입력하세요. " name="noticeContent" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>첨부파일: </th>
                <td><input type="password" placeholder="비밀번호를 입력하세요" class="form-control"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="등록" class="pull-right" onclick="return noticeCheck()" >
                    <input type="reset" value="취소" onclick="location.href='/notice?command=noticeListFormAction'" class="pull-left"/>
                    <input type="button" value="목록 " class="pull-right" onclick="location.href='/notice?command=noticeListFormAction'"/>
                    
                </td>
            </tr>
     
    	</tbody>
			</table>
			   </form>
		</div>
		
	</section>
	<!-- =======================
	공지사항 글쓰기 폼 끝 -->
	<%@ include file="../include/footer.jsp"%>
	</body>
</html>