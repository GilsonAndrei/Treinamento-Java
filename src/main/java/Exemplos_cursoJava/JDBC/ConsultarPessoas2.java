package Exemplos_cursoJava.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class ConsultarPessoas2 {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas";
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);

		List<Pessoa> pessoas = new ArrayList<>();

		while (resultado.next()) {
			Integer codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}

		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " ==> " + p.getNome());
		}

		stmt.close();
		conexao.close();
	}
}
