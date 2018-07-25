<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
	<head>
		<title>Home page</title>
	</head>
	<body>
		<h1>Do you like cigars? Do you like parties?</h1>
		
		<%--once the submit button is clicked, it takes us to the parks page --%>
		<c:url var="formAction" value="/greeting"/>
		
		<%--we use this method to get the img in case the file paths change down the road --%>
		<c:url var="imageLink" value="/imgs/forDummies.png"/>
		<img src="${imageLink}">	
	<form method="GET" action="${formAction}" >
	<label>Click Here To submit a park</label>
		<input type="submit" placeholder="Submit"/>
	</form>	
	
	<c:forEach items="${park}" var="park">
	
		<%--we get these values from the park.java file --%>	
		<%--how do we get the image? from the file --%>
		<img src="img/${park.parkcode} + .jpg">
		<p>${park.parkName}</p>
		<p>${park.parkDescription}</p>
		<p>${park.state}</p>
		
		
	</c:forEach>
		
		
		
	</body>
</html>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />