package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Llegada;

public class SQLLlegada {
	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLLlegada(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarLlegada (PersistenceManager pm, long pIdRecepcionista, long pIdAfiliado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaLlegada() + "(idrecepcionista, idafiliado) values (?, ?)");
        q.setParameters(pIdRecepcionista, pIdAfiliado);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarLlegada (PersistenceManager pm, long pIdRecepcionista, long pIdAfiliado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaLlegada() + " WHERE idrecepcionista = ? AND idafiliado = ?");
        q.setParameters(pIdRecepcionista, pIdAfiliado);
        return (long) q.executeUnique();
	}

	
	public List<Llegada> darLlegadas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaLlegada());
		q.setResultClass(Llegada.class);
		List<Llegada> resp = (List<Llegada>) q.execute();
		return resp;
	}


}
