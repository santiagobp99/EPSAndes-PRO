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

	public OrdenesServicios() {
		
		this.idOrden = 0;
		this.idServicio = 0;
		this.realizado = 0;
	}

	public OrdenesServicios(long idOrden, long idServicio, int realizado) {
		
		this.idOrden = idOrden;
		this.idServicio = idServicio;
		this.realizado = realizado;
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

	@Override
	public String toString() {
		return "OrdenesServicios [idOrden=" + idOrden + ", idServicio=" + idServicio + ", realizado=" + realizado + "]";
	}
	
	
	
}
