package com.treinamento.condutores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.condutores.model.EventoMultaModel;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@Repository
public interface EventoMultaRepository extends JpaRepository<EventoMultaModel, Long> {

	List<EventoMultaModel> findByCondutorCodigo(Long codigoCondutor);

	List<EventoMultaModel> findByVeiculoCodigo(Long codigoVeiculo);

}