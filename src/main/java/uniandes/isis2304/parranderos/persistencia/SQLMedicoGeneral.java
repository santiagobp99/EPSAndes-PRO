package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.MedicoGeneral;;

public class SQLMedicoGeneral {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLMedicoGeneral(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarMedicoGeneral (PersistenceManager pm, long pIdMedicoGeneral) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaMedicoGeneral() + "(id) values (?)");
        q.setParameters(pIdMedicoGeneral) ;
        return (long) q.executeUnique();
	}
	
	public long eliminarMedicoGeneral (PersistenceManager pm, long pIdMedicoGeneral)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaMedicoGeneral()  + " WHERE id = ?");
        q.setParameters(pIdMedicoGeneral);
        return (long) q.executeUnique();            
	}

	
	public MedicoGeneral darMedicoGeneral (PersistenceManager pm, long pIdMedicoGeneral) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedicoGeneral()  + " WHERE id = ?");
		q.setResultClass(MedicoGeneral.class);
		q.setParameters(pIdMedicoGeneral);
		return (MedicoGeneral) q.executeUnique();
	}

	
	public List<MedicoGeneral> darMedicosGenerales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedicoGeneral() );
		q.setResultClass(MedicoGeneral.class);
		return (List<MedicoGeneral>) q.executeList();
	}


}
