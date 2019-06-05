<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청서 작성</title>
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
	<div class="left bg-grad pattern-overlay-4">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n4 mt-9">후원하기</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->
	
	<!-- =======================
	careers -->
	<section>
		<div class="container">
			<div class="row">
				<!-- Job positions -->
				<div class="col-md-8">
					<h2 class="mb-4">희망의 책 대전본부</h2>
					<p>책읽는사회는 법인세법에 의거한 지정기부금단체입니다.</p>

					<p>후원해주신 기부금은 법인은 소득 금액의 10%, 개인은 30% 범위 내에서 </p>

					<p>손비인정 또는 소득공제를 받을 수 있는 기부금 영수증을 발급해드립니다.</p>


					<!-- Apply form -->
					<div class="row mt-5">
						<div class="col-md-12">
							<h2 class="mb-3">후원 신청자 정보</h2></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="Name"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="email" class="form-control" placeholder="E-mail"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="Mobile number"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="Mobile number"></span></div>
						<div class="col-md-3">
						<input type="text" id="sample4_postcode" name = "adr1" placeholder="우편번호" class="form-control" style ="width:150px" readonly="readonly">
						</div>			
						<div class="col-md-3">
									<input type="button" onclick="sample4_execDaumPostcode()" class ="btn btn-dark" value="우편번호 찾기" ><br>
						</div>		
						<div class="col-md-12">	
									<input type="text" id="sample4_roadAddress" name = "adr" id = "adr" placeholder="도로명주소" class="form-control" readonly="readonly">
									<span id="guide" style="color:#999"></span>
						</div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="소속"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="직급"></span></div>
						<div class="col-md-12"><span class="form-group"><textarea cols="40" rows="6" class="form-control" placeholder="Message"></textarea></span></div>
						
					</div>
					
						<!-- Apply form -->
					<div class="row mt-5">
						<div class="col-md-12">
							<h2 class="mb-3">후원 계좌 및 금액 정보</h2></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="은행"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="email" class="form-control" placeholder="예금주"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="계좌번호"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="금액"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="후원방식"></span></div>
						
						<div class="col-md-12 text-center"><button class="btn-block btn btn-dark">Apply now</button></div>
					</div>

				</div>
				<!-- Sidebar -->
				<div class="col-md-4 sidebar">
					<div class="sticky-element">
						<h2 class="mt-3 mt-md-0 mb-3">Job details</h2>
						<ul class="list-unstyled p-0">
							<li class="mb-3"><strong>Posted:</strong> 3 July 2018 </li>
							<li class="mb-3"><strong>Location:</strong> London </li>
							<li class="mb-3"><strong>Specialism:</strong> IT </li>
							<li class="mb-3"><strong>Job type:</strong> Permanent </li>
							<li class="mb-3"><strong>Reference number:</strong> CRR0001-18 </li>
							<li class="mb-3"><strong>Contact:</strong> Jessica Mores</li>
							<li class="mb-3"><strong>Phone:</strong> (+251) 854-6308 </li> 
						</ul>
						<a class="d-block mt-3" href="#"><i class="fa fa-print mr-2"></i> Print</a>
					</div>
				</div>
				<!-- Sidebar end-->

			</div>
		</div>
	</section>
	<!-- =======================
	careers -->
	
	
	
	
	
	
	
	
	
	<%@ include file="../include/footer.jsp"%>

</body>
</html>