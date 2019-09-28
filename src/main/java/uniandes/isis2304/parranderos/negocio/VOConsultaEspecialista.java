package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOConsultaEspecialista {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El idMedicoEspecialista de nombre-tabla
	 */
	public long getIdMedicoEspecialista();

	/**
	 * @return El idOrden de nombre-tabla
	 */
	public long getIdOrden();

	/**
	 * @return El diagnostico de nombre-tabla
	 */
	public String getDiagnostico();
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
