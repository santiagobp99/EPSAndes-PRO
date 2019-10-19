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
	
	public long adicionarReserva (PersistenceManager pm, long id, long idAfiliadoTomador,long idAfiliadoReservador, long idServicioSalud, String idEstado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaAdscritos() + "(id, idafiliadoTomador, idserviciosalud, idafiliadoReservador,estado) values (?, ?, ?, ?,?)");
        q.setParameters(id, idAfiliadoTomador, idServicioSalud,idAfiliadoReservador, idEstado);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarReservas (PersistenceManager pm, long id, long idAfiliadoTomador,long idAfiliadoReservador, long idServicioSalud, String idEstado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaAdscritos() + " WHERE id = ?  ");
        q.setParameters(id, idAfiliadoTomador, idServicioSalud, idAfiliadoReservador,idEstado);
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
