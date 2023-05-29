package com.kass.ufps.segundoParcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kass.ufps.segundoParcial.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
