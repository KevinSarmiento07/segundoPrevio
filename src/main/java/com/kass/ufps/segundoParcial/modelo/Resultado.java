package com.kass.ufps.segundoParcial.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resultado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@JoinColumn(name = "partido_id")
	@OneToOne
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name = "seleccion_id")
	private Seleccion seleccion;
	
	private Integer goles;
	
	private Integer amarillas;
	
	private Integer rojas;
}
