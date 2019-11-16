package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.RFC2;
import uniandes.isis2304.parranderos.negocio.RFC6;
import uniandes.isis2304.parranderos.negocio.RFC9;

public class SQLRFC {
	
	private final static String SQL = PersistenciaParranderos.SQL;

	private PersistenciaParranderos persistenciaEPS;


	public SQLRFC(PersistenciaParranderos pPersistenciaParranderos) {

		persistenciaEPS = pPersistenciaParranderos;
	}
	
	public List<RFC6> darMayorDemanda(PersistenceManager pm,String tipoServicio, Timestamp fecha1, Timestamp fecha2, int cuantos) {
		Query q = pm.newQuery(SQL, "SELECT h.fecha,cuenta FROM "+ persistenciaEPS.darTablaHorario() +" H INNER JOIN (select * from " + persistenciaEPS.darTablaServicioSalud() + " where tipo=UPPER(?))S ON h.idservicio=S.ID"+
	" INNER JOIN ("+	"SELECT COUNT(IDHORARIO)CUENTA,idhorario FROM "+ persistenciaEPS.darTablaReservas() +" GROUP BY idhorario )R ON h.id=R.IDHORARIO WHERE (H.FECHA >=? AND H.FECHA <=?) ORDER BY CUENTA DESC FETCH FIRST ? ROWS ONLY");
		System.out.println("ejecuta");
		System.out.println(q);
		q.setResultClass(Object.class);
		q.setParameters(tipoServicio,fecha1, fecha2, cuantos);
		return (List) q.executeList();
	}
	
	public List<RFC6> darMayorActividad(PersistenceManager pm,String tipoServicio, Timestamp fecha1, Timestamp fecha2, int cuantos) {
		Query q = pm.newQuery(SQL, "SELECT h.fecha,cuenta FROM "+ persistenciaEPS.darTablaHorario() +" H INNER JOIN (select * from " + persistenciaEPS.darTablaServicioSalud() + " where tipo=UPPER(?))S ON h.idservicio=S.ID"+
	" INNER JOIN ("+ "SELECT COUNT(IDHORARIO) CUENTA,idhorario,ESTADO FROM "+ persistenciaEPS.darTablaReservas() +"WHERE ESTADO='ASISTENCIA' GROUP BY idhorario,ESTADO )R ON h.id=R.IDHORARIO WHERE (H.FECHA >=? AND H.FECHA <=?) ORDER BY CUENTA DESC FETCH FIRST ? ROWS ONLY");
		q.setResultClass(RFC6.class);
		q.setParameters(tipoServicio,fecha1, fecha2, cuantos);
		return (List<RFC6>) q.executeList();
	}
	
	public List<RFC6> darMenorDemanda(PersistenceManager pm,String tipoServicio, Timestamp fecha1, Timestamp fecha2, int cuantos) {
		Query q = pm.newQuery(SQL, "SELECT h.fecha,cuenta FROM "+ persistenciaEPS.darTablaHorario() +" H INNER JOIN (select * from " + persistenciaEPS.darTablaServicioSalud() + " where tipo=UPPER(?))S ON h.idservicio=S.ID"+
	" INNER JOIN ("+ "SELECT COUNT(IDHORARIO) CUENTA,idhorario FROM "+ persistenciaEPS.darTablaReservas() +" GROUP BY idhorario )R ON h.id=R.IDHORARIO WHERE (H.FECHA >=? AND H.FECHA <=?) ORDER BY CUENTA ASC FETCH FIRST ? ROWS ONLY");
		q.setResultClass(RFC6.class);
		q.setParameters(tipoServicio,fecha1, fecha2, cuantos);
		return (List<RFC6>) q.executeList();
	}
	
	public List<RFC9> darPrestacionServicios(PersistenceManager pm, Timestamp fecha1, Timestamp fecha2){
		Query q = pm.newQuery(SQL,    "SELECT U.NOMBRE, U.CORREO,A.FECHANACIMIENTO, A.TIPODOCUMENTO,A.NUMDOCUMENTO,A.HOSPITALIZADO, R.ESTADO,S.TIPO, S.IDIPS "+
			    " FROM " + persistenciaEPS.darTablaReservas() + " R "+
			    " INNER JOIN " + persistenciaEPS.darTablaHorario() +" H "+
			    " ON R.IDHORARIO = H.ID "+
			    " INNER JOIN "+ persistenciaEPS.darTablaServicioSalud()+ " S "+
			    " ON S.ID = H.IDSERVICIO "+ 
			    " INNER JOIN "+ persistenciaEPS.darTablaUsuario() + " U " +
			    " ON U.ID = R.IDAFILIADORESERVADOR "+
			    " INNER JOIN "+ persistenciaEPS.darTablaAfliado() + " A "+
			    " ON U.ID = A.IDUSUARIO "+
			    " WHERE H.FECHA>=? AND H.FECHA>=?");
		q.setResultClass(RFC9.class);
		q.setParameters(fecha1, fecha2);
		return (List<RFC9>) q.executeList();
	}


}
