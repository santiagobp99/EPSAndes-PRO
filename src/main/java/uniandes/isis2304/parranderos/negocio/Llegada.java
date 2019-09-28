package uniandes.isis2304.parranderos.negocio;

/**
 * Clase para modelar la relaci�n nombre-tabla del negocio de los Parranderos:
 * 
 * 
 * 
 * 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public class Llegada implements VOLlegada {
	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador �NICO de los bares
	 */
	private long idRecepcionista;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idAfiliado;

	public Llegada() {
		
		this.idRecepcionista = 0;
		this.idAfiliado = 0;
	}

	public Llegada(long idRecepcionista, long idAfiliado) {
		
		this.idRecepcionista = idRecepcionista;
		this.idAfiliado = idAfiliado;
	}

	public long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	@Override
	public String toString() {
		return "Llegada [idRecepcionista=" + idRecepcionista + ", idAfiliado=" + idAfiliado + "]";
	}
	
	
	
	
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/


}
