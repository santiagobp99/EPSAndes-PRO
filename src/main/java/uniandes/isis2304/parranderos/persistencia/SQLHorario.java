package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.p;
import uniandes.isis2304.parranderos.negocio.Horario; 


public class SQLHorario {

	
public SQLHorario(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	
	
	public long adicionarHorario (PersistenceManager pm, int pCapacidad , long pIdServicio, String pHora, long pId,Timestamp fecha,int disponibilidad ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaHorario() + "(capacidad, idservicio, hora, id,fecha,disponibilidad) values (?,?, ?, ?, ?, ?)");
        q.setParameters(pCapacidad, pIdServicio, pHora, pId,fecha,disponibilidad);
        return (long) q.executeUnique();
	}
	
	public long eliminarHorario (PersistenceManager pm, long idHorario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaHorario()  + " WHERE id = ?");
        q.setParameters(idHorario);
        return (long) q.executeUnique();            
	}

	
	public Horario darHorario (PersistenceManager pm, long idHorario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaHorario()  + " WHERE id = ?");
		q.setResultClass(Horario.class);
		q.setParameters(idHorario);
		return (Horario) q.executeUnique();
	}

	
	public List<Horario> darHorarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaHorario() );
		q.setResultClass(Horario.class);
		return (List<Horario>) q.executeList();
	}
	
	public List<Horario> darHorariosPorServicio (PersistenceManager pm,long pIdServicioSalud)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaHorario()  + " WHERE idServicio = ? "
				+ "AND DISPONIBILIDAD = 1 AND CAPACIDAD >= 1");
		q.setResultClass(Horario.class);
		q.setParameters(pIdServicioSalud);
		return (List<Horario>) q.executeList();
	}
	
	public List darHorarioServicioFecha (PersistenceManager pm, Timestamp fechaInicio,Timestamp fechaFin,String tipoServicio) 
	{
		Query q = pm.newQuery(SQL,"SELECT h.id,h.idservicio,(h.capacidad-3)capacidad,h.fecha,h.hora,h.disponibilidad FROM " + persistenciaEPS.darTablaHorario()+ " H INNER JOIN " +persistenciaEPS.darTablaServicioSalud()+ " S ON H.idservicio = S.id WHERE (H.FECHA >= ? AND H.FECHA <= ?) AND TIPO =UPPER(?) AND DISPONIBILIDAD = 1 order by h.fecha,h.hora,h.idservicio");
		q.setResultClass(Horario.class);
		q.setParameters(fechaInicio,fechaFin,tipoServicio);
		return (List<Horario>) q.executeList();
	}
	
	public int darCapacidadHorario (PersistenceManager pm, long idHorario) 
	{
		Query q = pm.newQuery(SQL, "SELECT capacidad FROM " + persistenciaEPS.darTablaHorario()  + " WHERE id = ?");
		q.setResultClass(Integer.class);
		q.setParameters(idHorario);
		return (Integer) q.executeUnique();
	}
	
	public long aumentarCapacidadHorario (PersistenceManager pm, long pId) 
	{
		int x = darCapacidadHorario(pm, pId); 
		x++;
        Query q = pm.newQuery(SQL, "UPDATE " + persistenciaEPS.darTablaHorario() + " SET CAPACIDAD = ? "+" WHERE ID = ?");
        q.setParameters(x,pId);
        return (long) q.executeUnique();
	}
	
	public long disminuirCapacidadHorario (PersistenceManager pm, long pId) 
	{
		int x = darCapacidadHorario(pm, pId);
		x--;
        Query q = pm.newQuery(SQL, "UPDATE " + persistenciaEPS.darTablaHorario() + " SET CAPACIDAD = ? "+"WHERE ID = ?");
        q.setParameters(x,pId);
        return (long) q.executeUnique();
	}

	public long desabilitarServicio(PersistenceManager pm, long idServicio, Timestamp pFecha1,
			Timestamp pFecha2) {

		 Query q = pm.newQuery(SQL, "UPDATE " + persistenciaEPS.darTablaHorario() + " SET disponibilidad = ? " +
				 "WHERE idservicio = ? "+"AND fecha >= ? "+"AND fecha <= ?");
		        q.setParameters(0, idServicio,pFecha1,pFecha2);
		        return (long) q.executeUnique();
		        
	}
	public long habilitarServicio(PersistenceManager pm, long idServicio, Timestamp pFecha1,
			Timestamp pFecha2) {

		 Query q = pm.newQuery(SQL, "UPDATE " + persistenciaEPS.darTablaHorario() + " SET disponibilidad = ? " +
				 "WHERE idservicio = ? "+"AND fecha >= ? "+"AND fecha <= ?");
		        q.setParameters(1, idServicio,pFecha1,pFecha2);
		        return (long) q.executeUnique();
		        
	}
	  

	
}
