package com.gabriel.helpdesk.domain.enums;

import com.gabriel.helpdesk.domain.enums.Status;

public enum Status {
	
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), FECHADO(2, "FECHADO");
	
	private Integer codigo;
	private String descricao;
	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status inválido");
	}

}
