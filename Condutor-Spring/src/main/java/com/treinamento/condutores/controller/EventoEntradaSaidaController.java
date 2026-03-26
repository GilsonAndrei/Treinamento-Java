package com.treinamento.condutores.controller;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

import com.treinamento.condutores.dto.EventoEntradaSaidaDTO;
import com.treinamento.condutores.service.EventoEntradaSaidaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@RestController
@RequestMapping("/eventos/entrada-saida")
public class EventoEntradaSaidaController {

	@Autowired
	private EventoEntradaSaidaService service;

	@GetMapping
	public List<EventoEntradaSaidaDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public EventoEntradaSaidaDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public EventoEntradaSaidaDTO criar(@Valid @RequestBody EventoEntradaSaidaDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public EventoEntradaSaidaDTO atualizar(@PathVariable Long id,
	                                       @Valid @RequestBody EventoEntradaSaidaDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}