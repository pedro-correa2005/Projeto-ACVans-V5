package com.fooengineers.projetoAcVansV5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooengineers.projetoAcVansV5.dto.UsuarioResDTO;
import com.fooengineers.projetoAcVansV5.entity.Usuario;
import com.fooengineers.projetoAcVansV5.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/detalhes-usuario")
	public ResponseEntity<UsuarioResDTO> detalhesUsuario(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		UsuarioResDTO dto = new UsuarioResDTO(usuario);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/ativar-autenticacao")
	public ResponseEntity<?> ativarAutenticacao(Authentication authentication){
		Usuario usuario = (Usuario) authentication.getPrincipal();
		usuarioService.ativarAutenticacao(usuario);
		return ResponseEntity.status(200).build();
	}
	
	@PostMapping("/desativar-autenticacao")
	public ResponseEntity<?> desativarAutenticacao(Authentication authentication){
		Usuario usuario = (Usuario) authentication.getPrincipal();
		usuarioService.desativarAutenticacao(usuario);
		return ResponseEntity.status(200).build();
	}
}
