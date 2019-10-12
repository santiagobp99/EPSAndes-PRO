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
public class ServicioSalud implements VOServicioSalud {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long id;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idIps;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String descripcion;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String tipo;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private int orden;

	public ServicioSalud() {
		
		this.id = 0;
		this.idIps = 0;
		this.descripcion = "";
		this.tipo = "";
		this.orden = 0;
	}

	public ServicioSalud(long id, long idIps, String descripcion, String tipo, int orden) {
		
		this.id = id;
		this.idIps = idIps;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.orden = orden;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "ServicioSalud [id=" + id + ", idIps=" + idIps + ", descripcion=" + descripcion + ", tipo=" + tipo
				+ ", orden=" + orden + "]";
	}
	
	
	
	

	
}
