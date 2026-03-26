package com.treinamento.condutores.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.treinamento.condutores.dto.EventoDTO;
import com.treinamento.condutores.service.EventoService;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoService service;

	@GetMapping
	public List<EventoDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public EventoDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public EventoDTO criar(@Valid @RequestBody EventoDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public EventoDTO atualizar(@PathVariable Long id,
	                           @Valid @RequestBody EventoDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}