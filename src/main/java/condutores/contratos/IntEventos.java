package condutores.contratos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import condutores.models.evento.Evento;
import jdk.jfr.Event;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

//Deixando a interface Genérica eu consigo definir na implementação qual tipo de evento está passando
public interface IntEventos<T extends Evento> {

	void inserir(Connection conn, T evento) throws SQLException;

	void atualizar(Connection conn, T evento) throws SQLException;

	void excluir(Connection conn, Long codigo) throws SQLException;

	T buscarPorCodigo(Connection conn, Long codigo) throws SQLException;
}