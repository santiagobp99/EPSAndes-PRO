package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.ConsultaEspecialista;;

public class SQLConsultaEspecialista {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLConsultaEspecialista(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarConsultaEspecialista (PersistenceManager pm, String pDiagnostico, Long pId, Long pIdmedicoespecialista, Long pIdorden) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaConsultaEspecialista() + "(diagnostico, id, hospitalizado, idmedicoespecialista, idorden, idusuario) values (?, ?, ?, ?)");
        q.setParameters(pDiagnostico, pId, pIdmedicoespecialista, pIdorden);

        return (long) q.executeUnique();
	}
	
	public long eliminarConsultaEspecialista (PersistenceManager pm, long pId)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " +  persistenciaEPS.darTablaConsultaEspecialista()  + " WHERE id = ?");
        q.setParameters(pId);
        return (long) q.executeUnique();            
	}

	
	public ConsultaEspecialista darConsultaEspecialista (PersistenceManager pm, long pId) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaConsultaEspecialista()  + " WHERE id = ?");
		q.setResultClass(ConsultaEspecialista.class);
		q.setParameters(pId);
		return (ConsultaEspecialista) q.executeUnique();
	}

	
	public List<ConsultaEspecialista> darConsultasEspecialista (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaConsultaEspecialista() );
		q.setResultClass(ConsultaEspecialista.class);
		return (List<ConsultaEspecialista>) q.executeList();
	}
	

	

}
