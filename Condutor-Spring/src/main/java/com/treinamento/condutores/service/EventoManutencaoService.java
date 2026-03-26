package com.treinamento.condutores.service;

import com.treinamento.condutores.dto.EventoManutencaoDTO;
import com.treinamento.condutores.model.EventoManutencaoModel;
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
public class EventoManutencaoService {

	@Autowired
	private EventoManutencaoRepository repository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<EventoManutencaoDTO> listarTodos() {
		return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public EventoManutencaoDTO buscarPorId(Long id) {
		return repository.findById(id)
				.map(this::toDTO)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manutenção não encontrada"));
	}

	public EventoManutencaoDTO criar(EventoManutencaoDTO dto) {

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));

		EventoManutencaoModel entity = dto.toEntity();
		entity.setVeiculo(veiculo);

		return toDTO(repository.save(entity));
	}

	public EventoManutencaoDTO atualizar(Long id, EventoManutencaoDTO dto) {

		EventoManutencaoModel entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		entity.setDataHora(dto.getDataHora());
		entity.setLocal(dto.getLocal());
		entity.setObservacao(dto.getObservacao());
		entity.setTipoEvento(dto.getTipoEvento());

		entity.setHodometro(dto.getHodometro());
		entity.setServicosRealizados(dto.getServicosRealizados());
		entity.setVeiculo(veiculo);

		return toDTO(repository.save(entity));
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		repository.deleteById(id);
	}

	private EventoManutencaoDTO toDTO(EventoManutencaoModel e) {

		EventoManutencaoDTO dto = new EventoManutencaoDTO();

		dto.setCodigoEvento(e.getCodigo());
		dto.setDataHora(e.getDataHora());
		dto.setLocal(e.getLocal());
		dto.setObservacao(e.getObservacao());
		dto.setCodigoVeiculo(e.getVeiculo().getCodigo());
		dto.setTipoEvento(e.getTipoEvento());

		dto.setHodometro(e.getHodometro());
		dto.setServicosRealizados(e.getServicosRealizados());

		return dto;
	}
}