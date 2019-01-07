<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function() {
	//필수입력 사항입력후 저장버튼 클릭시 글목록 이동		
	$("#boastInsertBtn").click(function() {
		$("#writeForm").attr({
				"method":"POST",
				"action":"/boast/boastInsert"
		});	
		$("#writeForm").submit();
	});
	//목록버튼 클릭시 글목록 으로 이동
	$("#boastBtn").click(function() {
		location.href="/boast/boardList";
	});
});
</script>
</head>
<body>
	<div class="contentContainer">
			<div class="contentTit"><h3>꿀팁공유/자랑 글작성</h3></div>
				<div class="contentTB">
				<form id="writeForm" name="writeForm" enctype="multipart/form-data">
					<input type="hidden" id="m_number" name="m_number" value="1" />
					<table id="boastWrite">
						<tr>
							<td class="er">제목</td>
							<td><input type="text" name="b_title" id="b_title"></td>
						</tr>
						<tr>
							<td class="ac"><!-- 작성자 --></td>
							<td><!-- <input type="text" name="b_name" id="b_name"> --> 
							<select id="b_division" name="b_division">
								<option value="infomation">꿀팁공유</option>
								<option value="lad">반려묘자랑</option>
							</select> 
						</td>
						</tr>
						<tr>
							<td class="ac vm">내용</td>
							<td><textarea name="b_content" id="b_content"></textarea></td>
						</tr>
						<tr>
							<td class="ac">사진삽입</td>
							<td><input type="file" name="file" id="file"></td>
							<td><input type="button" value="목록보기" class="goToListBtn" id="boastBtn"></td>
							<td><input type="button" value="저장" class="goToListBtn" id="boastInsertBtn"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>