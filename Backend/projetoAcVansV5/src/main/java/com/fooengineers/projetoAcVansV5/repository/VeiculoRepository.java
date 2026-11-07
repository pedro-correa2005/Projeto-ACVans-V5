package com.fooengineers.projetoAcVansV5.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fooengineers.projetoAcVansV5.entity.Cliente;
import com.fooengineers.projetoAcVansV5.entity.Oficina;
import com.fooengineers.projetoAcVansV5.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, JpaSpecificationExecutor<Veiculo>{
	//Query para filtrar por cliente
	Page<Veiculo> findByCliente(Cliente c ,Pageable pageable);
	Page<Veiculo> findAll(Specification<Veiculo> specification, Pageable pageable);
	
	//Query para filtrar por placa e oficina
	Optional<Veiculo> findByPlacaAndOficina(String placa, Oficina oficina);
	
	//Query para contar número de veículos por cliente
	long countByCliente(Cliente c);
}
