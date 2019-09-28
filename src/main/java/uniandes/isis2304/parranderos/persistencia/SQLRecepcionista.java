package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Recepcionista;;

public class SQLRecepcionista {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLRecepcionista(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarRecepcionista (PersistenceManager pm, String pIdIPS) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaRecepcionista() + "(idips) values (?)");
        q.setParameters( pIdIPS);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarRecepcionista (PersistenceManager pm, long pIdIPS)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaRecepcionista()  + " WHERE id = ?");
        q.setParameters(pIdIPS);
        return (long) q.executeUnique();            
	}

	
	public Recepcionista darRolRecepcionista (PersistenceManager pm, long pIdIPS) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaRecepcionista()  + " WHERE id = ?");
		q.setResultClass(Recepcionista.class);
		q.setParameters(pIdIPS);
		return (Recepcionista) q.executeUnique();
	}


	
	public List<Recepcionista> darRecepcionistas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaRecepcionista() );
		q.setResultClass(Recepcionista.class);
		return (List<Recepcionista>) q.executeList();
	}




}
