package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Interconsultas;;

public class SQLInterconsultas {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLInterconsultas(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarInterconsulta (PersistenceManager pm, long pIdMedicoEspecialista, long pIdUrgencias) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaInterconsultas() + "(idmedicoespecialista, idurgencias) values (?, ?)");
        q.setParameters(pIdMedicoEspecialista, pIdUrgencias);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarInterconsulta (PersistenceManager pm, long pIdMedicoEspecialista, long pIdUrgencias)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaInterconsultas() + " WHERE idmedicoespecialista = ? AND idurgencias = ?");
        q.setParameters(pIdMedicoEspecialista, pIdUrgencias);
        return (long) q.executeUnique();
	}

	
	public List<Interconsultas> darInterconsultas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaInterconsultas());
		q.setResultClass(Interconsultas.class);
		List<Interconsultas> resp = (List<Interconsultas>) q.execute();
		return resp;
	}




}
