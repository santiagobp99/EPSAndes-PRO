package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOAfiliado {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El id de nombre-tabla
	 */
	public long getIdUsuario();

	/**
	 * @return El idEps de nombre-tabla
	 */
	public long getIdEps();

	/**
	 * @return El nombre de nombre-tabla
	 */
	public Timestamp getFechaNacimiento();

	/**
	 * @return El tipoDocumento de nombre-tabla
	 */
	public String getTipoDocumento();

	/**
	 * @return El hospitalizado de nombre-tabla
	 */
	public int getHospitalizado();

	/**
	 * @return El numDocumento de nombre-tabla
	 */
	public String getNumDocumento();
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
