$(document).on("click", "#btnlimpar", function(){
	document.getElementById("track").value = "";
	document.getElementById("title").value = "";
	document.getElementById("artist").value = "";
	document.getElementById("album").value = "";
	document.getElementById("year").value = "";
});

$(document).on("click", ".tags", function(){
	document.getElementById("track").value = this.dataset.number;
	document.getElementById("title").value = this.dataset.title;
	document.getElementById("artist").value = this.dataset.artist;
	document.getElementById("album").value = this.dataset.album;
	document.getElementById("year").value = this.dataset.year;
	document.getElementById("key").value = this.dataset.key;
	document.getElementById("link").value = this.dataset.link;
});

$(document).on("click", "#btnalterar", function(){
	var params = {
		"action" : "tags",
		"caminho" : document.getElementById("path").value,
		"chave" : document.getElementById("key").value,
		"usuario" : document.getElementById("usuario").value,
		"track" : document.getElementById("track").value,
		"title" : document.getElementById("title").value,
		"artist" : document.getElementById("artist").value,
		"album" : document.getElementById("album").value,
		"year" : document.getElementById("year").value,
		"link" : document.getElementById("link").value
	};
	//alert(JSON.stringify(params));
	document.getElementById("btncancelar").click();
	$('#pleaseWaitAlt').modal('toggle');
	$.post("/Nebula/view/usuario/DiretorioCRUD",$.param(params),
			function(responseJson){
		alert("Alterado com sucesso!");
		//alert(JSON.stringify(responseJson));		
		$('#pleaseWaitAlt').modal('hide');
		document.getElementById("bot").click();
	});
});