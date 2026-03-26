package Exemplos_cursoJava.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas1 {

	public static void main(String[] args) {

		String sql = "SELECT codigo, nome FROM pessoas WHERE nome LIKE ?";

		try (
				Connection conexao = FabricaConexao.getConexao();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner entrada = new Scanner(System.in)
		) {

			System.out.println("Informe parte do nome a ser buscado: ");
			String nomeBusca = entrada.nextLine();

			stmt.setString(1, "%" + nomeBusca + "%");

			ResultSet resultado = stmt.executeQuery();

			List<Pessoa> pessoas = new ArrayList<>();

			while (resultado.next()) {
				pessoas.add(new Pessoa(
						resultado.getInt("codigo"),
						resultado.getString("nome")
				));
			}

			pessoas.forEach(p ->
					System.out.println(p.getCodigo() + " ==> " + p.getNome())
			);


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
