<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="main_content">
<h1>ALIEN AGE CALCULATOR</h1>
<c:url var="formAction" value="/alien_age_result" />

<form method="GET" action="${formAction}">

<table>
<tr><td class="label">Choose  Planet:</td>
<td>
		<select name="planet_name">
			<option value="">Select an Planet</option>
			<option value="mercury">Mercury</option>
			<option value="venus">Venus</option>
			<option value="earth">Earth</option>
			<option value="moon">Moon</option>
			<option value="mars">Mars</option>
			<option value="jupiter">Jupiter</option>
			<option value="saturn">Saturn</option>
			<option value="uranus">Uranus</option>
			<option value="neptune">Neptune</option>
			<option value="pluto">Pluto</option>
		</select>"src/main/webapp/WEB-INF/jsp/alien_age.jsp"
		</td></tr>
<tr><td class="label">Enter your Earth Age:</td>
	<td>
		<input type="text" name="original_age">
	</td>
</tr>
<tr><td></td><td><input type="submit" value="Calulate Age"></td></tr>
</table>
</form>

</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />