package com.treinamento.condutores.service;

import com.treinamento.condutores.dto.CondutorDTO;
import com.treinamento.condutores.model.CondutorModel;
import com.treinamento.condutores.repository.CondutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Service
public class CondutorService {

	@Autowired
	private CondutorRepository repository;

	public List<CondutorDTO> listarTodos() {
		return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public CondutorDTO buscarPorId(Long id) {
		return repository.findById(id).map(this::toDTO).orElseThrow(() ->
				new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Condutor ID " + id + " não encontrado!"));
	}

	public CondutorDTO criar(CondutorDTO dto) {

		if (dto.getCpf() == null || dto.getCpf().trim().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF obrigatório!");
		}

		if (repository.findByCpf(dto.getCpf()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"CPF " + dto.getCpf() + " já cadastrado!");
		}

		if (dto.getNumeroCNH() != null &&
				repository.findByNumeroCNH(dto.getNumeroCNH()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"CNH " + dto.getNumeroCNH() + " já cadastrada!");
		}

		CondutorModel condutor = dto.toEntity();
		return toDTO(repository.save(condutor));
	}

	public CondutorDTO atualizar(Long id, CondutorDTO dto) {

		CondutorModel condutor = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Condutor ID " + id + " não encontrado!"
				));

		if (!condutor.getCpf().equals(dto.getCpf()) &&
				repository.findByCpf(dto.getCpf()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"CPF " + dto.getCpf() + " já cadastrado em outro condutor!");
		}

		if (dto.getNumeroCNH() != null &&
				!dto.getNumeroCNH().equals(condutor.getNumeroCNH()) &&
				repository.findByNumeroCNH(dto.getNumeroCNH()).isPresent()) {

			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"CNH " + dto.getNumeroCNH() + " já cadastrada em outro condutor!");
		}

		condutor.setCpf(dto.getCpf());
		condutor.setNome(dto.getNome());
		condutor.setDataNascimento(dto.getDataNascimento());
		condutor.setNumeroCNH(dto.getNumeroCNH());
		condutor.setCategoriaCNH(dto.getCategoriaCNH());
		condutor.setDataVencimento(dto.getDataVencimento());

		return toDTO(repository.save(condutor));
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Condutor ID " + id + " não encontrado!");
		}
		repository.deleteById(id);
	}

	private CondutorDTO toDTO(CondutorModel c) {
		CondutorDTO dto = new CondutorDTO();
		dto.setCodigo(c.getCodigo());
		dto.setCpf(c.getCpf());
		dto.setNome(c.getNome());
		dto.setDataNascimento(c.getDataNascimento());
		dto.setNumeroCNH(c.getNumeroCNH());
		dto.setCategoriaCNH(c.getCategoriaCNH());
		dto.setDataVencimento(c.getDataVencimento());
		return dto;
	}
}