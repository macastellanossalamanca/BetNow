bets = (function () {
    var stompClient = null;
var equipoCuota;
var idPartido;

    bet = function (){
        if (localStorage.getItem("Authorization") !== "") {
            apiclient.obtenerApuestas(drawBet,localStorage.getItem("Authorization"));
        } else {
            alert("Debe ingresar algún nombre, vuelva a intentarlo")
        }
    }
    askBet = function(){
        if (localStorage.getItem("Authorization") !== "") {
            apiclient.obtenerApuestasUsuario(drawUserBets,localStorage.getItem("Authorization"),localStorage.getItem("id"));
        } else {
            alert("La informacion del usuario es incorrecta")
        }

    }

    drawUserBets = function(resp){
        $("#betsUser tbody").empty();
        //console.log(typeof(resp));
        if(resp !== undefined){
            var data = resp.map((info) => {
                return {
                    idApuesta: info.id,
                    fecha: info.fecha,
                    cuota: info.cuota,
                    valorApostado: info.valorApostado,
                    estado: info.estado,
                    equipoApuesta: info.equipoApuesta,
                    administrador: info.administrador,
                    partidos: info.partidos,
                    usuarios: info.usuarios
                }
            })
            data.map((info) => {
                $("#betsUser > tbody:last").append($("<tr><td>" + info.fecha + "</td><td>" + info.cuota +
                    "</td><td>" + info.valorApostado +"</td><td>"+ info.estado +
                    "</td><td>" + info.equipoApuesta + "</td></tr>"))
            })
        } else {
            alert("No hay apuestas registradas")
        }
    }

    drawBet = function(resp){
        $("#betsTable tbody").empty();
        console.log(resp);
        if(resp !== undefined){
            var data = resp.map((info) => {
                return {
                    idApuesta: info.idApuesta,
                    hora: info.hora,
                    fecha: info.fecha,
                    logo1: info.logo1,
                    logo2: info.logo2,
                    equipo1: info.equipo1,
                    equipo2: info.equipo2,
                    cuota1: info.cuota1,
                    cuotaEmpate: info.cuotaEmpate,
                    cuota2: info.cuota2
                }
            })
            data.map((info) => {
                $("#betsTable > tbody:last").append($("<tr><td>" + info.fecha + "<br>" + info.hora +
                                                      `</td><td><img src="assets/images/icons/teams/${info.logo1}"><br>` +
                                                      `<img src="assets/images/icons/teams/${info.logo2}">`+
                                                      "</td><td>" + info.equipo1 +"<br>"+ info.equipo2 +
                                                      `</td><td><a style="color: #292929" id="${info.equipo1}" name ="${info.idApuesta}" type="button" class="btnn" data-toggle="modal" onclick="bets.updateCuota(${info.cuota1},this.id, this.name)" data-target="#myModal">${info.cuota1}</a>` +
                                                      `</td><td><a style="color: #292929" id="${info.equipo1}&${info.equipo2}" name ="${info.idApuesta}" type="button" class="btnn" data-toggle="modal" onclick="bets.updateCuota(${info.cuotaEmpate},this.id, this.name)" data-target="#myModal">${info.cuotaEmpate}</a>` +
                                                      `</td><td><a style="color: #292929" id="${info.equipo2}" name ="${info.idApuesta}" type="button" class="btnn" data-toggle="modal" onclick="bets.updateCuota(${info.cuota2},this.id, this.name)" data-target="#myModal">${info.cuota2}</a>`+
                                                      `</td><td><a href="/Tables.html"><img src="assets/images/icons/stat.png" alt=""></a>` +
                                                      "</td></tr>"))
            })
        } else {
            alert("No existe las apuestas")
        }
    }

    updateCuot = function(JsonUpdat){
        //var json=JSON.parse(JsonUpdat)
        console.log(JsonUpdat)
        console.log("llega enviando y enviando")
        stompClient.send("/app/newpoint",{},JsonUpdat);

    }
    updateCuota = function(cuota,equipoC,id){
        var integer = parseFloat(cuota)
        equipoCuota = equipoC;
        idPartido = id;
        document.getElementById("cuotaApuesta").value = integer;
        localStorage.setItem("cuota",cuota);
    }
    var subscribeToPoint = function(){

            var socket = new SockJS('/stompendpoint');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/newpoint', function (message) {
                    console.log(message)
                    var messagePoint=JSON.parse(message.body);
                    drawBet(messagePoint)
                });
            });

    }

    saveBet = function(pago,plata){
        var jsonApuesta = `{
            "idUser": ${localStorage.getItem("id")},
            "idPartido": ${idPartido},
            "equipoApuesta": ${equipoCuota},
            "cuota": ${localStorage.getItem("cuota")},
            "valorApostado": ${plata}
        }`;
        var jsonUpdate = `{
            "idPartido": ${idPartido},
            "equipoApuesta": ${equipoCuota},
        }`;
        //console.log(idPartido)
        //console.log(jsonApuesta)
        updateCuot(jsonUpdate)

        apiclient.guardarApuestas(localStorage.getItem("Authorization"),localStorage.getItem("id"),jsonApuesta);
    }



    return{
        init: function () {
            subscribeToPoint()
        },
       bet:bet,
       updateCuota : updateCuota,
       saveBet : saveBet,
       askBet : askBet,
        drawUserBets: drawUserBets

    }
})();