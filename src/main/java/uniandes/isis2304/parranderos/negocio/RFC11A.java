package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC11A {
	
	
	private String año;
	
	private String semana;
	
	private String tipo;
	
	private BigDecimal veces;

	public RFC11A(String año, String semana, String tipo, BigDecimal veces) {
		super();
		this.año = año;
		this.semana = semana;
		this.tipo = tipo;
		this.veces = veces;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getVeces() {
		return veces;
	}

	public void setVeces(BigDecimal veces) {
		this.veces = veces;
	}

	@Override
	public String toString() {
		return "Año=" + año + ", Semana=" + semana + ", Tipo=" + tipo + ", Veces=" + veces + "";
	}
	
	//private Timestamp fechanacimiento;
	
	
	
	


}
