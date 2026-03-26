package com.treinamento.condutores.repository;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

import java.util.Optional;

import com.treinamento.condutores.model.CondutorModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository extends JpaRepository<CondutorModel, Long> {

	Optional<CondutorModel> findById(Long id);

	Optional<CondutorModel> findByCpf(String cpf);

	Optional<CondutorModel> findByNumeroCNH(String numeroCNH);
}