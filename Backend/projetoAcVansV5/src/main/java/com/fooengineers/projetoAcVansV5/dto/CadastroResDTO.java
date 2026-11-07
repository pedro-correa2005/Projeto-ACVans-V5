package com.fooengineers.projetoAcVansV5.dto;

import java.sql.Timestamp;

import com.fooengineers.projetoAcVansV5.entity.EtapaServico;
import com.fooengineers.projetoAcVansV5.entity.Servico;
import com.fooengineers.projetoAcVansV5.entity.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroResDTO {
	private long idServico;
	private String tokenConsulta;
	private VeiculoResDTO veiculo;
	private TipoServicoResDTO tipo;
	private boolean receberNotificacao;
	private StatusServicoDTO status;
	private Timestamp dataInicio;
	private String etapaTitulo;
	private Timestamp dataFim;
	
	//Constructor a partir de entity.Servico
	public CadastroResDTO(Servico servico) {
		this.idServico = servico.getId();
		
		this.tokenConsulta = servico.getTokenConsulta();
		
		Veiculo veiculo = servico.getVeiculo();
		this.veiculo = new VeiculoResDTO(veiculo);
		
		this.tipo = new TipoServicoResDTO(servico.getTipoServico());
		
		this.receberNotificacao = servico.getReceberNotificacao();
		
		this.status = new StatusServicoDTO(servico.getStatusServico());
		
		this.dataInicio = servico.getDataInicio();
		
		EtapaServico etapa = servico.getEtapaServico();
		this.etapaTitulo = etapa != null? etapa.getTitulo():null;
		
		this.dataFim = servico.getDataFim();
	}
}
