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
public class Adscritos implements VOAdscritos {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	 /**
	 * El identificador �NICO de los bares
	 */
	private long idMedico;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idIps;
	
	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/
	
    /**
     * Constructor por defecto
     */
	public Adscritos() 
    {
    	this.idIps = 0;
    	this.idMedico = 0;
		
	}
	
	public Adscritos(long idMedico, long idIps) {
		this.idMedico = idMedico;
		this.idIps = idIps;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	@Override
	public String toString() {
		return "Adscritos [idMedico=" + idMedico + ", idIps=" + idIps + "]";
	}
	
}
