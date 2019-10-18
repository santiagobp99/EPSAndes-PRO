package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

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
	private int disponibilidad;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private int capacidad;

	/**
	 * El identificador �NICO de los bares
	 */
	private Timestamp fecha;

	public Horario() {
		
		this.id = 0;
		this.idServicio = 0;
		this.hora = "";
		this.disponibilidad = 0;
		this.capacidad = 0;
		this.fecha = new Timestamp (0);
	}

	public Horario(long id, long idServicio, String hora, int disponibilidad, int capacidad, Timestamp fecha) {
		
		this.id = id;
		this.idServicio = idServicio;
		this.hora = hora;
		this.disponibilidad = disponibilidad;
		this.capacidad = capacidad;
		this.fecha = fecha;
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

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", idServicio=" + idServicio + ", hora=" + hora + ", disponibilidad="
				+ disponibilidad + ", capacidad=" + capacidad + ", fecha=" + fecha + "]";
	}
	
	
	
	

}
