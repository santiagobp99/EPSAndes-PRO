package uniandes.isis2304.parranderos.persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Reservas;

public class SQLReservas {
	
public SQLReservas(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public long adicionarReserva (PersistenceManager pm, long id, long idAfiliado, Long idServicioSalud, String idEstado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaAdscritos() + "(id, idafiliado, idserviciosalud, estado) values (?, ?, ?, ?)");
        q.setParameters(id, idAfiliado, idServicioSalud, idEstado);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarReservas (PersistenceManager pm, long id, long idAfiliado, Long idServicioSalud, String idEstado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaAdscritos() + " WHERE id = ? AND idafiliado = ? AND idserviciosalud = ? AND estado = ? ");
        q.setParameters(id, idAfiliado, idServicioSalud, idEstado);
        return (long) q.executeUnique();
	}

	
	public List<Reservas> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaAdscritos());
		q.setResultClass(Reservas.class);
		List<Reservas> resp = (List<Reservas>) q.execute();
		return resp;
	}


}
