var api = (function() {
	function onloadEvents() {
		$.ajax({
			url: "/api/allEvents",
			type: "get",
			success: function(response) {
				app.mostrarTabla(response);
				vistas.cargarVista();
			},
		});
	}
	function onloadEventsClose() {
		$.ajax({
			url: "/api/allEvents",
			type: "get",
			success: function(response) {
				app.mostrarTablaClose(response);
				vistas.cargarVista();
			},
		});
	}
	function allBets() {
		$.ajax({
			url: "/api/allBets",
			type: "get",
			success: function(response) {
				app.allBets(response);
			},
		});
	}
	function allEvents() {
		$.ajax({
			url: "/api/allEvents",
			type: "get",
			success: function(response) {
				app.allEvents(response);
			},
		});
	}
	function allBetsByUser() {
		let usuario = {
			id: localStorage.getItem("idUsuario"),
		}
		$.ajax({
			data: JSON.stringify(usuario),
			contentType: "application/json",
			url: "/api/allBetsByUser",
			type: "post",
			success: function(response) {
				app.mostrarTablaApuestas(response);
				vistas.cargarVista();
			},
		});
	}
	function createUser() {
		let usuario = {
			nombre: $("#username").val(),
			correo : $("#email").val(),
			password : $("#password").val(),
			credito: 50000,
			tipo: "user"
		}
		$.ajax({
			data: JSON.stringify(usuario),
			contentType: "application/json",
			url: "/api/createUser",
			type: "post",
			success: function(response) {
				location.assign("index.html");
			}
		})
	}
	function createEvent() {
		let evento = {
			equipoA : $("#equipoA").val(),
			equipoB : $("#equipoB").val(),
			cuotaA: 2,
			cuotaB: 2
		}
		$.ajax({
			data: JSON.stringify(evento),
			contentType: "application/json",
			url: "/api/createEvent",
			type: "post",
			success: function(response) {
				location.assign("index.html");
			}
		})
	}
	function makeBet(equipo,valor,user,idEvento) {
		let bet = {
			equipo : equipo,
			monto: valor,
			usuarioId: user,
			evento: idEvento
		}
		$.ajax({
			data: JSON.stringify(bet),
			contentType: "application/json",
			url: "/api/makeBet",
			type: "post",
			success: function(response) {
				getUserById();
			}
		})
	}
	function login() {
		let usuario = {
			correo : $("#user").val(),
			password : $("#password").val()
		}
		$.ajax({
			data: JSON.stringify(usuario),
			contentType: "application/json",
			url: "/api/login",
			type: "post",
			success: function(response) {
				localStorage.setItem("idUsuario",response.id);
				localStorage.setItem("tipoUsuario",response.tipo);
				localStorage.setItem("nombreUsuario",response.nombre);
				localStorage.setItem("credito",response.credito);
				location.assign("index.html");
			}
		})
	}

	function getUserById(){
		$.ajax({
			url: "/api/userById/"+localStorage.getItem("idUsuario"),
			type: "get",
			success: function(response) {
				localStorage.setItem("credito",response.credito);				
				location.assign("index.html");
			}
		})
	}

	function endEvent(ganador, eventId) {
		let evento = {
			ganador : ganador,
			id : eventId
		}
		$.ajax({
			data: JSON.stringify(evento),
			contentType: "application/json",
			url: "/api/endEvent",
			type: "put",
			success: function(response) {
				location.assign("index.html");
			}
		})
	}
	return {
		onloadEvents: onloadEvents,
		onloadEventsClose:onloadEventsClose,
        makeBet:makeBet,
		login:login,
		createUser:createUser,
		createEvent:createEvent,
		allBetsByUser:allBetsByUser,
		makeBet:makeBet,
		endEvent:endEvent
	};
})();