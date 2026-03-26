package com.treinamento.condutores.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.treinamento.condutores.dto.CondutorDTO;
import com.treinamento.condutores.model.CondutorModel;
import com.treinamento.condutores.service.CondutorService;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@RestController
@RequestMapping("/condutores")
public class CondutorController {

	@Autowired
	private CondutorService service;

	@GetMapping
	public List<CondutorDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public CondutorDTO buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public CondutorDTO criar(@Valid @RequestBody CondutorDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public CondutorDTO atualizar(@PathVariable Long id,
	                             @Valid @RequestBody CondutorDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}