package com.kass.ufps.segundoParcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kass.ufps.segundoParcial.modelo.Estadio;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer>{

}
