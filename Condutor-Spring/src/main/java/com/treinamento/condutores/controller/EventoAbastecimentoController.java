package com.treinamento.condutores.controller;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

import com.treinamento.condutores.dto.EventoAbastecimentoDTO;
import com.treinamento.condutores.service.EventoAbastecimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/eventos/abastecimento")
public class EventoAbastecimentoController {

	@Autowired
	private EventoAbastecimentoService service;

	@GetMapping
	public List<EventoAbastecimentoDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public EventoAbastecimentoDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public EventoAbastecimentoDTO criar(@Valid @RequestBody EventoAbastecimentoDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public EventoAbastecimentoDTO atualizar(@PathVariable Long id,
	                                        @Valid @RequestBody EventoAbastecimentoDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}