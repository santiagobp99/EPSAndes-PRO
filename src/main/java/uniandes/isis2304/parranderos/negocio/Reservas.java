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
	private long idAfiliadoTomador;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idAfiliadoReservador;
	
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
		this.idAfiliadoTomador = 0;
		this.idAfiliadoReservador = 0;
		this.idServicioSalud = 0;
		this.estado = "";
	}

	public Reservas(long id, long idAfiliadoTomador, long idAfiliadoReservador, long idServicioSalud, String estado) {
		
		this.id = id;
		this.idAfiliadoTomador = idAfiliadoTomador;
		this.idAfiliadoReservador = idAfiliadoReservador;
		this.idServicioSalud = idServicioSalud;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdAfiliadoTomador() {
		return idAfiliadoTomador;
	}

	public void setIdAfiliadoTomador(long idAfiliadoTomador) {
		this.idAfiliadoTomador = idAfiliadoTomador;
	}

	public long getIdAfiliadoReservador() {
		return idAfiliadoReservador;
	}

	public void setIdAfiliadoReservador(long idAfiliadoReservador) {
		this.idAfiliadoReservador = idAfiliadoReservador;
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
		return "Reservas [id=" + id + ", idAfiliadoTomador=" + idAfiliadoTomador + ", idAfiliadoReservador="
				+ idAfiliadoReservador + ", idServicioSalud=" + idServicioSalud + ", estado=" + estado + "]";
	}
	
	

	
}
