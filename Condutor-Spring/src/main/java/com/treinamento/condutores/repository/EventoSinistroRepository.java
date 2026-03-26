package com.treinamento.condutores.repository;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.treinamento.condutores.model.EventoSinistroModel;

@Repository
public interface EventoSinistroRepository extends JpaRepository<EventoSinistroModel, Long> {

	List<EventoSinistroModel> findByCondutorCodigo(Long codigoCondutor);

	List<EventoSinistroModel> findByVeiculoCodigo(Long codigoVeiculo);
}