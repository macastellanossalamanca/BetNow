login = (function () {

    login = function (){
        correo = $("#user").val();
        password = $("#password").val();
        apiclient.obtenerTocken(correo,password,isLogin);
    }
    function cerrarSesion(){
        localStorage.clear();
        location.reload();
        location.href = "/";

    }
    function isLogin(token){
        app.getToken(token);
    }
    return{
        cerrarSesion:cerrarSesion,
        login:login
    }
})();