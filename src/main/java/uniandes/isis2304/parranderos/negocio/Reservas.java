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
	private long idHorario;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private String estado;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private int hospitalizado;

	public Reservas() {
		this.id = 0;
		this.idAfiliadoTomador = 0;
		this.idAfiliadoReservador = 0;
		this.idHorario = 0;
		this.estado = "";
		this.hospitalizado = 0;
	}

	public Reservas(long id, long idAfiliadoTomador, long idAfiliadoReservador, long idHorario, String estado,
			int hospitalizado) {
		this.id = id;
		this.idAfiliadoTomador = idAfiliadoTomador;
		this.idAfiliadoReservador = idAfiliadoReservador;
		this.idHorario = idHorario;
		this.estado = estado;
		this.hospitalizado = hospitalizado;
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

	public int getHospitalizado() {
		return hospitalizado;
	}

	public void setHospitalizado(int hospitalizado) {
		this.hospitalizado = hospitalizado;
	}

	@Override
	public String toString() {
		return "Reservas [id=" + id + ", idAfiliadoTomador=" + idAfiliadoTomador + ", idAfiliadoReservador="
				+ idAfiliadoReservador + ", idHorario=" + idHorario + ", estado=" + estado + ", hospitalizado="
				+ hospitalizado + "]";
	}
	
	
	
	
	
	

	
}
