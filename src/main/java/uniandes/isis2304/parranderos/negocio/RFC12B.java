package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC12B {
	
	private BigDecimal idusuario;
	
	private String numdocumento;
	
	private Timestamp analisis;
	
	private String tipodocumento;
	
	private BigDecimal veceshospitalizado;
	
	private BigDecimal citasasistidas;

	@Override
	public String toString() {
		return "RFC12B [idusuario=" + idusuario + ", numdocumento=" + numdocumento + ", analisis=" + analisis
				+ ", tipodocumento=" + tipodocumento + ", veceshospitalizado=" + veceshospitalizado
				+ ", citasasistidas=" + citasasistidas + "]";
	}

	public RFC12B(BigDecimal idusuario, String numdocumento, Timestamp analisis, String tipodocumento,
			BigDecimal veceshospitalizado, BigDecimal citasasistidas) {
		super();
		this.idusuario = idusuario;
		this.numdocumento = numdocumento;
		this.analisis = analisis;
		this.tipodocumento = tipodocumento;
		this.veceshospitalizado = veceshospitalizado;
		this.citasasistidas = citasasistidas;
	}

	public BigDecimal getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(BigDecimal idusuario) {
		this.idusuario = idusuario;
	}

	public String getNumdocumento() {
		return numdocumento;
	}

	public void setNumdocumento(String numdocumento) {
		this.numdocumento = numdocumento;
	}

	public Timestamp getAnalisis() {
		return analisis;
	}

	public void setAnalisis(Timestamp analisis) {
		this.analisis = analisis;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public BigDecimal getVeceshospitalizado() {
		return veceshospitalizado;
	}

	public void setVeceshospitalizado(BigDecimal veceshospitalizado) {
		this.veceshospitalizado = veceshospitalizado;
	}

	public BigDecimal getCitasasistidas() {
		return citasasistidas;
	}

	public void setCitasasistidas(BigDecimal citasasistidas) {
		this.citasasistidas = citasasistidas;
	}
	
	
	

}
