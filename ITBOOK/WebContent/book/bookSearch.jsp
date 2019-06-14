<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
   <title>책 검색</title>
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

   <!-- =======================
   Banner innerpage -->
  <!--  <div class="innerpage-banner center bg-overlay-dark-7 py-7"
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
   </div> -->
   <!-- =======================
   Banner innerpage -->
   <section>
      <div class="container">
         <div class="row">
            <div class="col-sm-12 mb-5">
               <div class="table-responsive-sm" id ="searchForm">
               <form name="frm" action="/book?command=bookListSearch" method="post">
            
            <select name="opt">
                <option value="0">제목</option>
                <option value="2">ISBN</option>
                <option value="1">키워드</option>
                
            </select>
            
            <input type="text" size="20" name="condition"/>
            <input type="submit" value="검색"/>
        	
                  <table class="table table-hover">
                     <thead>
                        <tr>
                           <th scope="col">제목</th>
                           <th scope="col">ISBN</th>
                         <th scope="col">키워드</th>
                         <th scope="col">저자</th>
                          <th scope="col">출판사</th>
                         
                          
                        </tr>
                        
                        
                     </thead>
                     
                     <tbody>
                     <c:forEach var="bookList" items="${bookList}">
                       
                     <%--    <!--id를 통해서 부모창으로 넘겨줌. -->
                        <input type="hidden" name="bookNum" id="bookNum" value="${bookList.bookNum}">
                        <input type="hidden" name="bookTitle" id="bookTitle" value="${bookList.bookTitle}">
                        <input type="hidden" name="writer" id="writer" value="${bookList.writer}">
                        <input type="hidden" name="publisher" id="publisher" value="${bookList.publisher}">
                        --%>
                        
                        <tr>
                        
                            <th scope = "row" onclick="sendToParent('${bookList.bookNum}', '${bookList.bookTitle}','${bookList.writer}','${bookList.publisher}')"><a href ="">${bookList.bookTitle}</a></th>

						   <td>${bookList.isbn}</td>
                           <td>${bookList.bookKeyword1}, ${bookList.bookKeyword2}, ${bookList.bookKeyword3}</td>
                           <td>${bookList.writer}</td>
                           <td>${bookList.publisher}</td>
                         
                        </tr>
                 </c:forEach>
                     </tbody>
                  </table>
           </form>
               </div>
            </div>
         </div>
         
   		<!-- 			<div align="right">
                  <a class="btn btn-primary" onclick="javascript:opener.location.href='/book?command=bookRegFormAction';self.close();"></a>
                  </div> -->
                  
                  <div align="right">
                  <button class="btn btn-primary" onclick="javascript:opener.location.href='/book?command=bookRegFormAction';self.close();">등록</button>
                  </div>
                  
      </div>
   </section>
   
   
   
<script type="text/javascript">
function sendToParent(booknum, bookTitle, writer, publisher){
	
	
//	alert(booknum + bookTitle + writer + publisher);

/*    window.opener.document.frm.bookNum.value = document.frm.bookNum.value;
   window.opener.document.frm.bookTitle.value = document.frm.bookTitle.value;
   window.opener.document.frm.writer.value = document.frm.writer.value;
   window.opener.document.frm.publisher.value = document.frm.publisher.value;  */
   
   
   window.opener.document.frm.bookNum.value = booknum;
   window.opener.document.frm.bookTitle.value = bookTitle;
   window.opener.document.frm.writer.value = writer;
   window.opener.document.frm.publisher.value = publisher; 
   
   
   self.close();
   
}

</script>   
</body>
</html>