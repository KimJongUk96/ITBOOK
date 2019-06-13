<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>

<!-- 독서모임 신청폼 -->
<!-- portfolio-grid-column-4.html Form -->
<html>
<head>
	<title>독서모임 신청</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Webestica.com">
	<meta name="description" content="Creative Multipurpose Bootstrap Template">

	<!-- Favicon -->
	<link rel="shortcut icon" href="../assets/images/favicon.ico">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700" rel="stylesheet">

	<!-- Plugins CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/themify-icons/css/themify-icons.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/animate/animate.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/fancybox/css/jquery.fancybox.min.css" />

	<!-- Theme CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />
	
	<!-- Form CSS -->
	<!-- 스타일 시트 추가 -->
	<style type="text/css">
	form {
	margin: 0 auto;
	}
	</style>
	
	<!-- Form JavaScript -->
	<script type="text/javascript" src="/js/meetingCheck.js"></script>
	
	<script type="text/javascript">
	
	function meetingList() {
		
	location.href='meeting?command=meetingList';
	}
	
	</script>
	
</head>
<body>
<!-- header 삽입 -->
  	<header>
     	<%@ include file="../include/header.jsp"%>
 	</header>
	<div class="preloader">
		<img src="../assets/images/preloader.svg" alt="Pre-loader">
	</div>

	<!-- =======================
	Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">독서모임 신청</h1>
					<h6 class="subtitle">나만의 독서모임 신청하기</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/index.jsp"><i class="ti-home"></i> Home</a></li>
							<li class="breadcrumb-item">독서모임</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->


	<!-- =======================
	Form -->
	<section>
		<div class="container">
			<div class="row">
				<form name="frm" method="post" action="/meeting?command=meetingApply" class="col-md-7">

					<!-- 독서모임명 -->
					<div class="form-group">
						<label>독서모임명</label>
						<input type="text" name="metName" class="form-control" placeholder="독서모임명을 입력해주세요.">
					</div>

					<!-- 독서모임소개 -->
					<div class="form-group">
						<label>독서모임소개</label>
						<textarea name="metIntro" class="form-control" rows="7" placeholder="독서모임을 소개합니다."></textarea>
					</div>
					
					<!-- 독서모임 인사말 -->
					<div class="form-group">
						<label>인사말</label>
						<textarea name="metGreeting" class="form-control" rows="2" placeholder="대표 인사말을 입력하세요."></textarea>
					</div>
					
					<!-- 대표자명 -->
					<div class="form-group">
						<label>대표자</label>
						<input type="text" name="represent" value="${LoginUser.memName}" class="form-control" style="width:250px" readonly>
					</div>

					<!-- Select -->
					<div class="form-group">
						<label>주 활동지역</label><br/>
						<select name="location" class="custom-select select-big mb-3" style="float:left; width:25%;">
							<option selected>전국</option>
							<option value="location1">서울특별시</option>
							<option value="location2">인천광역시</option>
							<option value="location3">대전광역시</option>
							<option value="location4">세종특별자치시</option>
							<option value="location5">대구광역시</option>
							<option value="location6">부산광역시</option>
							<option value="location7">울산광역시</option>
							<option value="location8">광주광역시</option>
							<option value="location9">제주도특별자치시</option>
							<option value="location10">울릉도</option>
							<option value="location11">독도</option>
						</select>
							<input type="text" name="metPlace" class="form-control" placeholder="활동장소를 입력하세요" style="float:left; width:75%; height:45.52px;">
				 	</div>

				<!-- <div class="col-md-6"> -->
					<!-- custom checkbox -->
					<label class="mt-3">활동주제  (※가장 적합한 1개의 주제를 선택해주세요)</label>
					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="checkbox" name="keyword" value="home" class="custom-control-input" id="home">
						<label class="custom-control-label" for="home">가정/육아</label>
					</div>
						
					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="checkbox" name="keyword" value="health" class="custom-control-input" id="health&beauti">
						<label class="custom-control-label" for="health&beauti">건강/뷰티</label>
					</div>
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="business" class="custom-control-input" id="economy&business">
						<label class="custom-control-label" for="economy&business">경제/경영</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="education" class="custom-control-input" id="education">
						<label class="custom-control-label" for="education">교육</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="literature" class="custom-control-input" id="literature">
						<label class="custom-control-label" for="literature">문학</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="social" class="custom-control-input" id="social&science">
						<label class="custom-control-label" for="social&science">사회과학</label>
					</div>
					
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="IT" class="custom-control-input" id="IT&programing">
						<label class="custom-control-label" for="IT&programing">IT/개발</label>
					</div>
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="leisure" class="custom-control-input" id="leisure">
						<label class="custom-control-label" for="leisure">여가생활</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="history" class="custom-control-input" id="history">
						<label class="custom-control-label" for="history">역사</label>
					</div>
					
					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="checkbox" name="keyword" value="art" class="custom-control-input" id="art&popculture">
						<label class="custom-control-label" for="art&popculture">예술/대중문화</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="foreign" class="custom-control-input" id="foreign">
						<label class="custom-control-label" for="foreign">외국어/외국문학</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="child" class="custom-control-input" id="child&teenager">
						<label class="custom-control-label" for="child&teenager">아동/청소년</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="humanity" class="custom-control-input" id="humanity">
						<label class="custom-control-label" for="humanity">인문학</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="selfimprove" class="custom-control-input" id="self-improve">
						<label class="custom-control-label" for="self-improve">자기계발</label>
					</div>
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="natural" class="custom-control-input" id="natural&science">
						<label class="custom-control-label" for="natural&science">자연/과학</label>
					</div>	
						
					<div class="custom-control custom-checkbox mr-sm-2">	
						<input type="checkbox" name="keyword" value="computer" class="custom-control-input" id="computer&internet">
						<label class="custom-control-label" for="computer&internet">컴퓨터/인터넷</label>
					</div>
					
					<br><br>
					<!-- post way -->
					<div class="text-center text-md-left align-self-center">
						<h5 class="m-0"><b>※독서모임은 관리자의 승인 후 활동 가능합니다.</b></h5>
					</div>
					<br>
					<section>
					<div class="text-center text-md-center mt-md-0 align-self-center ">
						<button class="btn btn-grad mb-0" type="submit" onclick="return meetingCheck()">신청</button>
						<button class="btn btn-grad mb-0" type="reset">다시작성</button>
						<input class="btn btn-grad mb-0" type="button" onclick="meetingList()" value="취소" />
						<!-- <input type ="button" class="btn btn-outline-light mb-0" value="취소" onclick="location.href='meeting?command=meetingList'"> -->
					</div>
					</section>
				</form>
			</div>
		</div>
	</section>

	<!-- =======================
	Form -->

	<!-- =======================r
	footer  -->
	<%@ include file="../include/footer.jsp"%>
	<!-- =======================
	footer  -->

	<div> <a href="#" class="back-top btn btn-grad"><i class="ti-angle-up"></i></a> </div>

	<!--Global JS-->
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/popper.js/umd/popper.min.js"></script>
	<script src="../assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!--Vendors-->
	<script src="../assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>
	<script src="../assets/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
	<script src="../assets/vendor/isotope/isotope.pkgd.min.js"></script>

	<!--Template Functions-->
	<script src="../assets/js/functions.js"></script>
</body>
</html>