package com.eduardo.v2.drogaria;

import com.eduardo.v2.drogaria.jpa.BuscaEstado;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DrogariaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(DrogariaApplication.class).run(args);
		BuscaEstado estado = applicationContext.getBean(BuscaEstado.class);
		estado.buscar();
	}
}
