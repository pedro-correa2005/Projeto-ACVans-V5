package com.fooengineers.projetoAcVansV5.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicoReqDTO {
	@NotBlank(message = "Descricao é obrigatória")
	private String descricao;
}
