package database;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Daniel Rocha
 */
public class SqlScript 
{
    
   /* public static void main(String[] args) 
    {
               
        PostgresConn.updateDB(createTableConferencia());
        insertConferencia();
        //deleteConferencia(2);
    }
    */
	public SqlScript(){}
    private static String createTableConferencia(){
        String sql = "/*==============================================================*/\n" +
        "/* DBMS name:      PostgreSQL 8                                 */\n" +
        "/* Created on:     13/11/2014 09:33:54 a.m.                     */\n" +
        "/*==============================================================*/\n" +
        "\n" +
        "\n" +
        // LA PRIMERA VEZ QUE CREAN LA TABLA EN LA BD COMENTAR LAS LINEAS  DROP 
        // LAS SIGUENTES VECES DESCOMENTAR LAS LINEAS DROP
        //"drop index CONFERENCIA_PK;\n" +
        "\n" +
        //"drop table CONFERENCIA;\n" +
        "\n" +
        "/*==============================================================*/\n" +
        "/* Table: CONFERENCIA                                           */\n" +
        "/*==============================================================*/\n" +
        "create table CONFERENCIA (\n" +
        "   ID_CONF              SERIAL not null,\n" +
        "   NOMBRE               CHAR(20)             not null,\n" +
        "   constraint PK_CONFERENCIA primary key (ID_CONF)\n" +
        ");\n" +
        "\n" +
        "/*==============================================================*/\n" +
        "/* Index: CONFERENCIA_PK                                        */\n" +
        "/*==============================================================*/\n" +
        "create unique index CONFERENCIA_PK on CONFERENCIA (\n" +
        "ID_CONF\n" +
        ");\n" +
        "";
        return sql;
    }
    
   private static boolean insertConferencia() {
        boolean res = false;
        String sql = "INSERT INTO conferencia VALUES(" + 1 + ", '"
                + "CCBOL" + "');";
        res = PostgresConn.updateDB(sql);
        System.out.println(res);
        return res;
    }
    
   private static boolean deleteConferencia(int idConferencia) {
        boolean res = false;
        String sql = "DELETE FROM conferencia WHERE \"id_conf\" =" + idConferencia + ";";
        res = PostgresConn.updateDB(sql);
        System.out.println(res);
        return res;
    }
   public static void registrarColaborador(String nombre,String apellidos,String correo,String funcion,int dni,int telefono)
   {
	   boolean res = false;
	   String sql = "SELECT registrar_colaborador('" + nombre + "','" + apellidos + "','" + correo +"','"+funcion+"',"+dni+","+telefono+");";	
	   res = PostgresConn.queryDB(sql);
   }
   public static ArrayList<String[]> obtenerListaColaboradores()
   {	   	   
	   String sql = "select * from lista_colaboradores() as datos(id int,idc int,nombre character varying(30), apellido character varying(30),correo character varying(30),dni int, telf int);";	
	   ArrayList<String[]> respuesta = PostgresConn.funcionDB(sql);
	   return respuesta;	   
   }
}
