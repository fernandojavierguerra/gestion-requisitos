package com.durgam.guerra.dominio;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class RequisitoSimple extends Requisito {

	public RequisitoSimple() {
		super();
		}

	public RequisitoSimple(long id, String nombre, String necesidad, String prioridad, String riesgo,
			Proyecto proyecto) {
		super(id, nombre, necesidad, prioridad, riesgo, proyecto);
	}
	
	public Boolean compuesto() {
		return Boolean.FALSE;
	}

}
