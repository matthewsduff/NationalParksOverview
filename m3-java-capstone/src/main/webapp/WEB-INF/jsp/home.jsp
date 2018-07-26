<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
	<head>
		<title>Home page</title>
	</head>
	<body>
		<%-- <h1>NATIONAL PARKS</h1> --%>
		
		<%--once the submit button is clicked, it takes us to the parks page --%>
		<c:url var="formAction" value="/greeting"/>
		
		<%--we use this method to get the img in case the file paths change down the road --%>
		
	
	
	<c:forEach items="${park}" var="park">
	
		<%--we get these values from the park.java file --%>	
		<%--how do we get the image? from the file --%>
		<%-- <img src="img/parks/${park.parkcode}.jpg"> --%>
		<img src="img/parks/${park.parkCode}.jpg">
		
		<p>${park.parkName}</p>
		<p>${park.parkDescription}</p>
		<p>${park.state}</p>
		
		
	</c:forEach>
		
		
	</body>
</html>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />