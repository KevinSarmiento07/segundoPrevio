package com.kass.ufps.segundoParcial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kass.ufps.segundoParcial.modelo.Resultado;
import com.kass.ufps.segundoParcial.modelo.Seleccion;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer>{
	
	List<Resultado> findBySeleccion(Seleccion seleccion);

}
