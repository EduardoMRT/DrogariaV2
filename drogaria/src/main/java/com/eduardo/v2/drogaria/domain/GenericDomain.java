package com.eduardo.v2.drogaria.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
public class GenericDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}
}
