package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC6 {

	private BigDecimal contador;
	
	private Timestamp analisis;

	public RFC6(BigDecimal idIps, Timestamp numero) {
		this.contador = idIps;
		this.analisis = numero;
	}

	public BigDecimal getContador() {
		return contador;
	}

	public void setContador(BigDecimal contador) {
		this.contador = contador;
	}

	public Timestamp getAnalisis() {
		return analisis;
	}

	public void setAnalisis(Timestamp analisis) {
		this.analisis = analisis;
	}

	@Override
	public String toString() {
		return "RFC6 [contador=" + contador + ", analisis=" + analisis + "]";
	}



	
	
}
