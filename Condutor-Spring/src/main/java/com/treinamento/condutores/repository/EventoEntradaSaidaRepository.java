package com.treinamento.condutores.repository;

import com.treinamento.condutores.model.EventoEntradaSaidaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Repository
public interface EventoEntradaSaidaRepository extends JpaRepository<EventoEntradaSaidaModel, Long> {

	List<EventoEntradaSaidaModel> findByVeiculoCodigo(Long codigoVeiculo);

}