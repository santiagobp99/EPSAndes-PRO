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
public class CitaMedica implements VOCitaMedica {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador �NICO de los bares
	 */
	private String diagnostico;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String tipo;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long id;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idOrden;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idMedicoGeneral;
	
	
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

	public CitaMedica() {
		this.diagnostico = "";
		this.tipo = "";
		this.id = 0;
		this.idOrden = 0;
		this.idMedicoGeneral = 0;
	}

	public CitaMedica(String diagnostico, String tipo, long id, long idOrden, long idMedicoGeneral) {
		this.diagnostico = diagnostico;
		this.tipo = tipo;
		this.id = id;
		this.idOrden = idOrden;
		this.idMedicoGeneral = idMedicoGeneral;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}

	public long getIdMedicoGeneral() {
		return idMedicoGeneral;
	}

	public void setIdMedicoGeneral(long idMedicoGeneral) {
		this.idMedicoGeneral = idMedicoGeneral;
	}

	@Override
	public String toString() {
		return "CitaMedica [diagnostico=" + diagnostico + ", tipo=" + tipo + ", id=" + id + ", idOrden=" + idOrden
				+ ", idMedicoGeneral=" + idMedicoGeneral + "]";
	}
	

}
