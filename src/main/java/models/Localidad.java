package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
 @Table(name = "localidades")
public class Localidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_localidad")
	private Integer idlocalidad;
 
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "id_provincias")
	@ManyToOne
	Provincia provincia;
	
	@Column(name = "codigo_postal")
	private Integer codigoPostal;
	
}
