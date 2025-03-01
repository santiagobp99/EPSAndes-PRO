/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.parranderos.persistencia;


import java.math.BigDecimal;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.parranderos.negocio.Afiliado;
import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.negocio.Bebida;
import uniandes.isis2304.parranderos.negocio.EpsAndes;
import uniandes.isis2304.parranderos.negocio.Gustan;
import uniandes.isis2304.parranderos.negocio.Horario;

import uniandes.isis2304.parranderos.negocio.Ips;

import uniandes.isis2304.parranderos.negocio.Medico;
import uniandes.isis2304.parranderos.negocio.MedicoEspecialista;
import uniandes.isis2304.parranderos.negocio.MedicoGeneral;
import uniandes.isis2304.parranderos.negocio.MedicoServicio;
import uniandes.isis2304.parranderos.negocio.MedicoTratante;
import uniandes.isis2304.parranderos.negocio.Orden;
import uniandes.isis2304.parranderos.negocio.OrdenesServicios;
import uniandes.isis2304.parranderos.negocio.RFC1;
import uniandes.isis2304.parranderos.negocio.RFC10;
import uniandes.isis2304.parranderos.negocio.RFC11A;
import uniandes.isis2304.parranderos.negocio.RFC11B;
import uniandes.isis2304.parranderos.negocio.RFC11C;
import uniandes.isis2304.parranderos.negocio.RFC12A;
import uniandes.isis2304.parranderos.negocio.RFC12B;
import uniandes.isis2304.parranderos.negocio.RFC12C;
import uniandes.isis2304.parranderos.negocio.RFC2;
import uniandes.isis2304.parranderos.negocio.RFC4;
import uniandes.isis2304.parranderos.negocio.RFC5;
import uniandes.isis2304.parranderos.negocio.RFC7;
import uniandes.isis2304.parranderos.negocio.RFC9;
import uniandes.isis2304.parranderos.negocio.RFC6;
import uniandes.isis2304.parranderos.negocio.Recepcionista;
import uniandes.isis2304.parranderos.negocio.Reservas;
import uniandes.isis2304.parranderos.negocio.Rol;
import uniandes.isis2304.parranderos.negocio.ServicioSalud;
import uniandes.isis2304.parranderos.negocio.Sirven;
import uniandes.isis2304.parranderos.negocio.TipoBebida;
import uniandes.isis2304.parranderos.negocio.Usuario;
import uniandes.isis2304.parranderos.negocio.VOReservas;
import uniandes.isis2304.parranderos.negocio.VOServicioSalud;
import uniandes.isis2304.parranderos.negocio.Visitan;

/**
 * Clase para el manejador de persistencia del proyecto Parranderos
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQLBar, SQLBebedor, SQLBebida, SQLGustan, SQLSirven, SQLTipoBebida y SQLVisitan, que son 
 * las que realizan el acceso a la base de datos
 * 
 * @author Germán Bravo
 */
public class PersistenciaParranderos 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaParranderos.class.getName());

	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaParranderos instance;

	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;

	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;

	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;

	/**
	 * Atributo para el acceso a la tabla TIPOBEBIDA de la base de datos
	 */
	private SQLTipoBebida sqlTipoBebida;

	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLBebida sqlBebida;

	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLBar sqlBar;

	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLBebedor sqlBebedor;

	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLGustan sqlGustan;

	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLSirven sqlSirven;

	/**
	 * Atributo para el acceso a la tabla VISITAN de la base de datos
	 */
	private SQLVisitan sqlVisitan;

	private SQLAdscritos sqlAdscritos;

	private SQLAfiliado sqlAfiliado;

	private SQLCitaMedica sqlCitaMedica;

	private SQLConsultaEspecialista sqlConsultaEspecialista;

	private SQLConsultaUrgencias sqlConsultaUrgencias;

	private SQLEpsAndes sqlEpsAndes;
	
	private SQLRFC sqlRFC;

	private SQLHorario sqlHorario;

	private SQLInterconsultas sqlInterconsultas;

	private SQLIps sqlIps;

	private SQLMedico sqlMedico;

	private SQLMedicoEspecialista sqlMedicoEspecialista;

	private SQLMedicoGeneral sqlMedicoGeneral;

	private SQLMedicoTratante sqlMedicoTratante;

	private SQLOrden sqlOrden;

	private SQLRecepcionista sqlRecepcionista;

	private SQLRol sqlRol;

	private SQLServicioSalud sqlServicioSalud;

	private SQLUsuario sqlUsuario;

	private SQLMedicoServicio sqlMedicoServicio;

	private SQLReservas sqlReservas;

	private SQLOrdenesServicios sqlOrdenesServicios;

	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaParranderos ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Parranderos");		
		crearClasesSQL ();

		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("ADSCRITOS");
		tablas.add ("AFILIADO");
		tablas.add ("CITA_MEDICA");
		tablas.add ("CONSULTA_ESPECIALISTA");
		tablas.add ("CONSULTA_URGENCIAS");
		tablas.add ("EPS_ANDES");
		tablas.add ("HORARIO");
		tablas.add ("INTERCONSULTAS");
		tablas.add ("IPS");
		tablas.add ("MEDICO");
		tablas.add ("MEDICO_ESPECIALISTA");
		tablas.add ("MEDICO_GENERAL");
		tablas.add("MEDICO_SERVICIO");
		tablas.add ("MEDICO_TRATANTE");
		tablas.add ("ORDEN");
		tablas.add("ORDENES_SERVICIOS");
		tablas.add ("RECEPCIONISTA");
		tablas.add ("RESERVAS");
		tablas.add ("ROL");
		tablas.add ("SERVICIO_SALUD");
		tablas.add ("USUARIO");

	}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaParranderos (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);

		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaParranderos getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaParranderos ();
		}
		return instance;
	}

	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaParranderos getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaParranderos (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}

	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}

		return resp;
	}

	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlAdscritos = new SQLAdscritos(this);
		sqlAfiliado = new SQLAfiliado(this);
		sqlCitaMedica = new  SQLCitaMedica(this);
		sqlConsultaEspecialista = new SQLConsultaEspecialista(this);
		sqlConsultaUrgencias = new SQLConsultaUrgencias(this);
		sqlEpsAndes = new SQLEpsAndes(this);
		sqlHorario = new SQLHorario(this);
		sqlInterconsultas = new SQLInterconsultas(this);
		sqlIps = new SQLIps(this);
		sqlMedico = new SQLMedico(this);
		sqlMedicoEspecialista = new SQLMedicoEspecialista(this);
		sqlMedicoGeneral = new SQLMedicoGeneral(this);
		sqlMedicoServicio = new SQLMedicoServicio(this);
		sqlMedicoTratante = new SQLMedicoTratante(this);
		sqlOrden = new SQLOrden(this);
		sqlOrdenesServicios = new SQLOrdenesServicios(this);
		sqlRecepcionista = new SQLRecepcionista(this);
		sqlReservas = new SQLReservas(this);
		sqlRol = new SQLRol(this);
		sqlServicioSalud = new SQLServicioSalud(this);
		sqlUsuario = new SQLUsuario(this);
		sqlUtil = new SQLUtil(this);
		sqlRFC = new SQLRFC(this);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqParranderos ()
	{
		return tablas.get (1000);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaTipoBebida ()
	{
		return tablas.get (100);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaBebida ()
	{
		return tablas.get (200);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaBar ()
	{
		return tablas.get (300);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de parranderos
	 */
	public String darTablaBebedor ()
	{
		return tablas.get (400);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaGustan ()
	{
		return tablas.get (500);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de parranderos
	 */
	public String darTablaSirven ()
	{
		return tablas.get (600);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaVisitan ()
	{
		return tablas.get (700);
	}

	public String darTablaAdscritos (){
		return tablas.get (0);
	}

	public String darTablaAfiliado (){
		return tablas.get (1);
	}

	public String darTablaCitaMedica (){
		return tablas.get (2);
	}

	public String darTablaConsultaEspecialista (){
		return tablas.get (3);
	}

	public String darTablaConsultaUrgencias (){
		return tablas.get (4);
	}

	public String darTablaEpsAndes (){
		return tablas.get (5);
	}

	public String darTablaHorario (){
		return tablas.get (6);
	}

	public String darTablaInterconsultas (){
		return tablas.get (7);
	}

	public String darTablaIps (){
		return tablas.get (8);
	}

	public String darTablaMedico (){
		return tablas.get (9);
	}

	public String darTablaMedicoEspecialista (){
		return tablas.get (10);
	}

	public String darTablaMedicoGeneral (){
		return tablas.get (11);
	}

	public String darTablaMedicoServicio (){
		return tablas.get (12);
	}

	public String darTablaMedicoTratante (){
		return tablas.get (13);
	}

	public String darTablaOrden (){
		return tablas.get (14);
	}

	public String darTablaOrdenesServicios(){
		return tablas.get (15);
	}

	public String darTablaRecepcionista (){
		return tablas.get (16);
	}

	public String darTablaReservas (){
		return tablas.get (17);
	}

	public String darTablaRol (){
		return tablas.get (18);
	}

	public String darTablaServicioSalud(){
		return tablas.get (19);
	}

	public String darTablaUsuario(){
		return tablas.get (20);
	}

	public String darSeqConsultaUrgencias() {
		return tablas.get (21);
	}

	public String darSeqEpsAndes() {
		return tablas.get (22);
	}

	public String darSeqHorario() {
		return tablas.get (23);
	}

	public String darSeqIps() {
		return tablas.get (24);
	}

	public String darSeqMedico ()	{
		return tablas.get (25);
	}

	public String darSeqOrden() {
		return tablas.get (26);
	}

	public String darSeqOrdenesServicio() {
		return tablas.get (27);
	}

	public String darSeqReservas (){
		return tablas.get (28);
	}

	public String darSeqRol (){
		return tablas.get (29);
	}

	public String darSeqServicioSalud() {
		return tablas.get(30);
	}

	public String darSeqUsuario (){
		return tablas.get (31);
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
		long resp = sqlUtil.nextval (pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currHorario ()
	{
		long resp = sqlUtil.currValHorario(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currMedico ()
	{
		long resp = sqlUtil.currValMedico(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currOrden ()
	{
		long resp = sqlUtil.currValOrden(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currOrdenServicio ()
	{
		long resp = sqlUtil.currValOrdenServicio(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currReservas ()
	{
		long resp = sqlUtil.currValReservas(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currRol ()
	{
		long resp = sqlUtil.currValRol(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currServicioSalud ()
	{
		long resp = sqlUtil.currValServicioSalud(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long currUsuario ()
	{
		long resp = sqlUtil.currValUsuario(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}


	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/* ****************************************************************
	 * 			 ROL
	 *****************************************************************/

	public Rol adicionarRol(String nombreRol)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long id = currRol();
			long tuplasInsertadas = sqlRol.adicionarRol(pm, id, nombreRol);
			tx.commit();

			log.trace ("Inserción del rol: " + nombreRol + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Rol(id, nombreRol);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}




	public long eliminarRolPorId (long idRol) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlRol.eliminarRolPorId(pm, idRol);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}



	public List<Rol> darRoles ()
	{
		return sqlRol.darRoles(pmf.getPersistenceManager());
	}

	public Rol darRolID (long idRol)
	{
		return sqlRol.darRolPorId(pmf.getPersistenceManager(), idRol);
	}


	/* ****************************************************************
	 * 			 USUARIO
	 *****************************************************************/

	public Usuario adicionarUsuario(String nombre, String correo, long idRol)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long id = currUsuario();
			long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, id,nombre, correo, idRol);
			tx.commit();

			log.trace ("Inserción del usuario: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Usuario(id,nombre, correo, idRol);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public Usuario darUsuario (long idUsuario)
	{
		return sqlUsuario.darUsuario(pmf.getPersistenceManager(), idUsuario);
	}

	public List<Usuario> darUsuarios ()
	{
		return sqlUsuario.darUsuarios(pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			 IPS
	 *****************************************************************/

	public Ips adicionarIPS(String ubicacion, String nombre, String tipo, int capacidad, long idEps)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlIps.adicionarIps(pm, ubicacion, nombre, tipo, capacidad, idEps);
			tx.commit();

			log.trace ("Inserción de la Ips: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Ips(ubicacion, nombre, tipo, capacidad, idEps);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public Ips darIPS (long idEps)
	{
		return sqlIps.darIPS(pmf.getPersistenceManager(), idEps);
	}

	public List<Ips> daIps ()
	{
		return sqlIps.darIPSs(pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			 MEDICO
	 *****************************************************************/

	public Medico adicionarMedico(long idRol,int numRegistroMedico, String especialidad, String identificacion, String nombre, String correo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long id = currMedico();
			long tuplasInsertadas = sqlMedico.adicionarMedico(pm, id,idRol, numRegistroMedico, especialidad, identificacion, nombre, correo);

			tx.commit();

			log.trace ("Inserción del medico: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Medico(id,idRol,numRegistroMedico, especialidad, identificacion, nombre, correo);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}



	public Medico darMedico (long idEps)
	{
		return sqlMedico.darMedico(pmf.getPersistenceManager(), idEps);
	}

	public List<Medico> darMedicos ()
	{
		return sqlMedico.darMedicos(pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			 MEDICO GENERAL
	 *****************************************************************/

	public MedicoGeneral adicionarMedicoGeneral(long pIdMedicoGeneral)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlMedicoGeneral.adicionarMedicoGeneral(pm, pIdMedicoGeneral);
			tx.commit();

			log.trace ("Inserción del medico general: " + pIdMedicoGeneral + ": " + tuplasInsertadas + " tuplas insertadas");

			return new MedicoGeneral(pIdMedicoGeneral);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public MedicoGeneral darMedicoGeneral (long pIdMedicoGeneral)
	{
		return sqlMedicoGeneral.darMedicoGeneral(pmf.getPersistenceManager(), pIdMedicoGeneral);
	}

	public List<MedicoGeneral> darMedicosGenerales ()
	{
		return sqlMedicoGeneral.darMedicosGenerales(pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			 MEDICO ESPECIALISTA
	 *****************************************************************/

	public MedicoEspecialista adicionarMedicoEspecialista(long pIdMedicoEspecialista)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlMedicoEspecialista.adicionarMedicoEspecialista(pm, pIdMedicoEspecialista);
			tx.commit();

			log.trace ("Inserción del medico especialista: " + pIdMedicoEspecialista + ": " + tuplasInsertadas + " tuplas insertadas");

			return new MedicoEspecialista(pIdMedicoEspecialista);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public MedicoEspecialista darMedicoEspecialista (long pIdMedicoEspecialista)
	{
		return sqlMedicoEspecialista.darMedicoEspecialista(pmf.getPersistenceManager(), pIdMedicoEspecialista);
	}

	public List<MedicoEspecialista> darMedicosEspecialistas ()
	{
		return sqlMedicoEspecialista.darMedicosEspecialistas(pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			 MEDICO TRATANTE
	 *****************************************************************/

	public MedicoTratante adicionarMedicoTratante(long pIdMedicoTratante)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlMedicoTratante.adicionarMedicoTratante(pm, pIdMedicoTratante);
			tx.commit();

			log.trace ("Inserción del medico tratante: " + pIdMedicoTratante + ": " + tuplasInsertadas + " tuplas insertadas");

			return new MedicoTratante(pIdMedicoTratante);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public MedicoTratante darMedicoTratante (long pIdMedicoTratante)
	{
		return sqlMedicoTratante.darMedicoTratante(pmf.getPersistenceManager(), pIdMedicoTratante);
	}

	public List<MedicoTratante> darMedicosTratantes ()
	{
		return sqlMedicoTratante.darMedicosTratantes(pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			 MEDICO_SERVICIO
	 *****************************************************************/


	public MedicoServicio adicionarMedicoServicio(long pIdMedico){

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{

			tx.begin();
			long pIdServicio = currServicioSalud()-1;
			long tuplasInsertadas = sqlMedicoServicio.adicionarMedicoServicio(pm, pIdMedico, pIdServicio);
			tx.commit();

			log.trace ("Inserción del MedicoServicio: " + pIdMedico+"--"+ pIdServicio + ": " + tuplasInsertadas + " tuplas insertadas");

			return new MedicoServicio(pIdMedico, pIdServicio);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}

	}



	/* ****************************************************************
	 * 			 OrdenesServicios
	 *****************************************************************/

	public OrdenesServicios adicionarOrdenesServicios(long idServicio, long pIdOrden, int realizado) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{

			tx.begin();
			long id = currOrdenServicio()-1;
			long tuplasInsertadas = sqlOrdenesServicios.adicionarOrdenServicio(pm, id,idServicio,pIdOrden, realizado);
			tx.commit();

			log.trace ("Inserción de la OrdenServicios: " + pIdOrden+"--"+ idServicio + ": " + tuplasInsertadas + " tuplas insertadas");

			return new OrdenesServicios(id, idServicio,pIdOrden, realizado);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public List<OrdenesServicios> darOrdenesServiciosId (long idOrden)
	{

		return sqlOrdenesServicios.darOrdenesServiciosId(pmf.getPersistenceManager(), idOrden);
	}


	/* ****************************************************************
	 * 			 Reservas
	 *****************************************************************/
	public Reservas adicionarReserva(Long idAfiliadoTomador,long idAfiliadoReservador, long idHorario,String estado) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{

			tx.begin();
			long id = currReservas();
			long tuplasInsertadas = sqlReservas.adicionarReserva(pm, id, idAfiliadoTomador, idAfiliadoReservador, idHorario, estado);
			tx.commit();

			log.trace ("Inserción de la OrdenServicios: " + id+"--"+ idAfiliadoTomador + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Reservas(id, idAfiliadoTomador, idAfiliadoReservador, idHorario, estado,0);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	/* ****************************************************************
	 * 			 AFILIADO
	 *****************************************************************/

	public Afiliado adicionarAfiliado(long idEps, long idUsuario, Timestamp fechaNacimiento, String tipoDocumento, int hospitalizado,
			String numDocumento)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlAfiliado.adicionarAfiliado(pm, idEps, idUsuario,  fechaNacimiento,  tipoDocumento,  hospitalizado,
					numDocumento);
			tx.commit();

			log.trace ("Inserción del afiliado: " + idUsuario + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Afiliado(idEps, idUsuario, fechaNacimiento, tipoDocumento, hospitalizado, numDocumento);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/* ****************************************************************
	 * 			 RECEPCIONISTA
	 *****************************************************************/

	public Recepcionista adicionarRecepcionista(long idIps, long idUsuario)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlRecepcionista.adicionarRecepcionista(pm, idIps, idUsuario);
			tx.commit();

			log.trace ("Inserción del afiliado: " + idUsuario + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Recepcionista(idUsuario,idIps);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public Afiliado darAfiliado (long idAfiliado)
	{

		return sqlAfiliado.darAfiliadoPorId(pmf.getPersistenceManager(), idAfiliado);
	}

	public List<Afiliado> darAfiliados ()
	{
		return sqlAfiliado.darAfiliados(pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			 SERVICIO DE SALUD
	 *****************************************************************/

	public ServicioSalud adicionarServicioDeSalud(long idIps, String descripcion, String tipo, int orden)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlServicioSalud.adicionarServicioSalud(pm, descripcion, tipo, idIps, orden);
			tx.commit();

			log.trace ("Inserción del servicio de salud: " + tipo + ": " + tuplasInsertadas + " tuplas insertadas");

			return new ServicioSalud(idIps, descripcion, tipo, orden);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public ServicioSalud darServicioDeSalud (long idServicioDeSalud)
	{
		return sqlServicioSalud.darServicioSalud(pmf.getPersistenceManager(), idServicioDeSalud);
	}

	public List<ServicioSalud> darServiciosDeSalud ()
	{
		return sqlServicioSalud.darServiciosSalud(pmf.getPersistenceManager());
	}

	public ArrayList<ArrayList<String>> RF12DesabilitarServicios(ArrayList<Long> pArregloServicios, Timestamp pFecha1, Timestamp pFecha2) {

		ArrayList<ArrayList<String>> arreglo = new ArrayList<>();
		ArrayList<String> idsServiciosDesabilitados = new ArrayList<>();
		ArrayList<String> idsReservasNoMovidas = new ArrayList<>();
		ArrayList<String> idsReservasMovidas = new ArrayList<>();


		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{ 
			tx.begin();
			for (int i = 0; i < pArregloServicios.size(); i++) {

				sqlHorario.desabilitarServicio(pmf.getPersistenceManager(), pArregloServicios.get(i), pFecha1, pFecha2);
				idsServiciosDesabilitados.add(pArregloServicios.get(i)+"");
				log.trace ("Servicio desabilitado: "+pArregloServicios.get(i));

				List<Reservas> reservasInvalidas = sqlReservas.darReservasInvalidas(pmf.getPersistenceManager());
			
				for (int j = 0; j < reservasInvalidas.size(); j++) {

					Horario horario = sqlHorario.darHorario(pmf.getPersistenceManager(), reservasInvalidas.get(j).getIdHorario());

					ServicioSalud servicio = sqlServicioSalud.darServicioSalud(pm, horario.getIdServicio());

					List<ServicioSalud> serviciosEquivalentes = sqlServicioSalud
							.darServiciosSaludEquivalentes(pmf.getPersistenceManager(), servicio.getTipo());
					

					if(serviciosEquivalentes.size()==0){
						idsReservasNoMovidas.add(reservasInvalidas.get(j).getId()+"");
					}
					else{
						
						boolean termino = false;
						for (int k = 0; k < serviciosEquivalentes.size() && !termino; k++) {
							
							List<Horario> horarios = sqlHorario.darHorariosPorServicio(pm, serviciosEquivalentes.get(k).getId());
							if(horarios.size()==0){
								idsReservasNoMovidas.add(reservasInvalidas.get(j).getId()+"");
								termino = true;
							}
							else{
								
								sqlReservas.cambiarHorarioReserva(pm, horarios.get(0).getId(), reservasInvalidas.get(j).getId());
								sqlHorario.disminuirCapacidadHorario(pm, horarios.get(0).getId());
								idsReservasMovidas.add(reservasInvalidas.get(j).getId()+"");
								
							}

						}
					}

				}



			}
			tx.commit();

		}
		catch (Exception e)
		{
			System.out.println("error");
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}


		arreglo.add(idsServiciosDesabilitados);
		arreglo.add(idsReservasMovidas);
		arreglo.add(idsReservasNoMovidas);
		
		return arreglo;
	}

	public ArrayList<String> RF13HabilitarServicios(ArrayList<Long> pArregloServicios, Timestamp pFecha1, Timestamp pFecha2) {

		ArrayList<String> idsServiciosHabilitados = new ArrayList<>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			for (int i = 0; i < pArregloServicios.size(); i++) {

				sqlHorario.habilitarServicio(pmf.getPersistenceManager(), pArregloServicios.get(i), pFecha1, pFecha2);
				idsServiciosHabilitados.add(pArregloServicios.get(i)+"");
				log.trace ("Servicio Habilitado: "+pArregloServicios.get(i));
			}
			tx.commit();

		}
		catch (Exception e)
		{
			System.out.println("error");
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}


		return idsServiciosHabilitados;
	}


	public List<RFC1> RFC1CantidadServiciosIPS(Timestamp fecha1, Timestamp fecha2) {

	
		return sqlEpsAndes.RFC1(pmf.getPersistenceManager(), fecha1, fecha2);


	}
	

	public List<RFC2> RFC2Mostrar20ServiciosMasSolicitados(Timestamp fecha1, Timestamp fecha2) {
		
		return sqlEpsAndes.RFC2(pmf.getPersistenceManager(), fecha1, fecha2);
		
	}
	
	public List<RFC2> RFC3IndiceDeServicios() {
		return sqlEpsAndes.RFC3(pmf.getPersistenceManager());
	}
	
	public List<RFC4> RFC4ServiciosAsistidos() {
		return sqlEpsAndes.RFC4(pmf.getPersistenceManager());
	}
	public List<RFC5> RFC5ServiciosAfiliadoFechas(String fecha1, String fecha2, String idAfiliado) {
		return sqlEpsAndes.RFC5(pmf.getPersistenceManager(), fecha1, fecha2, idAfiliado);
	}
	public List<RFC7> RFC7AfiliadosExigentes(Timestamp fecha1, Timestamp fecha2) {
		return sqlEpsAndes.RFC7(pmf.getPersistenceManager(), fecha1, fecha2);
	}
	
	public List<RFC12A> RFC12AConsultarAfiliadosCostosos() {
		return sqlEpsAndes.RFC12A(pmf.getPersistenceManager());
	}
	
	public List<RFC12B> RFC12BConsultarAfiliadosCostosos() {
		return sqlEpsAndes.RFC12B(pmf.getPersistenceManager());
	}
	
	public List<RFC12C> RFC12CConsultarAfiliadosCostosos() {
		return sqlEpsAndes.RFC12C(pmf.getPersistenceManager());
	}
	
	public List<RFC11A> RFC11AConsultarFuncionamiento() {
		return sqlEpsAndes.RFC11A(pmf.getPersistenceManager());
	}
	
	public List<RFC11B> RFC11BConsultarFuncionamiento() {
		return sqlEpsAndes.RFC11B(pmf.getPersistenceManager());
	}
	public List<RFC11C> RFC11CConsultarFuncionamiento() {
		return sqlEpsAndes.RFC11C(pmf.getPersistenceManager());
	}
	
	public List darMayorDemanda(String tipoServicio, Timestamp fecha1, Timestamp fecha2, int cuantos) {
		System.out.println("2");
		return sqlRFC.darMayorDemanda(pmf.getPersistenceManager(), tipoServicio, fecha1, fecha2, cuantos);
	}
	
	public List<RFC6> darMayorActividad(String tipoServicio, Timestamp fecha1, Timestamp fecha2, int cuantos) {
		return sqlRFC.darMayorActividad(pmf.getPersistenceManager(), tipoServicio, fecha1, fecha2, cuantos);
	}
	
	public List<RFC6> darMenorDemanda(String tipoServicio, Timestamp fecha1, Timestamp fecha2, int cuantos) {
		return sqlRFC.darMenorDemanda(pmf.getPersistenceManager(), tipoServicio, fecha1, fecha2, cuantos);
	}
	
	public List<RFC9> darPrestacionServicios(Timestamp fecha1, Timestamp fecha2,String[] idIps,String[] tipo) {
		return sqlRFC.darPrestacionServicios(pmf.getPersistenceManager(), fecha1, fecha2, idIps,tipo);
	}
	
	public List<RFC10> darPrestacionNoServicios(Timestamp fecha1, Timestamp fecha2,String[] idIps,String[] tipo) {
		return sqlRFC.darPrestacionNoServicios(pmf.getPersistenceManager(), fecha1, fecha2, idIps,tipo);
	}


	/* ****************************************************************
	 * 				 ORDEN
	 *****************************************************************/

	public Orden adicionarOrden(long idAfiliado, long idMedico,String receta)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction(); 
		try
		{
			tx.begin();
			long id = currOrden();
			long tuplasInsertadas = sqlOrden.adicionarOrden(pm, id, idAfiliado, idMedico,receta);
			tx.commit();

			log.trace ("Inserción de la orden: " + receta + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Orden(receta,id,idAfiliado, idMedico);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public Orden darOrden (long idOrdenServicio)
	{
		return sqlOrden.darOrden(pmf.getPersistenceManager(), idOrdenServicio);
	}

	public List<Orden> darOrdenServicios ()
	{
		return sqlOrden.darOrdenes(pmf.getPersistenceManager());
	}




	/* ****************************************************************
	 * 			 EPS
	 *****************************************************************/

	public EpsAndes adicionarEPS(long pIdGerente)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long id = nextval();
			long tuplasInsertadas = sqlEpsAndes.adicionarEPS(pm, id, pIdGerente);

			tx.commit();

			log.trace ("Inserción de la eps: " + id +" con gerente "+pIdGerente + ": " + tuplasInsertadas + " tuplas insertadas");

			return new EpsAndes(pIdGerente);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	/* ****************************************************************
	 * 			HORARIO
	 *****************************************************************/

	public Horario adicionarHorario(long servicio, String hora, int disponibilidad, int capacidad, Timestamp fecha) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long id = currHorario();
			long tuplasInsertadas = sqlHorario.adicionarHorario(pm, capacidad , servicio,  hora, id,fecha,disponibilidad);
			tx.commit();

			log.trace ("Inserción del horario del servicio: "+ servicio+ " con capacidad "+ capacidad+", "+ tuplasInsertadas + " tuplas insertadas");

			return new Horario(id, servicio, hora,disponibilidad,capacidad,fecha);
		}
		catch (Exception e)
		{
			// 	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	public List<Horario> darHorariosPorServicio (long idServicio)
	{
		return sqlHorario.darHorariosPorServicio(pmf.getPersistenceManager(),idServicio);
	}

	public List darHorarioServicioFecha (Timestamp fechaInicio,Timestamp fechaFin,String tipoServicio)
	{
		return sqlHorario.darHorarioServicioFecha(pmf.getPersistenceManager(), fechaInicio, fechaFin, tipoServicio);
	}

	public Horario darHorario (long idHorario)
	{
		return sqlHorario.darHorario(pmf.getPersistenceManager(), idHorario);
	}


	public void aumentarCapacidadHorario(long idhorario) {
		// TODO Auto-generated method stub

		sqlHorario.aumentarCapacidadHorario(pmf.getPersistenceManager(), idhorario);

	}

	public void disminuirCapacidadHorario(long idhorario) {
		// TODO Auto-generated method stub
		sqlHorario.disminuirCapacidadHorario(pmf.getPersistenceManager(), idhorario);
	}
	/* ****************************************************************
	 * 			Métodos para manejar los TIPOS DE BEBIDA
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla TipoBebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public TipoBebida adicionarTipoBebida(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idTipoBebida = nextval ();
			long tuplasInsertadas = sqlTipoBebida.adicionarTipoBebida(pm, idTipoBebida, nombre);
			tx.commit();

			log.trace ("Inserción de tipo de bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new TipoBebida (idTipoBebida, nombre);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla TipoBebida, dado el nombre del tipo de bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarTipoBebidaPorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlTipoBebida.eliminarTipoBebidaPorNombre(pm, nombre);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla TipoBebida, dado el identificador del tipo de bebida
	 * Adiciona entradas al log de la aplicación
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarTipoBebidaPorId (long idTipoBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlTipoBebida.eliminarTipoBebidaPorId(pm, idTipoBebida);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}



	/**
	 * Método que consulta todas las tuplas en la tabla TipoBebida
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<TipoBebida> darTiposBebida ()
	{
		return sqlTipoBebida.darTiposBebida (pmf.getPersistenceManager());
	}

	/**
	 * Método que consulta todas las tuplas en la tabla TipoBebida que tienen el nombre dado
	 * @param nombre - El nombre del tipo de bebida
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<TipoBebida> darTipoBebidaPorNombre (String nombre)
	{
		return sqlTipoBebida.darTiposBebidaPorNombre (pmf.getPersistenceManager(), nombre);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla TipoBebida con un identificador dado
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return El objeto TipoBebida, construido con base en las tuplas de la tabla TIPOBEBIDA con el identificador dado
	 */
	public TipoBebida darTipoBebidaPorId (long idTipoBebida)
	{
		return sqlTipoBebida.darTipoBebidaPorId (pmf.getPersistenceManager(), idTipoBebida);
	}

	/* ****************************************************************
	 * 			Métodos para manejar las BEBIDAS
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre de la bebida
	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
	 * @return El objeto Bebida adicionado. null si ocurre alguna Excepción
	 */
	public Bebida adicionarBebida(String nombre, long idTipoBebida, int gradoAlcohol) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();            
			long idBebida = nextval ();
			long tuplasInsertadas = sqlBebida.adicionarBebida(pm, idBebida, nombre, idTipoBebida, gradoAlcohol);
			tx.commit();

			log.trace ("Inserción bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Bebida (idBebida,nombre, idTipoBebida, gradoAlcohol);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Bebida, dado el nombre de la bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombreBebida - El nombre de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebidaPorNombre (String nombreBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBebida.eliminarBebidaPorNombre(pm, nombreBebida);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Bebida, dado el identificador de la bebida
	 * Adiciona entradas al log de la aplicación
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebidaPorId (long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBebida.eliminarBebidaPorId (pm, idBebida);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla Bebida que tienen el nombre dado
	 * @param nombreBebida - El nombre de la bebida
	 * @return La lista de objetos Bebida, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Bebida> darBebidasPorNombre (String nombreBebida)
	{
		return sqlBebida.darBebidasPorNombre (pmf.getPersistenceManager(), nombreBebida);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla Bebida
	 * @return La lista de objetos Bebida, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Bebida> darBebidas ()
	{
		return sqlBebida.darBebidas (pmf.getPersistenceManager());
	}

	/**
	 * Método que elimina, de manera transaccional, las bebidas que no son referenciadas en la tabla SIRVEN de Parranderos
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebidasNoServidas ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBebida.eliminarBebidasNoServidas(pm);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/* ****************************************************************
	 * 			Métodos para manejar los BEBEDORES
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Bebedor adicionarBebedor(String nombre, String ciudad, String presupuesto) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idBebedor = nextval ();
			long tuplasInsertadas = sqlBebedor.adicionarBebedor(pmf.getPersistenceManager(), idBebedor, nombre, ciudad, presupuesto);
			tx.commit();

			log.trace ("Inserción de bebedor: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Bebedor (idBebedor, nombre, ciudad, presupuesto);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BEBEDOR, dado el nombre del bebedor
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebedorPorNombre(String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBebedor.eliminarBebedorPorNombre (pm, nombre);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BEBEDOR, dado el identificador del bebedor
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebedorPorId (long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBebedor.eliminarBebedorPorId (pm, idBebedor);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el nombre dado
	 * @param nombreBebedor - El nombre del bebedor
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Bebedor> darBebedoresPorNombre (String nombreBebedor) 
	{
		return sqlBebedor.darBebedoresPorNombre (pmf.getPersistenceManager(), nombreBebedor);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el identificador dado
	 * @param idBebedor - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en la tuplas de la tabla BEBEDOR, que tiene el identificador dado
	 */
	public Bebedor darBebedorPorId (long idBebedor) 
	{
		return (Bebedor) sqlBebedor.darBebedorPorId (pmf.getPersistenceManager(), idBebedor);
	}

	/**
	 * Método que consulta TODA LA INFORMACIÓN DE UN BEBEDOR con el identificador dado. Incluye la información básica del bebedor,
	 * las visitas realizadas y las bebidas que le gustan.
	 * @param idBebedor - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en las tuplas de la tablas BEBEDOR, VISITAN, BARES, GUSTAN, BEBIDAS y TIPOBEBIDA,
	 * relacionadas con el identificador de bebedor dado
	 */
	public Bebedor darBebedorCompleto (long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Bebedor bebedor = (Bebedor) sqlBebedor.darBebedorPorId (pm, idBebedor);
		bebedor.setVisitasRealizadas(armarVisitasBebedor (sqlBebedor.darVisitasRealizadas (pm, idBebedor)));
		bebedor.setBebidasQueLeGustan(armarGustanBebedor (sqlBebedor.darBebidasQueLeGustan (pm, idBebedor)));
		return bebedor;
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Bebedor> darBebedores ()
	{
		return sqlBebedor.darBebedores (pmf.getPersistenceManager());
	}

	/**
	 * Método que consulta los bebedores y el número de visitas que ha realizado
	 * @return La lista de parejas de objetos, construidos con base en las tuplas de la tabla BEBEDOR y VISITAN. 
	 * El primer elemento de la pareja es un bebedor; 
	 * el segundo elemento es el número de visitas de ese bebedor (0 en el caso que no haya realizado visitas)
	 */
	public List<Object []> darBebedoresYNumVisitasRealizadas ()
	{
		List<Object []> respuesta = new LinkedList <Object []> ();
		List<Object> tuplas = sqlBebedor.darBebedoresYNumVisitasRealizadas (pmf.getPersistenceManager());
		for ( Object tupla : tuplas)
		{
			Object [] datos = (Object []) tupla;
			long idBebedor = ((BigDecimal) datos [0]).longValue ();
			String nombreBebedor = (String) datos [1];
			String ciudadBebedor = (String) datos [2];
			String presupuesto = (String) datos [3];
			int numBares = ((BigDecimal) datos [4]).intValue ();

			Object [] resp = new Object [2];
			resp [0] = new Bebedor (idBebedor, nombreBebedor, ciudadBebedor, presupuesto);
			resp [1] = numBares;	

			respuesta.add(resp);
		}

		return respuesta;
	}

	/**
	 * Método que consulta CUÁNTOS BEBEDORES DE UNA CIUDAD VISITAN BARES
	 * @param ciudad - La ciudad que se quiere consultar
	 * @return El número de bebedores de la ciudad dada que son referenciados en VISITAN
	 */
	public long darCantidadBebedoresCiudadVisitanBares (String ciudad)
	{
		return sqlBebedor.darCantidadBebedoresCiudadVisitanBares (pmf.getPersistenceManager(), ciudad);
	}

	/**
	 * Método que actualiza, de manera transaccional, la ciudad de un  BEBEDOR
	 * @param idBebedor - El identificador del bebedor
	 * @param ciudad - La nueva ciudad del bebedor
	 * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
	 */
	public long cambiarCiudadBebedor (long idBebedor, String ciudad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBebedor.cambiarCiudadBebedor (pm, idBebedor, ciudad);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimima, de manera transaccional, un BEBEDOR y las VISITAS que ha realizado
	 * Si el bebedor está referenciado en alguna otra relación, no se borra ni el bebedor NI las visitas
	 * @param idBebedor - El identificador del bebedor
	 * @return Un arreglo de dos números que representan el número de bebedores eliminados y 
	 * el número de visitas eliminadas, respectivamente. [-1, -1] si ocurre alguna Excepción
	 */
	public long []  eliminarBebedorYVisitas_v1 (long idBebedor)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long [] resp = sqlBebedor.eliminarBebedorYVisitas_v1 (pm, idBebedor);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return new long[] {-1, -1};
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimima, de manera transaccional, un BEBEDOR y las VISITAS que ha realizado
	 * Si el bebedor está referenciado en alguna otra relación, no se puede borrar, SIN EMBARGO SÍ SE BORRAN TODAS SUS VISITAS
	 * @param idBebedor - El identificador del bebedor
	 * @return Un arreglo de dos números que representan el número de bebedores eliminados y 
	 * el número de visitas eliminadas, respectivamente. [-1, -1] si ocurre alguna Excepción
	 */
	public long [] eliminarBebedorYVisitas_v2 (long idBebedor)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long visitasEliminadas = eliminarVisitanPorIdBebedor(idBebedor);
			long bebedorEliminado = eliminarBebedorPorId (idBebedor);
			tx.commit();
			return new long [] {bebedorEliminado, visitasEliminadas};
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return new long [] {-1, -1};
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}	

	/**
	 * Método privado para generar las información completa de las visitas realizadas por un bebedor: 
	 * La información básica del bar visitado, la fecha y el horario, en el formato esperado por los objetos BEBEDOR
	 * @param tuplas - Una lista de arreglos de 7 objetos, con la información del bar y de la visita realizada, en el siguiente orden:
	 *   bar.id, bar.nombre, bar.ciudad, bar.presupuesto, bar.cantsedes, vis.fechavisita, vis.horario
	 * @return Una lista de arreglos de 3 objetos. El primero es un objeto BAR, el segundo corresponde a la fecha de la visita y
	 * el tercero corresponde al horaario de la visita
	 */
	private List<Object []> armarVisitasBebedor (List<Object []> tuplas)
	{
		List<Object []> visitas = new LinkedList <Object []> ();
		for (Object [] tupla : tuplas)
		{
			long idBar = ((BigDecimal) tupla [0]).longValue ();
			String nombreBar = (String) tupla [1];
			String ciudadBar = (String) tupla [2];
			String presupuestoBar = (String) tupla [3];
			int sedesBar = ((BigDecimal) tupla [4]).intValue ();
			Timestamp fechaVisita = (Timestamp) tupla [5];
			String horarioVisita = (String) tupla [6];

			Object [] visita = new Object [3];
			visita [0] = new Bar (idBar, nombreBar, ciudadBar, presupuestoBar, sedesBar);
			visita [1] = fechaVisita;
			visita [2] = horarioVisita;

			visitas.add (visita);
		}
		return visitas;
	}

	/**
	 * Método privado para generar las información completa de las bebidas que le gustan a un bebedor: 
	 * La información básica de la bebida, especificando también el nombre de la bebida, en el formato esperado por los objetos BEBEDOR
	 * @param tuplas - Una lista de arreglos de 5 objetos, con la información de la bebida y del tipo de bebida, en el siguiente orden:
	 * 	 beb.id, beb.nombre, beb.idtipobebida, beb.gradoalcohol, tipobebida.nombre
	 * @return Una lista de arreglos de 2 objetos. El primero es un objeto BEBIDA, el segundo corresponde al nombre del tipo de bebida
	 */
	private List<Object []> armarGustanBebedor (List<Object []> tuplas)
	{
		List<Object []> gustan = new LinkedList <Object []> ();
		for (Object [] tupla : tuplas)
		{			
			long idBebida = ((BigDecimal) tupla [0]).longValue ();
			String nombreBebida = (String) tupla [1];
			long idTipoBebida = ((BigDecimal) tupla [2]).longValue ();
			int gradoAlcohol = ((BigDecimal) tupla [3]).intValue ();
			String nombreTipo = (String) tupla [4];

			Object [] gusta = new Object [2];
			gusta [0] = new Bebida (idBebida, nombreBebida, idTipoBebida, gradoAlcohol);
			gusta [1] = nombreTipo;	

			gustan.add(gusta);
		}
		return gustan;
	}

	/* ****************************************************************
	 * 			Métodos para manejar los BARES
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BAR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param sedes - El número de sedes del bar en la ciudad (Mayor que 0)
	 * @return El objeto Bar adicionado. null si ocurre alguna Excepción
	 */
	public Bar adicionarBar(String nombre, String ciudad, String presupuesto, int sedes) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idBar = nextval ();
			long tuplasInsertadas = sqlBar.adicionarBar(pm, idBar, nombre, ciudad, presupuesto, sedes);
			tx.commit();

			log.trace ("Inserción de Bar: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Bar (idBar, nombre, ciudad, presupuesto, sedes);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BAR, dado el nombre del bar
	 * Adiciona entradas al log de la aplicación
	 * @param nombreBar - El nombre del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBarPorNombre (String nombreBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBar.eliminarBaresPorNombre(pm, nombreBar);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BAR, dado el identificador del bar
	 * Adiciona entradas al log de la aplicación
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBarPorId (long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBar.eliminarBarPorId (pm, idBar);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BAR
	 * @return La lista de objetos BAR, construidos con base en las tuplas de la tabla BAR
	 */
	public List<Bar> darBares ()
	{
		return sqlBar.darBares (pmf.getPersistenceManager());
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BAR que tienen el nombre dado
	 * @param nombreBar - El nombre del bar
	 * @return La lista de objetos BAR, construidos con base en las tuplas de la tabla BAR
	 */
	public List<Bar> darBaresPorNombre (String nombreBar)
	{
		return sqlBar.darBaresPorNombre (pmf.getPersistenceManager(), nombreBar);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BAR que tienen el identificador dado
	 * @param idBar - El identificador del bar
	 * @return El objeto BAR, construido con base en la tuplas de la tabla BAR, que tiene el identificador dado
	 */
	public Bar darBarPorId (long idBar)
	{
		return sqlBar.darBarPorId (pmf.getPersistenceManager(), idBar);
	}

	/**
	 * Método que actualiza, de manera transaccional, aumentando en 1 el número de sedes de todos los bares de una ciudad
	 * @param ciudad - La ciudad que se quiere modificar
	 * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
	 */
	public long aumentarSedesBaresCiudad (String ciudad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlBar.aumentarSedesBaresCiudad(pm, ciudad);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/* ****************************************************************
	 * 			Métodos para manejar la relación GUSTAN
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla GUSTAN
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor - Debe haber un bebedor con ese identificador
	 * @param idBebida - El identificador de la bebida - Debe haber una bebida con ese identificador
	 * @return Un objeto GUSTAN con la información dada. Null si ocurre alguna Excepción
	 */
	public Gustan adicionarGustan(long idBebedor, long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlGustan.adicionarGustan (pm, idBebedor, idBebida);
			tx.commit();

			log.trace ("Inserción de gustan: [" + idBebedor + ", " + idBebida + "]. " + tuplasInsertadas + " tuplas insertadas");

			return new Gustan (idBebedor, idBebida);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla GUSTAN, dados los identificadores de bebedor y bebida
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarGustan(long idBebedor, long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlGustan.eliminarGustan(pm, idBebedor, idBebida);           
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla GUSTAN
	 * @return La lista de objetos GUSTAN, construidos con base en las tuplas de la tabla GUSTAN
	 */
	public List<Gustan> darGustan ()
	{
		return sqlGustan.darGustan (pmf.getPersistenceManager());
	}


	/* ****************************************************************
	 * 			Métodos para manejar la relación SIRVEN
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla SIRVEN
	 * Adiciona entradas al log de la aplicación
	 * @param idBar - El identificador del bar - Debe haber un bar con ese identificador
	 * @param idBebida - El identificador de la bebida - Debe haber una bebida con ese identificador
	 * @param horario - El hororio en que se sirve (DIURNO, NOCTURNO, TODOS)
	 * @return Un objeto SIRVEN con la información dada. Null si ocurre alguna Excepción
	 */
	public Sirven adicionarSirven (long idBar, long idBebida, String horario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlSirven.adicionarSirven (pmf.getPersistenceManager(), idBar, idBebida, horario);
			tx.commit();

			log.trace ("Inserción de gustan: [" + idBar + ", " + idBebida + "]. " + tuplasInsertadas + " tuplas insertadas");

			return new Sirven (idBar, idBebida, horario);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla SIRVEN, dados los identificadores de bar y bebida
	 * @param idBar - El identificador del bar
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarSirven (long idBar, long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlSirven.eliminarSirven (pm, idBar, idBebida);	            
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla SIRVEN
	 * @return La lista de objetos SIRVEN, construidos con base en las tuplas de la tabla SIRVEN
	 */
	public List<Sirven> darSirven ()
	{
		return sqlSirven.darSirven (pmf.getPersistenceManager());
	}

	/**
	 * Método que encuentra el identificador de los bares y cuántas bebidas sirve cada uno de ellos. Si una bebida se sirve en diferentes horarios,
	 * cuenta múltiples veces
	 * @return Una lista de arreglos de 2 números. El primero corresponde al identificador del bar, el segundo corresponde al nombre del tipo de bebida
	 */
	public List<long []> darBaresYCantidadBebidasSirven ()
	{
		List<long []> resp = new LinkedList<long []> ();
		List<Object []> tuplas =  sqlSirven.darBaresYCantidadBebidasSirven (pmf.getPersistenceManager());
		for ( Object [] tupla : tuplas)
		{
			long [] datosResp = new long [2];

			datosResp [0] = ((BigDecimal) tupla [0]).longValue ();
			datosResp [1] = ((BigDecimal) tupla [1]).longValue ();
			resp.add (datosResp);
		}
		return resp;
	}

	/* ****************************************************************
	 * 			Métodos para manejar la relación VISITAN
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla VISITAN
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor - Debe haber un bebedor con ese identificador
	 * @param idBar - El identificador del bar - Debe haber un bar con ese identificador
	 * @param fecha - La fecha en que se realizó la visita
	 * @param horario - El hororio en que se sirve (DIURNO, NOCTURNO, TODOS)
	 * @return Un objeto VISITAN con la información dada. Null si ocurre alguna Excepción
	 */	
	public Visitan adicionarVisitan (long idBebedor, long idBar, Timestamp fecha, String horario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlVisitan.adicionarVisitan(pm, idBebedor, idBar, fecha, horario);
			tx.commit();

			log.trace ("Inserción de gustan: [" + idBebedor + ", " + idBar + "]. " + tuplasInsertadas + " tuplas insertadas");

			return new Visitan (idBebedor, idBar, fecha, horario);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados los identificadores de bebedor y bar
	 * @param idBebedor - El identificador del bebedor
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarVisitan (long idBebedor, long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlVisitan.eliminarVisitan(pm, idBebedor, idBar);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados el identificador del bebedor
	 * @param idBebedor - El identificador del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarVisitanPorIdBebedor (long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long visitasEliminadas = sqlVisitan.eliminarVisitanPorIdBebedor (pm, idBebedor);
			tx.commit();

			return visitasEliminadas;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados el identificador del bar
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarVisitanPorIdBar (long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long visitasEliminadas = sqlVisitan.eliminarVisitanPorIdBar (pm, idBar);
			tx.commit();

			return visitasEliminadas;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla VISITAN
	 * @return La lista de objetos VISITAN, construidos con base en las tuplas de la tabla VISITAN
	 */
	public List<Visitan> darVisitan ()
	{
		return sqlVisitan.darVisitan (pmf.getPersistenceManager());
	}	

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarParranderos ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long [] resp = sqlUtil.limpiarParranderos (pm);
			tx.commit ();
			log.info ("Borrada la base de datos");
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return new long[] {-1, -1, -1, -1, -1, -1, -1};
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}

	}

	



	

	



	



	
















}
