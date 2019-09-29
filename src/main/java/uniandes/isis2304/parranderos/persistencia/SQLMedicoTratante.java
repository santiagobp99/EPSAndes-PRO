package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.MedicoTratante;

public class SQLMedicoTratante {
	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;

	
	public SQLMedicoTratante(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarMedicoTratante (PersistenceManager pm, long pIdMedicoTratante) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaMedicoTratante() + "(id) values (?)");
        q.setParameters(pIdMedicoTratante) ;
        return (long) q.executeUnique();
	}
	
	public long eliminarMedicoTratante (PersistenceManager pm, long pIdMedicoTratante)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaMedicoTratante()  + " WHERE id = ?");
        q.setParameters(pIdMedicoTratante);
        return (long) q.executeUnique();            
	}

	
	public MedicoTratante darMedicoTratante (PersistenceManager pm, long pIdMedicoTratante) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedicoTratante()  + " WHERE id = ?");
		q.setResultClass(MedicoTratante.class);
		q.setParameters(pIdMedicoTratante);
		return (MedicoTratante) q.executeUnique();
	}

	
	public List<MedicoTratante> darMedicosTratantes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedicoTratante() );
		q.setResultClass(MedicoTratante.class);
		return (List<MedicoTratante>) q.executeList();
	}



}
