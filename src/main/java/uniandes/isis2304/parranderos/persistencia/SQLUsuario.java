package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Usuario;;

public class SQLUsuario {
	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;

	
	public SQLUsuario(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarUsuario (PersistenceManager pm,String pNombre, String pCorreo, Long pIdRol) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaUsuario() + "(nombre, correo, idrol) values (?, ?, ?)");
        q.setParameters(pNombre, pCorreo, pIdRol);
        return (long) q.executeUnique();
	}
	
	public long eliminarUsuario (PersistenceManager pm, long pIdUsuario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " +  persistenciaEPS.darTablaUsuario()  + " WHERE id = ?");
        q.setParameters(pIdUsuario);
        return (long) q.executeUnique();            
	}

	
	public Usuario darUsuario (PersistenceManager pm, long pIdUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaUsuario()  + " WHERE id = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(pIdUsuario);
		return (Usuario) q.executeUnique();
	}

	
	public List<Usuario> darUsuarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  persistenciaEPS.darTablaUsuario() );
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}


}
