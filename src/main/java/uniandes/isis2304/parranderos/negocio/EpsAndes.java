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
public class EpsAndes implements VOEpsAndes {

	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idGerente;

	public EpsAndes() {
		
		this.idGerente = 0;
	}

	public EpsAndes(long idGerente) {
		
		this.idGerente = idGerente;
	}

	public long getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(long idGerente) {
		this.idGerente = idGerente;
	}

	@Override
	public String toString() {
		return "EpsAndes [idGerente=" + idGerente + "]";
	}

	
	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/


}
