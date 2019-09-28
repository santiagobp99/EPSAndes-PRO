package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Afiliado;

public class SQLAfiliado {

	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;

	public SQLAfiliado(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarAfiliado (PersistenceManager pm, long ideps, long idusuario, Timestamp fechanacimiento, String tipodocumento, int hospitalizado,
			String numdocumento) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaAfliado() + "(fechanacimiento, tipodocumento, hospitalizado, numdocumento, ideps, idusuario) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(fechanacimiento, tipodocumento, hospitalizado, numdocumento, ideps, ideps);
        return (long) q.executeUnique();
	}
	
	public long eliminarAfiliadoPorId (PersistenceManager pm, long idAfiliado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaAfliado()  + " WHERE id = ?");
        q.setParameters(idAfiliado);
        return (long) q.executeUnique();            
	}

	
	public Afiliado darAfiliadoPorId (PersistenceManager pm, long idAfiliado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaAfliado()  + " WHERE id = ?");
		q.setResultClass(Afiliado.class);
		q.setParameters(idAfiliado);
		return (Afiliado) q.executeUnique();
	}

	
	public List<Afiliado> darAfiliados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaAfliado() );
		q.setResultClass(Afiliado.class);
		return (List<Afiliado>) q.executeList();
	}
	
	
	
}
