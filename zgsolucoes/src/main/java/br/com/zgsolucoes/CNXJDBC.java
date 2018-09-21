package br.com.zgsolucoes;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

public class CNXJDBC {

    private String usuario = "postgres";
    private String senha = "zg@123";
    private String PathBase = "192.168.1.55:5432/checkout_beatriz";
    private String URL = "jdbc:postgresql://" + PathBase;

    public Connection conectar() {
        try {
            //Class.forName("org,postgresql.Driver");
            return DriverManager.getConnection(URL, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}