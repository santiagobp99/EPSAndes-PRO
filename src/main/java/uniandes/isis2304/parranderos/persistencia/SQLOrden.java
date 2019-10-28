package uniandes.isis2304.parranderos.persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Orden;;

public class SQLOrden {

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	
	public SQLOrden(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarOrden (PersistenceManager pm,long id, long pIdAfiliado, long pIdMedico,String pReceta) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaOrden() + "(id, idafiliado, idmedico, receta) values (?, ?, ?, ?)");
        q.setParameters(id, pIdAfiliado, pIdMedico,pReceta);
        return (long) q.executeUnique();
	}
	
	public long eliminarOrden (PersistenceManager pm, long pIdOrden)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " +  persistenciaEPS.darTablaOrden()  + " WHERE id = ?");
        q.setParameters(pIdOrden);
        return (long) q.executeUnique();            
	}

	
	public Orden darOrden (PersistenceManager pm, long pId) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaOrden()  + " WHERE id = ?");
		q.setResultClass(Orden.class);
		q.setParameters(pId);
		return (Orden) q.executeUnique();
	}

	
	public List<Orden> darOrdenes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaOrden() );
		q.setResultClass(Orden.class);
		return (List<Orden>) q.executeList();
	}

	


}
