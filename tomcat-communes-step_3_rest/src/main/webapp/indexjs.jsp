<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>communes</title>
<script type="text/javascript" src="js/communes.js"></script>
<style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
#map {
	height: 45%;
	width: 33%;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<h2>Recherche de communes</h2>
		<div id="meteo"></div>
	<div id="map"></div>

	<script>
		var map;
		var lat = 48.8580537;
		var lng = 2.294289;
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : lat,
					lng : lng
				},
				zoom : 12
			});
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD_aEzPFrouCpHX71oI-Vifg8ar1YVOz_I&callback=initMap"
		async defer></script>

	Par code postal
	<input name="cp" id="cp" size="8" onkeyup="keyUp()">

	<div id="container"></div>
</body>
</html>