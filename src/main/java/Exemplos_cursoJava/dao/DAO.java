package Exemplos_cursoJava.dao;

import java.sql.Connection;
import java.sql.SQLException;

import Exemplos_cursoJava.JDBC.FabricaConexao;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class DAO {

	private Connection conexao;

	private Connection getConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conexao = FabricaConexao.getConexao();
		return conexao;
	}
}
