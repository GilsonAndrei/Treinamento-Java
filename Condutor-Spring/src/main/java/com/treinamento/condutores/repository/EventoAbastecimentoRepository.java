
package com.treinamento.condutores.repository;

import com.treinamento.condutores.model.EventoAbastecimentoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@Repository
public interface EventoAbastecimentoRepository extends JpaRepository<EventoAbastecimentoModel, Long> {

	List<EventoAbastecimentoModel> findByVeiculoCodigo(Long codigoVeiculo);
}