package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Domino;
import clases.Elemento;
import clases.Elemento.tiposElementos;

public class DominoTest {

	@Test
	public void testCrearDomino() {
		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d = new Domino(ei, ed);

		assertEquals(tiposElementos.AGUA.toString(), d.getElemIzquierdo().getDescripcion());
		assertEquals(tiposElementos.BOSQUE.toString(), d.getElemDerecho().getDescripcion());
	}

	@Test
	public void testCrearDominoConCastillo() {
		Elemento e = new Elemento(tiposElementos.CASTILLO, 0);
		Domino d = new Domino(e);
		assertEquals(tiposElementos.CASTILLO.toString(), d.getElemIzquierdo().getDescripcion());
		assertEquals(tiposElementos.CASTILLO.toString(), d.getElemDerecho().getDescripcion());
	}

	@Test
	public void testCrearDominoConCorona() {
		Elemento ei = new Elemento(tiposElementos.AGUA, 1);
		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d = new Domino(ei, ed);
		assertEquals(1, d.getElemIzquierdo().getCoronas());
		assertEquals(0, d.getElemDerecho().getCoronas());
	}

	@Test
	public void testSePuedeUnirDominos() {
		Elemento ei1 = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed1 = new Elemento(tiposElementos.BOSQUE, 0);
		Elemento ei2 = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed2 = new Elemento(tiposElementos.PASTIZAL, 0);
		Domino d1 = new Domino(ei1, ed1);
		Domino d2 = new Domino(ei2, ed2);
		assertEquals(true, d1.puedenUnir(d2));
	}

	@Test
	public void testNoSePuedeUnirDominos() {
		Elemento ei1 = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed1 = new Elemento(tiposElementos.BOSQUE, 0);
		Elemento ei2 = new Elemento(tiposElementos.PASTIZAL, 0);
		Elemento ed2 = new Elemento(tiposElementos.PASTIZAL, 0);
		Domino d1 = new Domino(ei1, ed1);
		Domino d2 = new Domino(ei2, ed2);
		assertEquals(false, d1.puedenUnir(d2));
	}

	@Test
	public void testPuedeUnirDominosPorCastillo() {
		Elemento ei1 = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed1 = new Elemento(tiposElementos.BOSQUE, 0);
		Elemento ei2 = new Elemento(tiposElementos.CASTILLO, 0);
		Domino d1 = new Domino(ei1, ed1);
		Domino d2 = new Domino(ei2);
		assertEquals(0, d1.getElemIzquierdo().compareTo(d2.getElemIzquierdo()));
	}

}
