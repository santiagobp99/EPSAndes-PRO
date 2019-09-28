package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOMedicoEspecialista {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El id de nombre-tabla
	 */
	public long getId();
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
