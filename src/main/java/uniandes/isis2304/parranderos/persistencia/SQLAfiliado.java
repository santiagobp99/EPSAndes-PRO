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
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaAfiliado() + "(ideps, idusuario, fechanacimiento, tipodocumento, hospitalizado, numdocumento) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(ideps, idusuario,fechanacimiento, tipodocumento, hospitalizado, numdocumento);
        return (long) q.executeUnique();
	}
	
	public long eliminarAfiliadoPorId (PersistenceManager pm, long idAfiliado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaAfiliado()  + " WHERE id = ?");
        q.setParameters(idAfiliado);
        return (long) q.executeUnique();            
	}

	
	public Afiliado darAfiliadoPorId (PersistenceManager pm, long idAfiliado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaAfiliado()  + " WHERE id = ?");
		q.setResultClass(Afiliado.class);
		q.setParameters(idAfiliado);
		return (Afiliado) q.executeUnique();
	}

	
	public List<Afiliado> darAfiliados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaAfiliado() );
		q.setResultClass(Afiliado.class);
		return (List<Afiliado>) q.executeList();
	}
	
	
	
}
