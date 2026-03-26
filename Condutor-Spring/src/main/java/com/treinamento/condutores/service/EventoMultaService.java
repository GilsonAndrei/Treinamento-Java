package com.treinamento.condutores.service;

import com.treinamento.condutores.dto.EventoMultaDTO;
import com.treinamento.condutores.model.EventoMultaModel;
import com.treinamento.condutores.model.VeiculoModel;
import com.treinamento.condutores.model.CondutorModel;
import com.treinamento.condutores.repository.EventoMultaRepository;
import com.treinamento.condutores.repository.VeiculoRepository;
import com.treinamento.condutores.repository.CondutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoMultaService {

	@Autowired
	private EventoMultaRepository repository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private CondutorRepository condutorRepository;

	public List<EventoMultaDTO> listarTodos() {
		return repository.findAll()
				.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

	public EventoMultaDTO buscarPorId(Long id) {
		return repository.findById(id)
				.map(this::toDTO)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Evento de multa não encontrado!"));
	}

	public EventoMultaDTO criar(EventoMultaDTO dto) {

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Veículo não encontrado"));

		CondutorModel condutor = condutorRepository.findById(dto.getCodigoCondutor())
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Condutor não encontrado"));

		EventoMultaModel entity = dto.toEntity();

		entity.setVeiculo(veiculo);
		entity.setCondutor(condutor);

		return toDTO(repository.save(entity));
	}

	public EventoMultaDTO atualizar(Long id, EventoMultaDTO dto) {

		EventoMultaModel entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Evento de multa não encontrado"));

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		CondutorModel condutor = condutorRepository.findById(dto.getCodigoCondutor())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		entity.setDataHora(dto.getDataHora());
		entity.setLocal(dto.getLocal());
		entity.setObservacao(dto.getObservacao());
		entity.setTipoEvento(dto.getTipoEvento());
		entity.setTipoInfracao(dto.getTipoInfracao());
		entity.setPontosCnh(dto.getPontosCnh());
		entity.setValorMulta(dto.getValorMulta().doubleValue());
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

	private EventoMultaDTO toDTO(EventoMultaModel e) {

		EventoMultaDTO dto = new EventoMultaDTO();

		dto.setCodigoEvento(e.getCodigo());
		dto.setDataHora(e.getDataHora());
		dto.setLocal(e.getLocal());
		dto.setObservacao(e.getObservacao());
		dto.setCodigoVeiculo(e.getVeiculo().getCodigo());
		dto.setCodigoCondutor(e.getCondutor().getCodigo());
		dto.setTipoEvento(e.getTipoEvento());
		dto.setTipoInfracao(e.getTipoInfracao());
		dto.setPontosCnh(e.getPontosCnh());
		dto.setValorMulta(java.math.BigDecimal.valueOf(e.getValorMulta()));

		return dto;
	}
}