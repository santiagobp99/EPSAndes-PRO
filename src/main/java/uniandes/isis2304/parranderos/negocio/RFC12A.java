package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC12A {
	
	private BigDecimal idusuario;
	
	private String numdocumento;
	
	private Timestamp fechanacimiento;
	
	private String tipodocumento;
	
	private BigDecimal serviciosnormales;
	
	private BigDecimal veceshospitalizado;
	
	private BigDecimal citasasistidas;
	
	private BigDecimal mesesasistidos;

	public RFC12A(BigDecimal idusuario, String numdocumento, Timestamp fechanacimiento, String tipodocumento,
			BigDecimal serviciosnormales, BigDecimal veceshospitalizado, BigDecimal citasasistidas,
			BigDecimal mesesasistidos) {
		super();
		this.idusuario = idusuario;
		this.numdocumento = numdocumento;
		this.fechanacimiento = fechanacimiento;
		this.tipodocumento = tipodocumento;
		this.serviciosnormales = serviciosnormales;
		this.veceshospitalizado = veceshospitalizado;
		this.citasasistidas = citasasistidas;
		this.mesesasistidos = mesesasistidos;
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

	public Timestamp getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Timestamp fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public BigDecimal getServiciosnormales() {
		return serviciosnormales;
	}

	public void setServiciosnormales(BigDecimal serviciosnormales) {
		this.serviciosnormales = serviciosnormales;
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

	public BigDecimal getMesesasistidos() {
		return mesesasistidos;
	}

	public void setMesesasistidos(BigDecimal mesesasistidos) {
		this.mesesasistidos = mesesasistidos;
	}

	@Override
	public String toString() {
		return "RFC12A [idusuario=" + idusuario + ", numdocumento=" + numdocumento + ", fechanacimiento="
				+ fechanacimiento + ", tipodocumento=" + tipodocumento + ", serviciosnormales=" + serviciosnormales
				+ ", veceshospitalizado=" + veceshospitalizado + ", citasasistidas=" + citasasistidas
				+ ", mesesasistidos=" + mesesasistidos + "]";
	}
	
	

}