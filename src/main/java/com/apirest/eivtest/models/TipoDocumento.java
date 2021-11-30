package com.apirest.eivtest.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipos_documentos")
public class TipoDocumento {

    @Column(name = "id_tipodocumento")
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_TipoDocumento;
    @Column(name = "nombre")
    @Getter
    @Setter
    private String nombre;
    @Column(name = "abreviatura")
    @Getter
    @Setter
    private String abreviatura;
    @Column(name = "validar_como_cuit")
    @Getter
    @Setter
    private Boolean validarCuit;//validarCuit

    @Override
    public int hashCode() {
        return Objects.hash(abreviatura, id_TipoDocumento, nombre, validarCuit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) obj;
        return Objects.equals(abreviatura, other.abreviatura) && Objects.equals(id_TipoDocumento, other.id_TipoDocumento)
                && Objects.equals(nombre, other.nombre) && Objects.equals(validarCuit, other.validarCuit);
    }

    public TipoDocumento(Integer id_TipoDocumento, String nombre, String abreviatura, Boolean validarCuit) {
        super();
        this.id_TipoDocumento = id_TipoDocumento;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.validarCuit = validarCuit;
    }

    public TipoDocumento() {
        super();
    }

}
