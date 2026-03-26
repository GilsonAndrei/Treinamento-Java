package com.treinamento.condutores.service;


import com.treinamento.condutores.dto.CondutorDTO;
import com.treinamento.condutores.dto.EventoSinistroDTO;
import com.treinamento.condutores.model.CondutorModel;
import com.treinamento.condutores.model.EventoSinistroModel;
import com.treinamento.condutores.model.VeiculoModel;
import com.treinamento.condutores.repository.*;

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
public class EventoSinistroService {

	@Autowired
	private EventoSinistroRepository repository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private CondutorRepository condutorRepository;

	public List<EventoSinistroDTO> listarTodos() {
		return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public EventoSinistroDTO buscarPorId(Long id) {
		return repository.findById(id)
				.map(this::toDTO)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sinistro não encontrado"));
	}

	public EventoSinistroDTO criar(EventoSinistroDTO dto) {

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));

		CondutorModel condutor = condutorRepository.findById(dto.getCodigoCondutor())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Condutor não encontrado"));

		EventoSinistroModel entity = dto.toEntity();

		entity.setVeiculo(veiculo);
		entity.setCondutor(condutor);

		return toDTO(repository.save(entity));
	}

	public EventoSinistroDTO atualizar(Long id, EventoSinistroDTO dto) {

		EventoSinistroModel entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		CondutorModel condutor = condutorRepository.findById(dto.getCodigoCondutor())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		entity.setDataHora(dto.getDataHora());
		entity.setLocal(dto.getLocal());
		entity.setObservacao(dto.getObservacao());
		entity.setTipoEvento(dto.getTipoEvento());

		entity.setHouveVitimas(dto.getHouveVitimas());
		entity.setHouveEnvolvidos(dto.getHouveEnvolvidos());
		entity.setLaudo(dto.getLaudo());

		entity.setVeiculo(veiculo);
		entity.setCondutor(condutor);

		return toDTO(repository.save(entity));
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		repository.deleteById(id);
	}

	private EventoSinistroDTO toDTO(EventoSinistroModel e) {

		EventoSinistroDTO dto = new EventoSinistroDTO();

		dto.setCodigoEvento(e.getCodigo());
		dto.setDataHora(e.getDataHora());
		dto.setLocal(e.getLocal());
		dto.setObservacao(e.getObservacao());
		dto.setCodigoVeiculo(e.getVeiculo().getCodigo());
		dto.setCodigoCondutor(e.getCondutor().getCodigo());
		dto.setTipoEvento(e.getTipoEvento());

		dto.setHouveVitimas(e.isHouveVitimas());
		dto.setHouveEnvolvidos(e.isHouveEnvolvidos());
		dto.setLaudo(e.getLaudo());

		return dto;
	}
}