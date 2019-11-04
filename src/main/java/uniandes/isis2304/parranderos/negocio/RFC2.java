package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;

public class RFC2 {
	
	private BigDecimal idservicio;
	
	private BigDecimal count;

	public RFC2(BigDecimal id, BigDecimal numero) {
		super();
		this.idservicio = id;
		this.count = numero;
	}

	public BigDecimal getId() {
		return idservicio;
	}

	public void setId(BigDecimal id) {
		this.idservicio = id;
	}

	public BigDecimal getNumero() {
		return count;
	}

	public void setNumero(BigDecimal numero) {
		this.count = numero;
	}
	
	

}
