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

 <script type="text/javascript">
 
 // httpRequest 객체 생성
 function getXMLHttpRequest(){
     var httpRequest = null;
 
     if(window.ActiveXObject){
         try{
             httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
         } catch(e) {
             try{
                 httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
             } catch (e2) { httpRequest = null; }
         }
     }
     else if(window.XMLHttpRequest){
         httpRequest = new window.XMLHttpRequest();
     }
     return httpRequest;    
 }

function checkFunc(){
    if(httpRequest.readyState == 4){
        // 결과값을 가져온다.
        var resultText = httpRequest.responseText;
        if(resultText == 1){ 
            document.location.reload(); // 상세보기 창 새로고침
        }
    }
}

// 댓글 삭제창
function cmDeleteOpen(metComtNum){
    var msg = confirm("댓글을 삭제합니다.");    
    if(msg == true){ // 확인을 누를경우
        location.reload();
    }
    else{
        return false; // 삭제취소
    }
}


// 댓글 삭제
function deleteCmt(metComtNum)
{
    var param="metComtNum="+metComtNum;
    
    httpRequest = getXMLHttpRequest(); 
    httpRequest.onreadystatechange = checkFunc;
    httpRequest.open("POST", "com.itbook.controller.action.meeting.CommentDeleteAction", true);    
    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR'); 
    httpRequest.send(param);
}

// 댓글 수정창
function cmUpdateOpen(metComtNum){
    window.name = "parentForm";
    window.open("CommentUpdateFormAction.co?num="+metComtNum,
                "updateForm", "width=570, height=350, resizable = no, scrollbars = no");
}



</script>

</head>

<body>
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	<!-- =======================
	Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/index.jsp"><i class="ti-home"></i>Home</a></li>
						</ol>
					</nav>
				</div>	
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->
	
	<!-- =======================
	Banner innerpage -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 mb-5">
					<h5 class="text-center mb-4">게시글 상세보기</h5>
					<form name="frm" method="post"
						action="/meeting?command=metBoardUpdateFormAction&metNum=${meetingVo.metNum }">
						<input type="hidden" name="metBrdNum" value="${metbrd.metBrdNum}">
						<div class="table-responsive-sm">
							<table class="table table-hover">

								<tr>
									<th scope="col">제목</th>
									<td>${metbrd.metBrdName}</td>
									<th>작성일</th>
									<td>${metbrd.regDate }</td>

								</tr>
								<tr>
									<th scope="col">작성자</th>
									<td>${metbrd.memName }</td>
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

							</table>
								<div class="col-md-12">
									<span class="form-group">
										<textarea cols="40" rows="10"  name="metbrdContent" class="form-control" readonly="readonly" >${metbrd.metBrdContent}</textarea>
									</span>
								</div>
								
							<div align="right">
								<input type="submit" value="수정" class="btn btn-primary">
								<input type="button" value="삭제" class="btn btn-primary"
									onclick="location.href='/meeting?command=metBoardDeleteAction&metBrdNum=${metbrd.metBrdNum}&metNum=${meetingVo.metNum }'">
								<input type="button" value="돌아가기" class="btn btn-primary"
									onclick="location.href='/meeting?command=metBoardListFormAction&metNum=${meetingVo.metNum }'">
							</div>
						</div>
					</form>

					<!-- comments area -->
					<div class="row mt-5 comments-area">
						<div class="col-sm-12">
							<div class="comment-list">
								<!-- Comment-->
								<c:forEach var="comment" items="${requestScope.commentList}">
									<div class="comment">
										<form name="frm" method="post"	action="/meeting?command=commentDeleteAction&metBrdNum=${metbrd.metBrdNum }&metNum=${meetingVo.metNum}">
											<input type="hidden" name="metBrdNum" value="${metbrd.metBrdNum }">
											<input type="hidden" name="metComtNum" value="${comment.metComtNum}">
										<div class="comment-author">
											<img class="avatar"	src="assets/images/thumbnails/avatar-01.jpg" alt="">
										</div>
										
										<div class="comment-body">
											<div class="comment-meta">
												<div class="comment-meta-author">
													<a href="#">${comment.memName}</a>
												</div>
												<div class="comment-meta-date">${comment.metComtDate }</div>
											</div>
											<div class="comment-content">
												<p>${comment.metComtContent }</p>
											</div>
											<div class="comment-reply">
												<a href="#" class="btn btn-xs btn-light" onclick="cmUpdateOpen(${comment.metComtNum})">수정</a>
												<input type="submit" value="삭제" class="btn btn-xs btn-light">
												 
											</div>
										</div>
									</form>
										
									</div>
									</c:forEach>
									
									<!-- 댓글 등록 -->
									<form name="frm" method="post" action="meeting?command=commentWriteAction&metBrdNum=${metbrd.metBrdNum }&metNum=${meetingVo.metNum}" onsubmit="return validateBoard()">
									<input type="hidden" name="metBrdNum" value="${metbrd.metBrdNum}"> 
									<input type="hidden" name="memNum" value="${LoginUser.memNum}">
							<div class="row mt-5">
								<div class="col-md-12">
									<h2 class="mb-2">댓글</h2><br>
								</div>
									
							</div>
							<!-- border-dotted -->
										<section class="py-4">
											<div class="container">
												<div class="d-block d-md-flex border border-dotted p-4 p-sm-5 border-radius-3">
													<div class="col-md-2"><input type="text" class="form-control" value="${LoginUser.memName}"></div>
														<div class="align-self-center text-center text-md-left">
															<textarea name="metComtContent" cols="100" rows="2" class="form-control" placeholder="Message"></textarea>
														</div>
													<div class="mt-3 mt-md-0 text-center text-md-right ml-md-auto align-self-center">
														<input type="submit" class="btn btn-primary btn-lg" value="등록">
													</div>
												</div>
											</div>
										</section>
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