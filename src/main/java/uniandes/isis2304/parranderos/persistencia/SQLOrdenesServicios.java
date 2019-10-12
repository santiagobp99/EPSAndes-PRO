package uniandes.isis2304.parranderos.persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OrdenesServicios;

public class SQLOrdenesServicios {
	
public SQLOrdenesServicios(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public long adicionarOrdenServicio (PersistenceManager pm, long idorden, long idservicio, int realizado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaOrdenesServicios() + "(idorden, idservicios, realizado) values (?, ?, ?)");
        q.setParameters(idorden, idservicio, realizado);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarOrdenServicio (PersistenceManager pm, long idorden, long idservicio, int realizado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaOrdenesServicios() + " WHERE idorden = ? AND idservicios = ? AND realizado = ?");
        q.setParameters(idorden, idservicio, realizado);
        return (long) q.executeUnique();
	}

	
	public List<OrdenesServicios> darOrdenesServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaOrdenesServicios());
		q.setResultClass(OrdenesServicios.class);
		List<OrdenesServicios> resp = (List<OrdenesServicios>) q.execute();
		return resp;
	}


}
