<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
   <title>책 조회</title>
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
               <h1 class="innerpage-title">책 검색</h1>
               <h6 class="subtitle">희망의 책 대전본부</h6>
               <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                     <li class="breadcrumb-item active"><a href="index.html"><i
                           class="ti-home"></i>Main</a></li>
                     <li class="breadcrumb-item">책 검색</li>
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
            <div class="col-sm-12 mb-5">
               <h5 class="text-center mb-4">마음의 양식</h5> 
               <div class="table-responsive-sm" id ="searchForm">
               <form name="frm" action="/book?command=bookListSearch" method="post">
            
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">키워드</option>
            </select>
            
            <input type="text" size="20" name="condition"/>
            <input type="submit" value="검색"/>
        </form>
        
                  <table class="table table-hover">
                     <thead>
                        <tr>
                           <th scope="col">번호</th>
                           <th scope="col">제목</th>
                         <th scope="col">키워드</th>
                         <th scope="col">저자</th>
                          <th scope="col">출판사</th>
                          
                        </tr>
                     </thead>
                     
                     <tbody>
                     <c:forEach var="bookList" items="${bookList}">
                        <tr>
                           <td>${bookList.bookNum}</td>
                           <th scope = "row"><a href="book?command=bookUpdateFormAction&bookNum=${bookList.bookTitle}">${bookList.bookTitle}</a></th>
                           <td>${bookList.bookKeyword1}, ${bookList.bookKeyword2}, ${bookList.bookKeyword3}</td>
                           <td>${bookList.writer}</td>
                           <td>${bookList.publisher}</td>
                        </tr>
     				</c:forEach>
                     </tbody>
                  </table>
               </div>
            </div>
         </div>
      </div>
   </section>
   
   <%@ include file="../include/footer.jsp"%>
</body>
</html>