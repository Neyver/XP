
import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Colaborador;
import Vista.VentanaRegistrarColaborador;

public class Prueba 
{     
	@Test
	public void Registrar() 
	{
		Colaborador c = new Colaborador("harol","mamani choque","h_buezo@gmail.com","alimentacion",782998,450212);
		//VentanaRegistrarColaborador v = new VentanaRegistrarColaborador();	
	    assertTrue(RegistrarColaborador(c));
	}
	@Test
	public void ModificarColaboradorNombre()
	{
	   //assertTrue(c.ModificarNombre("lucas"));	  	   
	}
	@Test
	public void ModificarColaboradorApellidos()
	{
	   //assertTrue(c.ModificarApellidoP("Mamani Quispe"));	  	   
	}
	@Test
	public void ModificarColaboradorCI()
	{
	   //assertTrue(c.ModificarCI("7658892"));	  	   
	}
	@Test
	public void ModificarColaboradorTelefono()
	{
	   //assertTrue(c.ModificarT("70234817"));	  	   
	}
	@Test
	public void ModificarColaboradorCorreo()
	{
	   //assertTrue(c.ModificarC("papito@hotmail.com"));	  	   
	}
	@Test
	public void ModificarColaboradorFuncion()
	{
	   //assertTrue(c.ModificarF("Alimentacion"));	  	   
	}
	@Test
	public void ObtenerLista()
	{		
		//RegistrarColaborador(new Colaborador("lucas","mamani","orellana",798773,70323746,"pepito@hotmail.com","alimentos",0));
		//RegistrarColaborador(new Colaborador("cusi","choque","garcia",7345473,74563746,"Cusi@gmail.com","compras",100));
		//assertEquals(ObtenerLista(),Object);		
	}
}
