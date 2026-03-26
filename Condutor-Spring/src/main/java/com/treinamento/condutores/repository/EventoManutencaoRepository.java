package com.treinamento.condutores.repository;

import com.treinamento.condutores.model.EventoManutencaoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Repository
public interface EventoManutencaoRepository extends JpaRepository<EventoManutencaoModel, Long> {

	List<EventoManutencaoModel> findByVeiculoCodigo(Long codigoVeiculo);
}
