package condutores.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import Exemplos_cursoJava.JDBC.FabricaConexao;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class Conexao {
	public static Connection getConexao() {
		try {
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String password = prop.getProperty("banco.password");

			return DriverManager
					.getConnection(url, usuario, password);
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao_condutores.properties";
		prop.load(FabricaConexao.class.getResourceAsStream(caminho));
		return prop;
	}
}
