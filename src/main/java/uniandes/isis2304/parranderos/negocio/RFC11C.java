package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;

public class RFC11C {
	
private String anno;
	
	private String semana;
	
	private BigDecimal idafiliado;
	
	private BigDecimal veces;

	public RFC11C(String año, String semana, BigDecimal idafiliadoreservador, BigDecimal veces) {
		super();
		this.anno = año;
		this.semana = semana;
		this.idafiliado = idafiliadoreservador;
		this.veces = veces;
	}

	public String getAño() {
		return anno;
	}

	public void setAño(String año) {
		this.anno = año;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public BigDecimal getIdafiliadoreservador() {
		return idafiliado;
	}

	public void setIdafiliadoreservador(BigDecimal idafiliadoreservador) {
		this.idafiliado = idafiliadoreservador;
	}

	public BigDecimal getVeces() {
		return veces;
	}

	public void setVeces(BigDecimal veces) {
		this.veces = veces;
	}

	@Override
	public String toString() {
		return "Año=" + anno + ", Aemana=" + semana + ", idAfiliado=" + idafiliado
				+ ", Veces=" + veces + "";
	}
	
	
	

}
