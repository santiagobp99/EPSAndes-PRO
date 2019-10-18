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
public class Orden implements VOOrden {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String receta;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long id;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idAfiliado;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idMedico;

	public Orden() {
		this.receta = "";
		this.id = 0;
		this.idAfiliado = 0;
		this.idMedico = 0;
	}

	public Orden(String receta, long id, long idAfiliado, long idMedico) {
		
		this.receta = receta;
		this.id = id;
		this.idAfiliado = idAfiliado;
		this.idMedico = idMedico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	@Override
	public String toString() {
		return "Orden [receta=" + receta + ", id=" + id + ", idAfiliado=" + idAfiliado + ", idMedico=" + idMedico + "]";
	}

	
	
	
}
