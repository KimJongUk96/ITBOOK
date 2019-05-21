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
					<h3 class="box-title">공지사항 관리</h3>
				</div>
				<form name = "frm" method = "post" action = "admin?command=noticeListForm">
				<div class="box-body">

<div>

 <table class="table table-bordered" id="user-table">
	<thead>
	<tr><th colspan="5" style = "text-align: center;">공지사항 목록</th></tr>
	<tr>
	    <th style="width: 10px; text-align:center;"><input type = "checkbox" name = "AllCheck" ></th>
		<th style="width: 100px; text-align: center;">제목</th>
		<th style="width: 100px;text-align: center;">작성자</th>
		<th style="width: 100px;text-align: center;">작성일자</th>
		<!-- <th style="width: 50px;text-align: center;">회원등급</th> -->
	</tr>
	</thead>

<c:forEach items="${noticeList}" var="NoticeVO">
	<tbody >
	<tr style ="text-align:center;">
		<td><input type ="checkbox" value="${NoticeVO.noticeNum}" name="noticeNum" ></td>
		<td>${NoticeVO.noticeTitle}</td>
		<td><%-- ${NoticeVO.notice} --%>관리자</td>
		<td>${NoticeVO.noticeDate}</td>
		
	</tr>
	</tbody>
</c:forEach>
</table> 
</div>
		    <button type = "submit" class="btn btn-danger" style = "float : right">삭제</button> 
			<button type="button" class="btn btn-primary" style = "float : right">신규등록</button>	
</div>
			</form>
			</div>

		
			</div>
			
			
		</div> 
		<!--/.col (left) -->

	
	<!-- /.row -->
</section>
<section class="pt-0">
<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<nav>
				<ul class="pagination justify-content-center">
				<c:if test="${paging.pageNum > 1}">
					<li class="page-item"><a class ="page-link" href="/notice?command=noticeListForm&pageNum=${paging.pageNum - 1}">Prev</a></li>
				
					
				</c:if>	
					<c:forEach begin="${paging.firstPage}"
                               end="${paging.lastPage}" var="idx">
                               
                               <c:choose>
                                  <c:when test="${idx == paging.pageNum}">
                                     <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                  </c:when>
               
                                  <c:otherwise>
                                     <li class="page-item"><a class ="page-link"
                                        href="/notice?command=noticeListForm&pageNum=${idx}">${idx}</a></li>
                                  </c:otherwise>
                                  
                               </c:choose>
                            </c:forEach>
				
					<c:if test="${paging.numOfPage != paging.pageNum}">
                            <li class="page-item"><a class = "page-link" href="/notice?command=noticeListForm&pageNum=${paging.pageNum + 1}">Next</a></li>   
                            </c:if>
					

				</ul>
			</nav>
		</div>
	</div>
</div>
</section>
<!-- /.content -->
<!-- </div> -->
<!-- /.content-wrapper -->

<script>

// 올체크
 $("input[name=AllCheck]").click(function(){
	var chk = $(this).is(":checked");
	
	if(chk){
		$("input[name='memNum']").prop("checked", true);
	} else{
		$("input[name='memNum']").prop("checked", false);
	}
}); 
    
    </script>

<%@include file="../include/adminfooter.jsp"%>