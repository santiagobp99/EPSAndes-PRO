package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;

public class RFC11C {
	
private String año;
	
	private String semana;
	
	private BigDecimal idafiliadoreservador;
	
	private BigDecimal veces;

	public RFC11C(String año, String semana, BigDecimal idafiliadoreservador, BigDecimal veces) {
		super();
		this.año = año;
		this.semana = semana;
		this.idafiliadoreservador = idafiliadoreservador;
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

	public BigDecimal getIdafiliadoreservador() {
		return idafiliadoreservador;
	}

	public void setIdafiliadoreservador(BigDecimal idafiliadoreservador) {
		this.idafiliadoreservador = idafiliadoreservador;
	}

	public BigDecimal getVeces() {
		return veces;
	}

	public void setVeces(BigDecimal veces) {
		this.veces = veces;
	}

	@Override
	public String toString() {
		return "Año=" + año + ", Aemana=" + semana + ", idAfiliado=" + idafiliadoreservador
				+ ", Veces=" + veces + "";
	}
	
	
	

}
