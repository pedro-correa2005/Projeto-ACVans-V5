package com.fooengineers.projetoAcVansV5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooengineers.projetoAcVansV5.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	//Query para pesquisa por nome
	Optional<Role> findByNome(String nome);
}
