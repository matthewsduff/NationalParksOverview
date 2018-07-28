<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
<style>
.accordion {
	color: white;
	font-size: 4em;
	text-transform: uppercase;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	text-align: center;
	transition: 2s;
	height: 400px;
	width: 1200px;
}

.button:hover {
	opacity: 1
}

.active, .accordion:hover {
	background-color: white;
	opacity: 1:
}

.panel {
	margin-left: 30px;
	padding: 0 18px;
	display: none;
	background-color: white;
	overflow: hidden;
}

p {
	font-family: Helvetica;
}
</style>
<head>
<title>Home page</title>
</head>
<body>
	<div>
		<%-- <h1>NATIONAL PARKS</h1> --%>

		<%--once the submit button is clicked, it takes us to the parks page --%>
		<c:url var="formAction" value="/greeting" />

		<%--we use this method to get the img in case the file paths change down the road --%>



		<c:forEach items="${park}" var="park">
			<button class="accordion"
				style="background: url(img/parks/${park.parkCode}.jpg) no-repeat;">${park.parkName}</button>
			<%--we get these values from the park.java file --%>
			<%--how do we get the image? from the file --%>
			<%-- <img src="img/parks/${park.parkcode}.jpg"> --%>

			<div class="panel">



				<p>${park.parkName}</p>
				<p>Description: ${park.parkDescription}</p>
				<p>Acreage: ${park.acreage}</p>
				<p>Elevation In Feet: ${park.elevationInFeet}</p>
				<p>Miles of Trail: ${park.milesOfTrail}</p>
				<p>Number of Campsites: ${park.numberOfCampsites}</p>
				<p>Climate: ${park.climate}</p>
				<p>Founded: ${park.yearFounded}</p>
				<p>Annual Visitor Count: ${park.annualVisitorCount}</p>
				<p>
					<em>"${park.inspirationalQuote}" </em> -
					${park.inspirationalQuoteSource}
				</p>
				<p>Entry Fee: $${park.entryFee}</p>
				<p>Number of Animal Species: ${park.numberOfAnimalSpecies}</p>
				<p>State: ${park.state}</p>
				<br>
				<table class = "weather">
				<tr><th>low temp:F/C</th><th>high temp:F/C</th><th>Forecast:</th><th>Recommendation:</th>
				
				</tr>
				<c:forEach items="${weather}" var="weather">
				<c:if test = "${park.parkCode == weather.parkCode}">
					<tr><td>${weather.low} / ${weather.celLow}</td>
					<td>${weather.high} / ${weather.celHigh}</td>
					<td>${weather.forecast}</td>
					<td>${weather.equipment}</td>
					<td><img src="img/weather/${weather.forecast}.png"></td>
					<td>${weather.temperatureWarnings}</td>
					</tr>
												
					</c:if>
				</c:forEach>
				</table>

			</div>
		</c:forEach>
	</div>
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