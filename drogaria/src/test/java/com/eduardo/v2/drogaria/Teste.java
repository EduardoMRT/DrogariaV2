package com.eduardo.v2.drogaria;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.eduardo.v2.drogaria.repository.EstadoRepository;
import com.eduardo.v2.drogaria.response.EstadoResponse;


public class Teste {
	
	private EstadoRepository repository;
	
	@Test
	public List<EstadoResponse> getAll(){
		List<EstadoResponse> estadoList = repository.findAll().stream().map(EstadoResponse::new).toList();
		return estadoList;
	}
	
	@Test
	public static void Main(String[] args) {
		System.out.println("ABC");
	}
}
