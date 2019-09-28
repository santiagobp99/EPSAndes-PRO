package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OrdenServicio;;

public class SQLOrdenServicio {

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	
	public SQLOrdenServicio(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarOrdenServicio (PersistenceManager pm, String pReceta, Long pIdAfiliado, Long pIdMedico) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaOrdenServicio() + "(receta, idafiliado, idimedico) values (?, ?, ?)");
        q.setParameters(pReceta, pIdAfiliado, pIdMedico);
        return (long) q.executeUnique();
	}
	
	public long eliminarOrdenServicio (PersistenceManager pm, long pIdOrdenServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " +  persistenciaEPS.darTablaOrdenServicio()  + " WHERE id = ?");
        q.setParameters(pIdOrdenServicio);
        return (long) q.executeUnique();            
	}

	
	public OrdenServicio darOrdenServicio (PersistenceManager pm, long pIdOrdenServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaOrdenServicio()  + " WHERE id = ?");
		q.setResultClass(OrdenServicio.class);
		q.setParameters(pIdOrdenServicio);
		return (OrdenServicio) q.executeUnique();
	}

	
	public List<OrdenServicio> darOrdenesServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaOrdenServicio() );
		q.setResultClass(OrdenServicio.class);
		return (List<OrdenServicio>) q.executeList();
	}
	


}
