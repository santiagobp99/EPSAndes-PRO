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
public class Usuario implements VOUsuario {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
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
	
	private long secuencia;

	public Usuario() {
		id = 0;
		this.nombre = "";
		this.correo = "";
		this.idRol = 0;
	}

	public Usuario(long id,String nombre, String correo, long idRol) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.idRol = idRol;
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
		return "Usuario [nombre=" + nombre + ", correo=" + correo + ", idRol=" + idRol + ", id=" + id + ", secuencia="
				+ secuencia + "]";
	}

}
