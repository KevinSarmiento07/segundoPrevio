package com.kass.ufps.segundoParcial.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "seleccion")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seleccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	
	@ManyToOne
	@JoinColumn(name = "continente_id")
	private Continente continente;
	
	private String grupo;

}
