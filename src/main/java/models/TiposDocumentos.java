package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
 @Table(name = "tipos_documentos")
public class TiposDocumentos {
   @Column(name = "id_tipodocumento")
	private Integer id_TipoDocumento;
   @Column(name = "nombre")
   private String nombre;
   @Column(name = "abreviatura")
   private String abreviatura;
   @Column(name = "validar_como_cuit")
   private Boolean validarcuit;//validarCuit
}
