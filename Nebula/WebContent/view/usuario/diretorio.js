$(document).ready(function() {
	$(document.getElementById("alarms")).hide();
	document.getElementById("bot").click();
});

$(document).on("click", "#folder", function(){
	var params = {
			"action" : "criar",
			"caminho" : document.getElementById("path").value,
			"chave" : document.getElementById("folderName").value
		};
		$(document.getElementById("alarms")).value = "Criando pasta...";
		if (document.getElementById("folderName").value.length == 0){
			alert("Insira um nome!");
			return;
		}
		$.post(
				"/Nebula/view/usuario/DiretorioCRUD",
				$.param(params),
				function(responseJson) {
					$(document.getElementById("alarms")).hide();
					document.getElementById("bot").click();
				})
		.fail(
				function() {
					console.log("error");
					$(document.getElementById("alarms")).hide();
				});
});

$(document).on("click","#refresh",function(){
	document.getElementById("bot").click();
});

$(document).on("click","#bot",function() {
	var params = {
		"action" : "listar",
		"caminho" : document.getElementById("path").value,
		"usuario" : document.getElementById("usuario").value
	};
	document.getElementById("alarms").value = "Aguarde, carregando diretório...";
	$(document.getElementById("alarms")).show();
	$.post("/Nebula/view/usuario/DiretorioCRUD",$.param(params),
		function(responseJson) {
			//alert(JSON.stringify(responseJson));
			var table = document.getElementById("dir");
			var id = 1;
			table.innerHTML = '';
			var header = $("<tr bgcolor='eaeaea'>").appendTo(table);
						
			//cria linhas e campos da visualização para cada objeto retornado do servidor
			$.each(JSON.parse(JSON.stringify(responseJson)),
					function(index,
					item) {
					//cria linha 
					var row = $("<tr>").appendTo(table);
					row.id = "row" + id.toString();

					if (item.isDirectory) {
						row.append($("<td class='direc'>").text(item.key).width("30%"));
						
						//se for diretório, cria um botão "Abrir"
						var button = document.createElement("input");
						button.id = "but" + id.toString();
						button.className = "dirs btn";
						button.type = "button";
						button.value = "Abrir";
						button.dataset.dir = item.downloadLink.slice(0,-1);
						row.append($("<td>").append(button));
					} else {
						row.append($("<td class='files'>").text(item.key));
						
						//se for arquivo, cria link de download
						row.append($("<td>").html('<a href="'+ item.downloadLink + '">Download</a>'));

						//cria botão de reprodução
						var button = document.createElement("input");
						button.id = "play" + id.toString();
						button.className = "play btn";
						button.type = "button";
						button.value = "Tocar";
						button.dataset.song = item.downloadLink;
						row.append($("<td>").append(button));
						
						//mostra propriedades
						row.append($("<td>").text(item.title).width("30%"));
						row.append($("<td>").text(item.artist));
						row.append($("<td>").text(item.album).width("30%"));
						row.append($("<td>").text(item.number));
						row.append($("<td>").text(item.duration));
						row.append($("<td>").text(item.year));
						row.append($("<td>").text(item.size));
					}

					//cria botão de excluir
					if(item.key != "../"){
						var del = document.createElement("input");
						del.id = "del" + id.toString();
						del.className = "dels btn btn-danger";
						del.type = "button";
						del.value = "Excluir";
						del.dataset.key = item.key;
						row.append($("<td>").append(del));
					}
					
					id = id + 1;
				});
			$(document.getElementById("alarms")).hide();
			//alert("OK response");
		})
	.fail(function() {
		console.log("error");
		$(document.getElementById("alarms")).hide();
	});
});

$(document).on("click", "#upload", function() {
	
	document.getElementById("alarms").value = "Enviando arquivos";
	$(document.getElementById("alarms")).show();
	var ind = 0;
	var res = 0;
	var musicas = document.getElementById("file");
	var total = musicas.files.length;

	if (total == 0){
		alert("Não há arquivos a enviar!");
		$(document.getElementById("alarms")).hide();
		return;
	}
	$(document.getElementById("alarms")).show();
	document.getElementById("alarms").value = "Enviando arquivos";
	document.getElementById("alarms").value = "Enviando arquivo 1 de " + total + "...";
	for (ind = 0; ind < total; ind++) {
		
		$(document.getElementById("alarms")).show();
		var fdata = new FormData();
		fdata.append("action", "upload");
		fdata.append("usuario", document.getElementById("usuario").value);
		fdata.append("caminho", document.getElementById("path").value);	
		//fdata.append("file", $("#file")[ind].files[ind])
		//alert(ind);
		fdata.append("file", musicas.files[ind]);
		$(document.getElementById("alarms")).show();
		$.ajax({
			type : 'POST',
			url : '/Nebula/view/usuario/DiretorioCRUD',
			data : fdata,
			contentType : false,
			processData : false,
			success : function(response) {
				document.getElementById("alarms").value = "Enviando arquivo " + ind + " de " + total + "...";
				res = res + 1;
				alert("Arquivo " + res + " enviado!");
			}
		});
		document.getElementById("alarms").value = "Enviando arquivos...";
		$(document.getElementById("alarms")).show();
	}
	$(document.getElementById("alarms")).hide();
});

$(document).on("click", ".dirs", function() {
	document.getElementById("path").value = this.dataset.dir;
	document.getElementById("bot").click();
});

$(document).on("click",".dels",function() {
	var params = {
		"action" : "excluir",
		"caminho" : document.getElementById("path").value,
		"chave" : this.dataset.key
	};
	$(document.getElementById("alarms")).show();
	$.post(
			"/Nebula/view/usuario/DiretorioCRUD",
			$.param(params),
			function(responseJson) {
				document.getElementById("alarms").value = "Aguarde...";
				$(document.getElementById("alarms")).hide();
				document.getElementById("bot").click();
			})
	.fail(
			function() {
				console.log("error");
				$(document.getElementById("alarms")).hide();
			});
});

$(document).on("click", ".play", function() {
	var player = document.getElementById("player");
	var playlist = document.getElementById("playlist");
	var id = 1;
	var thisSong = this.dataset.song;
	
	player.pause();
	player.src = thisSong;
	player.load();
	player.play();
	
	playlist.innerHTML = "";
	
	$("#dir .play").each(function(){
		
		var song = this.dataset.song;
		var item = $("<li>");
		
		if (song = thisSong){
			item.className = "active";				
		}
		
		item.text(song);
		item.appendTo(playlist);
		
		id = id + 1;
	});
	
});

$(document).on("ended", "#player", function(){
	alert("ended");
	var next = $('#playlist li.active').next();
    if (next.length == 0) {
        next = $('.playlist li:first-child');
    }
    
    this.src = next.text();
    this.load();
    this.play();
});