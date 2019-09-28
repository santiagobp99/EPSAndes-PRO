package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Ips;;

public class SQLIps {

private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLIps(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarIps (PersistenceManager pm, String pUbicacion, String pNombre, String pTipo, int pCapacidad, Long pIdeps) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaIps()  + "(ubicacion, nombre, tipo, capacidad, ideps) values (?, ?, ?, ?, ?)");
        q.setParameters(pUbicacion, pNombre, pTipo, pCapacidad, pIdeps);
        return (long) q.executeUnique();
	}
	
	public long eliminarIPS (PersistenceManager pm, long idIps)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaIps()  + " WHERE id = ?");
        q.setParameters(idIps);
        return (long) q.executeUnique();            
	}

	
	public Ips darIPS (PersistenceManager pm, long idIps) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaIps()   + " WHERE id = ?");
		q.setResultClass(Ips.class);
		q.setParameters(idIps);
		return (Ips) q.executeUnique();
	}

	
	public List<Ips> darIPSs (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaIps()  );
		q.setResultClass(Ips.class);
		return (List<Ips>) q.executeList();
	}


}
