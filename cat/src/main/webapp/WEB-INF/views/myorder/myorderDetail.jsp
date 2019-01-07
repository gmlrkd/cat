<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#orderCancel")
								.click(
										function() {
											if (confirm("정말 주문을 취소하시겠습니까?")) {
												$
														.ajax({
															url : "/myorder/myorderDelete?o_number=${myorderDetail.o_number}&o_state=${myorderDetail.o_state}",
															type : "post",
															success : function(
																	data) {
																if (data == 1) {
																	alert("주문이 취소되었습니다.");
																	location.href = "/myorder/myorderList";
																} else {
																	alert("배송중이거나 배송 완료시에는 주문을 취소하실 수 없습니다.");
																}
															}

														});
											}
										});
					});
</script>
<script type="text/javascript">
	function addressModify(state) {
		if (state.match("배송준비중")) {
			window.open('/myorder/addressmodify?o_number=${findOrder.o_number}', 'addresssModify',
					'width=500, height=400');
		} else {
			alert("배송준비중일때만 주소변경이 가능합니다.");
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h4>상세보기 페이지</h4>
			<p>주문/배송내역 집사님의 주문내역을 확인 하실 수 있습니다.</p>
		</div>
		<form name="o_data" id="o_data" method="POST">
			<input type="hidden" name="o_number"
				value="${myorderDetail.o_number }" />
		</form>
		<div class="contentTB">
			<table border="1">
				<thead>
					<tr>
						<td>상품정보</td>
						<td>가격</td>
						<td>수량</td>
						<td>마일리지</td>
						<td>결제금액</td>
						<td>상태</td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty myorderDetail }">

							<c:forEach var="findProduct" items="${findProduct}"
								varStatus="status">
								<tr>
									<td>${findProduct.p_name}</td>
									<td>${findProduct.p_price}<input type="hidden" id="price"
										value="${findProduct.p_price}"></td>
									<td>${findProduct.p_amount }<input type="hidden"
										id="amount" value="${findProduct.p_amount }"></td>
									<td id="milage">${findProduct.p_price / 10}</td>
									<td id="totalprice">${findProduct.p_price * findProduct.p_amount }</td>
									<td><input type="hidden">
										<p>결제완료</p></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>

			</table>
			<div class="contentHeader">
				<h4>결제 금액</h4>
				<table border="1">
					<tr>
						<td>배송료</td>
						<td>3000</td>
					</tr>
					<tr>
						<td>마일리지 사용</td>
						<td>0</td>
					</tr>
					<tr>
						<td>총 주문합계 금액</td>
						<td><c:set var="total" value="0" /> <c:forEach var="result"
								items="${resultList}" varStatus="status">
								<tr>
									<td>${result.num}
									<td>
								</tr>
								<c:set var="total" value="${total + result.num}" />
							</c:forEach> <c:out value="${total}" /></td>
					</tr>
				</table>
			</div>

			<div class="contentHeader">
				<h4>주문서 정보</h4>
				<table border="1">
					<thead>
						<tr>
							<td>주문번호</td>
							<td>${findOrder.o_number}</td>
						</tr>
						<tr>
							<td>주문일</td>
							<td>${findOrder.o_date}</td>
						</tr>
						<tr>
							<td>주문상태</td>
							<td>${findOrder.o_state}<input type="hidden" id="state"
								value="${findOrder.o_state}"></td>
						</tr>
					</thead>
				</table>
			</div>

			<div class="contentHeader">
				<h4>주문자 정보</h4>
				<table border="1">
					<thead>
						<tr>
							<td>이름</td>
							<td>${findMember.m_name}</td>
						</tr>
						<tr>
							<td>휴대폰</td>
							<td>${findMember.m_phone }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${findMember.m_email }</td>
						</tr>
					</thead>
				</table>
			</div>
			<div class="contentHeader">
				<h4>배송지 정보</h4>
				<table border="1">
					<thead>
						<tr>
							<td>이름</td>
							<td>${findMember.m_name }</td>
						</tr>
						<tr>
							<td>휴대폰</td>
							<td>${findMember.m_phone }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${findMember.m_email }</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>${findOrder.o_address }</td>
						</tr>
				</table>
			</div>

			<br>
		</div>
		<div class="myorderListBtn">
			<input type="button" name="orderCancel" id="orderCancel" value="주문취소">
			<input type="button" name="orderModify" id="orderModify"
				value="배송지정보수정" onclick="addressModify('${findOrder.o_state}')">
		</div>
		
	</div>
</body>
</html>