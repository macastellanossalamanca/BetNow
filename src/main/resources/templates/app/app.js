var app = (function () {
    function consultarApuestas() {
        api.consultar();
    }

    function mostrarTabla(data) {
        let tabla = document.getElementById("apuestas");
        if (data.size > 0) {
            $("#filasApuestas").empty();
            let cont = 0;
            data.forEach(function (element) {
                let markup =
                    "<tr> <td>" +
                    element.equipo +
                    "</td> <td> " +
                    element.monto +
                    "</td> <td> " +
                    cuota +
                    "</td> </tr>";
                $("#filasApuestas").append(markup);
            });
        }
    }

    function subChanges() {
        stompClient.subscribe(
            "/topic/changes",
            function (event) {
                let data = JSON.parse(event.body);
                mostrarTabla(data);
            },
            { id: "changes" }
        );
    }

    var stompClient = null;

    function connect() {
        console.log("Connecting to WS...");
        var socket = new SockJS("/stompendpoint");
        stompClient = Stomp.over(socket);
        stompClient.connect(
            {},
            function (frame) {
                console.log("Connected: " + frame);
                subChanges();
            }
        );
    }


    return {
        consultarApuestas: consultarApuestas,
        mostrarTabla: mostrarTabla,
        connect: connect
    }
})();