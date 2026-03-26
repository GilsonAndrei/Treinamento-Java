package com.treinamento.condutores.controller;

import com.treinamento.condutores.dto.EventoMultaDTO;
import com.treinamento.condutores.service.EventoMultaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@RestController
@RequestMapping("/eventos/multa")
public class EventoMultaController {

	@Autowired
	private EventoMultaService service;

	@GetMapping
	public List<EventoMultaDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public EventoMultaDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public EventoMultaDTO criar(@Valid @RequestBody EventoMultaDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public EventoMultaDTO atualizar(@PathVariable Long id,
	                                @Valid @RequestBody EventoMultaDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}