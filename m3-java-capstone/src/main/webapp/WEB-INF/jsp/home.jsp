<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
<style>
.accordion {
    color: white;
    font-size:4em;
    text-transform:uppercase;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
   	text-align: center;
    transition: 0.4s;
    height:400px;
    width:1200px;
}

.active, .accordion:hover {
    background-color: white; 
}

.panel {
    padding: 0 18px;
    display: none;
    background-color: white;
    overflow: hidden;
}
</style>
	<head>
		<title>Home page</title>
	</head>
	<body>
		<%-- <h1>NATIONAL PARKS</h1> --%>
		
		<%--once the submit button is clicked, it takes us to the parks page --%>
		<c:url var="formAction" value="/greeting"/>
		
		<%--we use this method to get the img in case the file paths change down the road --%>
		
	
	
	<c:forEach items="${park}" var="park">
	<button class="accordion" style="background: url(img/parks/${park.parkCode}.jpg) no-repeat;">${park.parkName}</button>
		<%--we get these values from the park.java file --%>	
		<%--how do we get the image? from the file --%>
		<%-- <img src="img/parks/${park.parkcode}.jpg"> --%>
		
		<div class="panel">
		
		
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
		<p>${carlWeathers.forecast}</p>
		</div>
	</c:forEach>
	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function() {
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
        } else {
            panel.style.display = "block";
        }
    });
}
</script>
		
		
	</body>
</html>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />