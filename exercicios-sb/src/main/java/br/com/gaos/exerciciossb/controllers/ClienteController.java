package br.com.gaos.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gaos.exerciciossb.models.Cliente;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@RestController
@RequestMapping(path = "/clientes")

public class ClienteController {
	@GetMapping(path = "/qualquer")
	public Cliente obterCliente(){
		return new Cliente (28,"GILSON","39511950886");
	}
	@GetMapping("/{id}")
	public Cliente obterClientePorId1(@PathVariable int id){
		return new Cliente(id, "Maria TES111TE", "7777777777777777");
	}

	@GetMapping
	public Cliente obterClientePorId2(@RequestParam(name="id") Integer id){
		return new Cliente (id, "JOão maria", "1234567890");
	}




}
