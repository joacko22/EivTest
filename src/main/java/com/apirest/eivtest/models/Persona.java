package com.apirest.eivtest.models;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.apirest.eivtest.enums.Genero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipodocumento")@Getter @Setter
	@ManyToOne
	private TipoDocumento idTipoDocumento;
	
	@Column(name = "numero_documento")@Getter @Setter
	private Integer numero_documento;
	
	@Column(name = "fecha_nacimiento")@Getter @Setter
	private String nombre_apellido;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")@Getter @Setter
	private Date fecha_nacimiento;

	@Enumerated(EnumType.STRING)
	@Column(name = "genero")@Getter @Setter
	private Genero genero;
	
	@Column(name = "es_argentino")@Getter @Setter
	private Boolean esArgentino;
	
	@Column(name = "correo_electronico")@Getter @Setter
	private String email;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "foto_cara")@Getter @Setter
	private byte[] foto_cara;
	
	@Column(name = "id_localidad")@Getter @Setter
	@ManyToOne
	private Localidad idLocalidad;

	@Column(name = "codigo_postal")@Getter @Setter
	private Integer codigo_postal;

	

	public Persona(TipoDocumento idTipoDocumento, Integer numero_documento, String nombre_apellido,
			Date fecha_nacimiento, Genero genero, Boolean esArgentino, String email, byte[] foto_cara,
			Localidad idLocalidad, Integer codigo_postal) {
		super();
		this.idTipoDocumento = idTipoDocumento;
		this.numero_documento = numero_documento;
		this.nombre_apellido = nombre_apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.genero = genero;
		this.esArgentino = esArgentino;
		this.email = email;
		this.foto_cara = foto_cara;
		this.idLocalidad = idLocalidad;
		this.codigo_postal = codigo_postal;
	}

	public Persona() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(foto_cara);
		result = prime * result + Objects.hash(codigo_postal, email, esArgentino, fecha_nacimiento, genero, idLocalidad,
				idTipoDocumento, nombre_apellido, numero_documento);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(codigo_postal, other.codigo_postal) && Objects.equals(email, other.email)
				&& Objects.equals(esArgentino, other.esArgentino)
				&& Objects.equals(fecha_nacimiento, other.fecha_nacimiento) && Arrays.equals(foto_cara, other.foto_cara)
				&& genero == other.genero && Objects.equals(idLocalidad, other.idLocalidad)
				&& Objects.equals(idTipoDocumento, other.idTipoDocumento)
				&& Objects.equals(nombre_apellido, other.nombre_apellido)
				&& Objects.equals(numero_documento, other.numero_documento);
	}



}
