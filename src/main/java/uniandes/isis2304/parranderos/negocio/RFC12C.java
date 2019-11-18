package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC12C {
	
private BigDecimal idusuario;
	
	private String numdocumento;
	
	private Timestamp fechanacimiento;
	
	private String tipodocumento;
	
	private BigDecimal mesesasitidos;

	public RFC12C(BigDecimal idusuario, String numdocumento, Timestamp fechanacimiento, String tipodocumento,
			BigDecimal mesesasitidos) {
		super();
		this.idusuario = idusuario;
		this.numdocumento = numdocumento;
		this.fechanacimiento = fechanacimiento;
		this.tipodocumento = tipodocumento;
		this.mesesasitidos = mesesasitidos;
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

	public BigDecimal getMesesasitidos() {
		return mesesasitidos;
	}

	public void setMesesasitidos(BigDecimal mesesasitidos) {
		this.mesesasitidos = mesesasitidos;
	}

	@Override
	public String toString() {
		return "RFC12C [idusuario=" + idusuario + ", numdocumento=" + numdocumento + ", fechanacimiento="
				+ fechanacimiento + ", tipodocumento=" + tipodocumento + ", mesesasitidos=" + mesesasitidos + "]";
	}
	
	

}
