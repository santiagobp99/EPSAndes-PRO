package uniandes.isis2304.parranderos.persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Horario;
import uniandes.isis2304.parranderos.negocio.Orden;
import uniandes.isis2304.parranderos.negocio.OrdenesServicios;
import uniandes.isis2304.parranderos.negocio.ServicioSalud;

public class SQLOrdenesServicios {
	
public SQLOrdenesServicios(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public long adicionarOrdenServicio (PersistenceManager pm, long id, long idservicio,long idorden, int realizado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaOrdenesServicios() + "(id, idservicio,idorden, realizado) values (?, ?, ?, ?)");
        q.setParameters(id, idservicio,idorden, realizado);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarOrdenServicio (PersistenceManager pm, long idorden, long idservicio, int realizado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaOrdenesServicios() + " WHERE idorden = ? AND idservicio = ? AND realizado = ?");
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

	public List<OrdenesServicios> darOrdenesPorServicio (PersistenceManager pm,long pIdServicioSalud)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaHorario()  + " WHERE idservicio = ?"  );
		q.setResultClass(OrdenesServicios.class);
		q.setParameters(pIdServicioSalud);
		return (List<OrdenesServicios>) q.executeList();
	}
	
	
	public  List<OrdenesServicios> darOrdenesServiciosId (PersistenceManager pm, long pIdOrden) 
	{
		String orden = pIdOrden+"";
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaOrdenesServicios()  + " WHERE idorden = ?");
		q.setResultClass(OrdenesServicios.class);
		q.setParameters(orden);
		return (List<OrdenesServicios>) q.executeList();
		
		
		
	}
}
