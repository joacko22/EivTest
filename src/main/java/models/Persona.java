package models;

import java.util.Date;

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

import enums.Genero;

@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipodocumento")
	@ManyToOne
	private TiposDocumentos idTipoDocumento;
	
	@Column(name = "numero_documento")
	private Integer numero_documento;
	
	@Column(name = "fecha_nacimiento")
	private String nombre_apellido;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@Enumerated(EnumType.STRING)
	@Column(name = "genero")
	private Genero genero;
	
	@Column(name = "es_argentino")
	private Boolean esArgentino;
	
	@Column(name = "correo_electronico")
	private String email;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "foto_cara")
	private byte[] foto_cara;
	
	@Column(name = "id_localidad")
	@ManyToOne
	private Localidad idLocalidad;

	@Column(name = "codigo_postal")
	private Integer codigo_postal;

	public TiposDocumentos getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TiposDocumentos idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Integer getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Integer numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getNombre_apellido() {
		return nombre_apellido;
	}

	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Boolean getEsArgentino() {
		return esArgentino;
	}

	public void setEsArgentino(Boolean esArgentino) {
		this.esArgentino = esArgentino;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getFoto_cara() {
		return foto_cara;
	}

	public void setFoto_cara(byte[] foto_cara) {
		this.foto_cara = foto_cara;
	}

	public Localidad getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Localidad idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public Integer getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(Integer codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public Persona(TiposDocumentos idTipoDocumento, Integer numero_documento, String nombre_apellido,
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



}
