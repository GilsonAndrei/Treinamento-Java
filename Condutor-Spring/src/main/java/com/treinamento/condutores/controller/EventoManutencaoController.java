
package com.treinamento.condutores.controller;

import com.treinamento.condutores.dto.EventoManutencaoDTO;
import com.treinamento.condutores.service.EventoManutencaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@RestController
@RequestMapping("/eventos/manutencao")
public class EventoManutencaoController {

	@Autowired
	private EventoManutencaoService service;

	@GetMapping
	public List<EventoManutencaoDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public EventoManutencaoDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public EventoManutencaoDTO criar(@Valid @RequestBody EventoManutencaoDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public EventoManutencaoDTO atualizar(@PathVariable Long id,
	                                     @Valid @RequestBody EventoManutencaoDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}