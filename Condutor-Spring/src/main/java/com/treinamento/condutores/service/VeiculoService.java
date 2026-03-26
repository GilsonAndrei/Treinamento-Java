
package com.treinamento.condutores.service;

import com.treinamento.condutores.dto.EventoDTO;
import com.treinamento.condutores.dto.VeiculoDTO;
import com.treinamento.condutores.model.EventoModel;
import com.treinamento.condutores.model.VeiculoModel;
import com.treinamento.condutores.repository.EventoRepository;
import com.treinamento.condutores.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import net.bytebuddy.implementation.bind.annotation.This;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private EventoRepository repositoryEvento;

	public List<VeiculoDTO> listarTodos() {
		return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public List<VeiculoDTO> listarPaginado(Integer pagina) {
		Pageable pageable = (Pageable) PageRequest.of(0, 3);

		return repository.findAll((Sort) pageable).stream().map(this::toDTO).collect(Collectors.toList());
	}

	public List<EventoDTO> listarEventosVeiculo(Long id) {
		List<EventoModel> eventos = repositoryEvento.findByVeiculoCodigo(id);

		return eventos.stream().map(this::toEventoDTO).collect(Collectors.toList());
	}

	public VeiculoDTO buscarPorId(Long id) {
		return repository.findById(id)
				.map(this::toDTO)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Veículo ID " + id + " não encontrado!"));
	}

	public VeiculoDTO criar(VeiculoDTO dto) {
		if (dto.getPlaca() == null || dto.getPlaca().trim().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Placa obrigatória!");
		}

		if (repository.findByPlaca(dto.getPlaca()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Placa " + dto.getPlaca() + " já cadastrada!");
		}

		VeiculoModel veiculo = dto.toEntity();
		return toDTO(repository.save(veiculo));
	}

	public VeiculoDTO atualizar(Long id, VeiculoDTO dto) {

		VeiculoModel veiculo = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Veículo ID " + id + " não encontrado!"));

		if (!veiculo.getPlaca().equals(dto.getPlaca()) &&
				repository.findByPlaca(dto.getPlaca()).isPresent()) {

			throw new ResponseStatusException(
					HttpStatus.CONFLICT,
					"Placa " + dto.getPlaca() + " já cadastrada em outro veículo!");
		}

		veiculo.setPlaca(dto.getPlaca());
		veiculo.setMarcaModelo(dto.getMarcaModelo());
		veiculo.setAnoFabricacao(dto.getAnoFabricacao());
		veiculo.setDataAquisicao(dto.getDataAquisicao());
		veiculo.setHodometro(dto.getHodometro());

		return toDTO(repository.save(veiculo));
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Veículo ID " + id + " não encontrado!");
		}
		repository.deleteById(id);
	}

	private VeiculoDTO toDTO(VeiculoModel v) {
		VeiculoDTO dto = new VeiculoDTO();
		dto.setCodigo(v.getCodigo());
		dto.setPlaca(v.getPlaca());
		dto.setMarcaModelo(v.getMarcaModelo());
		dto.setAnoFabricacao(v.getAnoFabricacao());
		dto.setDataAquisicao(v.getDataAquisicao());
		dto.setTipoControle(v.getTipoControle().toString());
		dto.setHodometro(v.getHodometro());
		return dto;
	}

	private EventoDTO toEventoDTO(EventoModel e) {
		EventoDTO dto = new EventoDTO();
		dto.setCodigoEvento(e.getCodigo());
		dto.setDataHora(e.getDataHora());
		dto.setLocal(e.getLocal());
		dto.setObservacao(e.getObservacao());
		dto.setTipoEvento(e.getTipoEvento());
		dto.setCodigoVeiculo(e.getVeiculo().getCodigo());

		return dto;
	}
}
