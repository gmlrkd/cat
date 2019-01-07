<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reviewUpdateBtn").click(function() {
			if (!chkSubmit($('#r_title'), "제목을"))
				return;
			else if (!chkSubmit($('#r_content'), "작성할 내용을"))
				return;
			else {
				$("#r_writeForm").attr({
					"method" : "post",
					"action" : "/review/reviewUpdate"
				});
				$("#r_writeForm").submit();
			}
		});
		$("#reviewListBtn").click(function() {
			location.href = "/review/reviewList";
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>리뷰 게시판 글수정</h3>
		</div>
		<div class="contentTB">
			<form id="r_writeForm" name="r_writeForm">
				<input type="hidden" id="r_number" name="r_number"
					value="${updateData.r_number }" />
				<table>
					<colgroup>
						<col width="17%">
						<col width="33%">
						<col width="17%">
						<col width="33%">
					</colgroup>
					<tbody>
						<tr>
							<td>글번호</td>
							<td>${updateData.r_number }</td>
							<td>작성일</td>
							<td>${updateData.r_date }</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>${updateData.m_number}</td>
						</tr>
						<tr>
							<td>글제목</td>
							<td><input type="text" name="r_title" id="r_title"
								value="${updateData.r_title }" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="r_content" id="r_content">${updateDta.r_content }</textarea></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="contentBtn">
			<input type="button" value="수정" id="reviewUpdateBtn"> <input
				type="button" value="목록" id="reviewListBtn">
		</div>
	</div>
</body>
</html>