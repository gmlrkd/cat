<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:getAsString name="title" /></title>
<link rel="icon" href="/resources/images/common/icon.png" />
<link href="/resources/include/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/include/css/dashboard.css" rel="stylesheet" />
<script src="/resources/include/js/ie-emulation-modes-warning.js"></script>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<tiles:insertAttribute name="header" />
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset2 main">
				<tiles:insertAttribute name="main" />
			</div>
		</div>
	</div>
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<tiles:insertAttribute name="footer" />
	</nav>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/resources/include/js/bootstrap.min.js"></script>
	<script src="/resources/include/js/docs.min.js"></script>
	<script src="/resources/include/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>