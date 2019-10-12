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
	private long id;

	/**
	 * El identificador �NICO de los bares
	 */
	private long idServicio;

	/**
	 * El identificador �NICO de los bares
	 */
	private String hora;

	/**
	 * El identificador �NICO de los bares
	 */
	private String dia;

	/**
	 * El identificador �NICO de los bares
	 */
	private int capacidad;

	public Horario() {
		
		this.id = 0;
		this.idServicio = 0;
		this.hora = "";
		this.dia = "";
		this.capacidad = 0;
	}

	public Horario(long id, long servicio, String hora, String dia, int capacidad) {
		
		this.id = id;
		this.idServicio = servicio;
		this.hora = hora;
		this.dia = dia;
		this.capacidad = capacidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", idServicio=" + idServicio + ", hora=" + hora + ", dia=" + dia + ", capacidad="
				+ capacidad + "]";
	}


	
	

}
