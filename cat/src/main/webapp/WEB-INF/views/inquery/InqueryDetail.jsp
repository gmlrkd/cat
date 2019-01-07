<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의 상세보기</title>
</head>
<body>
	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var i_number = "<c:out value='${ inqueryDetail.i_number }' />";
							$("#iModBtn").click(function() {
												location.href = "/inquery/InqueryUpdateForm?i_number=${inqueryDetail.i_number}";
											});
							$("#iDelBtn").click(function() {
												location.href = "/inquery/InqueryDelete?i_number=${inqueryDetail.i_number}";
											});
							$("#back").click(function() {
								location.href = "/inquery/InqueryList?m_number=<%=session.getAttribute("m_number")%>";
							});
						});
	</script>
	<h3>1:1문의 상세보기</h3>
	<hr />
	<table>
		<tr>
			<td>작성자</td>
			<td>${ inqueryDetail.m_number }</td>
			<td>작성일</td>
			<td>${ inqueryDetail.i_date }</td>
		</tr>

		<tr>
			<td>글 제목</td>
			<td colspan="3">${ inqueryDetail.i_title }</td>
		</tr>

		<tr>
			<td>글 내용</td>
			<td colspan="3">${ inqueryDetail.i_content }</td>
		</tr>
		<tr>
			<td colspan="4" id="btn1">
		</tr>
	</table>

	<c:choose>
		<c:when test="${ inqueryDetail.i_whether == 'X' }">
			<input type="button" id="iModBtn" value="수정" />
			<input type="button" id="iDelBtn" value="삭제" />
			<input type="button" id="back" value="목록" />
		</c:when>
	</c:choose>
</body>
</html>