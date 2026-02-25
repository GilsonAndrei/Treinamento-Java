package Exemplos_cursoJava.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	public static void main(String[] args) {

		String sql = "DELETE FROM pessoas WHERE codigo = ?";

		try (
				Connection conexao = FabricaConexao.getConexao();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner entrada = new Scanner(System.in)
		) {

			System.out.print("Informe o código da pessoa que deseja excluir: ");
			int codigo = entrada.nextInt();
			entrada.nextLine(); // limpar buffer

			System.out.print("Tem certeza que deseja excluir? (S/N): ");
			String confirmacao = entrada.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {

				stmt.setInt(1, codigo);

				int linhasAfetadas = stmt.executeUpdate();

				if (linhasAfetadas > 0) {
					System.out.println("Pessoa excluída com sucesso!");
				} else {
					System.out.println("Pessoa não encontrada.");
				}

			} else {
				System.out.println("Exclusão cancelada.");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao excluir pessoa: " + e.getMessage());
		}
	}
}
