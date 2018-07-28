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
	margin: 0, 0, 0, 10px;
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

td {
	font-family: Helvetica;
}
</style>
<head>
<title>Home page</title>
<c:url var="stylesheetHref" value="/CSS/npgeekCSS.css" />
<link rel="stylesheet" href="${stylesheetHref}">
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



				<table width="1100px">
					<tr>
						<td id="parkName">${park.parkName}</td>
					</tr>
					<tr>
						<td>State: ${park.state}</td>
					</tr>
					<tr>
						<td width="1200px">Description: ${park.parkDescription}</td>
					</tr>
					<tr>
						<td><em>"${park.inspirationalQuote}" </em> -
							${park.inspirationalQuoteSource}</td>
					</tr>
				</table>
				<table width="1100px">
					<tr>
						<td>Acreage: ${park.acreage}</td>
						<td>Elevation In Feet: ${park.elevationInFeet}</td>
						<td>Miles of Trail: ${park.milesOfTrail}</td>
					</tr>

					<tr>
						<td>Number of Campsites: ${park.numberOfCampsites}</td>
						<td>Climate: ${park.climate}</td>
						<td>Founded: ${park.yearFounded}</td>
					</tr>
					<tr>
						<td>Annual Visitor Count: ${park.annualVisitorCount}</td>
						<td>Entry Fee: $${park.entryFee}</td>
						<td>Number of Animal Species: ${park.numberOfAnimalSpecies}</td>
					</tr>

				</table>
				<br>


				<table class="weather">
					<tr>
						<th width="50px">low temp:F/C</th>
						<th width="50px">high temp:F/C</th>
						<th width="50px">Forecast:</th>
						<th width="50px"></th>
						<th width ="600px">Recommendation:</th>
						<th width="50px"></th>

					</tr>
					<c:forEach items="${weather}" var="weather">
						<c:if test="${park.parkCode == weather.parkCode}">
							<tr>
								<td>${weather.low}/${weather.celLow}</td>
								<td>${weather.high}/${weather.celHigh}</td>
								<td>${weather.forecast}</td>
								<td><img src="img/weather/${weather.forecast}.png"
									height="15%" width="15%"></td>
								<td>${weather.temperatureWarnings}. ${weather.equipment}</td>
								<td></td>
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