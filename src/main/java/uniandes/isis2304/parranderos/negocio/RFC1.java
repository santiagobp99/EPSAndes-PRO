package uniandes.isis2304.parranderos.negocio;

public class RFC1 {

	private long idIps;
	
	private int numero;

	public RFC1() {
		this.idIps = 0;
		this.numero = 0;
	}
	
	public RFC1(long idIps, int numero) {
		this.idIps = idIps;
		this.numero = numero;
	}

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
