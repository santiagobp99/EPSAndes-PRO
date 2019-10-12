package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.MedicoServicio;

public class SQLMedicoServicio {
	
public SQLMedicoServicio(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public long adicionarMedicoServicio (PersistenceManager pm, long idMedico, long idservicio) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaMedicoServicio() + "(idmedico, idservicio) values (?, ?)");
        q.setParameters(idMedico, idservicio);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarMedicoServicio (PersistenceManager pm, long idMedico, long idservicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaMedicoServicio() + " WHERE idmedico = ? AND idservicio = ?");
        q.setParameters(idMedico, idservicio);
        return (long) q.executeUnique();
	}

	
	public List<MedicoServicio> darMedicoServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedicoServicio());
		q.setResultClass(MedicoServicio.class);
		List<MedicoServicio> resp = (List<MedicoServicio>) q.execute();
		return resp;
	}

}
