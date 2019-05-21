
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
   <!--    <div class="preloader">
      <img src="../assets/images/preloader.svg" alt="Pre-loader">
   </div>  -->
   <header>
      <%@ include file="../include/header.jsp"%>
   </header>

   <!-- <div class="left bg-dark-grad pattern-overlay-1">
      <div class="container">
         <div class="row all-text-white">
            <div class="col-md-12 align-self-center">
             <h1 class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n4 mt-9">희망의 책 독후감</h1> 
               
            </div>
         </div>
      </div>
   </div>  -->

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
   <!-- =======================
   Banner innerpage -->

   <section>
      <div class="container">
         <div class="row">
            <div class="col-md-6">
	<form name ="frm" method ="post" action="book?command=adminTodayBookRegister">
               <div class="form-group">
                  <label>책제목</label> <input class="form-control" type="text" name = ""
                     placeholder="* 책 제목을 입력하세요.">
               </div>
               <div class="form-group">
                  <label>저자</label> <input class="form-control" type="text" name = ""
                     placeholder="* 저자를 입력하세요.">
               </div>
               <div class="form-group">
                  <label>출판사</label> <input class="form-control" type="text" name = ""
                     placeholder="* 출판사를 입력하세요.">
               </div>
               
               <div class="custom-file">
                  <label>Upload Book</label><input type="file" class="custom-file-input" id="inputGroupFile01" name = "">
								<label class="custom-file-label" for="inputGroupFile01">Upload Book</label>
               </div>
               
               
               <div class="form-group">
                  <label>내용</label>
                  <textarea class="form-control" rows="10" name = ""
                     placeholder="내용을 입력하세요."></textarea>
               </div>
         </form>      
         
               <button type ="submit" class ="btn btn-success" ><i class="fa fa-check-circle-o"></i>수정</button>
               
               <button type = "button" class="btn btn-warning" onclick="location.href='book?command=adminTodayBookList'">
               <i class="fa  fa-close"></i>취소</button>
            </div>
            
         </div>
         
      </div>
   </section>


   <%@ include file="../include/footer.jsp"%>
</body>
</html>