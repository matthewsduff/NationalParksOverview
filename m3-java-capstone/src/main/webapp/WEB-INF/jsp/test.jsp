<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    transition: 0.4s;
}

.active, .accordion:hover {
    background-color: #ccc; 
}

.panel {
    padding: 0 18px;
    display: none;
    background-color: white;
    overflow: hidden;
}
</style>
</head>
<body>

<h2>Accordion</h2>

<button class="accordion">Section 1</button>
<div class="panel">
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
</div>

<button class="accordion">Section 2</button>
<div class="panel">
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
</div>

<button class="accordion">Section 3</button>
<div class="panel">
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
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