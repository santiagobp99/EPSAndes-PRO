package uniandes.isis2304.parranderos.negocio;

public class MedicoServicio implements VOMedicoServicio{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador �NICO de los bares
	 */
	private long idMedico;
	
	/**
	 * El identificador �NICO de los bares
	 */
	private long idServicio;

	public MedicoServicio() {
		
		this.idMedico = 0;
		this.idServicio = 0;
	}

	public MedicoServicio(long idMedico, long idServicio) {
		
		this.idMedico = idMedico;
		this.idServicio = idServicio;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	@Override
	public String toString() {
		return "MedicoServicio [idMedico=" + idMedico + ", idServicio=" + idServicio + "]";
	}
	
	
}
