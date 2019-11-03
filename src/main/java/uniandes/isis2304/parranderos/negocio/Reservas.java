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
	private Long idAfiliadoTomador;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idAfiliadoReservador;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idHorario;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String estado;

	public Reservas() {
		
		this.id = 0;
		this.idAfiliadoTomador = null;
		this.idAfiliadoReservador = 0;
		this.idHorario = 0;
		this.estado = "";
	}

	public Reservas(long id, Long idAfiliadoTomador, long idAfiliadoReservador, long idHorario, String estado) {
		
		this.id = id;
		this.idAfiliadoTomador = idAfiliadoTomador;
		this.idAfiliadoReservador = idAfiliadoReservador;
		this.idHorario = idHorario;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getIdAfiliadoTomador() {
		return idAfiliadoTomador;
	}

	public void setIdAfiliadoTomador(Long idAfiliadoTomador) {
		this.idAfiliadoTomador = idAfiliadoTomador;
	}

	public long getIdAfiliadoReservador() {
		return idAfiliadoReservador;
	}

	public void setIdAfiliadoReservador(long idAfiliadoReservador) {
		this.idAfiliadoReservador = idAfiliadoReservador;
	}

	public long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
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
				+ idAfiliadoReservador + ", idHorario=" + idHorario + ", estado=" + estado + "]";
	}


	
	

	
}
