package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC12A {
	
	private BigDecimal idusuario;
	
	private String numdocumento;
	
	private Timestamp fechanacimiento;
	
	private String tipodocumento;
	
	private BigDecimal serviciosnormales;

	public RFC12A(BigDecimal idusuario, String numdocumento, Timestamp fechanacimiento, String tipodocumento,
			BigDecimal serviciosnormales) {
		super();
		this.idusuario = idusuario;
		this.numdocumento = numdocumento;
		this.fechanacimiento = fechanacimiento;
		this.tipodocumento = tipodocumento;
		this.serviciosnormales = serviciosnormales;
	}

	@Override
	public String toString() {
		return "RFC12A [idusuario=" + idusuario + ", numdocumento=" + numdocumento + ", fechanacimiento="
				+ fechanacimiento + ", tipodocumento=" + tipodocumento + ", serviciosnormales=" + serviciosnormales
				+ "]";
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
	


}
