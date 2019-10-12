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
	private long id;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idMedicoTratante;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String diagnostico;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private int prioridadTriage;

	public ConsultaUrgencias() {
		
		this.id = 0;
		this.idMedicoTratante = 0;
		this.diagnostico = "";
		this.prioridadTriage = 0;
	}

	public ConsultaUrgencias(long id, long idMedicoTratante, String diagnostico, int prioridadTriage) {
		
		this.id = id;
		this.idMedicoTratante = idMedicoTratante;
		this.diagnostico = diagnostico;
		this.prioridadTriage = prioridadTriage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdMedicoTratante() {
		return idMedicoTratante;
	}

	public void setIdMedicoTratante(long idMedicoTratante) {
		this.idMedicoTratante = idMedicoTratante;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public int getPrioridadTriage() {
		return prioridadTriage;
	}

	public void setPrioridadTriage(int prioridadTriage) {
		this.prioridadTriage = prioridadTriage;
	}

	@Override
	public String toString() {
		return "ConsultaUrgencias [id=" + id + ", idMedicoTratante=" + idMedicoTratante + ", diagnostico=" + diagnostico
				+ ", prioridadTriage=" + prioridadTriage + "]";
	}
	
}
