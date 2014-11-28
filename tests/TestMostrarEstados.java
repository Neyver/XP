package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import database.MostrarEstados;

public class TestMostrarEstados {

	@Test
	public void testMostrarE() {
		MostrarEstados m = new MostrarEstados();
		try {
			m.updateData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = m.getMsg1();
		assertEquals("Clicked",result);
	}

}
