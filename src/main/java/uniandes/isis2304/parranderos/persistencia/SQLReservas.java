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

	public long adicionarReserva (PersistenceManager pm, long id, Long idAfiliadoTomador,long idAfiliadoReservador, long idHorario, String estado) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaReservas() + "(id, idafiliadoTomador, idafiliadoReservador,idHorario, estado,HOSPITALIZADO) values (?, ?, ?, ?, ?,0)");
		q.setParameters(id, idAfiliadoTomador, idAfiliadoReservador,idHorario, estado);
		return (long) q.executeUnique();
	}


	public long eliminarReservas (PersistenceManager pm, long id, long idAfiliadoTomador,long idAfiliadoReservador, long idHorario, String idEstado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaReservas() + " WHERE id = ?  ");
		q.setParameters(id, idAfiliadoTomador, idHorario, idAfiliadoReservador,idEstado);
		return (long) q.executeUnique();
	}


	public List<Reservas> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaReservas());
		q.setResultClass(Reservas.class);
		List<Reservas> resp = (List<Reservas>) q.execute();
		return resp;
	}

	public List<Reservas> darReservasInvalidas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT r.id, r.idafiliadotomador, r.idhorario, r.idafiliadoreservador, r.estado FROM " +persistenciaEPS.darTablaHorario() + 
				" H INNER JOIN "+persistenciaEPS.darTablaReservas() + " R on r.idhorario = h.id "+
				"WHERE h.disponibilidad = 0 AND r.estado = ?");
		q.setParameters("RESERVADO");
		q.setResultClass(Reservas.class);
		List<Reservas> resp = (List<Reservas>) q.executeList();
		return resp;
	}


	public void cambiarHorarioReserva(PersistenceManager pm, long idhorario, long idreserva ) {
		 Query q = pm.newQuery(SQL, "UPDATE " + persistenciaEPS.darTablaReservas() + " SET idhorario = ? " +
				 "WHERE id = ?");
		        q.setParameters(idhorario, idreserva);
		        q.executeUnique();
		
	}


}
