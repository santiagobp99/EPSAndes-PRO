package uniandes.isis2304.parranderos.negocio;

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
public class ConsultaUrgencias implements VOConsultaUrgencias {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador �NICO de los bares
	 */
	private String diagnostico;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idRecepcionista;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idMedicoTratante;

	public ConsultaUrgencias() {
		
		this.diagnostico = "";
		this.idRecepcionista = 0;
		this.idMedicoTratante = 0;
	}

	public ConsultaUrgencias(String diagnostico, long idRecepcionista, long idMedicoTratante) {
		
		this.diagnostico = diagnostico;
		this.idRecepcionista = idRecepcionista;
		this.idMedicoTratante = idMedicoTratante;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public long getIdMedicoTratante() {
		return idMedicoTratante;
	}

	public void setIdMedicoTratante(long idMedicoTratante) {
		this.idMedicoTratante = idMedicoTratante;
	}

	@Override
	public String toString() {
		return "ConsultaUrgencias [diagnostico=" + diagnostico + ", idRecepcionista=" + idRecepcionista
				+ ", idMedicoTratante=" + idMedicoTratante + "]";
	}
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/



}
