package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Rol;

public class SQLRol {
private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	
	public SQLRol(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarRol (PersistenceManager pm,long id, String nombreRol) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaRol() + "(id, nombre) values (?,?)");
        q.setParameters( id, nombreRol);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarRolPorId (PersistenceManager pm, long idRol)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaRol()  + " WHERE id = ?");
        q.setParameters(idRol);
        return (long) q.executeUnique();            
	}

	
	public Rol darRolPorId (PersistenceManager pm, long idRol) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaRol()  + " WHERE id = ?");
		q.setResultClass(Rol.class);
		q.setParameters(idRol);
		return (Rol) q.executeUnique();
	}


	
	public List<Rol> darRoles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaRol() );
		q.setResultClass(Rol.class);
		return (List<Rol>) q.executeList();
	}
}
