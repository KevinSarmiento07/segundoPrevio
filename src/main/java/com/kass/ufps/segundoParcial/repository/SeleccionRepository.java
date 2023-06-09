package com.kass.ufps.segundoParcial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kass.ufps.segundoParcial.modelo.Seleccion;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer>{
	
	List<Seleccion> findByGrupo(String grupo);

}
