package condutores.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import condutores.enums.TipoControle;
import condutores.models.Veiculo;
import condutores.util.Conexao;

import static condutores.util.Tabelas.*;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class VeiculoDao {
	private String sql = "";

	public void inserir(Veiculo veiculo) {
		sql = "INSERT INTO " + VEICULOS + " (dataAquisicao,anoFabricacao,placa,marcaModelo,tipoControle,hodometro)" +
				"VALUES(?,?,?,?,?,?)";
		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql)) {
			stmt.setDate(1, (Date) veiculo.getDataAquisicao());
			stmt.setInt(2, veiculo.getAnoFabricacao());
			stmt.setString(3, veiculo.getPlaca());
			stmt.setString(4, veiculo.getMarcaModelo());
			stmt.setString(5, veiculo.getTipoControle().name());
			stmt.setDouble(6, veiculo.getHodometro());
			stmt.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir veiculo", e);
		}
	}

	public void atualizar(Veiculo veiculo) {
		sql = "UPDATE " + VEICULOS + " " +
				"SET dataAquisicao = ?," +
				"anoFabricacao     = ?," +
				"placa             = ?" +
				"marcaModelo       = ?," +
				"tipoControle      = ?," +
				"hodometro         = ?" +
				"WHERE codigo = ?";
		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql)) {
			stmt.setDate(1, (Date) veiculo.getDataAquisicao());
			stmt.setInt(2, veiculo.getAnoFabricacao());
			stmt.setString(3, veiculo.getPlaca());
			stmt.setString(4, veiculo.getMarcaModelo());
			stmt.setString(5, veiculo.getTipoControle().name());
			stmt.setDouble(6, veiculo.getHodometro());
			stmt.setLong(7, veiculo.getCodigo());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar veiculo", e);
		}
	}

	public void excluir(Long codigo) {
		sql = "DELETE " +
				"FROM " + VEICULOS +
				" WHERE codigo = ?";

		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql)) {

			stmt.setLong(1, codigo);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir veiculo", e);
		}
	}

	public Veiculo listarPorId(Long codigo) {
		sql = "SELECT * FROM " + VEICULOS + " WHERE codigo = ?";

		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql)) {
			stmt.setLong(1, codigo);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				return new Veiculo(
						resultado.getLong("codigo"),
						resultado.getDate("dataAquisicao"),
						resultado.getInt("anoFabricacao"),
						resultado.getString("placa"),
						resultado.getString("marcaModelo"),
						TipoControle.valueOf(resultado.getString("tipoControle")),
						resultado.getDouble("hodometro"));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar por ID", e);
		}
		return null;
	}

	public List<Veiculo> listarTodos() {
		sql = "SELECT * FROM " + VEICULOS;
		List<Veiculo> lVeiculos = new ArrayList<>();

		try (Connection DB = Conexao.getConexao();
		     PreparedStatement stmt = DB.prepareStatement(sql);) {
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				Veiculo veiculo = new Veiculo(
						resultado.getLong("codigo"),
						resultado.getDate("dataAquisicao"),
						resultado.getInt("anoFabricacao"),
						resultado.getString("placa"),
						resultado.getString("marcaModelo"),
						TipoControle.valueOf(resultado.getString("tipoControle")),
						resultado.getDouble("hodometro"));
				lVeiculos.add(veiculo);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar veiculos", e);
		}
		return lVeiculos;
	}
}
