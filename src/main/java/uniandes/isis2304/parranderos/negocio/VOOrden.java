package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOOrden {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El id de nombre-tabla
	 */
	public long getId();
	
	/**
	 * @return El idAfiliado de nombre-tabla
	 */
	public long getIdAfiliado();

	/**
	 * @return El idMedico de nombre-tabla
	 */
	public long getIdMedico();
	
	/**
	 * @return El receta de nombre-tabla
	 */
	public String getReceta();

	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
