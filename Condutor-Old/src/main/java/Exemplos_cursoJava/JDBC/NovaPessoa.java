package Exemplos_cursoJava.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class NovaPessoa {
	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o nome: ");
		String nome = entrada.nextLine();

		System.out.println(nome);

		Connection conexao = FabricaConexao.getConexao();

		String sql = "INSERT INTO pessoas (nome) VALUES(?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();

		System.out.println(sql);


		entrada.close();
	}
}
