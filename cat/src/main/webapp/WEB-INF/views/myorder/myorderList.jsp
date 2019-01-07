<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<meta charset="UTF-8">
<title>나의 주문내역</title>
</head>
<body>
	<script type="text/javascript">
		//한페이지에 보여줄 레코드 수 페이징을 위한 실질적인 처리 함수
		function goPage(page) {
			$("#page").val(page);
			$("#detailForm").attr({
				"method" : "get",
				"action" : "/myorder/myorderList"
			});
			$("#detailForm").submit();
		}
	</script>
	<div class="contentContainer">
		<div class="contentTit">
			<h2>나의 주문내역</h2>
			<p>주문/배송내역 집사님의 주문내역을 확인 하실 수 있습니다.</p>
			<p>-상세보기 버튼을 클릭하시면, 주문 상세내역을 확인 할 수 있습니다.</p>
			<p>-간략내역보기 에서 상품 후기를 작성 하실 수 있습니다.</p>
		</div>


		<form name="detailForm" id="detailForm">
			<input type="hidden" name="m_number" id="m_number"
				value="<%=session.getAttribute("m_number")%>"> <input
				type="hidden" id="page" name="page" value="${data.page }">
		</form>
		<div id="myorderList">
			<table summary="나의 주문 내역">
				<colgroup>
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th data-value="o_date">주문일자</th>
						<th>주문번호</th>
						<th>사용 마일리지</th>
						<th>결제금액</th>
						<th>배송료</th>
						<th>배송현황</th>
					</tr>
				</thead>
				<tbody id="list">
					<c:choose>
						<c:when test="${not empty myorderList }">
							<c:forEach items="${myorderList}" var="myorder"
								varStatus="status">
								<tr>
									<td>${myorder.o_date}</td>
									<td>${myorder.o_number }<br> <a
										href="/myorder/myorderDetail?o_number=${myorder.o_number}">[상세보기]</a>
									</td>
									<td>${myorder.o_usemilage}</td>
									<td>${myorder.o_totalprice}</td>
									<td><input type="hidden" value="3000">
										<p>3000</p></td>
									<td>${myorder.o_state }</td>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td>등록 된 주문이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div id="myorderPage">
			<tag:paging page="${param.page }" total="${total }" list_size="5" />
		</div>
	</div>
</body>
</html>