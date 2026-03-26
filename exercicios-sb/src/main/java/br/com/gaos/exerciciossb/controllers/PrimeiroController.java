package br.com.gaos.exerciciossb.controllers;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@RestController
public class PrimeiroController {
	@RequestMapping(method = RequestMethod.GET,path = "/ola")
	public String ola(){
		return "Olá Sprin1g Boot";
	}
}
