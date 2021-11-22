package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.Regiones;

@Entity
@Table(name = "provincias")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_provincia")
	private Integer idProvincia;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "region")
	@Enumerated(EnumType.STRING)
	Regiones region;
}
