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
public class CitasDeServicios implements VOCitasDeServicios {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	 
	private long idRecepcionista;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idServicio;

	public CitasDeServicios() {
	
		this.idRecepcionista = 0;
		this.idServicio = 0;
	}
	
	public CitasDeServicios(long idRecepcionista, long idServicio) {
	
		this.idRecepcionista = idRecepcionista;
		this.idServicio = idServicio;
	}

	public long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	@Override
	public String toString() {
		return "CitasDeServicios [idRecepcionista=" + idRecepcionista + ", idServicio=" + idServicio + "]";
	}

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

	

	

}
