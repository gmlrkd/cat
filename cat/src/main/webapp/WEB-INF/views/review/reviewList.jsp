<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<style>
.starR {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat right 0;
	background-size: auto 100%;
	width: 30px;
	height: 30px;
	display: inline-block;
	text-indent: -9999px;
	cursor: pointer;
}

.starR.on {
	background-position: 0 0;
}
</style>
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#insertReviewBtn").click(function() {
			location.href = "/review/reviewWriteForm";
		});

		//제목 클릭시 상세페이지 이동 처리 이벤트
		$(".goDetail").click(function() {
			var r_number = $(this).parents("tr").attr("data-num");
			$("#r_number").val(r_number);
			console.log("글번호 : " + r_number);
			//상세페이지 이동하기 위해 form 추가
			$("#detailForm").attr({
				"method" : "get",
				"action" : "/review/reviewDetail"
			});
			$("#detailForm").submit();
		});

	});
	function goPage(page) {
		$("#page").val(page);
		$("#review_Array").attr({
			"method" : "get",
			"action" : "/review/reviewList"
		});
		$("#review_Array").submit();
	}
</script>
<meta charset="UTF-8">
<title>리뷰목록</title>
</head>
<body>

	<%
		if (session.getAttribute("m_number") != null) {
			int m_number = (Integer) session.getAttribute("m_number");
	%>
	<div class="contentContainer">
		<div class="contentTit">리뷰게시판</div>

		<%--상세 페이지 이동 Form --%>
		<form name="review_Array" id="review_Array">
		<input type="hidden" name="m_number" id="m_number"
				value="<%=session.getAttribute("m_number")%>"> <input
				type="hidden" id="page" name="page" value="${data.page }">
		</form>
		<form name="detailForm" id="detailForm">
			<input type="hidden" name="r_number" id="r_number">
		</form>
		<div id="reviewList">
			<table summary="리뷰게시판 리스트">
				<colgroup>
					<col width="10%">
					<col width="32%">
					<col width="15%">
					<col width="13%">
					<col width="13%">
				</colgroup>
				<thead>
					<tr>
						<th class="order">글 번호</th>
						<th>글 제목</th>
						<th class="writer">작성자</th>
						<th class="product_starrate">평점</th>
						<th data-value="r_date" class="order">작성일</th>
					</tr>
				</thead>
				<tbody id="list">
					<c:choose>
						<c:when test="${not empty reviewList }">
							<c:forEach var="review" items="${reviewList }" varStatus="status">
								<tr class="tac" data-num="${review.r_number}">
									<td>${review.r_number }</td>
									<td class="goDetail tal">${review.r_title }</td>
									<td class="name"><%=session.getAttribute("m_name")%><input
										type="hidden" name="m_number" value="<%=m_number%>"></td>
									<td>${review.r_starrate }</td>
									<td>${review.r_date}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4" class="tac">등록 된 게시물이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div id="reviewPage">
			<tag:paging page="${param.page }" total="${total }" list_size="5" />
		</div>
		<div class="contentBtn">
			<input type="button" value="후기작성" id="insertReviewBtn">
		</div>
	</div>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("로그인 후 이용하실 수 있습니다.");
		location.href = "/member/login";
	</script>
	<%
		}
	%>

</body>
</html>