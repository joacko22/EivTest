package com.apirest.eivtest.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
 @Table(name = "localidades")
public class Localidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_localidad")@Getter @Setter
	private Integer idlocalidad;
 
	@Column(name = "nombre")@Getter @Setter
	private String nombre;
	
	@Column(name = "id_provincias")@Getter @Setter
	@ManyToOne
	private Provincia provincia;
	
	@Column(name = "codigo_postal")@Getter @Setter
	private Integer codigoPostal;

	public Localidad() {
		super();
	}

	public Localidad(Integer idlocalidad, String nombre, Provincia provincia, Integer codigoPostal) {
		super();
		this.idlocalidad = idlocalidad;
		this.nombre = nombre;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(codigoPostal, idlocalidad, nombre, provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		return Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(idlocalidad, other.idlocalidad)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(provincia, other.provincia);
	}
	
}
