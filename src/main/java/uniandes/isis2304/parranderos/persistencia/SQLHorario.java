package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Horario;

public class SQLHorario {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLHorario(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarHorario (PersistenceManager pm, int pCapacidad , Long pIdServicio, String pHora, String pDia, String pID) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaHorario() + "(capacidad, idservicio, hora, dia, id) values (?, ?, ?, ?, ?)");
        q.setParameters(pCapacidad, pIdServicio, pHora, pDia, pID);
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


}
