package uniandes.isis2304.parranderos.negocio;

public interface VOOrdenesServicios {

	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getId() ;
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getIdOrden() ;
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getIdServicio() ;
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public int getRealizado() ;
	
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
}
