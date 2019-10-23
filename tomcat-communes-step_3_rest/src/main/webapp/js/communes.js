let url = "rest/communes/cp/";
let urlmeteo = "https://api.openweathermap.org/data/2.5/weather";
let xhr = new XMLHttpRequest();
let xhr2 = new XMLHttpRequest();


xhr.onreadystatechange = function () {
	if (this.readyState == 4 && this.status == 200) {
		show(JSON.parse(this.responseText))
	}
}

xhr2.onreadystatechange = function () {
	if (this.readyState == 4 && this.status == 200) {
		showMeteo(JSON.parse(this.responseText))
	}
}

function getMeteo() {
	xhr2.open("GET", urlmeteo + "?lat=" + lat +"&lon="+lng+"&units=metric&appid=96e14ff430196c7aa959583de51dbd27&lang=fr");
	xhr2.send();

}

function showMeteo(datas) {
	document.getElementById("meteo").innerText = "La Temperature à "+datas.name+" est de : "+datas.main.temp+" °"+" , avec un temps "+datas.weather[0].description;
}

function getCommunes() {
	let cp = document.getElementById("cp").value;
	xhr.open("GET", url + cp);
	xhr.send();
}

function show(datas) {
	document.getElementById("container").innerText = "";
	let liste = document.createElement("ul");
	for (let i = 0; i < datas.length; i++) {

		let ligne = document.createElement("li");
		ligne.innerHTML = datas[i].codePostal + " " + datas[i].nom;
		ligne.dataset.lat = datas[i].gpsLatitude;
		ligne.dataset.lng = datas[i].gpsLongitude;
		ligne.dataset.cp = datas[i].codePostal;
		ligne.addEventListener("click", cliquer);
		liste.appendChild(ligne);
	}
	document.getElementById("container").appendChild(liste);
}

function keyUp() {
	if (document.getElementById("cp").value.length > 2) {
		getCommunes();
	} else {
		document.getElementById("container").innerText = "";
	}
}

function cliquer(event) {
	lat = parseFloat(event.target.dataset.lat);
	lng = parseFloat(event.target.dataset.lng);
	cp2 = parseInt(event.target.dataset.cp);

	map.setCenter({ lat: lat, lng: lng });
	getMeteo();
}
