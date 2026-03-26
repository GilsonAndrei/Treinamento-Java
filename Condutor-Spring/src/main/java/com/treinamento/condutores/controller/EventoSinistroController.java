package com.treinamento.condutores.controller;

import com.treinamento.condutores.dto.EventoSinistroDTO;
import com.treinamento.condutores.service.EventoSinistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/eventos/sinistro")
public class EventoSinistroController {

	@Autowired
	private EventoSinistroService service;

	@GetMapping
	public List<EventoSinistroDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public EventoSinistroDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public EventoSinistroDTO criar(@Valid @RequestBody EventoSinistroDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public EventoSinistroDTO atualizar(@PathVariable Long id,
	                                   @Valid @RequestBody EventoSinistroDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}