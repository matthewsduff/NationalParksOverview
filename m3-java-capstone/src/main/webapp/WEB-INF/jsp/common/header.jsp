<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>
		National Parks 
	  	<c:if test="${param.subTitle != null}"> - <c:out value="${param.subTitle}"/></c:if>
	</title>
	<c:url var="stylesheetHref" value="#" />
	<link rel="stylesheet" href="${stylesheetHref}">
</head>
<body>
	<header>
	
		<c:url var="logoImgSrc" value="/img/logo.png" />
		<img src="${logoImgSrc}" alt="National Parks logo">
		
		<p class="motto">National Parks are great.</p>

	</header>
	<nav>
		<%-- temp converter goes here --%>
	</nav>
	
	<div id="container" class="wrapper">
