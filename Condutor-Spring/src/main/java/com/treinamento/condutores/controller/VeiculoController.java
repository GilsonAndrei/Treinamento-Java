package com.treinamento.condutores.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.condutores.dto.EventoDTO;
import com.treinamento.condutores.dto.VeiculoDTO;
import com.treinamento.condutores.service.VeiculoService;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;

	@GetMapping
	public List<VeiculoDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping(path = "/pagina/{numeroPagina}")
	public List<VeiculoDTO> listarPorPagina(@PathVariable int numeroPagina) {
		return service.listarPaginado(0);
	}

	@GetMapping(path = "/{id}/eventos")
	public List<EventoDTO> listarEventosVeiculo(@PathVariable Long id) {
		return service.listarEventosVeiculo(id);
	}

	@GetMapping("/{id}")
	public VeiculoDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public VeiculoDTO criar(@Valid @RequestBody VeiculoDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public VeiculoDTO atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}


}
