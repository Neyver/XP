package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Rocha
 */
public class PostgresConn {
    
    private static Connection conexion;
    private static Statement sentencia;

    public static final String DRIVER = Constantes.POSTGRESQL_DRIVER;
    public static final String DBURL = Constantes.POSTGRESQL_DBURL;
    
    private static PostgresConn uniqueInstance = new PostgresConn();
    
    private PostgresConn(){};

    public static Connection createConnection() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager
                    .getConnection(DBURL,
                            Constantes.POSTGRESQL_USER,
                            Constantes.POSTGRESQL_PASS);

            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage()); 
        }
        return conexion;
    }

    /**
     * Executes the given SQL statement, which may be an INSERT, UPDATE, or
     * DELETE statement or an SQL statement that returns nothing, such as an SQL
     * DDL statement.
     *
     * @param sql
     * @return True if everything went well
     */
    public static boolean updateDB(String sql) {
        try 
        {
            sentencia = createConnection().createStatement(
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }
    public static boolean queryDB(String sql) {
        try 
        {
            sentencia = createConnection().createStatement(
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeQuery(sql);
            sentencia.close();
            conexion.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }
    public static ArrayList<String[]> funcionDB(String sql) 
    {    	    	
        String[] respuesta = {"","","","","","",""};
        ArrayList<String[]> lista = new ArrayList<String[]>();
        int id_colaborador,id_funcion,dni,telefono;
        String nombre,apellido,correo;
        //"Nro ", "nombre(s)", "apellido(s)", "correo", "funcion", "DNI", "telefono(s)"
        try 
        {
            sentencia = createConnection().createStatement(
            ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet res= sentencia.executeQuery(sql);
            while ( res.next() ) 
            {
                 id_funcion = res.getInt("id");
                 id_colaborador = res.getInt("idc");
                 dni = res.getInt("dni");
                 telefono = res.getInt("telf");
                 nombre = res.getString("nombre");
                 apellido = res.getString("apellido");
                 correo = res.getString("correo");
                 respuesta[0] = ""+id_colaborador;
                 respuesta[1] = nombre;
                 respuesta[2] = apellido;
                 respuesta[3] = correo;
                 respuesta[4] = ""+id_funcion;
                 respuesta[5] = ""+dni;
                 respuesta[6] = ""+telefono;
                 lista.add(respuesta);
           	}
       	}
        catch (SQLException ex) 
       	{
            	JOptionPane.showMessageDialog(null,"Error al tratar de conectar la base, varifica tus datos de conexion");
        }
            //select * from lista_colaboradores() as datos(id int,idc int,nombre character varying(30), apellido character varying(30),correo character varying(30),dni int, telf int);select * from lista_colaboradores() as datos(id int,idc int,nombre character varying(30), apellido character varying(30),correo character varying(30),dni int, telf int);                                          
        return lista;
     }


    /**
     * Executes the given SQL statement, which is a Select statement
     *
     * @param sql
     * @return
     */
    public static ResultSet consultar(String sql) {
        ResultSet resultado = null;
        try {
            sentencia = createConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La consulta fallo");
            return null;
        }
        System.out.println("La consulta Fue Exitosa");
        return resultado;
    }

    
}
