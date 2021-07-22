var vistas = (function() {
    function cargarVista(){
        let tipo = localStorage.getItem("tipoUsuario");
        let evento = document.getElementById("crearEvento");
        let apuestas = document.getElementById("misApuestas");
        let registro = document.getElementById("registro");
        let acceso = document.getElementById("acceso");
        let logOff = document.getElementById("logOff");
        let cerrar = document.getElementById("cerrarEvento");
        let saldo = document.getElementById("saldo"); 

        if (tipo === "admin"){
            evento.style.display = "block";
            cerrar.style.display = "block";
            logOff.style.display = "";
            saldo.style.display = "";
            saldo.innerHTML = "Saldo:" + localStorage.getItem("credito");
            apuestas.style.display = "none";
            registro.style.display = "none";
            acceso.style.display = "none";

        }else if (tipo === "user"){
            evento.style.display = "none";
            cerrar.style.display = "none";
            saldo.style.display = "";
            saldo.innerHTML = "Saldo:" + localStorage.getItem("credito");
            logOff.style.display = "";
            apuestas.style.display = "block";
            registro.style.display = "none";
            acceso.style.display = "none";
        }else{
            evento.style.display = "none";
            cerrar.style.display = "none";
            logOff.style.display = "none";
            saldo.style.display = "none";
            apuestas.style.display = "none";
            registro.style.display = "";
            acceso.style.display = "";
        }
    }

    return{
        cargarVista: cargarVista,
    }
})();