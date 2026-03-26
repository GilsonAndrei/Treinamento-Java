package Exemplos_cursoJava.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarPessoa {

	public static void main(String[] args) {

		String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

		try (
				Connection conexao = FabricaConexao.getConexao();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner entrada = new Scanner(System.in)
		) {

			System.out.print("Informe o código da pessoa: ");
			int codigo = entrada.nextInt();
			entrada.nextLine(); // limpar buffer

			System.out.print("Informe o novo nome: ");
			String novoNome = entrada.nextLine();

			stmt.setString(1, novoNome);
			stmt.setInt(2, codigo);

			int linhasAfetadas = stmt.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Pessoa atualizada com sucesso!");
			} else {
				System.out.println("Nenhuma pessoa encontrada com esse código.");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
		}
	}
}
