package Exemplos_cursoJava.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class CriarTabelaPessoas {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
				"codigo INT AUTO_INCREMENT PRIMARY KEY," +
				"nome VARCHAR(80) NOT NULL" +
				")";

		Statement stmt = conexao.createStatement();
		stmt.execute(sql);

		System.out.println("Tabela Pessoas criada com sucesso");
		conexao.close();
	}
}
