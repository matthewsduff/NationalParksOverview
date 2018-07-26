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
		
		<p>${park.parkName}</p>parkName
		<p>${park.parkDescription}</p>parkDescription
		<p>${park.acreage}</p>acreage
		<p>${park.elevationInFeet}</p>elevationInFeet
		<p>${park.milesOfTrail}</p>milesOfTrail
		<p>${park.numberOfCampsites}</p>numberOfCampsites
		<p>${park.climate}</p>climate
		<p>${park.yearFounded}</p>yearFounded
		<p>${park.annualVisitorCount}</p>annualVisitorCount
		<p>${park.inspirationalQuote}</p>inspirationalQuote
		<p>${park.inspirationalQuoteSource}</p>inspirationalQuoteSource
		<p>${park.parkDescription}</p>parkDescription
		<p>${park.entryFee}</p>entryFee
		<p>${park.numberOfAnimalSpecies}</p>numberOfAnimalSpecies
		<p>${park.state}</p>state
		
	</c:forEach>
		
		
	</body>
</html>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />