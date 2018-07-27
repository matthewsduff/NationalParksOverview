<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="main_content">
	<h1></h1>
	<c:url var="formAction" value="/alien_age_result" />

	<form method="GET" action="${formAction}">

		<table>
			<tr>
				<td class="labelPopularParks">Most popular parks:</td>
				<td>
				<c:forEach items="${park}" var="park">
				<p>${park.parkName}</p>parkName
				<p>${survey.surveySomething}</p>
				
				</c:forEach>
				
				</td>
			</tr>
		</table>
	</form>

</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />