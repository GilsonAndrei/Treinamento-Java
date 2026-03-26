package com.treinamento.condutores.repository;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

import com.treinamento.condutores.model.EventoModel;

import condutores.enums.TipoEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Long> {

	List<EventoModel> findByTipoEvento(TipoEvento tipoEvento);

	List<EventoModel> findByVeiculoCodigo(Long codigoVeiculo);
}