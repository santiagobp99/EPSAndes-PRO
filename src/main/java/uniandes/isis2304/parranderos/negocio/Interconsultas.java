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
public class Interconsultas implements VOInterconsultas {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador �NICO de los bares
	 */
	private long idMedicoEspecialista;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idUrgencias;

	public Interconsultas() {
		this.idMedicoEspecialista = 0;
		this.idUrgencias = 0;
	}

	public Interconsultas(long idMedicoEspecialista, long idUrgencias) {
		this.idMedicoEspecialista = idMedicoEspecialista;
		this.idUrgencias = idUrgencias;
	}

	public long getIdMedicoEspecialista() {
		return idMedicoEspecialista;
	}

	public void setIdMedicoEspecialista(long idMedicoEspecialista) {
		this.idMedicoEspecialista = idMedicoEspecialista;
	}

	public long getIdUrgencias() {
		return idUrgencias;
	}

	public void setIdUrgencias(long idUrgencias) {
		this.idUrgencias = idUrgencias;
	}

	@Override
	public String toString() {
		return "Interconsultas [idMedicoEspecialista=" + idMedicoEspecialista + ", idUrgencias=" + idUrgencias + "]";
	}
	
	
	
	
	
	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/


}
