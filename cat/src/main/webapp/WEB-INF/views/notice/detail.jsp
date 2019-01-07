<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/include/css/noticeDetail.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wapper">
	<div id="detailContainer">
		<div><h3>공지글 상세보기</h3></div>
			<input type="hidden" name="n_number" value="${nvo.n_number}" />
		<!-- 상세 정보 보여주기 -->
		<div>
			<table>
				<tbody>
					<tr>
						<td><strong>제목</strong></td>
						<td>${nvo.n_title}</td>
					</tr>
					<tr>
						<td>등록일&nbsp;&nbsp;</td>
						<td>${nvo.n_date}</td>
					</tr>
					<tr>
						<td>작성자&nbsp;&nbsp;</td>
						<td>운영자</td>
					</tr>
				</tbody>
			</table>
			<div></div>
			<div id="content">${nvo.n_content}</div>
		</div>
		<div>
			<button id="catcareListBtn" onclick="history.go(-1);">목록으로</button>
		</div>
	</div>
	</div>
</body>
</html>