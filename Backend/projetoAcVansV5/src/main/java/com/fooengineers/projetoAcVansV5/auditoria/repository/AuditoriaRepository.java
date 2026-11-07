package com.fooengineers.projetoAcVansV5.auditoria.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fooengineers.projetoAcVansV5.auditoria.entity.Auditoria;
import com.fooengineers.projetoAcVansV5.entity.Oficina;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
	Page<Auditoria> findByOficina(Oficina oficina, Pageable pageable);
}
