package com.fooengineers.projetoAcVansV5.dto;

import com.fooengineers.projetoAcVansV5.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResDTO {
	private Integer id;
	private String name;
	
	public RoleResDTO(Role role) {
		this.id = role.getId();
		this.name = role.getNome();
	}
}
