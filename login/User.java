package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe User é responsável por gerenciar a conexão com o banco de dados e
 * realizar a verificação de usuários.
 */
public class User {

    /**
     * Realiza a conexão com o banco de dados MySQL.
     *
     * @return Um objeto {@link Connection} que representa a conexão com o banco de dados.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            // URL de conexão ao banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Imprime a stack trace em caso de erro
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Nome do usuário autenticado, caso a verificação seja bem-sucedida.
     */
    public String nome = "";

    /**
     * Resultado da verificação do login do usuário.
     * Indica se o login foi autenticado com sucesso.
     */
    public boolean result = false;

    /**
     * Verifica se o login e senha fornecidos correspondem a um usuário no banco de dados.
     *
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha associada ao usuário.
     * @return {@code true} se o login for válido e {@code false} caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();

        // Monta a consulta SQL
        sql = "SELECT nome FROM usuarios WHERE login = '" + login + "' AND senha = '" + senha + "'";

        try {
            // Executa a consulta
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                // Define o resultado como verdadeiro e recupera o nome do usuário
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Imprime a stack trace em caso de erro
            e.printStackTrace();
        }
        return result;
    }
}
