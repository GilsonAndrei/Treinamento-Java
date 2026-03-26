package com.treinamento.condutores.service;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

import com.treinamento.condutores.dto.EventoEntradaSaidaDTO;
import com.treinamento.condutores.model.EventoEntradaSaidaModel;
import com.treinamento.condutores.model.VeiculoModel;
import com.treinamento.condutores.model.CondutorModel;
import com.treinamento.condutores.repository.EventoEntradaSaidaRepository;
import com.treinamento.condutores.repository.VeiculoRepository;
import com.treinamento.condutores.repository.CondutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoEntradaSaidaService {

	@Autowired
	private EventoEntradaSaidaRepository repository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private CondutorRepository condutorRepository;

	public List<EventoEntradaSaidaDTO> listarTodos() {
		return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public EventoEntradaSaidaDTO buscarPorId(Long id) {
		return repository.findById(id).map(this::toDTO).orElseThrow(() ->
				new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Evento não encontrado!"));
	}

	public EventoEntradaSaidaDTO criar(EventoEntradaSaidaDTO dto) {

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() ->
						new ResponseStatusException(HttpStatus.NOT_FOUND,
								"Veículo não encontrado"));

		CondutorModel condutor = condutorRepository.findById(dto.getCodigoCondutor())
				.orElseThrow(() ->
						new ResponseStatusException(HttpStatus.NOT_FOUND,
								"Condutor não encontrado"));

		EventoEntradaSaidaModel entity = dto.toEntity();

		entity.setVeiculo(veiculo);
		entity.setCondutor(condutor);

		return toDTO(repository.save(entity));
	}

	public EventoEntradaSaidaDTO atualizar(Long id, EventoEntradaSaidaDTO dto) {

		EventoEntradaSaidaModel entity = repository.findById(id).orElseThrow(() ->
				new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Veículo não encontrado"));

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		CondutorModel condutor = condutorRepository.findById(dto.getCodigoCondutor())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		entity.setDataHora(dto.getDataHora());
		entity.setLocal(dto.getLocal());
		entity.setObservacao(dto.getObservacao());
		entity.setTipoEvento(dto.getTipoEvento());
		entity.setTipoMovimento(dto.getTipoMovimento());
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

	private EventoEntradaSaidaDTO toDTO(EventoEntradaSaidaModel e) {

		EventoEntradaSaidaDTO dto = new EventoEntradaSaidaDTO();

		dto.setCodigoEvento(e.getCodigo());
		dto.setDataHora(e.getDataHora());
		dto.setLocal(e.getLocal());
		dto.setObservacao(e.getObservacao());
		dto.setCodigoVeiculo(e.getVeiculo().getCodigo());
		dto.setCodigoCondutor(e.getCondutor().getCodigo());
		dto.setTipoMovimento(e.getTipoMovimento());
		dto.setTipoEvento(e.getTipoEvento());

		return dto;
	}
}