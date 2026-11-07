package com.fooengineers.projetoAcVansV5.dto;

import com.fooengineers.projetoAcVansV5.entity.TipoServico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicoResDTO {
	private Long id;
	private String descricao;
	
	//Constructor a partir de entity.TipoServico
	public TipoServicoResDTO(TipoServico tipo) {
		this.id = tipo.getId();
		this.descricao = tipo.getDescricao();
	}
}
