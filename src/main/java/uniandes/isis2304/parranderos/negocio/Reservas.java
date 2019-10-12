package uniandes.isis2304.parranderos.negocio;

public class Reservas implements VOReservas{

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
	private long idAfiliado;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idServicioSalud;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String estado;

	public Reservas() {
		
		this.id = 0;
		this.idAfiliado = 0;
		this.idServicioSalud = 0;
		this.estado = "";
	}

	public Reservas(long id, long idAfiliado, long idServicioSalud, String estado) {
		
		this.id = id;
		this.idAfiliado = idAfiliado;
		this.idServicioSalud = idServicioSalud;
		this.estado = estado;
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

	public long getIdServicioSalud() {
		return idServicioSalud;
	}

	public void setIdServicioSalud(long idServicioSalud) {
		this.idServicioSalud = idServicioSalud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Reservas [id=" + id + ", idAfiliado=" + idAfiliado + ", idServicioSalud=" + idServicioSalud
				+ ", estado=" + estado + "]";
	}
	
	
	
	
	
	
	
}
