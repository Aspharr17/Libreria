package DBHelper;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseHelper <T> {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/libreria";
	private static final String USUARIO = "Aspharr17";
	private static final String CLAVE = "Ghostrecon17";


	private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());
	
	
	
	public int modificarRegistro(String consultaSQL) throws DBException
	{
		
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;
		try
		{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
			
		}catch(ClassNotFoundException e) {
			//System.out.println("Error driver"+e.getMessage());
			log.error("Error de accesso al driver"+e.getMessage());
			throw new DBException("Error driver",e);
			
		}catch(SQLException e) {
			//System.out.println("Error de SQL"+e.getMessage());
			log.error("Error de SQL "+e.getMessage());
			throw new DBException("Error de SQL",e);
		}finally {
			
			if(sentencia != null) {
				try 
				{
					sentencia.close();
				} 
				catch(SQLException e) 
				{
					log.error("Error con la sentencia"+e.getMessage());
				}
			}
			if(conexion != null) {
				try {
					conexion.close();
					}
				catch(SQLException e) 
				{
					log.error("Error cerrando la conexion"+e.getMessage());
				}
			}
		}
		return filasAfectadas;
	}
	
	
	@SuppressWarnings({ "finally", "unchecked", "rawtypes" })
	public List<T> seleccionarRegistros(String consultaSQL, Class clase) 
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos=new ArrayList<T>();
		try 
		{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
			while (filas.next()) 
			{
				T objeto=(T) Class.forName(clase.getName()).newInstance();
				Method[] metodos=objeto.getClass().getDeclaredMethods();
				for (int i=0;i<metodos.length;i++) 
				{

					if (metodos[i].getName().startsWith("set") ) 
					{

						if(isNumeric(filas.getString(metodos[i].getName().substring(3))))
						{
							metodos[i].invoke(objeto,filas.getInt(metodos[i].getName().substring(3)));
						}
						else
						{
							metodos[i].invoke(objeto,filas.getString(metodos[i].getName().substring(3)));

						}
					}
					if (objeto.getClass().getName().equals("java.lang.String")) 
					{
						objeto=(T)filas.getString(1);
					}
				}	
				listaDeObjetos.add(objeto);
			}
		} catch (Exception e) {
		System.out.println("Error al seleccionar registros" + e.getMessage());
		}
		finally {
		if (sentencia != null) {
		try {sentencia.close();} catch (SQLException e) {}
		}
		if (conexion != null) {
		try {conexion.close();} catch (SQLException e) {}
		}
		return listaDeObjetos;
		}
	}
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
