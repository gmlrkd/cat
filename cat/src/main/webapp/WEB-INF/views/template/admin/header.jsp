<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<style>
input[type=button] {
	float: right;
}
</style>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/admin/order/getOrderList.do"><font color="black">우리집고양이</font></a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">메인</a></li>
				<li class="active dropdown"><a href="#about" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">상품관리<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/product/productList.do">상품목록</a></li>
						<li><a href="/admin/product/productRegForm.do">상품등록</a></li>
					</ul>
				</li>
				<li class="active"><a href="#">회원관리</a></li>
				<li class="active dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">통계관리<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/memberStats.do">회원통계</a></li>
						<li><a href="/admin/salesStats.do">매출통계</a></li>
					</ul>
				</li>
				<li class="active dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">고객센터 관리<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/qnaList.do">1 : 1 문의 관리</a></li>
						<li><a href="/admin/faqList.do">FAQ 게시판 관리</a></li>
						<li><a href="/admin/noticeList.do">공지사항 게시판 관리</a></li>
					</ul>
				</li>
				<li class="active dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">게시판 관리<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/catinfoList.do">반려묘 관리법 정보 게시판</a></li>
						<li><a href="/admin/shareBoard.do">꿀팁공유 / 반려묘 자랑 게시판</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/member/main.do"><font color="black">사용자페이지</font></a></li>
				<li><a href="/admin/adminLogout.do"><font color="black">로그아웃</font></a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>