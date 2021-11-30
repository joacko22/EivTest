package com.apirest.eivtest.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apirest.eivtest.enums.Rol;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        
	@Column(name = "id_tipodocumento")@Getter @Setter
	@ManyToOne
	private Persona idTipoDocumento;

	@Column(name = "numero_documento")@Getter @Setter
	@ManyToOne
	private Persona documento;

	@Column(name = "nombre_usuario")@Getter @Setter
	private String nombreUsuario;

	@Column(name = "hashed_pwd")@Getter @Setter
	private String hashed;
	@Column(name = "rol")@Getter @Setter
	private Rol rol;
	
    @Column(name = "activo")@Getter @Setter
	private Boolean activo;



	@Override
	public int hashCode() {
		return Objects.hash(activo, documento, hashed, idTipoDocumento, nombreUsuario, rol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(activo, other.activo) && Objects.equals(documento, other.documento)
				&& Objects.equals(hashed, other.hashed) && Objects.equals(idTipoDocumento, other.idTipoDocumento)
				&& Objects.equals(nombreUsuario, other.nombreUsuario) && rol == other.rol;
	}

	public Usuario(Persona idTipoDocumento, Persona documento, String nombreUsuario, String hashed, Rol rol,
			Boolean activo) {
		super();
		this.idTipoDocumento = idTipoDocumento;
		this.documento = documento;
		this.nombreUsuario = nombreUsuario;
		this.hashed = hashed;
		this.rol = rol;
		this.activo = activo;
	}

	public Usuario() {
		super();
	}

}
