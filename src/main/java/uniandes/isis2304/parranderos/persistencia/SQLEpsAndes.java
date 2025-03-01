package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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
import uniandes.isis2304.parranderos.negocio.RFC11A;
import uniandes.isis2304.parranderos.negocio.RFC12A;
import uniandes.isis2304.parranderos.negocio.RFC12B;
import uniandes.isis2304.parranderos.negocio.RFC12C;
import uniandes.isis2304.parranderos.negocio.RFC11B;
import uniandes.isis2304.parranderos.negocio.RFC11C;
import uniandes.isis2304.parranderos.negocio.RFC2;
import uniandes.isis2304.parranderos.negocio.RFC4;
import uniandes.isis2304.parranderos.negocio.RFC5;
import uniandes.isis2304.parranderos.negocio.RFC7;
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

	public List<RFC4> RFC4(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT DISTINCT h.idservicio " +
				"FROM "+persistenciaEPS.darTablaReservas()+ " r INNER JOIN HORARIO H on r.idhorario = h.id "
				+"WHERE r.estado = ?" );
		q.setResultClass(RFC4.class);
		q.setParameters("ASISTENCIA");
		return (List<RFC4>) q.executeList();
	}

	public List<RFC5> RFC5(PersistenceManager pm, String pFecha1, String pFecha2, String idAfiliado) {

		Timestamp fecha1 = Timestamp.valueOf(pFecha1);
		Timestamp fecha2 = Timestamp.valueOf(pFecha2);
		long id = Long.valueOf(idAfiliado);		

		Query q = pm.newQuery(SQL, "SELECT COUNT(s.id) as numeroservicios FROM "+
				persistenciaEPS.darTablaServicioSalud()+" s INNER JOIN "+ persistenciaEPS.darTablaHorario()+ 
				" H ON s.id = h.idservicio  INNER JOIN RESERVAS R on r.idhorario = h.id" +
				" WHERE h.fecha > ? AND h.fecha < ?"+
				" AND r.idafiliadotomador = ?" );
		q.setResultClass(RFC5.class);
		q.setParameters(fecha1, fecha2, id);
		return (List<RFC5>) q.executeList();
	}

	public List<RFC7> RFC7(PersistenceManager pm, Timestamp fecha1, Timestamp fecha2) {
		Query q = pm.newQuery(SQL, "SELECT r.idafiliadotomador, COUNT(s.id) as numeroservicios, COUNT(DISTINCT h.idservicio) as diferentes FROM "+
				persistenciaEPS.darTablaServicioSalud()+ " s INNER JOIN "+persistenciaEPS.darTablaHorario()+ " H ON s.id = h.idservicio  INNER JOIN "+
				persistenciaEPS.darTablaReservas()+ " R on r.idhorario = h.id "+
				" WHERE h.fecha > ? AND h.fecha < ? "+
				"GROUP BY r.idafiliadotomador" );
		q.setResultClass(RFC7.class);
		q.setParameters(fecha1, fecha2);
		return (List<RFC7>) q.executeList();
	}

	public List<RFC12A> RFC12A(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT  a.IDUSUARIO, a.NUMDOCUMENTO, a.FECHANACIMIENTO, "+
	"a.TIPODOCUMENTO,"+
	"			sum(case when (s.TIPO not in ('INTERVENCION','CIRUGIA', "+
	"			'CIRUGIA_AMBULATORIA','DIALISIS','RADIOGRAFIA')) "+
	"			then 1 else 0 end) as ServiciosNormales, null AS veceshospitalizado, null "+
	"					 AS citasasistidas, null AS mesesasistidos  FROM "+
		"		afiliado a INNER JOIN  reservas "+
		"		r ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
		"		INNER JOIN horario h ON h.ID = r.IDHORARIO INNER JOIN "+
		"		servicio_salud s ON s.ID = h.IDSERVICIO "+
		"		GROUP BY a.TIPODOCUMENTO, a.FECHANACIMIENTO, a.NUMDOCUMENTO, a.IDUSUARIO "+
		"		HAVING sum(case when (s.TIPO not in ('INTERVENCION','CIRUGIA', 'CIRUGIA_AMBULATORIA', "+
		"				'DIALISIS' "+
		"		))"+
		"		then 1 else 0 end) = 0 "+
         "       Union all "+
         "       SELECT a.IDUSUARIO, a.NUMDOCUMENTO, a.FECHANACIMIENTO, a.TIPODOCUMENTO, null AS serviciosnormales, "+
			"	sum(case when (r.HOSPITALIZADO <> 0) "+
			"	then 1 else 0 end) as veceshospitalizado, sum(case when (r.estado = 'ASISTENCIA') "+
			"	then 1 else 0 end) as citasasistidas, null AS mesesasistidos  FROM AFILIADO a INNER "+
			"			JOIN RESERVAS r ON a.IDUSUARIO "+
			"	= r.IDAFILIADORESERVADOR "+
			"	GROUP BY a.TIPODOCUMENTO, a.FECHANACIMIENTO, a.NUMDOCUMENTO, a.IDUSUARIO HAVING "+
			"	sum(case when (r.HOSPITALIZADO <> 0) "+
			"	then 1 else 0 end) > 0 AND sum(case when (r.HOSPITALIZADO <> 0) "+
			"	then 1 else 0 end) = sum(case when (r.estado = 'ASISTENCIA') "+
			"	then 1 else 0 end) "+
             "   Union all "+
           "     SELECT a.IDUSUARIO, a.NUMDOCUMENTO, a.FECHANACIMIENTO, "+
		"		a.TIPODOCUMENTO,null AS serviciosnormales,null AS veceshospitalizado,null AS citasasistidas, COUNT(DISTINCT to_char(h.FECHA ,'MM')) as mesesasitidos FROM AFILIADO a "+ 
		"		INNER JOIN RESERVAS r ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
		"		INNER JOIN HORARIO h ON h.ID = r.IDHORARIO "+
		"		GROUP BY a.IDUSUARIO, a.NUMDOCUMENTO, a.FECHANACIMIENTO, a.TIPODOCUMENTO "+
		"		HAVING COUNT(DISTINCT to_char(h.FECHA ,'MM'))>=12" );
		q.setResultClass(RFC12A.class);
		List<RFC12A> arreglo = new ArrayList<RFC12A>();
		long start = System.currentTimeMillis();
		arreglo =  q.executeList();
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time 12 is " + formatter.format((end - start) / 1000d) + " seconds");
		return arreglo;
	}

	public List<RFC12B> RFC12B(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT a.IDUSUARIO, a.NUMDOCUMENTO, a.FECHANACIMIENTO, a.TIPODOCUMENTO, "+
				"sum(case when (r.HOSPITALIZADO <> 0) "+
				"then 1 else 0 end) as veceshospitalizado, sum(case when (r.estado = 'ASISTENCIA') "+
				"then 1 else 0 end) as citasasistidas  FROM AFILIADO a INNER JOIN RESERVAS r ON a.IDUSUARIO "+
				"= r.IDAFILIADORESERVADOR "+
				"GROUP BY a.TIPODOCUMENTO, a.FECHANACIMIENTO, a.NUMDOCUMENTO, a.IDUSUARIO HAVING "+
				"sum(case when (r.HOSPITALIZADO <> 0) "+
				"then 1 else 0 end) > 0 AND sum(case when (r.HOSPITALIZADO <> 0) "+
				"then 1 else 0 end) = sum(case when (r.estado = 'ASISTENCIA') "+
				"then 1 else 0 end)" );
		q.setResultClass(RFC12B.class);
		List<RFC12B> arreglo = new ArrayList<RFC12B>();
		long start = System.currentTimeMillis();
		arreglo =  q.executeList();
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time 12B is " + formatter.format((end - start) / 1000d) + " seconds");
		return arreglo;
	}

	public List<RFC12C> RFC12C(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT a.IDUSUARIO, a.NUMDOCUMENTO, a.FECHANACIMIENTO, "+
				"a.TIPODOCUMENTO, COUNT(DISTINCT to_char(h.FECHA ,'MM')) as mesesasitidos FROM AFILIADO a "+
				"INNER JOIN RESERVAS r ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
				"INNER JOIN HORARIO h ON h.ID = r.IDHORARIO "+
				"GROUP BY a.IDUSUARIO, a.NUMDOCUMENTO, a.FECHANACIMIENTO, a.TIPODOCUMENTO "+
				"HAVING COUNT(DISTINCT to_char(h.FECHA ,'MM'))>=12" );
		q.setResultClass(RFC12C.class);
		List<RFC12C> arreglo = new ArrayList<RFC12C>();
		long start = System.currentTimeMillis();
		arreglo =  q.executeList();
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time 12C is " + formatter.format((end - start) / 1000d) + " seconds");
		return arreglo;
	}

	public List<RFC11A> RFC11A(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT s.año, s.semana, s.idafiliado, s.veces, null AS idips, null "+
				" AS tipo from ( "+
    "SELECT b.año, "+
     "      b.semana,"+
      "     b.idafiliado,"+
       "    b.veces,"+
        "   ROW_NUMBER() OVER(PARTITION BY b.semana"+
         "  ORDER BY b.veces DESC) AS rk "+
      " FROM (SELECT to_char(h.FECHA ,'IYYY') as año, to_char(h.FECHA ,'IW') "+
      " as semana, r.idafiliadoreservador as idafiliado,count(r.idafiliadoreservador) as veces "+
" FROM AFILIADO a "+
" INNER JOIN RESERVAS r "+
" ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
" INNER JOIN HORARIO h "+
" ON h.ID = r.IDHORARIO "+
"GROUP BY to_char(h.FECHA ,'IYYY'), to_char(h.FECHA ,'IW'), r.idafiliadoreservador "+
"ORDER by semana ASC) b) s "+
"WHERE s.rk = 1 "+
"  Union all "+
" SELECT to_char(h.FECHA ,'IYYY') as Año, to_char(h.FECHA ,'IW') as semana,null AS idafiliado, "+
" s.idips,null AS tipo, COUNT( s.idips) as veces "+
" FROM AFILIADO a INNER JOIN RESERVAS r ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
" INNER JOIN HORARIO h ON h.ID = r.IDHORARIO INNER JOIN SERVICIO_SALUD s ON s.ID = h.IDSERVICIO "+
" GROUP BY to_char(h.FECHA ,'IYYY'), to_char(h.FECHA ,'IW'), s.idips "+
" Union all "+
" SELECT to_char(h.FECHA ,'IYYY') as Año, to_char(h.FECHA ,'IW') "+
"				as semana,null AS idafiliado, null AS idips,  s.TIPO, COUNT( s.TIPO) as veces "+
"FROM AFILIADO a INNER JOIN RESERVAS r ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
" INNER JOIN HORARIO h ON h.ID = r.IDHORARIO INNER JOIN SERVICIO_SALUD s ON s.ID = h.IDSERVICIO "+
" GROUP BY to_char(h.FECHA ,'IYYY'), to_char(h.FECHA ,'IW'), s.TIPO "+
" ORDER by semana ASC" );
		q.setResultClass(RFC11A.class);
		List<RFC11A> arreglo = new ArrayList<RFC11A>();
		long start = System.currentTimeMillis();
		arreglo =  q.executeList();
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time 11 is " + formatter.format((end - start) / 1000d) + " seconds");
		return arreglo;
	}
	
	
	public List<RFC11B> RFC11B(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT to_char(h.FECHA ,'IYYY') as Año, to_char(h.FECHA ,'IW') as semana,  s.idips, COUNT( s.idips) as veces "+
"FROM AFILIADO a INNER JOIN RESERVAS r ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
"INNER JOIN HORARIO h ON h.ID = r.IDHORARIO INNER JOIN SERVICIO_SALUD s ON s.ID = h.IDSERVICIO "+
"GROUP BY to_char(h.FECHA ,'IYYY'), to_char(h.FECHA ,'IW'), s.idips "+
"ORDER by semana ASC" );
		q.setResultClass(RFC11B.class);
		List<RFC11B> arreglo = new ArrayList<RFC11B>();
		long start = System.currentTimeMillis();
		arreglo =  q.executeList();
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time 11B is " + formatter.format((end - start) / 1000d) + " seconds");
		return arreglo;
	}
	public List<RFC11C> RFC11C(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT s.anno, s.semana, s.idafiliado, s.veces from ( "+
    "SELECT b.anno, "+
     "      b.semana, "+
      "     b.idafiliado,"+
       "    b.veces, "+
        "   ROW_NUMBER() OVER(PARTITION BY b.semana "+
         "  ORDER BY b.veces DESC) AS rk "+
       " FROM (SELECT to_char(h.FECHA ,'IYYY') as anno, to_char(h.FECHA ,'IW') "+
      " as semana, r.idafiliadoreservador as idafiliado,count(r.idafiliadoreservador) as veces "+
" FROM AFILIADO a "+
" INNER JOIN RESERVAS r "+
" ON a.IDUSUARIO = r.IDAFILIADORESERVADOR "+
" INNER JOIN HORARIO h "+
" ON h.ID = r.IDHORARIO "+
" GROUP BY to_char(h.FECHA ,'IYYY'), to_char(h.FECHA ,'IW'), r.idafiliadoreservador "+
"ORDER by semana ASC) b) s"+
" WHERE s.rk = 1" );
		q.setResultClass(RFC11C.class);
		List<RFC11C> arreglo = new ArrayList<RFC11C>();
		long start = System.currentTimeMillis();
		List aarreglo = (List) q.execute();
		System.out.println(arreglo.size());
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time 11C is " + formatter.format((end - start) / 1000d) + " seconds");
		return aarreglo;
	}


}