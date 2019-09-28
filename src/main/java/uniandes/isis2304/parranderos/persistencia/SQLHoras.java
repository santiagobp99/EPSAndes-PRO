package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.parranderos.negocio.Horas;

public class SQLHoras {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLHoras(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarHora (PersistenceManager pm, Timestamp pHora , Long pIdHorario) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaHoras() + "(hora, idhoraio) values (?, ?)");
        q.setParameters(pHora, pIdHorario);
        return (long) q.executeUnique();
	}
	
	public long eliminarHora (PersistenceManager pm, long idHora)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaHoras()  + " WHERE id = ?");
        q.setParameters(idHora);
        return (long) q.executeUnique();            
	}

	
	public Horas darHora (PersistenceManager pm, long idHora) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaHoras()  + " WHERE id = ?");
		q.setResultClass(Horas.class);
		q.setParameters(idHora);
		return (Horas) q.executeUnique();
	}

	
	public List<Horas> darHoras (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaHoras() );
		q.setResultClass(Horas.class);
		return (List<Horas>) q.executeList();
	}


}
