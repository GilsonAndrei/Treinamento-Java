package condutores.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import condutores.models.Condutor;
import condutores.util.Conexao;
import static condutores.util.Tabelas.*;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class CondutorDao {
	private String sql;

	public void inserir(Condutor condutor) {
		sql = "INSERT INTO " + CONDUTORES + "(codigo,cpf,nome,dataNascimento,numeroCNH,categoriaCNH,dataVencimento)" +
				"VALUES(?,?,?,?,?,?,?)";
		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql);) {
			stmt.setLong(1, condutor.getCodigo());
			stmt.setString(2, condutor.getCpf());
			stmt.setString(3, condutor.getNome());
			stmt.setDate(4, (Date) condutor.getDataNascimento());
			stmt.setString(5, condutor.getNumeroCNH());
			stmt.setString(6, condutor.getCategoriaCNH());
			stmt.setDate(7, (Date) condutor.getDataVencimento());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir condutor.", e);
		}
	}

	public void atualizar(Condutor condutor) {
		sql = "UPDATE " + CONDUTORES + " " +
				"SET cpf = ?, " +
				"nome = ?, " +
				"dataNascimento = ?, " +
				"numeroCNH = ?, " +
				"categoriaCNH = ?, " +
				"dataVencimento = ? " +
				"WHERE codigo = ?";
		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql);) {
			stmt.setString(1, condutor.getCpf());
			stmt.setString(2, condutor.getNome());
			stmt.setDate(3, (Date) condutor.getDataNascimento());
			stmt.setString(4, condutor.getNumeroCNH());
			stmt.setString(5, condutor.getCategoriaCNH());
			stmt.setDate(6, (Date) condutor.getDataVencimento());
			stmt.setLong(7, condutor.getCodigo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar condutor", e);
		}
	}

	public void excluir(Long codigo) {
		sql = "DELETE " +
				"FROM " + CONDUTORES +
				"WHERE codigo = ?";

		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql)) {

			stmt.setLong(1, codigo);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir condutor", e);
		}
	}

	public Condutor listarPorId(Long codigo) {
		sql = "SELECT * FROM " + CONDUTORES + " WHERE codigo = ?";

		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql)) {
			stmt.setLong(1, codigo);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				return new Condutor(
						resultado.getLong("codigo"),
						resultado.getString("cpf"),
						resultado.getString("nome"),
						resultado.getDate("dataNascimento"),
						resultado.getString("numeroCNH"),
						resultado.getString("categoriaCNH"),
						resultado.getDate("dataVencimento"));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar por ID", e);
		}
		return null;
	}

	public List<Condutor> listarTodos() {
		sql = "SELECT * FROM " + CONDUTORES;
		List<Condutor> lCondutores = new ArrayList<>();

		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql);) {
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				Condutor condutor = new Condutor(
						resultado.getLong("codigo"),
						resultado.getString("cpf"),
						resultado.getString("nome"),
						resultado.getDate("dataNascimento"),
						resultado.getString("numeroCNH"),
						resultado.getString("categoriaCNH"),
						resultado.getDate("dataVencimento")
				);

				lCondutores.add(condutor);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar condutores", e);
		}
		return lCondutores;
	}

	public Condutor buscarPorCodigo(Long codigo) {
		sql = "SELECT * FROM " + CONDUTORES + " WHERE codigo = ?";

		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql)) {

			stmt.setLong(1, codigo);
			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {
				return new Condutor(
						resultado.getLong("codigo"),
						resultado.getString("cpf"),
						resultado.getString("nome"),
						resultado.getDate("dataNascimento"),
						resultado.getString("numeroCNH"),
						resultado.getString("categoriaCNH"),
						resultado.getDate("dataVencimento")
				);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar condutor por código", e);
		}

		return null;
	}
}
