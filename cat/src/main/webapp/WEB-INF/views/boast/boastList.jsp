<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 화면</title>
</head>
<body>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript">
$(function() {

	
	//제목버튼 클릭시 상세 페이지 로 이동
	$(".goDetail").click(function() {
		var b_number = $(this).parents("tr").attr("data-num");
		$("#b_number").val(b_number);
	});
	
	$("#searchData").click(function() {
		/* 검색 from 추가 */
		if ($("#search").val() == '') {
			$("#keyword").val("");
		}
		$("#page").val(1);
		$("#b_search").attr({
			"method":"get",
			"action":"/boast/boardList.do"
		});
		$("#b_search").submit();
	});
	//글쓰기 버튼 클릭시 글작성 이동 이벤트
	$("#boastInsertBtn").click(function() {
		location.href = "/boast/writeBoast";
	}); 
	
});
</script>
		<h3>꿀팁공유/자랑게시판</h3>		
		<span id="d"></span>
			<form id="b_search">
			<input type="hidden" id="page" name="page" value="${ data.page }" />
			<select id="b_division" name="b_division">
				<option value="">전체</option>
				<option value="꿀팁공유">꿀팁공유</option>
				<option value="반려묘자랑">반려묘자랑</option>
			</select>
			<select id="search" name="search">
				<option value="">전체</option>
				<option value="제목">제목</option>
				<option value="내용">내용</option>
			</select>
			<input type="text" name="keyword" id="keyword" placeholder="검색어를입력하세요" /><input type="button" value="검색" id="searchData" />
		</form>
		<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>등록일</td>
			<td>작성자</td>
			<td>글분류</td>
		</tr>
		<c:choose>
			<c:when test="${ not empty boastList }">
				<c:forEach var="boast" items="${ boastList }" varStatus="status">
					<tr>
						<td>
							${ boast.b_number }
						</td>
						<td>
							<a href="/boast/boastDetail.do?b_number=${ boast.b_number }">${ boast.b_title }</a>
						</td>
						<td>
							<fmt:formatDate value="${ boast.b_date }" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${ boast.m_number }
						</td>
						<td>
							${ boast.b_division }
						</td>
					</tr>		
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
			</c:otherwise>
		</c:choose>
	</table>
 	<!--페이징 -->
	 <div id="FaqboardPage">    							
		<tag:paging page="${param.page}" total="${total}" list_size="${data.pageSize}" />
    </div> 
	<!--페이징end --> 
		 <input type="button" value="글작성" class="goToInsertBtn" id="boastInsertBtn">
	

</html>