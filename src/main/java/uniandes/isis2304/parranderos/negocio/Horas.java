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
public class Horas implements VOHoras {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador �NICO de los bares
	 */
	private Timestamp hora;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idHorario;

	public Horas() {
		this.hora = new Timestamp(0);
		this.idHorario = 0;
	}

	public Horas(Timestamp hora, long idHorario) {
		this.hora = hora;
		this.idHorario = idHorario;
	}

	public Timestamp getHora() {
		return hora;
	}

	public void setHora(Timestamp hora) {
		this.hora = hora;
	}

	public long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}

	@Override
	public String toString() {
		return "Horas [hora=" + hora + ", idHorario=" + idHorario + "]";
	}
	
	
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

}
