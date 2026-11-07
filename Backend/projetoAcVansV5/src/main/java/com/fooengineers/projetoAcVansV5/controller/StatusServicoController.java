package com.fooengineers.projetoAcVansV5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooengineers.projetoAcVansV5.dto.StatusServicoDTO;
import com.fooengineers.projetoAcVansV5.service.StatusServicoService;

@RestController
@RequestMapping("/api/status-servico")
public class StatusServicoController {
	@Autowired
	StatusServicoService statusServicoService;
	
	@GetMapping
	public List<StatusServicoDTO> listar(){
		return statusServicoService.listar();
	}
}
