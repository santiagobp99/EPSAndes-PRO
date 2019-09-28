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
public class ServicioSalud implements VOServicioSalud {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String descripcion;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String disponibilidad;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String tipo;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String estado;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idAfiliado;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idMedico;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idIps;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idOrden;

	public ServicioSalud() {
		
		this.descripcion = "";
		this.disponibilidad = "";
		this.tipo = "";
		this.estado = "";
		this.idAfiliado = 0;
		this.idMedico = 0;
		this.idIps = 0;
		this.idOrden = 0;
	}

	public ServicioSalud(String descripcion, String disponibilidad, String tipo, String estado, long idAfiliado,
			long idMedico, long idIps, long idOrden) {
		
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
		this.tipo = tipo;
		this.estado = estado;
		this.idAfiliado = idAfiliado;
		this.idMedico = idMedico;
		this.idIps = idIps;
		this.idOrden = idOrden;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	public long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}

	@Override
	public String toString() {
		return "ServicioSalud [descripcion=" + descripcion + ", disponibilidad=" + disponibilidad + ", tipo=" + tipo
				+ ", estado=" + estado + ", idAfiliado=" + idAfiliado + ", idMedico=" + idMedico + ", idIps=" + idIps
				+ ", idOrden=" + idOrden + "]";
	}
	

	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

}
