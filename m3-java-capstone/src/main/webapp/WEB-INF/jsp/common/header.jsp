<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>
		Fly By Night Bank 
	  	<c:if test="${param.subTitle != null}"> - <c:out value="${param.subTitle}"/></c:if>
	</title>
	<c:url var="stylesheetHref" value="/css/flybynight.css" />
	<link rel="stylesheet" href="${stylesheetHref}">
</head>
<body>
	<header>
		<c:set var="loggedIn" value="${not empty sessionScope.username }"/>
		<c:url var="logoImgSrc" value="/img/flybynightlogo.png" />
		<img src="${logoImgSrc}" alt="Fly By Night Bank">
		<c:if test="${loggedIn}">
		<p class="motto">Welcome ${sessionScope.username}</p>
		</c:if>
		<p class="motto">At Fly By Night, we treat your money as if it's our own.</p>

	</header>
	<nav>
		<ul>
			<c:url var="homePageHref" value="/" />
			
			
			<li><a href="${homePageHref}">Home</a></li>
			<c:choose>
			<c:when test="${loggedIn}">
				<c:url var="logoutHref" value="/logout" />
				<li><a href="${logoutHref}">Logout</a></li>
			</c:when>
			<c:otherwise>
				<c:url var="loginHref" value="/login" />
				<li><a href="${loginHref}">Log In or Enroll</a></li>
			</c:otherwise>
			</c:choose>
			<li><a href="#">Why Fly By Night</a></li>
			<c:url var="stocksHref" value="/stocks" />
			<li><a href="${stocksHref}">Stocks</a></li>
		</ul>
	</nav>
	
	<div id="container" class="wrapper">
