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
	
   window.opener.document.frm.bookNum.value = booknum;
   window.opener.document.frm.bookTitle.value = bookTitle;
   window.opener.document.frm.writer.value = writer;
   window.opener.document.frm.publisher.value = publisher; 
   
   
   self.close();
   
}

</script>   
</body>
</html>