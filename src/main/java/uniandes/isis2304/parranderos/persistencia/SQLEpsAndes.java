package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;



import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.EpsAndes;
import uniandes.isis2304.parranderos.negocio.Gustan;
import uniandes.isis2304.parranderos.negocio.Horario;
import uniandes.isis2304.parranderos.negocio.Sirven;
import uniandes.isis2304.parranderos.negocio.VOServicioSalud;
import uniandes.isis2304.parranderos.negocio.RFC1;
import uniandes.isis2304.parranderos.negocio.RFC2;
import uniandes.isis2304.parranderos.negocio.RFC6;

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


	public List<RFC1> RFC1(PersistenceManager pm, java.sql.Timestamp fecha1, java.sql.Timestamp fecha2) {
		Query q = pm.newQuery(SQL, "SELECT s.idips, COUNT(s.id) FROM " + persistenciaEPS.darTablaServicioSalud() +  
				" s INNER JOIN " + persistenciaEPS.darTablaHorario() + " h ON s.id = h.idservicio INNER JOIN " +  
				persistenciaEPS.darTablaReservas() + " r ON h.id = r.idhorario "
				+ "WHERE h.fecha > ? AND h.fecha < ? AND r.estado = ?" +
				" GROUP BY s.idips");

		q.setResultClass(RFC1.class);
		q.setParameters(fecha1, fecha2, "ASISTENCIA");
		return  (List<RFC1>) q.executeList();


	}

	public List<RFC2> RFC2(PersistenceManager pm, java.sql.Timestamp fecha1, java.sql.Timestamp fecha2) {

		Query q = pm.newQuery(SQL, "SELECT h.idservicio, COUNT(h.idservicio) as count FROM "+
				persistenciaEPS.darTablaHorario()+ " H INNER JOIN " + persistenciaEPS.darTablaReservas()
				+ " R ON H.id = r.idhorario" 
				+ " WHERE h.fecha > ? AND h.fecha < ?" 
				+ " GROUP BY h.idservicio" 
				+ " ORDER BY COUNT(h.idservicio) DESC"
				+ " FETCH FIRST 20 ROW ONLY" );
		q.setResultClass(RFC2.class);
		q.setParameters(fecha1, fecha2);
		return (List<RFC2>) q.executeList();
	}

	public List<RFC2> RFC3(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT h.idservicio, COUNT(h.idservicio) as count FROM "
				+ persistenciaEPS.darTablaHorario() + " h INNER JOIN " +persistenciaEPS.darTablaReservas()+
				" r ON H.id = r.idhorario"+
				" GROUP BY h.idservicio" );
		q.setResultClass(RFC2.class);
		return (List<RFC2>) q.executeList();
	}
}
