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
public class Horario implements VOHorario {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador �NICO de los bares
	 */
	private int capacidad;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idServicio;

	public Horario() {
		this.capacidad = 0;
		this.idServicio = 0;
	}

	public Horario(int capacidad, long idServicio) {
		this.capacidad = capacidad;
		this.idServicio = idServicio;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	@Override
	public String toString() {
		return "Horario [capacidad=" + capacidad + ", idServicio=" + idServicio + "]";
	}

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/


}
