<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript" src="js/logout.js"></script>
<!doctype html>
<html>
<head>
   <!-- <title>Wizixo | Creative Multipurpose Bootstrap Template</title> -->
   <!-- <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="author" content="Webestica.com">
   <meta name="description" content="Creative Multipurpose Bootstrap Template">

   Favicon
   <link rel="shortcut icon" href="assets/images/favicon.ico">

   Google Font
   <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700" rel="stylesheet">

   Plugins CSS
   <link rel="stylesheet" type="text/css" href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
   <link rel="stylesheet" type="text/css" href="../assets/vendor/themify-icons/css/themify-icons.css" />
   <link rel="stylesheet" type="text/css" href="../assets/vendor/animate/animate.min.css" />
   <link rel="stylesheet" type="text/css" href="../assets/vendor/fancybox/css/jquery.fancybox.min.css" />
   <link rel="stylesheet" type="text/css" href="../assets/vendor/owlcarousel/css/owl.carousel.min.css" />
   <link rel="stylesheet" type="text/css" href="../assets/vendor/swiper/css/swiper.min.css" />

   Theme CSS
   <link rel="stylesheet" type="text/css" href="assets/css/style.css" /> -->

</head>

<body>
   <!-- =======================
   header Start-->
   <header class="header-static navbar-sticky navbar-light">
      <!-- Search -->
      <div class="top-search collapse bg-light" id="search-open" data-parent="#search">
         <div class="container">
            <div class="row position-relative">
               <div class="col-md-8 mx-auto py-5">
                  <form>
                     <div class="input-group">
                        <input class="form-control border-radius-right-0 border-right-0" type="text" name="search" autofocus placeholder="What are you looking for?">
                        <button type="button" class="btn btn-grad border-radius-left-0 mb-0">Search</button>
                     </div>
                  </form>
                  <p class="small mt-2 mb-0"><strong>e.g.</strong>희망의 책 대전본부 홈페이지 </p>
               </div>
               <a class="position-absolute top-0 right-0 mt-3 mr-3" data-toggle="collapse" href="#search-open"><i class="fa fa-window-close"></i></a>
            </div>
         </div>
      </div>
      <!-- End Search -->
 
      <!-- Navbar top start-->
      <div class="navbar-top d-none d-lg-block">
         <div class="container">
            <div class="d-flex justify-content-between align-items-center">
               <!-- navbar top Left-->
               <div class="d-flex align-items-center">
                  <!-- Language -->
                  <div class="dropdown">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownLanguage" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <img class="dropdown-item-icon" src="assets/images/flags/uk.svg" alt=""> English </a>
                    <div class="dropdown-menu mt-2 shadow" aria-labelledby="dropdownLanguage">
                       <span class="dropdown-item-text">Select language</span>
                       <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#"><img class="dropdown-item-icon" src="../assets/images/flags/sp.svg" alt=""> Español</a>
                      <a class="dropdown-item" href="#"><img class="dropdown-item-icon" src="../assets/images/flags/fr.svg" alt=""> Français</a>
                      <a class="dropdown-item" href="#"><img class="dropdown-item-icon" src="../assets/images/flags/gr.svg" alt=""> Deutsch</a>
                    </div>
                  </div> 
                  <!-- Top info -->
                  <ul class="nav list-unstyled ml-3">
                     <li class="nav-item mr-3">
                        <a class="navbar-link" href="#"><strong>전화:</strong> (042) 252-9540</a>
                     </li>
                     <li class="nav-item mr-3">
                        <a class="navbar-link" href="#"><strong>이메일:</strong> help@wizixo.com</a>
                     </li>
                  </ul>
               </div>
               
               <!-- navbar top Right-->
               <div class="d-flex align-items-center" id = "navbar">
               <c:if test = "${LoginUser.authority eq 1 or LoginUser.authority eq 2 or LoginUser.authority eq 3}">
               <span class = "loginfo"> 
               <span class= "dept_of_top"></span> <b>${LoginUser.memName}</b>님 반갑습니다. 
               </span>
               </c:if>
                  <!-- Top Account -->               
                  <div class="dropdown">
               <c:if test = "${LoginUser.authority eq 1 or LoginUser.authority eq 2}">
                    <a class="dropdown-toggle" href="" role="button" id="dropdownAccount" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="ti-user mr-2"></i>로그인 </a>
                    <div class="dropdown-menu mt-2 shadow" aria-labelledby="dropdownAccount">
                      <a class="dropdown-item" href="member/myPage.jsp">내 정보</a>
                    </div>
                  </c:if>
                  
                  <c:if test = "${LoginUser.authority eq 3}">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownAccount" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="ti-user mr-2"></i>Account </a>
                    <div class="dropdown-menu mt-2 shadow" aria-labelledby="dropdownAccount">
                      <a class="dropdown-item" href="member/myPage.jsp">내 정보</a>
                      <a class="dropdown-item" onclick="logout();">로그아웃</a>
                    </div>
                  </c:if>
                  </div> 
                  
                  <div class="dropdown">
               <c:if test = "${LoginUser.authority ne 1 and LoginUser.authority ne 2 and LoginUser.authority ne 3}">                  
                    <a class="nav-link" href="login.jsp">로그인</a>
                  </c:if>
                  </div>
                  
                  <!-- top link -->
                  <ul class="nav">
              <li class="nav-item">
                 <c:if test = "${LoginUser.authority eq '1' or LoginUser.authority eq '2'}">
                 <a class="nav-link" onclick="logout();">로그아웃</a>
                 </c:if>
                 <c:if test = "${LoginUser.authority eq 3}">
                  <a class="nav-link" href="admin?command=memberListForm">관리자 화면</a>
                  </c:if>
              </li>
            </ul>
                  <!-- top social -->
                  <ul class="social-icons">
                     <li class="social-icons-item social-facebook m-0">
                        <a class="social-icons-link w-auto px-2" href="#"><i class="fa fa-facebook"></i></a>
                     </li>
                     <li class="social-icons-item social-instagram m-0">
                        <a class="social-icons-link w-auto px-2" href="#"><i class="fa fa-instagram"></i></a>
                     </li>
                     <li class="social-icons-item social-twitter m-0">
                        <a class="social-icons-link w-auto pl-2" href="#"><i class="fa fa-twitter"></i></a>
                     </li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
      <!-- Navbar top End-->

      <!-- Logo Nav Start -->
      <nav class="navbar navbar-expand-lg">
         <div class="container">
            <!-- Logo -->
            <a class="navbar-brand" href="main?command=loginForm">
               <!-- SVG Logo Start -->
               <svg class="navbar-brand-item" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" preserveAspectRatio="xMinYMid" width="325.656" height="100" viewBox="0 0 325.656 100">
                 <defs>
                    <linearGradient id="LogoGradient">
                        <stop class="fill-grad-start" offset="0%"/>
                        <stop class="fill-grad-end" offset="100%"/>
                     </linearGradient>
                  </defs>
                 <g><path d="M320.187,75.278 C316.545,78.817 312.335,80.585 307.558,80.585 C302.721,80.585 298.497,78.830 294.885,75.322 C291.271,71.813 289.466,67.749 289.466,63.129 L289.466,55.058 C289.466,50.440 291.243,46.404 294.797,42.953 C298.351,39.503 302.605,37.778 307.558,37.778 C312.393,37.778 316.617,39.488 320.231,42.909 C323.843,46.330 325.650,50.381 325.650,55.058 L325.650,63.129 C325.650,67.690 323.828,71.740 320.187,75.278 ZM316.473,55.086 C316.473,52.763 315.583,50.671 313.807,48.813 C312.029,46.954 309.946,46.023 307.558,46.023 C305.111,46.023 303.013,46.954 301.265,48.813 C299.517,50.671 298.643,52.763 298.643,55.086 L298.643,63.103 C298.643,65.485 299.517,67.620 301.265,69.507 C303.013,71.396 305.111,72.339 307.558,72.339 C309.946,72.339 312.029,71.396 313.807,69.507 C315.583,67.620 316.473,65.485 316.473,63.103 L316.473,55.086 ZM285.184,76.023 C285.184,77.018 284.513,78.027 283.173,79.050 C281.832,80.072 280.551,80.585 279.328,80.585 C278.220,80.585 277.434,80.234 276.968,79.532 L267.529,65.058 L258.090,79.532 C257.565,80.234 256.749,80.585 255.642,80.585 C254.535,80.585 253.296,80.087 251.928,79.094 C250.558,78.100 249.874,77.076 249.874,76.023 C249.874,75.440 250.078,74.883 250.486,74.357 L261.323,58.743 L251.010,44.006 C250.602,43.480 250.398,42.953 250.398,42.427 C250.398,41.374 251.083,40.337 252.452,39.313 C253.821,38.290 255.147,37.778 256.429,37.778 C257.478,37.778 258.206,38.129 258.614,38.830 L267.529,52.865 L276.444,38.918 C276.909,38.159 277.667,37.778 278.716,37.778 C279.881,37.778 281.163,38.290 282.562,39.313 C283.960,40.337 284.659,41.374 284.659,42.427 C284.659,42.896 284.454,43.422 284.047,44.006 L273.647,58.830 L284.572,74.357 C284.979,74.883 285.184,75.440 285.184,76.023 ZM238.687,27.865 C237.230,27.865 235.978,27.383 234.929,26.418 C233.880,25.453 233.356,24.328 233.356,23.041 C233.356,21.696 233.880,20.556 234.929,19.620 C235.978,18.685 237.230,18.216 238.687,18.216 C240.143,18.216 241.397,18.685 242.445,19.620 C243.494,20.556 244.019,21.696 244.019,23.041 C244.019,24.328 243.494,25.453 242.445,26.418 C241.397,27.383 240.143,27.865 238.687,27.865 ZM224.617,79.883 L197.435,79.883 C196.387,79.883 195.585,79.560 195.032,78.910 C194.477,78.260 194.202,77.512 194.202,76.665 C194.202,75.659 194.726,74.416 195.775,72.935 L214.478,45.673 L197.872,45.673 C197.115,45.673 196.444,45.307 195.862,44.572 C195.279,43.837 194.988,42.963 194.988,41.946 C194.988,40.930 195.250,40.069 195.775,39.364 C196.299,38.658 196.998,38.304 197.872,38.304 L223.131,38.304 C224.005,38.304 224.748,38.573 225.360,39.109 C225.972,39.646 226.277,40.422 226.277,41.437 C226.277,42.680 225.810,43.954 224.879,45.256 L206.088,72.515 L224.617,72.515 C225.432,72.515 226.131,72.868 226.714,73.574 C227.296,74.280 227.588,75.169 227.588,76.241 C227.588,77.258 227.311,78.119 226.758,78.825 C226.204,79.531 225.491,79.883 224.617,79.883 ZM182.753,27.865 C181.295,27.865 180.043,27.383 178.994,26.418 C177.946,25.453 177.421,24.328 177.421,23.041 C177.421,21.696 177.946,20.556 178.994,19.620 C180.043,18.685 181.295,18.216 182.753,18.216 C184.208,18.216 185.462,18.685 186.511,19.620 C187.560,20.556 188.084,21.696 188.084,23.041 C188.084,24.328 187.560,25.453 186.511,26.418 C185.462,27.383 184.208,27.865 182.753,27.865 ZM158.544,78.918 C158.077,80.146 156.853,80.760 154.873,80.760 C152.891,80.760 151.639,80.175 151.115,79.006 L143.511,56.374 L135.994,78.743 C135.470,80.087 134.159,80.760 132.061,80.760 C130.139,80.760 128.915,80.087 128.391,78.743 L114.844,43.304 C114.610,42.602 114.494,42.106 114.494,41.813 C114.494,40.760 115.134,39.854 116.417,39.094 C117.698,38.334 119.009,37.953 120.350,37.953 C121.806,37.953 122.738,38.510 123.147,39.620 L132.848,66.901 L140.277,42.690 C140.684,41.345 141.763,40.673 143.511,40.673 C145.259,40.673 146.336,41.345 146.745,42.690 L154.086,67.076 L163.875,39.620 C164.225,38.510 165.127,37.953 166.584,37.953 C167.865,37.953 169.163,38.334 170.474,39.094 C171.785,39.854 172.440,40.790 172.440,41.901 C172.440,42.369 172.323,42.837 172.091,43.304 L158.544,78.918 ZM182.753,38.304 C184.092,38.304 185.200,38.582 186.074,39.137 C186.948,39.694 187.385,40.409 187.385,41.287 L187.385,76.813 C187.385,77.574 186.933,78.275 186.030,78.918 C185.126,79.562 184.034,79.883 182.753,79.883 C181.470,79.883 180.393,79.562 179.519,78.918 C178.645,78.275 178.208,77.574 178.208,76.813 L178.208,41.287 C178.208,40.409 178.630,39.694 179.475,39.137 C180.319,38.582 181.412,38.304 182.753,38.304 ZM238.687,38.304 C240.027,38.304 241.134,38.582 242.008,39.137 C242.882,39.694 243.319,40.409 243.319,41.287 L243.319,76.813 C243.319,77.574 242.867,78.275 241.965,78.918 C241.061,79.562 239.968,79.883 238.687,79.883 C237.405,79.883 236.327,79.562 235.453,78.918 C234.579,78.275 234.142,77.574 234.142,76.813 L234.142,41.287 C234.142,40.409 234.564,39.694 235.410,39.137 C236.254,38.582 237.346,38.304 238.687,38.304 Z" class="fill-dark"/>
                   <circle cx="50.047" cy="50" r="50.047" fill="url(#LogoGradient)"/>
                   <path d="M86.607,38.585 L55.868,69.317 C53.678,71.508 50.126,71.508 47.936,69.317 C45.745,67.127 45.745,63.577 47.936,61.387 L78.674,30.654 C80.865,28.464 84.416,28.464 86.607,30.654 C88.797,32.844 88.797,36.395 86.607,38.585 ZM26.806,69.317 C25.679,70.444 24.193,70.981 22.716,70.948 C22.636,70.953 22.560,70.972 22.478,70.972 L20.552,70.972 C18.108,70.972 16.128,68.992 16.128,66.548 L16.128,33.452 C16.128,31.008 18.108,29.028 20.552,29.028 L22.478,29.028 C24.922,29.028 26.902,31.008 26.902,33.452 L26.902,53.359 L49.612,30.654 C51.802,28.464 55.354,28.464 57.544,30.654 C59.735,32.844 59.735,36.395 57.544,38.585 L26.806,69.317 Z" class="fill-white"/>
                 </g>
               </svg>
               <!-- SVG Logo End -->
            </a>
            <!-- Menu opener button -->
            <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"> </span>
           </button>
            <!-- Main Menu Start -->
            <div class="collapse navbar-collapse" id="navbarCollapse">
               <ul class="navbar-nav ml-auto">
                  <!-- Menu item 1 Demos-->
                  <li class="nav-item dropdown active">
                     <a class="nav-link dropdown-toggle" href="#" id="demosMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">희망의 책</a>
                     <div class="dropdown-menu pb-3 pb-lg-0" aria-labelledby="demosMenu" >
                        <div class="d-block d-sm-flex">
                           <ul class="list-unstyled w-100 w-sm-50 pr-0 pr-lg-5">
                              <li class="dropdown-header">Business Homepages</li>
                              <li> <a class="dropdown-item active" href="index.html">Classic Default<span class="badge badge-success ml-2">Hot</span></a> </li>
                              <li> <a class="dropdown-item" href="index-2.html">Corporate Start-Up</a> </li>
                              <li> <a class="dropdown-item" href="index-3.html">Landing Trendy</a> </li>
                              <li> <a class="dropdown-item" href="index-4.html">Portfolio Modern</a> </li>
                              <li> <a class="dropdown-item" href="index-5.html">Agency Start-Up</a> </li>
                           </ul>
                           <ul class="list-unstyled w-100 w-sm-50 pr-0 pr-lg-5">
                              <li class="dropdown-header mt-3 mt-sm-0">Classic Homepages</li>
                              <li> <a class="dropdown-item" href="index-6.html">Classic Corporate</a> </li>
                              <li> <a class="dropdown-item" href="index-7.html">Creative agency</a> </li>
                              <li> <a class="dropdown-item" href="index-8.html">Home Elegant</a> </li>
                              <li> <a class="dropdown-item" href="index-9.html">Marketplace</a> </li>
                              <li> <a class="dropdown-item" href="index-10.html">Personal Portfolio</a> </li>
                           </ul>
                        </div>
                        <!-- mega menu Bottom -->
                        <div class="w-100 bg-grad pattern-overlay-2 p-4 mt-3 all-text-white d-none d-lg-flex">
                           <div class="align-self-center mr-4">
                              <h4 class="mb-0">Checkout the doc!</h4>
                              <p class="mb-0 small">For better understanding of theme standard</p>
                           </div>
                           <a href="https://wizixo.webestica.com/documentation/" target="_blank" class="btn btn-outline-white btn-sm mb-0 align-self-center ml-auto">Read more!</a>
                        </div>
                     </div>
                  </li>
                  <!-- Menu item 2 Blog-->
                  <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="blogMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">독서 생태계</a>
                     <ul class="dropdown-menu" aria-labelledby="blogMenu">
                        <li class="dropdown-submenu">
                           <a class="dropdown-item dropdown-toggle" href="#">Blog default</a>
                           <ul class="dropdown-menu">
                              <li> <a class="dropdown-item" href="blog-classic.html">Full Width</a> </li>
                              <li> <a class="dropdown-item" href="blog-classic-left-sidebar.html">Left Sidebar</a> </li>
                              <li> <a class="dropdown-item" href="blog-classic-right-sidebar.html">Right Sidebar</a> </li>
                           </ul>
                        </li>
                        <li class="dropdown-submenu">
                           <a class="dropdown-item dropdown-toggle" href="#">Blog Grid</a>
                           <ul class="dropdown-menu">
                              <li> <a class="dropdown-item" href="/book?command=bookList">Three column</a> </li>
                              <li> <a class="dropdown-item" href="blog-grid-column-4.html">Four column</a> </li>
                              <li> <a class="dropdown-item" href="blog-grid-left-sidebar.html">Left Sidebar</a> </li>
                              <li> <a class="dropdown-item" href="blog-grid-right-sidebar.html">Right Sidebar</a> </li>
                           </ul>
                        </li>
                        <li><a class="dropdown-item" href="blog-minimal.html">Blog minimal</a></li>
                        <li class="dropdown-submenu">
                           <a class="dropdown-item dropdown-toggle" href="#">Blog Single</a>
                           <ul class="dropdown-menu">
                              <li> <a class="dropdown-item" href="blog-single-classic.html">Single classic</a> </li>
                              <li> <a class="dropdown-item" href="blog-single-minimal.html">Single Minimal</a> </li>
                           </ul>
                        </li>
                     </ul>
                  </li>
                  <!-- Menu item 3 Pages-->
                  <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="pagesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">독서모임</a>
                     <ul class="dropdown-menu" aria-labelledby="pagesMenu">
                        <li> <a class="dropdown-item" href="/meeting?command=meetingList">독서모임</a></li>
                        <li> <a class="dropdown-item" href="about-advance.html">About Advance</a> </li>
                        <li> <a class="dropdown-item" href="service.html">Service</a> </li>
                        <li> <a class="dropdown-item" href="contact.html">Contact</a> </li>
                        <li> <a class="dropdown-item" href="team.html">Team</a> </li>
                        <li> <a class="dropdown-item" href="careers.html">Careers</a> </li>
                        <li> <a class="dropdown-item" href="careers-single.html">Careers single</a> </li>
                        <li class="dropdown-submenu">
                           <a class="dropdown-item dropdown-toggle" href="#">Login & Signup</a>
                           <ul class="dropdown-menu">
                              <li> <a class="dropdown-item" href="sign-in.html">Sign in</a> </li>
                              <li> <a class="dropdown-item" href="sign-up.html">Sign up</a> </li>
                              <li> <a class="dropdown-item" href="password-recovery.html">Password recovery</a> </li>
                           </ul>
                        </li>
                        <li> <a class="dropdown-item" href="pricing.html">Pricing</a> </li>
                        <li> <a class="dropdown-item" href="timeline.html">Timeline</a> </li>
                        <li> <a class="dropdown-item" href="faq.html">FAQs</a> </li>
                        <li> <a class="dropdown-item" href="maintenance-mode.html">Maintenance mode</a> </li>
                        <li> <a class="dropdown-item" href="error-404.html">Error 404</a> </li>
                     </ul>
                  </li>
                  <!-- Menu item 4 Portfolio-->
                  <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="portfolioMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">소통의 장</a>
                     <ul class="dropdown-menu" aria-labelledby="portfolioMenu">
                        <li> <a class="dropdown-item" href="/notice?command=noticeListFormAction">공지사항</a> </li>
                        <li> <a class="dropdown-item" href="/report?command=Report_List">독후감</a> </li>
                        
                        <!-- 관리자로 로그인을 했을 시 이달의 책 등록-->
                        <c:if test = "${LoginUser.authority eq 3}">
                  <li><a class="dropdown-item" href="/book?command=adminTodayBookList">이달의 책</a></li>
                  </c:if>      
                  
                              <!-- 사용자로 로그인을 했을 시 이달의 책 등록-->
                              <c:if test = "${LoginUser.authority ne 3}">
                  <li><a class="dropdown-item" href="/book?command=todayBookList">이달의 책</a></li>
                  </c:if>
                        <li> <a class="dropdown-item" href="/book?command=bookList">책등록</a> </li>
                        <li> <a class="dropdown-item" href="portfolio-grid-column-6.html">Portfolio Column 6</a> </li>
                        <li> <a class="dropdown-item" href="portfolio-single.html">Portfolio Single</a> </li>
                        <li> <a class="dropdown-item" href="portfolio-single-02.html">Portfolio Single 2</a> </li>
                        <li> <a class="dropdown-item" href="portfolio-case-studies.html">Portfolio case studies <span class="badge badge-success ml-2">Hot</span></a> </li>
                     </ul>
                  </li>
                  <!-- Menu item 5 Elements-->
                  <li class="nav-item dropdown megamenu">
                     <a class="nav-link dropdown-toggle" href="#" id="elementsMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">후원하기</a>
                     <div class="dropdown-menu" aria-labelledby="elementsMenu" style="background-image:url(assets/images/menu-bg.jpg); background-position: right bottom; background-repeat: no-repeat;">
                        <div class="container">
                           <div class="row">
                              <div class="col-sm-6 col-lg-3">
                                 <ul class="list-unstyled">
                                    <li> <a class="dropdown-item" href="elements-accordion.html">Accordion</a> </li>
                                    <li> <a class="dropdown-item" href="elements-action-box.html">Action box</a> </li>
                                    <li> <a class="dropdown-item" href="elements-alerts.html">Alerts</a> </li>
                                    <li> <a class="dropdown-item" href="elements-animated-headlines.html">Animated Headlines</a> </li>
                                    <li> <a class="dropdown-item" href="elements-blockquote.html">Blockquote</a> </li>
                                    <li> <a class="dropdown-item" href="elements-buttons.html">Buttons</a> </li>
                                 </ul>
                              </div>
                              <div class="col-sm-6 col-lg-3">
                                 <ul class="list-unstyled">
                                    <li> <a class="dropdown-item" href="elements-clients.html">Clients</a> </li>
                                    <li> <a class="dropdown-item" href="elements-counter.html">Counter</a> </li>
                                    <li> <a class="dropdown-item" href="elements-divider.html">Divider</a> </li>
                                    <li> <a class="dropdown-item" href="elements-feature-box.html">Feature box</a> </li>
                                    <li> <a class="dropdown-item" href="elements-forms.html">Forms</a> </li>
                                    <li> <a class="dropdown-item" href="elements-grid.html">Grid</a> </li>
                                 </ul>
                              </div>
                              <div class="col-sm-6 col-lg-3">
                                 <ul class="list-unstyled">
                                    <li> <a class="dropdown-item" href="elements-list-styles.html">list styles</a> </li>
                                    <li> <a class="dropdown-item" href="elements-map.html">Map</a> </li>
                                    <li> <a class="dropdown-item" href="elements-modal.html">Modal</a> </li>
                                    <li> <a class="dropdown-item" href="elements-skill.html">skill</a> </li>
                                    <li> <a class="dropdown-item" href="elements-social-icon.html">social icon</a> </li>
                                    <li> <a class="dropdown-item" href="elements-tab.html">Tab</a> </li>
                                 </ul>
                              </div>
                              <div class="col-sm-6 col-lg-3">
                                 <ul class="list-unstyled">
                                    <li> <a class="dropdown-item" href="elements-table.html">Table</a> </li>
                                    <li> <a class="dropdown-item" href="elements-team.html">Team</a> </li>
                                    <li> <a class="dropdown-item" href="elements-typography.html">Typography</a> </li>
                                    <li> <a class="dropdown-item" href="elements-video.html">Video</a> </li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                  </li>
                  <!-- Menu item 6 Docs-->
                  <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="docMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Docs</a>
                     <ul class="dropdown-menu" aria-labelledby="docMenu">
                        <li> <a class="dropdown-item" href="https://wizixo.webestica.com/documentation/">Introduction</a> </li>
                        <li> <a class="dropdown-item" href="https://wizixo.webestica.com/documentation/#getting-started-section">Directory structure</a> </li>
                        <li> <a class="dropdown-item" href="https://wizixo.webestica.com/documentation/#installation-section">Gulp</a> </li>
                        <li> <a class="dropdown-item" href="https://wizixo.webestica.com/documentation/#edit-section">Customization</a> </li>
                        <li> <a class="dropdown-item" href="https://wizixo.webestica.com/documentation/#faqs">FAQs</a> </li>
                        <li class="dropdown-divider"></li>
                        <li> <a class="dropdown-item" href="http://support.webestica.com/" target="_blank">Support</a> </li>
                     </ul>
                  </li>
               </ul>
            </div>
            <!-- Main Menu End -->
            <!-- Header Extras Start-->
            <div class="navbar-nav">
               <!-- extra item Search-->
               <div class="nav-item search border-0 pl-3 pr-0 px-lg-2" id="search">
                  <a class="nav-link" data-toggle="collapse" href="#search-open"><i class="ti-search"> </i></a>
               </div>
               <!-- extra item Btn-->
               <div class="nav-item border-0 d-none d-lg-inline-block align-self-center">
                  <a href="#" class=" btn btn-sm btn-grad text-white mb-0">Buy Now!</a>
               </div>
            </div>
            <!-- Header Extras End-->
         </div>
      </nav>
      <!-- Logo Nav End -->
   </header>
   <!-- =======================
   header End-->
   </body>
   </html>