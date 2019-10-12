package uniandes.isis2304.parranderos.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Medico;

public class SQLMedico {

	
	public SQLMedico(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public long adicionarMedico (PersistenceManager pm,long id,long pIdRol, int pNumregistromedico, String pEspecialidad, String pIdentificacion, String pNombre, String pCorreo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaMedico() + "(id,idRol,numregistromedico, especialidad, identificacion, nombre, correo) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id,pIdRol,pNumregistromedico, pEspecialidad,  pIdentificacion, pNombre, pCorreo) ;
        return (long) q.executeUnique();
	}
	
	public long eliminarMedico (PersistenceManager pm, long pIdMedico)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaMedico()  + " WHERE id = ?");
        q.setParameters(pIdMedico);
        return (long) q.executeUnique();            
	}

	
	public Medico darMedico (PersistenceManager pm, long pIdMedico) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedico()  + " WHERE id = ?");
		q.setResultClass(Medico.class);
		q.setParameters(pIdMedico);
		return (Medico) q.executeUnique();
	}

	
	public List<Medico> darMedicos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaMedico() );
		q.setResultClass(Medico.class);
		return (List<Medico>) q.executeList();
	}
	
	
	

}
