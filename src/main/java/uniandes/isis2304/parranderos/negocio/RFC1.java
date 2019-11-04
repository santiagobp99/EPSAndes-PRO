package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;

public class RFC1 {

	private BigDecimal idIps;
	
	private BigDecimal numero;

	public RFC1(BigDecimal idIps, BigDecimal numero) {
		super();
		this.idIps = idIps;
		this.numero = numero;
	}

	public BigDecimal getIdIps() {
		return idIps;
	}

	public void setIdIps(BigDecimal idIps) {
		this.idIps = idIps;
	}

	public BigDecimal getNumero() {
		return numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}
	
	
}
