var apiclient = (function () {

    return {
        crearUsuario: function (nombre, cedula, usuario, email, password){
            var promise = $.ajax({
                url: "/usuarios",
                method: "POST",
                data: JSON.stringify([nombre, cedula, usuario, email, password]),
                contentType: "application/json"
            });
            return promise
        },

        obtenerTocken(correo,password,callback){
        var promise = $.ajax({
          "url": "/oauth/token",
          "method": "POST",
          "timeout": 0,
          "headers": {
            "Authorization": "Basic RWNpQmV0OkhvbGExMjM0",
            "Content-Type": "application/x-www-form-urlencoded"
          },
          "data": {
            username: correo,
            password: password,
            "grant_type": "password"
          },
          contentType: "application/x-www-form-urlencoded"
        });
        promise.then(function (data) {
                        //console.log("Llego al OK")
                        console.info("OK");
                        localStorage.setItem("correo", correo);
                        callback(data);
                    }, function (data) {
                        //console.log("No llego al OK")
                        console.info(data)
                        console.info("Credenciales incorrectas");

                    });
        },
        obtenerApuestas(callback,token){
            jQuery.ajax({
                url: "/tables/bets",
                type: 'GET',
                contentType: "application/json",
                success: function (result) {
                    callback(result);
                },
                async: true
            });
        },
        obtenerStats(callback){
            jQuery.ajax({
                url: "/tables/stats",
                type: 'GET',
                contentType: "application/json",
                success: function (result) {
                    callback(result);
                },
                async: true
            });
        },
        obtenerApuestasUsuario(callback,token,id){
                   var promise = $.ajax({
                     url: "/tables/apuestas/"+id,
                     type: 'GET',
                     headers: {"Authorization" : "Bearer "+token},
                     contentType: "application/json"
                   });
                    promise.then(function (data) {
                        console.info("OK en apuestas usuario");
                        console.log(data)
                        callback(data);
                    }, function (data) {
                        console.info(data)
                        console.info("Credenciales incorrectas");
                    });
                },

        obtenerUsuarioCorreo(correo, token, callback){
                    //console.log(token);
                    var promise = $.ajax({
                        url: "/usuarios/correos/"+correo,
                        type: 'GET',
                        headers: {"Authorization" : "Bearer "+token},
                        contentType: "application/json"
                    });
                    promise.then(function (data) {
                        console.info("OK");
                        //console.log(data)
                        callback(data);
                    }, function (data) {
                        console.info(data)
                        console.info("Credenciales incorrectas");
                    });
        },
        guardarApuestas(token,id,apuesta){
        //var pr=JSON.stringify(apuesta)
            //console.log(apuesta);
            var promise = $.ajax({
                      "url": "/tables/"+id+"/apuestas",
                      "method": "POST",
                      "timeout": 0,
                      "headers": {
                        "Authorization": "Bearer "+token,
                        "Content-Type": "application/json"

                      },
                      "data": apuesta
                      });
                      console.log(apuesta)

                    promise.then(function (data) {
                        console.info("OK");
                    }, function (data) {
                        console.info("ERROR");
                    });
        }
    }
})();