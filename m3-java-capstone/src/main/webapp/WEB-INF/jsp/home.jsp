<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
	<link rel="stylesheet" type = "text/css" href="css/npgeekCSS.css" />

	<div>
	<br />
	<br />
		<c:url var="formAction" value="/greeting" />

		<c:forEach items="${park}" var="park">
			<button class="accordion"
				style="background: url(img/parks/${park.parkCode}.jpg);">${park.parkName}</button>

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
<button class="tempButton">Temp converter</button>
				<table class="weather">
					<tr>
						<th width="50px">low temp:</th>
						<th width="50px">high temp:</th>
						<th width="50px">Forecast:</th>
						<th width="50px"></th>
						<th width="600px">Recommendation:</th>
						<th width="50px"></th>

					</tr>
					<c:forEach items="${weather}" var="weather">
						<c:if test="${park.parkCode == weather.parkCode}">
							<tr>
								<td class="temp hidden">C° ${weather.celLow}</td>
								<td class="temp">F° ${weather.low}</td>
								<td class="temp hidden">C° ${weather.celHigh}</td>
								<td class="temp">F° ${weather.high}</td>
								<td>${weather.forecast}</td>
								<td><img src="img/weather/${weather.forecast}.png"
									height="25px" width="Auto"></td>
								<td>${weather.temperatureWarnings}.${weather.equipment}</td>
								<td></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</c:forEach>
	</div>

	<script type="text/javascript" src="JavaScript/accordion.js"></script>	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />