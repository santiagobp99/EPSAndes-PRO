package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.ServicioSalud;;

public class SQLServicioSalud {
	
	public SQLServicioSalud(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public long adicionarServicioSalud (PersistenceManager pm, String pDescripcion, String pDisponibilidad, String pTipo, String pEstado, long pIdAfiliado,
			long pIdMedico, long pIdIPS, long pIdOrden) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaServicioSalud() + "(descripcion, disponibilidad, tipo, estado, idafiliado, idmedico, idips, idorden) values (?, ?, ?, ?, ?, ?, ?, ? )");
        q.setParameters(pDescripcion, pDisponibilidad, pTipo, pEstado, pIdAfiliado, pIdMedico, pIdIPS, pIdOrden );
        return (long) q.executeUnique();
	}
	
	
	public long eliminarServicioSalud (PersistenceManager pm, long idServicioSalud)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaServicioSalud()   + " WHERE id = ?");
        q.setParameters(idServicioSalud);
        return (long) q.executeUnique();            
	}

	
	public ServicioSalud darServicioSalud (PersistenceManager pm, long idServicioSalud) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaServicioSalud()   + " WHERE id = ?");
		q.setResultClass(ServicioSalud.class);
		q.setParameters(idServicioSalud);
		return (ServicioSalud) q.executeUnique();
	}


	
	public List<ServicioSalud> darServiciosSalud (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaServicioSalud()  );
		q.setResultClass(ServicioSalud.class);
		return (List<ServicioSalud>) q.executeList();
	}


}