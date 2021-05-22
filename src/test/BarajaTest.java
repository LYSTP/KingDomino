package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import clases.Baraja;
import clases.Domino;

public class BarajaTest {

	@Test
	public void testCrearBaraja() {
		Baraja b = new Baraja();
		assertEquals(48, b.getSizeDominos());
	}

	@Test
	public void testMezclarBaraja() {
		Baraja b = new Baraja();
		int numeroPrimerDomino = b.getMazo().get(0).getNumero();
		b.mezclar();
		assertNotEquals(numeroPrimerDomino, b.getMazo().get(0).getNumero());
	}//puede pasar que justo te toca de nuevo la primera carta

	@Test
	public void testRepartirBaraja() {
		Baraja b = new Baraja();
		List<Domino> l = b.repartir();
		assertEquals(4, l.size());
	}
}
