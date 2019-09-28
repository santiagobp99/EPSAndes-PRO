package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Adscritos;


public class SQLAdscritos {
	
	public SQLAdscritos(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public long adicionarAdcrito (PersistenceManager pm, long idMedico, long idIps) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaAdscritos() + "(idmedico, idips) values (?, ?)");
        q.setParameters(idMedico, idIps);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarAdcrito (PersistenceManager pm, long idMedico, long idIps)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaAdscritos() + " WHERE idmedico = ? AND idips = ?");
        q.setParameters(idMedico, idIps);
        return (long) q.executeUnique();
	}

	
	public List<Adscritos> darAdcritos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaAdscritos());
		q.setResultClass(Adscritos.class);
		List<Adscritos> resp = (List<Adscritos>) q.execute();
		return resp;
	}

	

}
