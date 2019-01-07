<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
//전체목록 보기 버튼 클릭시 상세보기 페이지로 이동
$(document).ready(function() {
	$("#goToList").click(function() {
		location.href="/faqboard/faqboardlist";
	});
 	
});
</script>
</head>
<body>
<h2>FAQ게시물 상세보기</h2>
<table>
	<tr>
		<td>글번호</td>
		<td>${ detail.f_number }</td>
	</tr>

	<tr>
		<td>작성자</td>
		<td>ID</td>
	</tr>
	
	<tr>
		<td>글내용</td>
		<td>${ detail.f_content }</td>
	</tr>
	
	<tr>
		<td>첨부 이미지</td>
	</tr>
	
	<tr>
		<td>작성일</td>
		<td><fmt:formatDate value="${ detail.f_date }" pattern="yyyy/MM/dd" /></td>
	</tr>

</table>
<div>
	<!-- <input type="button" value="이전글" class="btn btn-default" id="pre" /> -->
	<input type="button" value="전체목록보기" class="btn btn-default" id="goToList" />        
	<!-- <input type="button" value="다음글" class="btn btn-default" id="next" />         -->
</div>


</body>
</html>