package com.apirest.eivtest.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.apirest.eivtest.enums.Regiones;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "provincias")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_provincia")@Getter @Setter
	private Integer idProvincia;
	
	@Column(name = "nombre")@Getter @Setter
	private String nombre;
	
	@Column(name = "region")@Getter @Setter
	@Enumerated(EnumType.STRING)
	Regiones region;

	

	@Override
	public int hashCode() {
		return Objects.hash(idProvincia, nombre, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return Objects.equals(idProvincia, other.idProvincia) && Objects.equals(nombre, other.nombre)
				&& region == other.region;
	}

	public Provincia(Integer idProvincia, String nombre, Regiones region) {
		super();
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.region = region;
	}

	public Provincia() {
		super();
	}
	
}
