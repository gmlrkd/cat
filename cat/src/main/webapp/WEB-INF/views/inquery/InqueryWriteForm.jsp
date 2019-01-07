<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의하기</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script>
	$(document).ready(function() {
		
		$("#cancelBtn").on("click", function() {
			if(confirm("취소하시겠습니까?")){
				window.location.href = "/inquery/InqueryList?m_number=<%=session.getAttribute("m_number")%>";				
			}
		});
		
		/* $("#writeBtn").click(function(){
			var i_title = $("#i_title").val();
			var i_content = $("#i_content").val();
			if(i_title ==""){
				alert("제목을 입력하세요");
				document.insertForm.i_title.focus();
				return;
			}
			if(i_content==""){
				alert("내용을 입력하세요");
				document.insertForm.i_content.focus();
				return;
			}
		}); */
	});
	
	
</script>
</head>
<body>
	<%
		int m_number = (Integer) session.getAttribute("m_number");
	%>
	<h3>1:1문의</h3>
	<form id="insertForm" enctype="multipart/form-data"
		action="/inquery/Inqueryinsert" method="post">
		<%-- <input type="text" id="m_number" name="m_number" value="<%= out.print(m_number) %>"/> --%>
		<table>
			<tr>
				<td class="ac">작성자</td>
				<td><%=session.getAttribute("m_id")%> <input type="hidden"
					name="m_number" value="<%=m_number%>"></td>

			</tr>
			<tr>
				<td class="ac">글제목</td>
				<td><input type="text" name="i_title" id="i_title"></td>
			</tr>
			<tr>
				<td class="ac vm">내용</td>
				<td><textarea name="i_content" id="i_content"></textarea></td>
			</tr>

			<tr>
				<td class="ac">파일첨부</td>
				<td><input type="file" name="file" id="file"></td>
			</tr>
			<tr>
				<td><input type="button" value="취소하기" id="cancelBtn">
				<td><input type="submit" value="문의하기" id="writeBtn">
			</tr>
		</table>
	</form>
</body>
</html>