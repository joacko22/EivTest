package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enums.Rol;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipodocumento")
	@ManyToOne
	private Persona idTipoDocumento;

	@Column(name = "numero_documento")
	@ManyToOne
	private Persona documento;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column(name = "hashed_pwd")
	private String hashed;
	@Column(name = "rol")
	private Rol rol;
	
    @Column(name = "activo")
	private Boolean activo;

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Persona getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Persona idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Persona getDocumento() {
		return documento;
	}

	public void setDocumento(Persona documento) {
		this.documento = documento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getHashed() {
		return hashed;
	}

	public void setHashed(String hashed) {
		this.hashed = hashed;
	}

}
