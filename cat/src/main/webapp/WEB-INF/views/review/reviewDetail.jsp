<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var r_number = "<c:out value='${reviewDetail.r_number}'/>";
						//수정 버튼 클릭시 처리 이벤트
						$("#updateFormBtn")
								.click(
										function() {
											location.href = "/review/updateForm?r_number=${reviewDetail.r_number}";
										});

						$("#reviewDeleteBtn")
								.click(
										function() {
											location.href = "/review/reviewDelete?r_number=${reviewDetail.r_number}";
										});

						$("#reviewListBtn").click(function() {
							location.href = "/review/reviewList";
						});
					});
</script>
</head>
<body>
<%
		int m_number = (Integer) session.getAttribute("m_number");
	%>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>리뷰 상세보기</h3>
		</div>
		<form name="r_data" id="r_data" method="POST">
			<input type="hidden" name="r_number" value="${detail.r_number }" />
		</form>

		<%-- review 상세정보 보여주기 --%>
		<div class="contentTB">
			<table>
				<tbody>
					<tr>
						<td>작성자</td>
						<td class="name"><%=session.getAttribute("m_name")%><input
										type="hidden" name="m_number" value="<%=m_number%>"></td>
						<td>작성일</td>
						<td>${reviewDetail.r_date }</td>
					</tr>
					<tr>
						<td>제목</td>
						<td>${reviewDetail.r_title}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>${reviewDetail.r_content}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<table class="btn">
			<tr>
				<td id="btd"><input type="button" value="수정" id="updateFormBtn">
					<input type="button" value="삭제" id="reviewDeleteBtn"> <input
					type="button" value="목록" id="reviewListBtn"></td>
			</tr>
		</table>

	</div>
</body>
</html>