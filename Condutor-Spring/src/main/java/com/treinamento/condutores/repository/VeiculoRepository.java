package com.treinamento.condutores.repository;

import java.util.List;
import java.util.Optional;

import com.treinamento.condutores.model.VeiculoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
//Verificar, desnecessário ja que o Jpa faz automaticamente.
//	Optional<VeiculoModel> findById(Long id);
//
//	List<VeiculoModel> findAll();
//
//	VeiculoModel save(VeiculoModel entity);
//
//	void deleteById(Long id);

	Optional<VeiculoModel> findByPlaca(String placa);
}
