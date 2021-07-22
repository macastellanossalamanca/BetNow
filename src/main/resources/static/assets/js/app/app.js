var app = (function () {

    function mostrarTabla(data) {
        let tabla = document.getElementById("eventTable");

        $("#eventRow").empty();
        data.forEach(function (element) {
            let markup =
                "<tr> <td>" +
                "<input type='button' value='" + element.equipoA + "' onclick='app.apostar(\"" + element.equipoA + "\",\"" + element.id + "\")'></input>" +
                "</td> <td> " +
                "<input type='button' value='" + element.equipoB + "' onclick='app.apostar(\"" + element.equipoB + "\",\"" + element.id + "\")'></input>" +
                "</td> <td> " +
                element.cuotaA +
                "</td> <td> " +
                element.cuotaB +
                "</td> </tr>";
            if (element.ganador === null) {
                $("#eventRow").append(markup);
            }
        });

    }

    function apostar(equipo, idEvento) {
        let valor = document.getElementById("valorApuesta").value;
        let user = localStorage.getItem("idUsuario")
        if (user !== null) {
            api.makeBet(equipo, valor, user, idEvento);
        }
    }

    function cerrarSesion() {
        localStorage.clear();
        location.assign("index.html");
    }

    function mostrarTablaApuestas(data) {
        let tabla = document.getElementById("betsUserTable");

        $("#betsUserRows").empty();
        data.forEach(function (element) {
            let markup =
                "<tr> <td>" +
                element.cuota +
                "</td> <td> " +
                element.monto +
                "</td> <td> " +
                element.equipo +
                "</td> </tr>";
            $("#betsUserRows").append(markup);
        });
    }

    function mostrarTablaClose(data) {
        let tabla = document.getElementById("betsUserTable");

        $("#betsUserRows").empty();
        data.forEach(function (element) {
            let markup =
                "<tr> <td>" +
                "<input type='button' value='" + element.equipoA + "' onclick='app.cerrar(\"" + element.equipoA + "\",\"" + element.id + "\")'></input>" +
                "</td> <td> " +
                "<input type='button' value='" + element.equipoB + "' onclick='app.cerrar(\"" + element.equipoB + "\",\"" + element.id + "\")'></input>" +
                "</td> <td> " +
                element.cuotaA +
                "</td> <td> " +
                element.cuotaB +
                "</td> </tr>";
            if (element.ganador === null) {
                $("#betsUserRows").append(markup);
            }
        });
    }

    function cerrar(ganador, idEvento) {
        api.endEvent(ganador, idEvento);
    }

    return {
        mostrarTabla: mostrarTabla,
        mostrarTablaClose: mostrarTablaClose,
        mostrarTablaApuestas: mostrarTablaApuestas,
        apostar: apostar,
        cerrarSesion: cerrarSesion,
        cerrar: cerrar

    }
})();