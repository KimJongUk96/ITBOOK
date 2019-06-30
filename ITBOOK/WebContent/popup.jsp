<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="js/member.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>아아디 중복확인</title>

<!-- css include -->
<link rel="stylesheet" type="text/css" href="css/materialize.css">
<link rel="stylesheet" type="text/css" href="css/icofont.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
<link rel="stylesheet" type="text/css"
	href="css/owl.theme.default.min.css">

<!-- my css include -->
<link rel="stylesheet" type="text/css" href="css/custom-menu.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">

</head>
<body>
	<h3>아이디 중복체크</h3>
	<section id="error-section" class="error-section w100dt mb-50">

		<div class="container">
			<form name="frm" method="post" action="member?command=memberIdCheck">
				 <table class="bordered">
					<%-- <tr>
							<th>아이디 </th>
							<td><input type="text" name="memId" value="${memId}"></td>
							<td><button type="submit" class="btn">중복체크</button></td>
					</tr> --%>
					<div>
						<span class="form-group"><input type="text" name="memId" id="memId"
							value="${memId}" class="input" placeholder="아이디를 입력해주세요."
							style="height: 30px" onkeyup="characterCheck()" onkeydown="characterCheck()"></span>
						<button type="submit" class="btn btn-dark" style="height: 30px">중복확인</button>
					</div>
					<c:if test="${result == 1}">
						<tr>
							<td></td>
							<td colspan="3" align="center">중복된 아이디입니다.</td>
							<td></td>
						</tr>
					</c:if>
					<c:if test="${result == -1}">
						<tr>
							<td></td>
							<td>사용 가능한 아이디입니다.</td>
							<td><input type="button" class="btn" value="확인"
								onclick="sendToParent()"></td>
						</tr>
					</c:if>
			</table>
			</form>
		</div>
		<!-- container -->
	</section>
	<!-- /#error-section -->
	<!-- ==================== error-section end ==================== -->





	<!-- ==================== instag leftram-section Start ==================== -->
	<!--   <section id="instagram-section" class="instagram-section w100dt">

			<div class="instagram-link w100dt">
				<a href="#">
					<span>FIND US ON INSTAGRAM</span>
					@SUJONMAJIDESIGN
				</a>
			</div>

		</section> -->
	<!-- /#instag leftram-section -->
	<!-- ==================== instag leftram-section End ==================== -->

	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.js"></script>
	<script type="text/javascript" src="js/owl.carousel.min.js"></script>

	<!-- my custom js -->
	<script type="text/javascript" src="js/custom.js"></script>

	<script type="text/javascript">
	</script>
</body>
</html>