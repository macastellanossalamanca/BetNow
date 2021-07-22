var app = (function () {
    var token;
    function getToken(newToken) {
            token = newToken.access_token;
            correo = localStorage.getItem("correo");
            localStorage.setItem("Authorization", token);
            location.href = "/indexLogin.html";

    }
    function onload() {
            if (localStorage.getItem("Authorization") === null) {
                location.href = "/";
                return
            }
    }
    function createTable(){
        if (localStorage.getItem("Authorization") !== null) {
            apiclient.obtenerApuestas();
            return
        }
    }
    function onloadBets() {
        bets.bet()
        bets.init()
        if (localStorage.getItem("Authorization") !== null) {
             onloadUsuario();
             return
        }

    }
    function onloadUserBets() {
        bets.askBet()
        if (localStorage.getItem("Authorization") !== null) {
            onloadUsuario();
            return
        }

    }


    function onloadUsuario() {
            apiclient.obtenerUsuarioCorreo(localStorage.getItem("correo"), localStorage.getItem("Authorization"), cargarInformacion);
    }

    function cargarInformacion(Usuario) {
            //console.log("llego a cargarInformacion")
            localStorage.setItem("id", Usuario.id);
    }
    function onloadStat() {
        apiclient.obtenerStats(drawStat);
        return

    }
    drawStat = function(resp){
        $("#statTable tbody").empty();
        //console.log(resp);
        var contact = JSON.parse(resp);
        if(contact !== undefined){
            var data = contact.map((info) => {
                return {
                    team: info.team,
                    played: info.played,
                    win: info.win,
                    draw: info.draw,
                    loss: info.loss,
                    goalsFor: info.goalsFor,
                    goalsAgainst: info.goalsAgainst,
                    points:info.points,
                }
            })

            data.map((info) => {
                var x = 0;
                $("#statTable > tbody:last").append($("<tr><td>" + info.team +
                    "</td><td>" + info.played  +
                    "</td><td>" +info.win  +
                    "</td><td>" + info.draw  +
                    "</td><td>" +info.loss  +
                    "</td><td>" +info.goalsFor  +
                    "</td><td>" + info.goalsAgainst  +
                    "</td><td>" +info.points  +
                    "</td></tr>"))
            })
        } else {
            alert("No existen estadisticas")
        }
    }

    return {
        drawStat: drawStat,
        getToken: getToken,
        onload : onload,
        onloadBets : onloadBets,
        onloadUserBets : onloadUserBets,
        onloadStat :onloadStat
    }
})();
