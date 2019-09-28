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
public class ConsultaEspecialista implements VOConsultaEspecialista {


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
	private long idMedicoEspecialista;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idOrden;

	public ConsultaEspecialista() {
		
		this.diagnostico = "";
		this.idMedicoEspecialista = 0;
		this.idOrden = 0;
	}

	public ConsultaEspecialista(String diagnostico, long idMedicoEspecialista, long idOrden) {
		super();
		this.diagnostico = diagnostico;
		this.idMedicoEspecialista = idMedicoEspecialista;
		this.idOrden = idOrden;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public long getIdMedicoEspecialista() {
		return idMedicoEspecialista;
	}

	public void setIdMedicoEspecialista(long idMedicoEspecialista) {
		this.idMedicoEspecialista = idMedicoEspecialista;
	}

	public long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}

	@Override
	public String toString() {
		return "ConsultaEspecialista [diagnostico=" + diagnostico + ", idMedicoEspecialista=" + idMedicoEspecialista
				+ ", idOrden=" + idOrden + "]";
	}
	
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

}
