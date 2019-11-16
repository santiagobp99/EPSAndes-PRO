package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC9 {

	private String nombre;
	
	private String estado;

	public RFC9() {
		this.nombre = "";
		this.estado = "";
	}

	public RFC9(String nombre, String estado) {
		this.nombre = nombre;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "RFC9 [nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
