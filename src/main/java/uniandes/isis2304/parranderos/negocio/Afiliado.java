package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar la relaci�n nombre-tabla del negocio de los Parranderos:
 * 
 * 
 * 
 * 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public class Afiliado implements VOAfiliado{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador �NICO de los bares
	 */
	private long idEps;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idUsuario;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private Timestamp fechaNacimiento;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String tipoDocumento;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private int hospitalizado;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String numDocumento;
	


	public Afiliado() {
		this.idEps = 0;
		this.idUsuario = 0;
		this.fechaNacimiento = new Timestamp (0);
		this.tipoDocumento = "";
		this.hospitalizado = 0;
		this.numDocumento = "";
	}



	public Afiliado(long idEps, long idUsuario, Timestamp fechaNacimiento, String tipoDocumento, int hospitalizado,
			String numDocumento) {
		this.idEps = idEps;
		this.idUsuario = idUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoDocumento = tipoDocumento;
		this.hospitalizado = hospitalizado;
		this.numDocumento = numDocumento;
	}



	public long getIdEps() {
		return idEps;
	}



	public void setIdEps(long idEps) {
		this.idEps = idEps;
	}



	public long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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



	public int getHospitalizado() {
		return hospitalizado;
	}



	public void setHospitalizado(int hospitalizado) {
		this.hospitalizado = hospitalizado;
	}



	public String getNumDocumento() {
		return numDocumento;
	}



	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}



	@Override
	public String toString() {
		return "Afiliado [idEps=" + idEps + ", idUsuario=" + idUsuario + ", fechaNacimiento=" + fechaNacimiento
				+ ", tipoDocumento=" + tipoDocumento + ", hospitalizado=" + hospitalizado + ", numDocumento="
				+ numDocumento + "]";
	}

}
