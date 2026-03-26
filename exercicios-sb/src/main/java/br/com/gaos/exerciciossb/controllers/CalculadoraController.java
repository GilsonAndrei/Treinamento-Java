package br.com.gaos.exerciciossb.controllers;

import java.lang.reflect.Parameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@RestController
@RequestMapping(path = "/calculadora")

public class CalculadoraController {
	//Calculadora/Somar/10/20
	//Calculadora/Subtrair?a=10&b=20

	@GetMapping(path = "/somar/{a}/{b}")
	public Integer somar(@PathVariable Integer a, @PathVariable Integer b) {
		return a + b;
	}

	@GetMapping(path = "/subtrair")
	public Integer subtrair(@RequestParam(name = "a") Integer a, @RequestParam(name = "b") Integer b) {
		return a - b;
	}

}
