package ligarbd;

import java.sql.*;

public class ligacaomysql {
    public static String estado = "Não ligado.";

    public static Connection criarligacao() {
        Connection cn;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String caminho = "jdbc:mysql://127.0.0.1/bd_24023_livros?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String pass = "admin";
            cn = DriverManager.getConnection(caminho, user, pass);
            if (cn != null) {
                estado = "Ligação efetuada.";
            } else {
                estado = "Não foi possível estabelecer a ligação.";
            }
            return (cn);

        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o Driver.");
            return null;

        } catch (SQLException e) {
            System.out.println("Erro ao aceder a base de dados.");
            return null;
        }
    }

    public static String estadoligacao() {
        return (estado);
    }
}
