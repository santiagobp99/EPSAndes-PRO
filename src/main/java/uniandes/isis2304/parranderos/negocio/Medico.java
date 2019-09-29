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
public class Medico implements VOMedico {


	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador �NICO de los bares
	 */
	private int numRegistroMedico;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String especialidad;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String identificacion;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String nombre;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String correo;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idRol;

	/**
	 * El identificador �NICO de los bares
	 */
	private long id;
	
	public Medico() {
		
		this.id = 0;
		this.numRegistroMedico = 0;
		this.especialidad = "";
		this.identificacion = "";
		this.nombre = "";
		this.correo = "";
		this.idRol = 0;
	}

	public Medico(long id,long idRol, int numRegistroMedico, String especialidad, String identificacion, String nombre, String correo) {
		
		this.id = id;
		this.numRegistroMedico = numRegistroMedico;
		this.especialidad = especialidad;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.correo = correo;
		this.idRol = idRol;
	}

	public int getNumRegistroMedico() {
		return numRegistroMedico;
	}

	public void setNumRegistroMedico(int numRegistroMedico) {
		this.numRegistroMedico = numRegistroMedico;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Medico [numRegistroMedico=" + numRegistroMedico + ", especialidad=" + especialidad + ", identificacion="
				+ identificacion + ", nombre=" + nombre + ", correo=" + correo + ", idRol=" + idRol + ", id=" + id
				+ "]";
	}

	
	
	
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

	
}
