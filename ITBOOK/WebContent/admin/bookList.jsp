<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/adminheader.jsp"%>

<!-- Main content -->


<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

				
			
			<div class="box" >
			
				<div class="box-header with-border">
					<h3 class="box-title">등록 책 관리</h3>
				</div>
				<form name = "frm" method = "post" action = "admin?command=bookDelete">
				<div class="box-body">

<div>

 <table class="table table-bordered" id="user-table">
	<thead>
	<tr><th colspan="5" style = "text-align: center;">등록된 책</th></tr>
	<tr>
	    <th style="width: 10px; text-align:center;"><input type = "checkbox" name = "AllCheck" ></th>
		<th style="width: 100px; text-align: center;">번호</th>
		<th style="width: 100px; text-align: center;">제목</th>
		<th style="width: 100px; text-align: center;">키워드</th>
		<th style="width: 100px;text-align: center;">저자</th>
		<th style="width: 100px;text-align: center;">출판사</th>
		<th style="width: 50px;text-align: center;">책등록자</th>
	</tr>
	</thead>

<c:forEach var="bookList" items="${bookList}">
                        <tr>
                           <th scope = "row"><a href="admin?command=bookUpdateFormAction&bookNum=${bookList.bookNum}">${bookList.bookNum}</a></th>
                           <td>${bookList.bookTitle}</td>
                           <td>${bookList.bookKeyword1}, ${bookList.bookKeyword2}, ${bookList.bookKeyword3}</td>
                           <td>${bookList.writer}</td>
                           <td>${bookList.publisher}</td>
                           <td>${bookList.memNum}</td>
                        </tr>
     				</c:forEach>
</table> 
</div>
		    <button type = "submit" class="btn btn-danger" style = "float : right">삭제</button> 
			<a class="btn btn-primary" href="admin?command=bookRegFormAction">책 등록</a>	
</div>
</form>
			</div>

		
			</div>
			
			
		</div> 
		<!--/.col (left) -->

	
	<!-- /.row -->
</section>
<!-- /.content -->
<!-- </div> -->
<!-- /.content-wrapper -->

<script>
// 올체크
 $("input[name=essAllCheck]").click(function(){
	var chk = $(this).is(":checked");
	
	if(chk){
		$("input[name='essSubId']").prop("checked", true);
	} else{
		$("input[name='essSubId']").prop("checked", false);
	}
}); 
    
    </script>

<%@include file="../include/adminfooter.jsp"%>