package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Domino;
import clases.Elemento;

public class DominoTest {

	@Test
	public void testCrearDomino() {
		Elemento ei = new Elemento("Agua", 0);
		Elemento ed = new Elemento("Bosque", 0);
		Domino d = new Domino(ei, ed);

		assertEquals("Agua", d.getElemIzquierdo().getDescripcion());
		assertEquals("Bosque", d.getElemDerecho().getDescripcion());
	}

	@Test
	public void testCrearDominoConCastillo() {
		Elemento e = new Elemento("Castillo", 0);
		Domino d = new Domino(e);
		assertEquals("Castillo", d.getElemIzquierdo().getDescripcion());
		assertEquals("Castillo", d.getElemDerecho().getDescripcion());
	}

	@Test
	public void testCrearDominoConCorona() {
		Elemento ei = new Elemento("Agua", 1);
		Elemento ed = new Elemento("Bosque", 0);
		Domino d = new Domino(ei, ed);
		assertEquals(1, d.getElemIzquierdo().getCoronas());
		assertEquals(0, d.getElemDerecho().getCoronas());
	}

	@Test
	public void testSePuedeUnirDominos() {
		Elemento ei1 = new Elemento("Agua", 0);
		Elemento ed1 = new Elemento("Bosque", 0);
		Elemento ei2 = new Elemento("Agua", 0);
		Elemento ed2 = new Elemento("Pastizal", 0);
		Domino d1 = new Domino(ei1, ed1);
		Domino d2 = new Domino(ei2, ed2);
		assertEquals(true, d1.puedenUnir(d2));
	}
	
	@Test
	public void testNoSePuedeUnirDominos() {
		Elemento ei1 = new Elemento("Agua", 0);
		Elemento ed1 = new Elemento("Bosque", 0);
		Elemento ei2 = new Elemento("Pastizal", 0);
		Elemento ed2 = new Elemento("Pastizal", 0);
		Domino d1 = new Domino(ei1, ed1);
		Domino d2 = new Domino(ei2, ed2);
		assertEquals(false, d1.puedenUnir(d2));
	}
	
	@Test
	public void testPuedeUnirDominosPorCastillo() {
		Elemento ei1 = new Elemento("Agua", 0);
		Elemento ed1 = new Elemento("Bosque", 0);
		Elemento ei2 = new Elemento("Castillo", 0);
		Domino d1 = new Domino(ei1, ed1);
		Domino d2 = new Domino(ei2);
		assertEquals(0,d1.getElemIzquierdo().compareTo(d2.getElemIzquierdo()));
	}

}
