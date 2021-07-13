package edu.escuelaing.BetNow.Persistence;

import org.springframework.stereotype.Service;

import edu.escuelaing.BetNow.Modelo.Apuesta;
import edu.escuelaing.BetNow.Modelo.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;

@Service("DbConnection")
public class DataBaseConnection {

    private RethinkDB r = RethinkDB.r;
    private Connection connection;
    private static final String HOST = "ec2-54-160-111-65.compute-1.amazonaws.com";
    private static final String DB_NAME = "ReyCanino";
    private static final int PORT = 32769;

    private void createConnection() {
        connection = RethinkDB.r.connection().hostname(HOST).port(PORT).connect();
    }

    public String insertarUsuario(Usuario usuario) {

        createConnection();

        HashMap<String, Object> insert = r.db(DB_NAME).table("usuario")
                .insert(r.array(r.hashMap("nombre", usuario.getNombre()).with("credito", 100)
                        .with("apuestas", new ArrayList<Apuesta>()).with("correo", usuario.getCorreo())
                        .with("contrasena", usuario.getPsw())))
                .run(connection);
        ArrayList<String> llaves = (ArrayList<String>) insert.get("generated_keys");
        usuario.setId(llaves.get(0));
        connection.close();
        return usuario.getId();
    }

    public List<Apuesta> buscarApuestas() {

        List<Apuesta> apuestas = new ArrayList<>();
        createConnection();

        Cursor<Apuesta> query = r.db(DB_NAME).table("apuesta").run(connection, Apuesta.class);
        while (query.hasNext()) {
            apuestas.add(query.next());
        }
        connection.close();
        return apuestas;
    }

    public List<Apuesta> buscarApuestas(String id) {

        createConnection();
        Cursor<Usuario> query = r.db(DB_NAME).table("usuario").filter(apuesta -> apuesta.getField("id").eq(id))
                .run(connection, Usuario.class);

        Usuario usuario = null;

        while (query.hasNext()) {
            usuario = query.next();
        }
        connection.close();
        return usuario.getApuestas();
    }

    public Usuario login(Usuario usuario) {
        createConnection();
        Cursor<Usuario> query = r.db(DB_NAME).table("usuario")
                .filter(cl -> cl.getField("correo").eq(usuario.getCorreo()))
                .filter(cl -> cl.getField("contrasena").eq(usuario.getPsw())).run(connection, Usuario.class);
        Usuario usuarioLogin = null;

        while (query.hasNext()) {
            usuarioLogin = query.next();
        }
        connection.close();
        return usuarioLogin;
    }
}
