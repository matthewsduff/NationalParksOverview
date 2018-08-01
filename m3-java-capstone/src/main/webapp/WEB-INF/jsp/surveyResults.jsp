<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="main_content">
		
		<br />
		<br />
		<br />
		<br /><br />
		
		<table>
			<tr>
				<td class="labelPopularParks">Most popular parks:</td>
				<td>
				<c:forEach items="${surveyResults}" var="survey_result">
				<p>${survey_result.parkName}</p>				
				</c:forEach>
				
				</td>
			</tr>
		</table>

</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />