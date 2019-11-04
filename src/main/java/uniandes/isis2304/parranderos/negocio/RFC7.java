package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;

public class RFC7 {
	
	private BigDecimal idafiliadotomador;
	
	private BigDecimal numeroservicios;
	
	private BigDecimal diferentes;

	public RFC7(BigDecimal idafiliadotomador, BigDecimal numeroservicios, BigDecimal diferentes) {
		super();
		this.idafiliadotomador = idafiliadotomador;
		this.numeroservicios = numeroservicios;
		this.diferentes = diferentes;
	}

	public BigDecimal getIdafiliadotomador() {
		return idafiliadotomador;
	}

	public void setIdafiliadotomador(BigDecimal idafiliadotomador) {
		this.idafiliadotomador = idafiliadotomador;
	}

	public BigDecimal getNumeroservicios() {
		return numeroservicios;
	}

	public void setNumeroservicios(BigDecimal numeroservicios) {
		this.numeroservicios = numeroservicios;
	}

	public BigDecimal getDiferentes() {
		return diferentes;
	}

	public void setDiferentes(BigDecimal diferentes) {
		this.diferentes = diferentes;
	}
	
	
	
	

}
