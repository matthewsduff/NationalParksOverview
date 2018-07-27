<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="main_content">
	<h1>NATIONAL PARKS SURVEY</h1>

	<c:url var="formAction" value="/survey" />
	<form method="POST" action="${formAction}">

		<table>
			<tr>
				<td class="label">Vote for your favorite park:</td>
				<td><select name="parkcode">
						<option value="CVNP">Cuyahoga Valley National Park</option>
						<option value=ENP>Everglades National Park</option>
						<option value="GCNP">Grand Canyon National Park</option>
						<option value="GNP">Glacier National Park</option>
						<option value="GSMNP">Great Smoky Mountains National Park</option>
						<option value="GTNP">Grand Teton National Park</option>
						<option value="MRDR">Mordor</option>
						<option value="MRNP">Mount Rainier National Park</option>
						<option value="RMNP">Rocky Mountain National Park</option>
						<option value="YNP">Yellowstone National Park</option>
						<option value="YNP2">Yosemite National Park</option>
				</select></td>
			</tr>
			<tr>
				<td class="state">Please select your state of residence:</td>
				<td><select name="state">
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
				</select></td>

			</tr>
			<tr>

				<td class="selectAL">Please select your activity level:</td>
				<td><select name="activitylevel">
						<option value="Inactive">Inactive</option>
						<option value="Sedentary">Sedentary</option>
						<option value="Active" selected>Active</option>
						<option value="Extremely_Active">Extremely Active</option>
				</select></td>
			</tr>
			<tr>
				<td class="label">Please enter your email:</td>
				<td><input type="text" name="emailaddress" placeholder = "fake_email@example.com" /></td>
			</tr>
			<tr><td><input type = "submit" value = "Submit"/></td></tr>
		</table>
	</form>

</div>




<footer></footer>