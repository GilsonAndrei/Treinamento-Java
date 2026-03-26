package condutores.contratos;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public interface IntBaseDao<T, ID> {
	void salvar(T entidade);

	T buscarPorId(ID id);

	void atualizar(T entidade);

	void deletar(T entidade);

	List<T> listarTodos();
}
