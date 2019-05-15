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
					<h3 class="box-title">회원정보 관리</h3>
				</div>
				<form name = "frm" method = "post" action = "email?command=senderEmail&email=${MemberVO.email}">
				<div class="box-body">

<div> 

 <table class="table table-bordered" id="user-table">
	<thead>
	<tr><th colspan="5" style = "text-align: center;">회원정보</th></tr>
	<tr>
	    <th style="width: 10px; text-align:center;"><input type = "checkbox" name = "AllCheck" ></th>
		<th style="width: 100px; text-align: center;">아이디</th>
		<th style="width: 100px;text-align: center;">이름</th>
		<th style="width: 100px;text-align: center;">이메일</th>
		<th style="width: 50px;text-align: center;">회원등급</th>
	</tr>
	</thead>

<c:forEach items="${memberList}" var="MemberVO">
	<tbody >
	<tr style ="text-align:center;">
		<td><input type ="checkbox" value="${MemberVO.email}" name="email" ></td>
		<td>${MemberVO.memId}</td>
		<td>${MemberVO.memName}</td>
		<td>${MemberVO.email}</td>
 		<c:if test = "${MemberVO.authority eq '1'}"><td>일반회원</td></c:if>	
		<c:if test = "${MemberVO.authority eq '2'}"><td>기부회원</td></c:if>
		<c:if test = "${MemberVO.authority eq '3'}"><td>관리자</td></c:if> 
		
	</tr>
	</tbody>
</c:forEach>
</table> 
</div>
		    <button type = "submit" class="btn btn-danger" style = "float : right">메일전송</button> 
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
 $("input[name=AllCheck]").click(function(){
	var chk = $(this).is(":checked");
	
	if(chk){
		$("input[name='eamil']").prop("checked", true);
	} else{
		$("input[name='eamil']").prop("checked", false);
	}
}); 
    
    </script>

<%@include file="../include/adminfooter.jsp"%>