package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC11A {
	
	
	private String año;
	
	private String semana;
	
	private BigDecimal idafiliado;
	
	private BigDecimal veces;
	
	private BigDecimal idips;
	
	private String tipo;

	public RFC11A(String año, String semana, BigDecimal idafiliado, BigDecimal veces, BigDecimal idips, String tipo) {
		super();
		this.año = año;
		this.semana = semana;
		this.idafiliado = idafiliado;
		this.veces = veces;
		this.idips = idips;
		this.tipo = tipo;
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

	public BigDecimal getIdafiliado() {
		return idafiliado;
	}

	public void setIdafiliado(BigDecimal idafiliado) {
		this.idafiliado = idafiliado;
	}

	public BigDecimal getVeces() {
		return veces;
	}

	public void setVeces(BigDecimal veces) {
		this.veces = veces;
	}

	public BigDecimal getIdips() {
		return idips;
	}

	public void setIdips(BigDecimal idips) {
		this.idips = idips;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "RFC11A [año=" + año + ", semana=" + semana + ", idafiliado=" + idafiliado + ", veces=" + veces
				+ ", idips=" + idips + ", tipo=" + tipo + "]";
	}
	


	

	
	
	


}