<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>희망의 책 : 독서모임</title>
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
		
				<!-- ======================= Banner innerpage -->
				<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
					<div class="container">
						<div class="row all-text-white">
							<div class="col-md-12 align-self-center">
								<h1 class="innerpage-title">- ${meetingVo.metName} - 관리 홈</h1>
								<h6 class="subtitle">다같이 만들어가는 독서모임</h6>
								<nav aria-label="breadcrumb">
									<ol class="breadcrumb">
										<li class="breadcrumb-item active"><a href="/main?command=loginForm"><i class="ti-home"></i> Home</a></li>
										<li class="breadcrumb-item"><a href="/meeting?command=meetingList">독서모임</a></li>
									</ol>
								</nav>
							</div>
						</div>
					</div>
				</div>
				<!-- ======================= Banner innerpage -->
				
				<!-- ======================= feature box -->
					<section>
						<div class="container">
				
							<!-- default style -->
							<div class="row">
								<!-- feature 1 -->
								<div class="col-md-4">
									<div class="feature-box h-100 icon-grad">
										<div class="feature-box-icon">
											<a href="/meeting?command=metUpdateFormAction&metNum=${meetingVo.metNum}">
												<i class="ti-settings"></i>
											</a>
										</div>
										<h3 class="feature-box-title"><a href="/meeting?command=metUpdateFormAction&metNum=${meetingVo.metNum}">독서모임 수정</a></h3>
										<p class="feature-box-desc">독서모임에 대한 기본정보를 수정할 수 있습니다. </p>
									</div>
								</div>
								<!-- feature 2 -->
								<div class="col-md-4">
									<div class="feature-box h-100 text-center icon-grad">
										<div class="feature-box-icon"><a href="/meeting?command=manageJoinAction&metNum=${meetingVo.metNum}"><i class="ti-support"></i></a></div>
										<h3 class="feature-box-title"><a href="/meeting?command=manageJoinAction&metNum=${meetingVo.metNum}">가입신청 관리</a></h3>
										<p class="feature-box-desc">가입신청한 멤버를 승인 또는 거절할 수 있습니다. </p>
									</div>
								</div>
								<!-- feature 3 -->
								<div class="col-md-4">
									<div class="feature-box h-100 text-right icon-grad">
										<div class="feature-box-icon"><a href="/meeting?command=manageMemberAction&metNum=${meetingVo.metNum}"><i class="ti-bolt"></i></a></div>
										<h3 class="feature-box-title"><a href="/meeting?command=manageMemberAction&metNum=${meetingVo.metNum}">멤버 관리</a></h3>
										<p class="feature-box-desc">독서모임에 가입된 멤버를 관리합니다.</p>
									</div>
								</div>
							</div>
						<!-- default style end -->
						</div>
					</section>
			
		
		<footer>
			<%@ include file="../include/footer.jsp"%>
		</footer>

</body>
</html>