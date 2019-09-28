package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.CitaMedica;

public class SQLCitaMedica {
	
	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;

	public SQLCitaMedica(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	public long adicionarCitaMedica (PersistenceManager pm, String diagnostico, String tipo, Long id, long idorden, long idmedicogeneral ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaCitaMedica() + "(diagnostico, tipo, id, idorden, idmedicogeneral) values (?, ?, ?, ?, ? )");
        q.setParameters(diagnostico, tipo, id, idorden, idmedicogeneral );
        return (long) q.executeUnique();
	}
	
	
	public long eliminarCitaMedicaPorId (PersistenceManager pm, long idCitaMedica)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaCitaMedica()  + " WHERE id = ?");
        q.setParameters(idCitaMedica);
        return (long) q.executeUnique();            
	}

	
	public CitaMedica darCitaMedicaPorId (PersistenceManager pm, long idCitaMedica) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaCitaMedica()  + " WHERE id = ?");
		q.setResultClass(CitaMedica.class);
		q.setParameters(idCitaMedica);
		return (CitaMedica) q.executeUnique();
	}


	
	public List<CitaMedica> darRoles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaCitaMedica() );
		q.setResultClass(CitaMedica.class);
		return (List<CitaMedica>) q.executeList();
	}
	

	
}
