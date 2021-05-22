package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Jugador;

public class JugadorTest {

	@Test
	public void testCrearJugador() {
		Jugador j = new Jugador(1, "Charles");
		assertEquals(1, j.getId());
	}

}
