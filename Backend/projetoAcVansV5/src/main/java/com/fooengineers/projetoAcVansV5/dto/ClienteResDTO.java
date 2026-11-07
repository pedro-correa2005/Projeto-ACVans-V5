package com.fooengineers.projetoAcVansV5.dto;

import com.fooengineers.projetoAcVansV5.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResDTO {
	private Long id;
	private String nome;
	private String celular;
	
	//Constructor a partir de entity.Cliente
	public ClienteResDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.celular = cliente.getCelular();
	}
}
