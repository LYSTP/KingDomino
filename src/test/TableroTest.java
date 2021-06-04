package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Tablero;

public class TableroTest {

	@Test
	public void crearTablero() {
		Tablero t = new Tablero();
		t.mostrarTablero();
	}

}