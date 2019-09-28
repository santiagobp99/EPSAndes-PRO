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
public class MedicoTratante implements VOMedicoTratante {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador �NICO de los bares
	 */
	private long id;

	public MedicoTratante() {
		
		this.id = 0;
	}

	public MedicoTratante(long id) {
		
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MedicoTratante [id=" + id + "]";
	}
	
	
	
	
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

}
