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
public class Ips implements VOIps {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String ubicacion;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String nombre;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String tipo;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private int capacidad;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idEps;

	public Ips() {
		this.ubicacion = "";
		this.nombre = "";
		this.tipo = "";
		this.capacidad = 0;
		this.idEps = 0;
	}

	public Ips(String ubicacion, String nombre, String tipo, int capacidad, long idEps) {
		this.ubicacion = ubicacion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.idEps = idEps;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public long getIdEps() {
		return idEps;
	}

	public void setIdEps(long idEps) {
		this.idEps = idEps;
	}

	@Override
	public String toString() {
		return "Ips [ubicacion=" + ubicacion + ", nombre=" + nombre + ", tipo=" + tipo + ", capacidad=" + capacidad
				+ ", idEps=" + idEps + "]";
	}
	
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/



}
