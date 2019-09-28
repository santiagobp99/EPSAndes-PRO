package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.parranderos.negocio.CitasDeServicios;


public class SQLCitasDeServicios {

	
	private final static String SQL = PersistenciaParranderos.SQL;
	
	private PersistenciaParranderos persistenciaEPS;
	
	public SQLCitasDeServicios(PersistenciaParranderos pPersistenciaParranderos) {
		
		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public long adicionarCitaDeServicios (PersistenceManager pm,  long idrecepcionista, long idservicio ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaCitasDeServicios() + "(idrecepcionista, idservicio) values (?, ? )");
        q.setParameters(idrecepcionista, idservicio );
        return (long) q.executeUnique();
	}
	
	
	public long eliminarCitaDeServicios (PersistenceManager pm, long idrecepcionista, long idservicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaCitasDeServicios() + " WHERE idrecepcionista = ? AND idservicio = ?");
        q.setParameters(idrecepcionista, idservicio);
        return (long) q.executeUnique();
	}

	
	public List<CitasDeServicios> darGustan (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaCitasDeServicios());
		q.setResultClass(CitasDeServicios.class);
		List<CitasDeServicios> resp = (List<CitasDeServicios>) q.execute();
		return resp;
	}



}