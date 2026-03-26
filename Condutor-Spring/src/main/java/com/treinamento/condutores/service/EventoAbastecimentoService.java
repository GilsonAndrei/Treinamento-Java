

package com.treinamento.condutores.service;

import com.treinamento.condutores.dto.EventoAbastecimentoDTO;

import com.treinamento.condutores.model.EventoAbastecimentoModel;

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
public class EventoAbastecimentoService {

	@Autowired
	private EventoAbastecimentoRepository repository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<EventoAbastecimentoDTO> listarTodos() {
		return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public EventoAbastecimentoDTO buscarPorId(Long id) {
		return repository.findById(id)
				.map(this::toDTO)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public EventoAbastecimentoDTO criar(EventoAbastecimentoDTO dto) {

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));

		EventoAbastecimentoModel entity = dto.toEntity();
		entity.setVeiculo(veiculo);

		return toDTO(repository.save(entity));
	}

	public EventoAbastecimentoDTO atualizar(Long id, EventoAbastecimentoDTO dto) {

		EventoAbastecimentoModel entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		VeiculoModel veiculo = veiculoRepository.findById(dto.getCodigoVeiculo())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		entity.setDataHora(dto.getDataHora());
		entity.setLocal(dto.getLocal());
		entity.setObservacao(dto.getObservacao());
		entity.setTipoEvento(dto.getTipoEvento());

		entity.setHodometro(dto.getHodometro());
		entity.setTipoCombustivel(dto.getTipoCombustivel());
		entity.setValorLitro(dto.getValorLitro());
		entity.setLitros(dto.getLitros());

		entity.setVeiculo(veiculo);

		return toDTO(repository.save(entity));
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		repository.deleteById(id);
	}

	private EventoAbastecimentoDTO toDTO(EventoAbastecimentoModel e) {

		EventoAbastecimentoDTO dto = new EventoAbastecimentoDTO();

		dto.setCodigoEvento(e.getCodigo());
		dto.setDataHora(e.getDataHora());
		dto.setLocal(e.getLocal());
		dto.setObservacao(e.getObservacao());
		dto.setCodigoVeiculo(e.getVeiculo().getCodigo());
		dto.setTipoEvento(e.getTipoEvento());

		dto.setHodometro(e.getHodometro());
		dto.setTipoCombustivel(e.getTipoCombustivel());
		dto.setValorLitro(e.getValorLitro());
		dto.setLitros(e.getLitros());

		return dto;
	}
}
