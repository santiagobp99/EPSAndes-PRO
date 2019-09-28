package uniandes.isis2304.parranderos.negocio;

public interface VORol {
	/**
	 * @return El nombre de nombre-tabla
	 */
	public String getNombre();
	
	public long getId() ;
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
}
