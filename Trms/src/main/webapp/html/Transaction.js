window.onload = function() {
	getTransInfo();
}

function getTransInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {	
			let trans = JSON.parse(xhttp.responseText);
			setValues(trans);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/Trms/html/TransJSON.do',
			true);
	xhttp.send();

}

function setValues(trans) {
	document.getElementsById('row1').innerHTML= trans.userId;
	document.getElementsById('row2').innerHTML= trans.transId;
	document.getElementsById('row3').innerHTML= trans.amountReim;
	document.getElementsById('row4').innerHTML= trans.remainingReim;
	document.getElementsById('row5').innerHTML= trans.date;
	/*document.getElementById("Us").innerHTML = "The username is: "
			+ user.userName;
	document.getElementById("Pas").innerHTML = "The password is: "
			+ user.passWord;*/

}