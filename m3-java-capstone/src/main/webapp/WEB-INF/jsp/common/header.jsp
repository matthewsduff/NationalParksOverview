<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<style>
.navBar{
	overflow: hidden;
	position: fixed;
	background-color: white;
	top: 0;
	width: 100%;
	margin: 0,0,0,10px;
}
</style>
	<title>
		National Parks 
	  	<c:if test="${param.subTitle != null}"> - <c:out value="${param.subTitle}"/></c:if>
	</title>
	<c:url var="stylesheetHref" value="/css/npgeekCSS.css" />
	<link rel="stylesheet" href="${stylesheetHref}">
</head>
<body>
	<header>
	
		<div class = "navBar"><c:url var="logoImgSrc" value="/img/park.png" />
		<a href="home"><img src="${logoImgSrc}" alt="National Parks logo" style="width:40%"></a></div>
		
		

	</header>
	<nav>
		<%-- temp converter goes here --%>
	</nav>
	
	<div id="container" class="wrapper">
