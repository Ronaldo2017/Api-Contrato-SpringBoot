package com.rc.gestaocontrato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rc.gestaocontrato.domain.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer>{

}
