package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.MedicoEspecialista;;

public class SQLMedicoEspecialista {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLMedicoEspecialista(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarMedicoEspecialista (PersistenceManager pm, long pIdMedicoEspecialista) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaMedicoEspecialista() + "(id) values (?)");
        q.setParameters(pIdMedicoEspecialista) ;
        return (long) q.executeUnique();
	}
	
	public long eliminarMedicoEspecialista (PersistenceManager pm, long pIdMedicoEspecialista)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaMedicoEspecialista()  + " WHERE id = ?");
        q.setParameters(pIdMedicoEspecialista);
        return (long) q.executeUnique();            
	}

	
	public MedicoEspecialista darMedicoEspecialista (PersistenceManager pm, long pIdEspecialista) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedicoEspecialista()  + " WHERE id = ?");
		q.setResultClass(MedicoEspecialista.class);
		q.setParameters(pIdEspecialista);
		return (MedicoEspecialista) q.executeUnique();
	}

	
	public List<MedicoEspecialista> darMedicosEspecialistas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedicoEspecialista() );
		q.setResultClass(MedicoEspecialista.class);
		return (List<MedicoEspecialista>) q.executeList();
	}


}
