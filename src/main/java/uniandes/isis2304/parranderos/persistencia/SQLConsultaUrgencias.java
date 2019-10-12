package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.ConsultaUrgencias;;

public class SQLConsultaUrgencias {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLConsultaUrgencias(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarConsultaUrgencias (PersistenceManager pm, String pDiagnostico, Long pRecepcionista, Long pIdMedicoTratante, Long Id, String pPrioridadTriage ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaConsultaUrgencias() + "(diagnostico, id, idrecepcionista, idmedicotratante, prioridadtriage) values (?, ?, ?, ?)");
        q.setParameters(pDiagnostico, Id, pRecepcionista, pIdMedicoTratante, pPrioridadTriage);
        return (long) q.executeUnique();
	}
	
	public long eliminarConsultaUrgencias (PersistenceManager pm, long pId)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " +  persistenciaEPS.darTablaConsultaUrgencias()  + " WHERE id = ?");
        q.setParameters(pId);
        return (long) q.executeUnique();            
	}

	
	public ConsultaUrgencias darConsultaUrgencias (PersistenceManager pm, long pId) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaConsultaUrgencias()  + " WHERE id = ?");
		q.setResultClass(ConsultaUrgencias.class);
		q.setParameters(pId);
		return (ConsultaUrgencias) q.executeUnique();
	}

	
	public List<ConsultaUrgencias> darConsultasUrgencias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaConsultaEspecialista() );
		q.setResultClass(ConsultaUrgencias.class);
		return (List<ConsultaUrgencias>) q.executeList();
	}

	

}
