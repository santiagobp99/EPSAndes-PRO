package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOHorario {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El idServicio de nombre-tabla
	 */
	public long getId();
	
	/**
	 * @return El idServicio de nombre-tabla
	 */
	public long getIdServicio();


	/**
	 * @return El capacidad de nombre-tabla
	 */
	public String getHora();
	
	/**
	 * @return El capacidad de nombre-tabla
	 */
	public Timestamp getFecha();

	/**
	 * @return El capacidad de nombre-tabla
	 */
	public int getCapacidad();
	
	/**
	 * @return El capacidad de nombre-tabla
	 */
	public int getDisponibilidad();
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
