<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/include/css/noticeList.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* 한페이지에 보여줄 레코드 수 조회 후 선택한 값 그대로 유지하기 위한 설정*/
		if ("<c:out value='${data.pageSize}'/>" != "") {
			$("#pageSize").val("<c:out value='${data.pageSize}'/>");
		}
	});
</script>
</head>
<body>
	<div id="listContainer">
		<div id="list">
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th id="title">제목</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list }">
							<c:forEach items="${list }" var="list">
								<tr>
									<td>${list.n_number }</td>
									<td><a href="/notice/detail?n_number=${list.n_number}">${list.n_title }</a></td>
									<td>${list.n_date }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3">등록 된 게시물이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<div id="Paging">
				<tag:paging page="${param.page}" total="${total }"
					list_size="${data.pageSize}" />
			</div>
		</div>
	</div>
</body>
</html>