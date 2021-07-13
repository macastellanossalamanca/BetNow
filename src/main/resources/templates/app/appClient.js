var api = (function () {
    function consultar() {
        $.ajax({
            url: "/allBets",
            type: "get",
            success: function (response) {
                app.mostrarTabla(response);
                app.connect();
            },
        });
    }

    return {
        consultar: consultar
    }
})();