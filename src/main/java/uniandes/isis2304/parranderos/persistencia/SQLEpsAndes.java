package uniandes.isis2304.parranderos.persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.sun.jmx.snmp.Timestamp;

import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.EpsAndes;
import uniandes.isis2304.parranderos.negocio.Gustan;
import uniandes.isis2304.parranderos.negocio.Sirven;
import uniandes.isis2304.parranderos.negocio.RFC1;

public class SQLEpsAndes {


	private final static String SQL = PersistenciaParranderos.SQL;

	private PersistenciaParranderos persistenciaEPS;


	public SQLEpsAndes(PersistenciaParranderos pPersistenciaParranderos) {

		persistenciaEPS = pPersistenciaParranderos;
	}

	public long adicionarEPS (PersistenceManager pm,long id, long pIdGerente) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + persistenciaEPS.darTablaEpsAndes() + "(id, idgerente) values (?,?)");
		q.setParameters( id, pIdGerente);
		return (long) q.executeUnique();
	}


	public long eliminarEPS (PersistenceManager pm, long pIdEPS)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + persistenciaEPS.darTablaEpsAndes()   + " WHERE id = ?");
		q.setParameters(pIdEPS);
		return (long) q.executeUnique();            
	}


	public EpsAndes darEPS (PersistenceManager pm, long pIdEPS) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaEpsAndes()   + " WHERE id = ?");
		q.setResultClass(EpsAndes.class);
		q.setParameters(pIdEPS);
		return (EpsAndes) q.executeUnique();
	}



	public List<EpsAndes> darEPSs (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + persistenciaEPS.darTablaEpsAndes() );
		q.setResultClass(EpsAndes.class);
		return (List<EpsAndes>) q.executeList();
	}

	public void RFC1(PersistenceManager pm, java.sql.Timestamp fecha1, java.sql.Timestamp fecha2) {
		Query q = pm.newQuery(SQL, "SELECT s.idips, COUNT(s.id) FROM " + persistenciaEPS.darTablaServicioSalud() +  
				" s INNER JOIN " + persistenciaEPS.darTablaHorario() + " h ON s.id = h.idservicio INNER JOIN " +  
				persistenciaEPS.darTablaReservas() + " r ON h.id = r.idhorario "
				+ "WHERE h.fecha > ? AND h.fecha < ? AND r.estado = ?" +
				" GROUP BY s.idips");

		q.setResultClass(RFC1.class);
		q.setParameters(fecha1, fecha2, "ASISTENCIA");

		List<RFC1> resp = (List<RFC1>) q.executeList();
		System.out.println(resp.size());


		for (int i = 0; i < resp.size(); i++) {
			System.out.println(resp.get(i).getIdIps());
		}
	}




}
