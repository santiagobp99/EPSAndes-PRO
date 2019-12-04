package uniandes.isis2304.parranderos.negocio;

public class RFC9 {

	
	private long id;
	private String estado;
	private String tipo;
	private long idIps;
	
	
	
	public RFC9() {
		this.id = 0;
		this.estado = "";
		this.tipo = "";
		this.idIps = 0;
	}
	
	public RFC9(long id, String estado, String tipo, long idIps) {
		this.id = id;
		this.estado = estado;
		this.tipo = tipo;
		this.idIps = idIps;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	@Override
	public String toString() {
		return "RFC9 [id=" + id + ", estado=" + estado + ", tipo=" + tipo + ", idIps=" + idIps + "]";
	}
	
	
	
	
}
