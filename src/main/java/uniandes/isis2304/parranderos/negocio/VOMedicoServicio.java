package uniandes.isis2304.parranderos.negocio;

public interface VOMedicoServicio {
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getIdMedico();
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getIdServicio();
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
}
