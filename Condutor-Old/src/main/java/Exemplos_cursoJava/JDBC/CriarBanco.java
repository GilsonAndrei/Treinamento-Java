package Exemplos_cursoJava.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class CriarBanco {
	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
		final String usuario = "root";
		final String password = "pisup1993";

		Connection conexao = DriverManager
				.getConnection(url, usuario, password);

		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");
		System.out.println("Banco criado com sucesso.");

		conexao.close();
	}
}
