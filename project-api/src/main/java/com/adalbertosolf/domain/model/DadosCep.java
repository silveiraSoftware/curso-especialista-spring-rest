package com.adalbertosolf.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DadosCep {
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	public String saida() {
		return "{"
			    +"\"cep\":"+this.cep+","
				+"\"logradouro\":\""+ this.logradouro
				+ "\"}";
	}

}
