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
public class Recepcionista implements VORecepcionista {

	
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
	private long idIps;

	public Recepcionista() {
		
		this.id = 0;
		this.idIps = 0;
	}

	public Recepcionista(long id, long idIps) {
		
		this.id = id;
		this.idIps = idIps;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	@Override
	public String toString() {
		return "Recepcionista [id=" + id + ", idIps=" + idIps + "]";
	}
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

}
