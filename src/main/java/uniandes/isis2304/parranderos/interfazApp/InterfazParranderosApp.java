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

package uniandes.isis2304.parranderos.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.parranderos.negocio.Parranderos;
import uniandes.isis2304.parranderos.negocio.VOEpsAndes;
import uniandes.isis2304.parranderos.negocio.VOHorario;
import uniandes.isis2304.parranderos.negocio.VOIps;
import uniandes.isis2304.parranderos.negocio.VOMedico;
import uniandes.isis2304.parranderos.negocio.VOMedicoEspecialista;
import uniandes.isis2304.parranderos.negocio.VOMedicoGeneral;
import uniandes.isis2304.parranderos.negocio.VOMedicoServicio;
import uniandes.isis2304.parranderos.negocio.VOMedicoTratante;
import uniandes.isis2304.parranderos.negocio.VOOrden;
import uniandes.isis2304.parranderos.negocio.VOOrdenesServicios;
import uniandes.isis2304.parranderos.negocio.VORecepcionista;
import uniandes.isis2304.parranderos.negocio.VOReservas;
import uniandes.isis2304.parranderos.negocio.VOAfiliado;
import uniandes.isis2304.parranderos.negocio.VORol;
import uniandes.isis2304.parranderos.negocio.VOServicioSalud;
import uniandes.isis2304.parranderos.negocio.VOTipoBebida;
import uniandes.isis2304.parranderos.negocio.VOUsuario;

/**
 * Clase principal de la interfaz
 * @author Germán Bravo
 */
@SuppressWarnings("serial")

public class InterfazParranderosApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());

	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 

	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
	 */
	private JsonObject tableConfig;

	/**
	 * Asociación a la clase principal del negocio.
	 */
	private Parranderos parranderos;

	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
	/**
	 * Objeto JSON con la configuración de interfaz de la app.
	 */
	private JsonObject guiConfig;

	/**
	 * Panel de despliegue de interacción para los requerimientos
	 */
	private PanelDatos panelDatos;

	/**
	 * Menú de la aplicación
	 */
	private JMenuBar menuBar;

	/**
	 * Frames de la accion
	 */
	private JFrame frame;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Construye la ventana principal de la aplicación. <br>
	 * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
	 */
	public InterfazParranderosApp( )
	{
		// Carga la configuración de la interfaz desde un archivo JSON
		guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);

		// Configura la apariencia del frame que contiene la interfaz gráfica
		configurarFrame ( );
		if (guiConfig != null) 	   
		{
			crearMenu( guiConfig.getAsJsonArray("menuBar") );
		}

		tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
		parranderos = new Parranderos (tableConfig);

		String path = guiConfig.get("bannerPath").getAsString();
		panelDatos = new PanelDatos ( );

		setLayout (new BorderLayout());
		add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
		add( panelDatos, BorderLayout.CENTER );        
	}

	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
	/**
	 * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
	 * @param tipo - El tipo de configuración deseada
	 * @param archConfig - Archivo Json que contiene la configuración
	 * @return Un objeto JSON con la configuración del tipo especificado
	 * 			NULL si hay un error en el archivo.
	 */
	private JsonObject openConfig (String tipo, String archConfig)
	{
		JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
			//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
		return config;
	}

	/**
	 * Método para configurar el frame principal de la aplicación
	 */
	private void configurarFrame(  )
	{
		int alto = 0;
		int ancho = 0;
		String titulo = "";	

		if ( guiConfig == null )
		{
			log.info ( "Se aplica configuración por defecto" );			
			titulo = "Parranderos APP Default";
			alto = 300;
			ancho = 500;
		}
		else
		{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
			titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
		}

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocation (50,50);
		setResizable( true );
		setBackground( Color.WHITE );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocation (50,50);
		setResizable( true );
		setBackground( Color.BLUE );

		setTitle( titulo );
		setSize ( ancho, alto);        
	}

	/**
	 * Método para crear el menú de la aplicación con base em el objeto JSON leído
	 * Genera una barra de menú y los menús con sus respectivas opciones
	 * @param jsonMenu - Arreglo Json con los menùs deseados
	 */
	private void crearMenu(  JsonArray jsonMenu )
	{    	
		// Creación de la barra de menús
		menuBar = new JMenuBar();       
		for (JsonElement men : jsonMenu)
		{
			// Creación de cada uno de los menús
			JsonObject jom = men.getAsJsonObject(); 

			String menuTitle = jom.get("menuTitle").getAsString();        	
			JsonArray opciones = jom.getAsJsonArray("options");

			JMenu menu = new JMenu( menuTitle);

			for (JsonElement op : opciones)
			{       	
				// Creación de cada una de las opciones del menú
				JsonObject jo = op.getAsJsonObject(); 
				String lb =   jo.get("label").getAsString();
				String event = jo.get("event").getAsString();

				JMenuItem mItem = new JMenuItem( lb );
				mItem.addActionListener( this );
				mItem.setActionCommand(event);

				menu.add(mItem);
			}       
			menuBar.add( menu );
		}        
		setJMenuBar ( menuBar );	
	}

	/* ****************************************************************
	 * 			 CRUD de ROL
	 *****************************************************************/




	/**
	 * Adiciona un tipo de bebida con la información dada por el usuario
	 * Se crea una nueva tupla de tipoBebida en la base de datos, si un tipo de bebida con ese nombre no existía
	 */
	public void adicionarRol(String nombre)
	{
		try 
		{
			//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del rol?", "Adicionar rol", JOptionPane.QUESTION_MESSAGE);

			if (nombre != null)
			{
				VORol tb = parranderos.adicionarRol (nombre);
				if (tb == null)
				{
					throw new Exception ("No se pudo crear un rol con nombre: " + nombre);
				}
				String resultado = "En adicionarRol\n\n";
				resultado += "Rol adicionado exitosamente: " + tb;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	public void adicionarRolDialog() {

		// Definiendo elementos necesarios para la construccion del panel

		JPanel panel;
		JTextField rolField = new JTextField();
		panel = new JPanel();

		// 0 filas/ 2columnas/ espacio de 2 entre filas/ espacio de 2 entre columnas
		panel.setLayout(new GridLayout(0, 2, 2, 2));

		// Aca creo dos variable 
		String nombreRol;

		// Aca pongo los dos labels de añadir el nombre del rol        
		panel.add(new JLabel("Nombre del rol?"));
		panel.add(rolField); 

		int option = JOptionPane.showConfirmDialog(frame, panel, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (option == JOptionPane.YES_OPTION) {

			// Aca saco el valor del rol
			String nombreRolInput = rolField.getText();

			adicionarRol(nombreRolInput);

			try {

				// Aqui obtengo el input del nombre del rol
				nombreRol = nombreRolInput;             	

				panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

				panel.add(new JLabel("Nombre del rol: " + nombreRol));


			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, panel);
		}
	}


	///// cierre probando

	/**
	 * Adiciona un tipo de bebida con la información dada por el usuario
	 * Se crea una nueva tupla de tipoBebida en la base de datos, si un tipo de bebida con ese nombre no existía
	 */

	/* ****************************************************************
	 * 			 CRUD de USUARIO
	 *****************************************************************/
	public void adicionarUsuario(String nombre,String correo,String strRol)
	{
		try 
		{

			long idRol = Long.valueOf(strRol);
			if (nombre != null)
			{
				VOUsuario u = parranderos.adicionarUsuario(nombre, correo, idRol);
				if (u == null){
					throw new Exception ("No se pudo crear un usuario con nombre: "+ nombre+"\n"+"correo:"+correo+"\n"+"id"+idRol);
				}

				String resultado = "En adicionarRol\n\n";
				resultado += "Usuario adicionado exitosamente: " + u;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void adicionarUsuarioDialog() {

		// Definiendo elementos necesarios para la construccion del panel

		JPanel panel;
		JTextField nombreField = new JTextField();
		JTextField correoField = new JTextField();
		JTextField rolField = new JTextField();
		panel = new JPanel();

		// 0 filas/ 2columnas/ espacio de 2 entre filas/ espacio de 2 entre columnas
		panel.setLayout(new GridLayout(0, 2, 2, 2));

		// Aca creo dos variable 
		String nombreUsuario;
		String correoUsuario;
		String rolUsuario;

		// Aca pongo los dos labels de añadir el nombre del rol        
		panel.add(new JLabel("Nombre del Usuario?"));
		panel.add(nombreField); 

		panel.add(new JLabel("Correo del Usuario?"));
		panel.add(correoField); 

		panel.add(new JLabel("Rol del Usuario?"));
		panel.add(rolField); 

		int option = JOptionPane.showConfirmDialog(frame, panel, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (option == JOptionPane.YES_OPTION) {

			// Aca saco el valor del rol
			String nombreUsuarioInput = nombreField.getText();
			String correoUsuarioInput = correoField.getText();
			String rolUsuarioInput = rolField.getText();
			adicionarUsuario(nombreUsuarioInput, correoUsuarioInput, rolUsuarioInput);

			try {

				// Aqui obtengo el input del nombre del rol
				nombreUsuario = nombreUsuarioInput;
				correoUsuario = correoUsuarioInput;
				rolUsuario = rolUsuarioInput;


				panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

				panel.add(new JLabel("Nombre del Usuario: " + nombreUsuario ));


			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, panel);
		}
	}
	/* ****************************************************************
	 * 			 CRUD de RECEPCIONISTA
	 *****************************************************************/


	public void adicionarRecepcionista()
	{
		try 
		{
			String nombre = JOptionPane.showInputDialog (this, "Nombre del recepcionista?", "adicionarUsuario", JOptionPane.QUESTION_MESSAGE);
			String correo = JOptionPane.showInputDialog (this, "Correo del recepcionista?", "adicionarUsuario", JOptionPane.QUESTION_MESSAGE);
			String strRol = JOptionPane.showInputDialog (this, "idRol del recepcionista?", "adicionarUsuario", JOptionPane.QUESTION_MESSAGE);

			long idRol = Long.valueOf(strRol);
			if (nombre != null)
			{
				VOUsuario u = parranderos.adicionarUsuario(nombre, correo, idRol);
				if (u == null){
					throw new Exception ("No se pudo crear un usuario con nombre: "+ nombre+"\n"+"correo:"+correo+"\n"+"id"+idRol);
				}
				String strIdIps = JOptionPane.showInputDialog (this, "id IPS?", "adicionarRecepcionista", JOptionPane.QUESTION_MESSAGE);
				long idIps = Long.valueOf(strIdIps);
				long idUsuario = u.getId()+1;
				VORecepcionista af = parranderos.adicionarRecepcionista(idUsuario,idIps);

				if(af == null) {
					throw new Exception ("No se pudo crear un recepcionista con id: " + idUsuario+"\n" + "idIps: "+ idIps);
				}

				String resultado = "En adicionarRol\n\n";
				resultado += "Recepcionista adicionado exitosamente: " + u + af;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/* ****************************************************************
	 * 			 CRUD de Administrador y de gerente
	 *****************************************************************/


	public void adicionarAdministradorOGerente( )
	{
		try 
		{
			String nombre = JOptionPane.showInputDialog (this, "Nombre del Administrador o Gerente?", "adicionarAdministradorOGerente", JOptionPane.QUESTION_MESSAGE);
			String correo = JOptionPane.showInputDialog (this, "Correo del Administrador o Gerente?", "adicionarAdministradorOGerente", JOptionPane.QUESTION_MESSAGE);
			String strRol = JOptionPane.showInputDialog (this, "idRol del Administrador o Gerente?", "adicionarAdministradorOGerente", JOptionPane.QUESTION_MESSAGE);

			long idRol = Long.valueOf(strRol);
			if (nombre != null)
			{
				VOUsuario u = parranderos.adicionarUsuario(nombre, correo, idRol);
				if (u == null){
					throw new Exception ("No se pudo crear un usuario con nombre: "+ nombre+"\n"+"correo:"+correo+"\n"+"id"+idRol);
				}

				String resultado = "En adicionarRol\n\n";
				resultado += "usuario adicionado exitosamente: " + u ;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/* ****************************************************************
	 * 			 CRUD de AFILIADO
	 *****************************************************************/


	public void adicionarAfiliado( )
	{
		try 
		{
			String nombre = JOptionPane.showInputDialog (this, "Nombre del Afiliado?", "adicionarUsuario", JOptionPane.QUESTION_MESSAGE);
			String correo = JOptionPane.showInputDialog (this, "Correo del Afiliado?", "adicionarUsuario", JOptionPane.QUESTION_MESSAGE);
			String strRol = JOptionPane.showInputDialog (this, "idRol del Afiliado?", "adicionarUsuario", JOptionPane.QUESTION_MESSAGE);

			long idRol = Long.valueOf(strRol);
			if (nombre != null)
			{
				VOUsuario u = parranderos.adicionarUsuario(nombre, correo, idRol);
				if (u == null){
					throw new Exception ("No se pudo crear un usuario con nombre: "+ nombre+"\n"+"correo:"+correo+"\n"+"id"+idRol);
				}

				String strIdEps = JOptionPane.showInputDialog (this, "id EPS?", "adicionarAfiliado", JOptionPane.QUESTION_MESSAGE);
				String datefechaNacimiento = JOptionPane.showInputDialog (this, "fecha de Nacimiento?", "adicionarAfiliado", JOptionPane.QUESTION_MESSAGE);
				String strTipoDocumento = JOptionPane.showInputDialog (this, "Tipo de documento?", "adicionarAfiliado", JOptionPane.QUESTION_MESSAGE);
				String intHospitalizado = JOptionPane.showInputDialog (this, "hospitalizado?", "adicionarAfiliado", JOptionPane.QUESTION_MESSAGE);
				String strNumDocumento = JOptionPane.showInputDialog (this, "numero de documento?", "adicionarAfiliado", JOptionPane.QUESTION_MESSAGE);


				Timestamp fechaNacimiento = Timestamp.valueOf(datefechaNacimiento);
				int hospitalizado = Integer.valueOf(intHospitalizado);
				long idEps = Long.valueOf(strIdEps);

				long idUsuario = u.getId()-1;
				VOAfiliado af = parranderos.adicionarAfiliado(idEps, idUsuario,fechaNacimiento,strTipoDocumento, hospitalizado, strNumDocumento);

				if(af == null) {
					throw new Exception ("No se pudo crear un afiliado con id: " + idUsuario+"\n"+"fechaNacimiento: "+fechaNacimiento+"\n"
							+"hospitalizado: "+hospitalizado+"\n"+"TipoDocumento"+strTipoDocumento+"\n"+"numDocumento: " +strNumDocumento);
				}

				String resultado = "En adicionarRol\n\n";


				resultado += "Afiliado adicionado exitosamente: " + u + af;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/* ****************************************************************
	 * 			 CRUD de Medico
	 *****************************************************************/

	public void adicionarMedico( )
	{
		try 
		{

			String numeroRegistro = JOptionPane.showInputDialog (this, "Numero de registro?", "adicionarMedico", JOptionPane.QUESTION_MESSAGE);
			String especialidad = JOptionPane.showInputDialog (this, "Especialidad?", "adicionarMedico", JOptionPane.QUESTION_MESSAGE);
			String identificacion = JOptionPane.showInputDialog (this, "Identificacion?"+"Ingrese letras", "adicionarMedico", JOptionPane.QUESTION_MESSAGE);
			String nombre = JOptionPane.showInputDialog (this, "Nombre?", "adicionarMedico", JOptionPane.QUESTION_MESSAGE);
			String correo = JOptionPane.showInputDialog (this, "Correo", "adicionarMedico", JOptionPane.QUESTION_MESSAGE);
			String idRol = JOptionPane.showInputDialog (this, "idRol?", "adicionarMedico", JOptionPane.QUESTION_MESSAGE);


			String strTipoMedico = JOptionPane.showInputDialog (this, "Tipo de medico:" + "\n"+ "Ingrese un numero"+ "\n"+  "Especialista = 1 "+ "\n"+  "General = 2" +"\n" 
					+"Tratante = 3", "adicionarMedico", JOptionPane.QUESTION_MESSAGE);


			int NumeroRegistro = Integer.valueOf(numeroRegistro);
			long IdRol = Long.valueOf(idRol);
			long tipoMedico = Long.valueOf(strTipoMedico);



			if (nombre != null)
			{
				VOMedico m = parranderos.adicionarMedico(IdRol,NumeroRegistro, especialidad, identificacion, nombre, correo);
				long id = m.getId()+1;

				if (m == null)
				{
					throw new Exception ("No se pudo crear un medico con nombre: " + m+ nombre+"\n"+"correo:"+correo+"\n"+"id"+idRol);
				}
				if(tipoMedico==1) {
					parranderos.adicionarMedicoEspecialista(id);
				}
				else if(tipoMedico==2) {
					parranderos.adicionarMedicoGeneral(id);
				}
				else if(tipoMedico==3) {
					parranderos.adicionarMedicoTratante(id);
				}
				else
				{
					throw new Exception ("No se pudo crear un medico de tipo: " + tipoMedico);
				}
				String resultado = "En adicionMedico\n\n";
				resultado += "Medico adicionado exitosamente: " + m;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/* ****************************************************************
	 * 			 CRUD de EPS
	 *****************************************************************/


	public void adicionarEPS( )

	{


		try 
		{
			String idGerente = JOptionPane.showInputDialog (this, "id del gerente?", "adicionarEPS", JOptionPane.QUESTION_MESSAGE);	

			long IdGerente = Long.valueOf(idGerente);
			if (idGerente != null)
			{
				VOEpsAndes tb = parranderos.adicionarEps(IdGerente);
				if (tb == null)
				{
					throw new Exception ("No se pudo crear la eps: " + tb+ "con gerente "+IdGerente);
				}
				String resultado = "En adicionMedico\n\n";
				resultado += "EPS adicionada exitosamente: " + tb;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/* ****************************************************************
	 * 			 CRUD de IPS
	 *****************************************************************/


	public void adicionarIPS( )

	{


		try 
		{
			String ubicacion = JOptionPane.showInputDialog (this, "Ubicacion?", "adicionarIPS", JOptionPane.QUESTION_MESSAGE);
			String nombre = JOptionPane.showInputDialog (this, "Nombre?", "adicionarIPS", JOptionPane.QUESTION_MESSAGE);
			String tipo = JOptionPane.showInputDialog (this, "Tipo?", "adicionarIPS", JOptionPane.QUESTION_MESSAGE);
			String capacidad = JOptionPane.showInputDialog (this, "Capacidad?", "adicionarIPS", JOptionPane.QUESTION_MESSAGE);
			String idEps = JOptionPane.showInputDialog (this, "idEps", "adicionarIPS", JOptionPane.QUESTION_MESSAGE);


			int Capacidad = Integer.valueOf(capacidad);
			long IdEPS = Long.valueOf(idEps);


			if (nombre != null)
			{
				VOIps tb = parranderos.adicionarIps(ubicacion, nombre, tipo, Capacidad, IdEPS);
				if (tb == null)
				{
					throw new Exception ("No se pudo crear la ips: " + tb+ "con eps "+IdEPS);
				}
				String resultado = "En adicionIps\n\n";
				resultado += "Ips adicionado exitosamente: " + tb;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//  			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/* ****************************************************************
	 * 			 CRUD de Servicio de Salud
	 *****************************************************************/

	public void registrarServicioSalud( )

	{

		try 
		{

			String descripcion = JOptionPane.showInputDialog (this, "Descripcion?", "Resgistrar Servicio de Salud", JOptionPane.QUESTION_MESSAGE);
			String tipo = JOptionPane.showInputDialog (this, "Tipo?", "Resgistrar Servicio de Salud", JOptionPane.QUESTION_MESSAGE);
			String idIps = JOptionPane.showInputDialog (this, "idIps?", "Resgistrar Servicio de Salud", JOptionPane.QUESTION_MESSAGE);
			String orden = JOptionPane.showInputDialog (this, "Necesita orden de servicio? 0 o 1", "Resgistrar Servicio de Salud", JOptionPane.QUESTION_MESSAGE);
			String medico = JOptionPane.showInputDialog (this, "ID del Medico?", "Resgistrar Servicio de Salud", JOptionPane.QUESTION_MESSAGE);


			int Orden = Integer.valueOf(orden);
			long IdIps = Long.valueOf(idIps);
			long Medico = Long.valueOf(medico);


			if (descripcion != null)

			{
				VOServicioSalud ss = parranderos.adicionarServicioDeSalud(IdIps, descripcion, tipo, Orden);
				VOMedicoServicio ms = parranderos.adicionarMedicoServicio(Medico);
				if (ss == null || ms == null)
				{
					throw new Exception ("No se pudo crear el servicio de salud: " + ss+ ".\ncon \ndescripcion: "+descripcion
							+".\ntipo: "+tipo
							+".\nIdIps: "+idIps
							+".\norden: "+orden
							+".\nmedico: "+medico
							);
				}
				String resultado = "En adicionServicioSalud\n\n";
				resultado += "Servicio de salud adicionado exitosamente: " + ss;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//  			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/**
	 * Consulta en la base de datos los tipos de bebida existentes y los muestra en el panel de datos de la aplicación
	 */
	public void listarServicio( )
	{
		try 
		{
			List <VOServicioSalud> lista = parranderos.darVOServiciosDeSalud();

			String resultado = "En listarServicios";
			resultado +=  "\n" + listarServicios (lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	/**
	 * Consulta en la base de datos el atributo orden de un servicio de salud.
	 */
	public boolean hayOrdenServicioDeSalud(long idservicio)
	{
		boolean hay = false;

		VOServicioSalud servicio = parranderos.darVOServicioDeSalud(idservicio);

		if(servicio.getOrden()==0){
			return hay;
		}
		else{
			hay = true;
		}
		return hay;


	}
	public boolean hayCapacidadHorario(long idhorario)
	{
		boolean hay = false;

		VOHorario horario = parranderos.darHorario(idhorario);

		if(horario.getCapacidad()<=0 && horario.getDisponibilidad()==1){

			return hay;

		}
		else{
			hay = true;
		}
		return hay;


	}

	/**
	 * Consulta en la base de datos si hay un servicio de salud en la orden
	 * y que el servicio no se haya realizado
	 */
	public boolean existeServicioEnOrden( long idservicio, long idorden)
	{
		boolean existe = false;

		List <VOOrdenesServicios> listaOrdenes = parranderos.darVOOrdenesServiciosId(idorden);

		for(int i = 0; i<listaOrdenes.size();i++){
			if(listaOrdenes.get(i).getIdServicio()==idservicio){
				if(listaOrdenes.get(i).getRealizado()==0){
					existe = true;
				}
			}
		}

		return existe;



	}

	/* ****************************************************************
	 * 			 CRUD de Orden de servicio
	 *****************************************************************/

	public void adicionarOrdenDeServicio( )

	{

		ArrayList<Long> servicios = new ArrayList<Long>();

		try 
		{
			String idAfiliado = JOptionPane.showInputDialog (this, "id Afiliado?", "adicionarOrdenDeServicio", JOptionPane.QUESTION_MESSAGE);
			String idMedico = JOptionPane.showInputDialog (this, "id Medico?", "adicionarOrdenDeServicio", JOptionPane.QUESTION_MESSAGE);
			String receta = JOptionPane.showInputDialog (this, "Receta?", "adicionarOrdenDeServicio", JOptionPane.QUESTION_MESSAGE);

			boolean servicio = true;
			while(servicio){
				int g =  JOptionPane.showConfirmDialog(null, "Agregar servicio de salud a la orden?", "adicionarOrdenDeServicio?", JOptionPane.YES_NO_OPTION);
				if(g!=0){
					servicio = false;
				}
				else{
					String idServicio = JOptionPane.showInputDialog (this, "Id del servicio?", "adicionarOrdenDeServicio", JOptionPane.QUESTION_MESSAGE);
					long IdServicio = Long.valueOf(idServicio);
					servicios.add(IdServicio);

				}

			}

			long IdAfiliado = Long.valueOf(idAfiliado);
			long IdMedico = Long.valueOf(idMedico);

			if (receta != null)
			{
				VOOrden os = parranderos.adicionarOrdenServicio(receta, IdAfiliado, IdMedico);
				System.out.println(os.getId());
				System.out.println(os.getIdAfiliado());
				System.out.println(os.getIdMedico());
				System.out.println(servicios.get(0));
				if (os == null)
				{
					throw new Exception ("No se pudo crear la orden de servicio: " + os+ "con receta "+receta);
					
				}
				for(int i = 0; i<servicios.size();i++){
					VOOrdenesServicios oss = parranderos.adicionarOrdenesServicios(servicios.get(i),os.getId() ,0 );
					if (oss == null)
					{
						throw new Exception ("No se pudo crear un servicio asociado: " + os+ "id "+servicios.get(i));
					}
				}


				String resultado = "En adicionOrdenServicio\n\n";
				resultado += "Orden servicio adicionada exitosamente: " + os;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//  			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/* ****************************************************************
	 * 			 CRUD de Reserva
	 *****************************************************************/

	public void adicionarReserva( )

	{


		try 
		{
			String idAfiliadoReservador = JOptionPane.showInputDialog (this, "id Afiliado Reservador?", "Reservar", JOptionPane.QUESTION_MESSAGE);
			String idAfiliadoTomador = JOptionPane.showInputDialog (this, "id Afiliado Tomador?", "Reservar", JOptionPane.QUESTION_MESSAGE);
			String idServicioSalud = JOptionPane.showInputDialog (this, "id Servicio de Salud?", "Reservar", JOptionPane.QUESTION_MESSAGE);
			String idHorario = JOptionPane.showInputDialog (this, "Hora?", "Horario", JOptionPane.QUESTION_MESSAGE);
			String estado = JOptionPane.showInputDialog (this, "Estado?", "Estado", JOptionPane.QUESTION_MESSAGE);
			
			long IdAfiliadoReservador = Long.valueOf(idAfiliadoReservador);
			long IdAfiliadoTomador = Long.valueOf(idAfiliadoTomador);
			long IdServicioSalud = Long.valueOf(idAfiliadoTomador);
			long IdHorario = Long.valueOf(idHorario);
			
			
			boolean cumple = false;

			if (hayOrdenServicioDeSalud(IdServicioSalud)){
				String idOrden = JOptionPane.showInputDialog (this, "Orden?", "Reservar", JOptionPane.QUESTION_MESSAGE);
				long IdOrden = Long.valueOf(idOrden);
				if(existeServicioEnOrden(IdServicioSalud, IdOrden)){
					if(hayCapacidadHorario(IdHorario)){
						
						cumple = true;
						
					}
				}
			}
			else{
				if(hayCapacidadHorario(IdHorario)){
					
					cumple = true;
					
				}
			}
			
			if(cumple){
				VOReservas r = parranderos.adicionarReserva(IdAfiliadoReservador, IdAfiliadoTomador, IdServicioSalud, estado );

				if (r == null)
				{
					throw new Exception ("No se pudo realizar la reserva: " + r
							+".\nidAfiliadoReservador: "+idAfiliadoReservador
							+".\nidAfiliadoTomador: "+idAfiliadoTomador
							+".\nidServicioSalud: "+idServicioSalud
							+".\nestado: "+estado
							);
				}
				String resultado = "En adicionReserva\n\n";
				resultado += "Reserva adicionada exitosamente: " + r;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}

			
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}




	/* ****************************************************************
	 * 			 CRUD de Horario
	 *****************************************************************/


	      public void adicionarHorario( )
	      
	      {
	      	
	      	try 
	      	{
	      		String lngIdServicio = JOptionPane.showInputDialog (this, "ID del servicio?", "adicionarHorario", JOptionPane.QUESTION_MESSAGE);
	      		String intCapacidad = JOptionPane.showInputDialog (this, "Capacidad?", "adicionarHorario", JOptionPane.QUESTION_MESSAGE);	
	      			
	      		String timeFecha = JOptionPane.showInputDialog (this, "Fecha?", "adicionarHorario", JOptionPane.QUESTION_MESSAGE);	
	      		String hora = JOptionPane.showInputDialog (this, "Hora?", "adicionarHorario", JOptionPane.QUESTION_MESSAGE);
	      		String intDisponibilidad = JOptionPane.showInputDialog (this, "Disponibilidad?", "adicionarHorario", JOptionPane.QUESTION_MESSAGE);	
	      		
	      		
	      		
	      		
	      		int capacidad = Integer.valueOf(intCapacidad);
	      		long idServicio = Long.valueOf(lngIdServicio);
	      		Timestamp fecha = Timestamp.valueOf(timeFecha);
	      		int disponibilidad = Integer.valueOf(intDisponibilidad);
	      		
	      		if (idServicio != 0)
	      		{
	          		VOHorario tb = parranderos.adicionarHorario(idServicio, hora, disponibilidad, capacidad, fecha);
	          		if (tb == null)
	          		{
	          			throw new Exception ("No se pudo crear el horario: " + tb+ "con capacidad "+capacidad + " y servicio "+idServicio);
	          		}
	          		String resultado = "En adicionHorario\n\n";
	          		resultado += "Horario adicionado exitosamente: " + tb;
	      			resultado += "\n Operación terminada";
	      			panelDatos.actualizarInterfaz(resultado);
	      		}
	      		else
	      		{
	      			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
	      		}
	  		} 
	      	catch (Exception e) 
	      	{
	//  			e.printStackTrace();
	  			String resultado = generarMensajeError(e);
	  			panelDatos.actualizarInterfaz(resultado);
	  		}
	      }
	      









	/* ****************************************************************
	 * 			CRUD de TipoBebida
	 *****************************************************************/
	/**
	 * Adiciona un tipo de bebida con la información dada por el usuario
	 * Se crea una nueva tupla de tipoBebida en la base de datos, si un tipo de bebida con ese nombre no existía
	 */
	public void adicionarTipoBebida( )
	{
		try 
		{
			String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
			if (nombreTipo != null)
			{
				VOTipoBebida tb = parranderos.adicionarTipoBebida (nombreTipo);
				if (tb == null)
				{
					throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
				}
				String resultado = "En adicionarTipoBebida\n\n";
				resultado += "Tipo de bebida adicionado exitosamente: " + tb;
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/**
	 * Consulta en la base de datos los tipos de bebida existentes y los muestra en el panel de datos de la aplicación
	 */
	public void listarTipoBebida( )
	{
		try 
		{
			List <VOTipoBebida> lista = parranderos.darVOTiposBebida();

			String resultado = "En listarTipoBebida";
			resultado +=  "\n" + listarTiposBebida (lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/**
	 * Borra de la base de datos el tipo de bebida con el identificador dado po el usuario
	 * Cuando dicho tipo de bebida no existe, se indica que se borraron 0 registros de la base de datos
	 */
	public void eliminarTipoBebidaPorId( )
	{
		try 
		{
			String idTipoStr = JOptionPane.showInputDialog (this, "Id del tipo de bedida?", "Borrar tipo de bebida por Id", JOptionPane.QUESTION_MESSAGE);
			if (idTipoStr != null)
			{
				long idTipo = Long.valueOf (idTipoStr);
				long tbEliminados = parranderos.eliminarTipoBebidaPorId (idTipo);

				String resultado = "En eliminar TipoBebida\n\n";
				resultado += tbEliminados + " Tipos de bebida eliminados\n";
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/**
	 * Busca el tipo de bebida con el nombre indicado por el usuario y lo muestra en el panel de datos
	 */
	public void buscarTipoBebidaPorNombre( )
	{
		try 
		{
			String nombreTb = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Buscar tipo de bebida por nombre", JOptionPane.QUESTION_MESSAGE);
			if (nombreTb != null)
			{
				VOTipoBebida tipoBebida = parranderos.darTipoBebidaPorNombre (nombreTb);
				String resultado = "En buscar Tipo Bebida por nombre\n\n";
				if (tipoBebida != null)
				{
					resultado += "El tipo de bebida es: " + tipoBebida;
				}
				else
				{
					resultado += "Un tipo de bebida con nombre: " + nombreTb + " NO EXISTE\n";    				
				}
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}


	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de Parranderos
	 */
	public void mostrarLogParranderos ()
	{
		mostrarArchivo ("parranderos.log");
	}

	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}

	/**
	 * Limpia el contenido del log de parranderos
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogParranderos ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("parranderos.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}

	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}

	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de parranderos
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			long eliminados [] = parranderos.limpiarParranderos();

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += eliminados [0] + " Gustan eliminados\n";
			resultado += eliminados [1] + " Sirven eliminados\n";
			resultado += eliminados [2] + " Visitan eliminados\n";
			resultado += eliminados [3] + " Bebidas eliminadas\n";
			resultado += eliminados [4] + " Tipos de bebida eliminados\n";
			resultado += eliminados [5] + " Bebedores eliminados\n";
			resultado += eliminados [6] + " Bares eliminados\n";
			resultado += "\nLimpieza terminada";

			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
	}

	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Parranderos.pdf");
	}

	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Parranderos.pdf");
	}

	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaParranderos.sql");
	}

	/**
	 * Muestra la arquitectura de referencia para Parranderos
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}

	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}

	/**
	 * Muestra la información acerca del desarrollo de esta apicación
	 */
	public void acercaDe ()
	{
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * Licenciado	bajo	el	esquema	Academic Free License versión 2.1\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: Parranderos Uniandes\n";
		resultado += " * @version 1.0\n";
		resultado += " * @author Germán Bravo\n";
		resultado += " * Julio de 2018\n";
		resultado += " * \n";
		resultado += " * Revisado por: Claudia Jiménez, Christian Ariza\n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
	}


	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/

	/**
	 * Genera una cadena de caracteres con la lista de los tipos de bebida recibida: una línea por cada tipo de bebida
	 * @param lista - La lista con los tipos de bebida
	 * @return La cadena con una líea para cada tipo de bebida recibido
	 */
	private String listarServicios(List<VOServicioSalud> lista) 
	{
		String resp = "Los servicios existentes son:\n";
		int i = 1;
		for (VOServicioSalud tb : lista)
		{
			resp += i++ + ". " + tb.toString() + "\n";
		}
		return resp;
	}

	/**
	 * Genera una cadena de caracteres con la lista de los tipos de bebida recibida: una línea por cada tipo de bebida
	 * @param lista - La lista con los tipos de bebida
	 * @return La cadena con una líea para cada tipo de bebida recibido
	 */
	private String listarTiposBebida(List<VOTipoBebida> lista) 
	{
		String resp = "Los tipos de bebida existentes son:\n";
		int i = 1;
		for (VOTipoBebida tb : lista)
		{
			resp += i++ + ". " + tb.toString() + "\n";
		}
		return resp;
	}

	/**
	 * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
	 * @param e - La excepción recibida
	 * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
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

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
			//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
	/**
	 * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
	 * Invoca al método correspondiente según el evento recibido
	 * @param pEvento - El evento del usuario
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
		try 
		{
			Method req = InterfazParranderosApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}

	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
	/**
	 * Este método ejecuta la aplicación, creando una nueva interfaz
	 * @param args Arreglo de argumentos que se recibe por línea de comandos
	 */
	public static void main( String[] args )
	{
		try
		{

			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
			InterfazParranderosApp interfaz = new InterfazParranderosApp( );
			interfaz.setVisible( true );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}
}
