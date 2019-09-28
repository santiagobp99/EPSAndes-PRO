package uniandes.isis2304.parranderos.negocio;

public class Rol implements VORol {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador �NICO de los bares
	 */
	private String nombre;
	
	private long id;

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Rol() 
	{
		this.nombre ="";
		this.id=0;

	}

	public Rol(long id, String nombre) {
		
		this.nombre = nombre;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [nombre=" + nombre + ", id=" + id + "]";
	}
}
