package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;

public class RFC11B {

private String año;
	
	private String semana;
	
	private BigDecimal idips;
	
	private BigDecimal veces;

	public RFC11B(String año, String semana, BigDecimal idips, BigDecimal veces) {
		super();
		this.año = año;
		this.semana = semana;
		this.idips = idips;
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

	public BigDecimal getIdips() {
		return idips;
	}

	public void setIdips(BigDecimal idips) {
		this.idips = idips;
	}

	public BigDecimal getVeces() {
		return veces;
	}

	public void setVeces(BigDecimal veces) {
		this.veces = veces;
	}

	@Override
	public String toString() {
		return "Año=" + año + ", Semana=" + semana + ", idIps=" + idips + ", Veces=" + veces + "";
	}
	
	
	
}
