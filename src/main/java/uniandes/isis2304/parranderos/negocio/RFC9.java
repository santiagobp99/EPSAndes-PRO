package uniandes.isis2304.parranderos.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RFC9 {

	private String nombre;
	private String correo;
	private Timestamp fechaNacimiento;
	private String tipoDocumento;
	private String numDocumento;
	private int hospitalizado;
	private String estado;
	private String tipo;
	private long idIps;
	
	public RFC9() {
		this.nombre = "";
		this.correo = "";
		this.fechaNacimiento = new Timestamp (0);
		this.tipoDocumento = "";
		this.numDocumento = "";
		this.hospitalizado = 0;
		this.estado = "";
		this.tipo = "";
		this.idIps = 0;
	}
	
	public RFC9(String nombre, String correo, Timestamp fechaNacimiento, String tipoDocumento, String numDocumento,
			int hospitalizado, String estado, String tipo, long idIps) {
		this.nombre = nombre;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoDocumento = tipoDocumento;
		this.numDocumento = numDocumento;
		this.hospitalizado = hospitalizado;
		this.estado = estado;
		this.tipo = tipo;
		this.idIps = idIps;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public int getHospitalizado() {
		return hospitalizado;
	}

	public void setHospitalizado(int hospitalizado) {
		this.hospitalizado = hospitalizado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	@Override
	public String toString() {
		return "RFC9 [nombre=" + nombre + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento
				+ ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", hospitalizado="
				+ hospitalizado + ", estado=" + estado + ", tipo=" + tipo + ", idIps=" + idIps + "]";
	}


}
