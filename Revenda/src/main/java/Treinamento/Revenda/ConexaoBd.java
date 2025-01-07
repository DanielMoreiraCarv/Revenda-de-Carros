package Treinamento.Revenda;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {

    private static final String URL = "jdbc:postgresql://localhost:5432/estudo";  
    private static final String USUARIO = "postgres";  
    private static final String SENHA = "12345678";  
    private static Connection conexao = null;


    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                
                Class.forName("org.postgresql.Driver");
                
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC não encontrado.");
                throw new SQLException("Driver JDBC não encontrado", e);
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
                throw e;
            }
        }
        return conexao;  
    }

    
    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}

