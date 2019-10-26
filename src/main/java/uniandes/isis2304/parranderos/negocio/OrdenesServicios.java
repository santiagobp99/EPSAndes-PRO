package uniandes.isis2304.parranderos.negocio;

public class OrdenesServicios implements VOOrdenesServicios{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idOrden;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idServicio;

	/**
	 * El identificador �NICO de los bares
	 */
	private int realizado;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long id;

	public OrdenesServicios() {
		
		this.idOrden = 0;
		this.idServicio = 0;
		this.realizado = 0;
		this.id = 0;
	}

	public OrdenesServicios( long id, long idOrden, long idServicio, int realizado) {
		
		this.idOrden = idOrden;
		this.idServicio = idServicio;
		this.realizado = realizado;
		this.id = id;
	}

	public long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public int getRealizado() {
		return realizado;
	}

	public void setRealizado(int realizado) {
		this.realizado = realizado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrdenesServicios [idOrden=" + idOrden + ", idServicio=" + idServicio + ", realizado=" + realizado
				+ ", id=" + id + "]";
	}
	
	
	
	

	
}
