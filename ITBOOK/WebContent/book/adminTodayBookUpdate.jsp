<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>
<html lang="en">
<head>
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
<script type="text/javascript" src ="/js/todayBook.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

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
              <h1 class="innerpage-title">이달의 책</h1>
					<h6 class="subtitle">희망의 책에서 추천하는 이달의 책입니다.</h6>
               <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                     <li class="breadcrumb-item active"><a href="/main?command=loginForm"><i
                           class="ti-home"></i>Home</a></li>
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
	<form name ="frm" method ="post" action="book?command=adminTodayBookUpdate" enctype="multipart/form-data">
               <div class="form-group">
               <input type="hidden" name="bookNum" value="${todayBookList.bookNum}">
               <input type="hidden" name="bookBrdNum" value="${todayBookList.bookBrdNum}">
               
                  <label>이달의 책제목</label> <input class="form-control" type="text" value = "${todayBookList.bookBrdTitle}" name ="bookBrdTitle"
                     placeholder="* 이달의 책 제목을 입력하세요.">
               </div>
               
               <div class="form-group">
                     <label>책 제목 찾기</label>
                     <div class="row">
                           
                        
                        <div class="col-md-4 col-xs-4">
                        
                        
                         <!-- id="keyword" -->
                           <button type="button" class="form-control"
                              onclick="openPopUp()">제목이나 키워드
                        </button>
                     </div>
                     
					</div>
               </div>
               
               
               
            <div class="form-group">
                  <label>책제목</label> <input class="form-control" type="text" value="${todayBookList.bookTitle}" name ="bookTitle"
                     placeholder="* 책제목을 입력하세요.">
               </div>
               
               <div class="form-group">
                  <label>저자</label> <input class="form-control" type="text" value = "${todayBookList.writer}" name ="writer"
                     placeholder="* 저자를 입력하세요.">
               </div>
               <div class="form-group">
                  <label>출판사</label> <input class="form-control" type="text" value = "${todayBookList.publisher}" name ="publisher"
                     placeholder="* 출판사를 입력하세요.">
               </div>
               
               
               <div class="form-group">
                  <label>내용</label>
                  <textarea class="form-control" rows="10"  name ="bookBrdContent" 
                     placeholder="내용을 입력하세요.">${todayBookList.bookBrdContent}</textarea>
               </div>
         		
         		
         		

				<div class="form-group">
                  <label>기존 파일</label> <input class="form-control" type="text" value = "${todayBookList.imgPath}" name ="imgPath" readonly="readonly">
               	</div>
         		
         		 <!-- 업로드 시작-->
               <div class="form-group">
					 <input type="file" class="form-control-file" name ="new_imgPath" value ="">                  
              	 </div>
               	<!--업로드 끝  -->
               
               
                 <input type="submit" class="btn btn-grad" onclick="return todayBookCheck()" value="수정">
                 
                 <%--  <button type="button"  class="btn btn-grad" id="delete" onclick="location.href='book?command=adminTodayBookDelete&bookBrdNum=${todayBookList.bookBrdNum}'" >
                 삭제</button> --%>
                  <button type="button"  class="btn btn-grad" id="delete">
                 삭제</button>
                  	<button type = "button" class="btn btn-grad" id="cancel">취소</button>
					</form>
                  
            </div>
            
         </div>
         
      </div>
   </section>
 <script>
   function openPopUp() {
      // window.name = "부모창 이름"; 
      window.name = "parentForm";
      // window.open("open할 window", "자식창 이름", "팝업창 옵션");
      var width = "650";
      var height = "300";
      var top = (window.screen.height - height) / 2;
      var left = (window.screen.width - width) / 2;
      var url = "../book/bookSearch.jsp";
      var title = "책";
      var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width="
            + width + ",height=" + height + ",top=" + top + ",left=" + left;

      window.open(url, title, status);
   }
   
 	
 	$(document).ready(
 		      function() {
 		         $('#cancel').on("click",function(event) {
 		                  self.location = "book?command=adminTodayBookList";
 		               });
 		         $('#delete').on("click", function(evt) {
 		            
 		            var confirmStat = confirm("삭제하시겠습니까?");
 		            
 		            if(confirmStat == true){
 		               var bookBrdNum = $('#bookBrdNum').val();
 		               alert("삭제되었습니다.");
 		               self.location = "book?command=adminTodayBookDelete&bookBrdNum=${todayBookList.bookBrdNum}";   
 		            } else{
 		               return false;
 		            }
 		            
 		         });
 		         
 		         $('.Message').on("click", function(event){
 		            
 		         });
 		      });
 	
   
   $(document).ready(function(){
		$('form').submit(function(){
	 	  var result = alert("수정되었습니다.");
	   
		   return result;
		})
		})
</script> 

   <%@ include file="../include/footer.jsp"%>
</body>
</html>