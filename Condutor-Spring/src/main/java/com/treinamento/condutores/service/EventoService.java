package com.treinamento.condutores.service;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

import com.treinamento.condutores.dto.EventoDTO;
import com.treinamento.condutores.model.EventoModel;
import com.treinamento.condutores.model.VeiculoModel;
import com.treinamento.condutores.repository.EventoRepository;
import com.treinamento.condutores.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<EventoDTO> listarTodos() {
		return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public EventoDTO buscarPorId(Long id) {
		return repository.findById(id).map(this::toDTO).orElseThrow(() ->
				new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Evento ID " + id + " não encontrado!"));
	}

	public EventoDTO criar(EventoDTO dto) {

		if (dto.getDataHora() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Data/Hora obrigatória!");
		}

		if (dto.getLocal() == null || dto.getLocal().trim().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Local obrigatório!");
		}

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() ->
						new ResponseStatusException(HttpStatus.NOT_FOUND,
								"Veículo ID " + dto.getCodigoVeiculo() + " não encontrado!"));

		EventoModel evento = dto.toEntity();
		evento.setVeiculo(veiculo);

		return toDTO(repository.save(evento));
	}

	public EventoDTO atualizar(Long id, EventoDTO dto) {

		EventoModel evento = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
				HttpStatus.NOT_FOUND,
				"Veículo ID " + id + " não encontrado!"
		));

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() ->
						new ResponseStatusException(HttpStatus.NOT_FOUND,
								"Veículo ID " + dto.getCodigoVeiculo() + " não encontrado!"));

		evento.setDataHora(dto.getDataHora());
		evento.setLocal(dto.getLocal());
		evento.setObservacao(dto.getObservacao());
		evento.setTipoEvento(dto.getTipoEvento());
		evento.setVeiculo(veiculo);

		return toDTO(repository.save(evento));
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Evento ID " + id + " não encontrado!");
		}
		repository.deleteById(id);
	}

	private EventoDTO toDTO(EventoModel e) {
		EventoDTO dto = new EventoDTO();

		dto.setCodigoEvento(e.getCodigo());
		dto.setDataHora(e.getDataHora());
		dto.setLocal(e.getLocal());
		dto.setObservacao(e.getObservacao());
		dto.setCodigoVeiculo(e.getVeiculo().getCodigo());
		dto.setTipoEvento(e.getTipoEvento());

		return dto;
	}
}
