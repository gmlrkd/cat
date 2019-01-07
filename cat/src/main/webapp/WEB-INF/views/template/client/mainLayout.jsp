<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<div id="wapper"></div>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>
	<div id="content">
		<tiles:insertAttribute name="body" />
	</div>
	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>