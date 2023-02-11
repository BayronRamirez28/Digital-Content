package com.DigitalContentV2.DigitalContentv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer>{

}
