package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOServicioSalud {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El idAfiliado de nombre-tabla
	 */
	public long getIdAfiliado();

	/**
	 * @return El idMedico de nombre-tabla
	 */
	public long getIdMedico();

	/**
	 * @return El idIps de nombre-tabla
	 */
	public long getIdIps();

	/**
	 * @return El idOrden de nombre-tabla
	 */
	public long getIdOrden();

	/**
	 * @return El estado de nombre-tabla
	 */
	public String getEstado();

	/**
	 * @return El tipo de nombre-tabla
	 */
	public String getTipo();

	/**
	 * @return La disponibilidad de nombre-tabla
	 */
	public String getDisponibilidad();

	/**
	 * @return La descripcion de nombre-tabla
	 */
	public String getDescripcion();
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
