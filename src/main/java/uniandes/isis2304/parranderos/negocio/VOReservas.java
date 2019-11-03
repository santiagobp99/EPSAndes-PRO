package uniandes.isis2304.parranderos.negocio;

public interface VOReservas {
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getId() ;
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getIdAfiliadoTomador() ;
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getIdAfiliadoReservador() ;
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public long getIdHorario() ;
	
	/**
	 * @return El nombre de nombre-tabla
	 */
	public String getEstado() ;
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
}
