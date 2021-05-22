package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Domino;
import clases.Elemento;

public class ElementoTest {

	@Test
	public void testCrearElementosCreanDomino() {
		Elemento ei = new Elemento("Mina", 0);
		Elemento ed = new Elemento("Tierra", 0);
		Domino d = new Domino(ei, ed);

		assertEquals("Mina", d.getElemIzquierdo().getDescripcion());
		assertEquals("Tierra", d.getElemDerecho().getDescripcion());
	}

	@Test
	public void testCrearElementoConCoronas() {
		Elemento elemMinaCorona3 = new Elemento("Mina", 3);
		assertEquals(3, elemMinaCorona3.getCoronas());
	}

	@Test
	public void testAsignarElementoIzquierda() {
		Elemento elemCesped = new Elemento("Cesped", 0);
		Elemento elemTierra = new Elemento("Tierra", 0);
		elemCesped.asignarElemIzq(elemTierra);
		assertFalse(elemCesped.asignarElemIzq(elemTierra));
	}
	
	@Test
	public void testAsignarElementoDerecha() {
		Elemento elemCesped = new Elemento("Cesped", 0);
		Elemento elemTierra = new Elemento("Tierra", 0);
		elemCesped.asignarElemDer(elemTierra);
		assertFalse(elemCesped.asignarElemDer(elemTierra));
	}
	
	@Test
	public void testAsignarElementoArriba() {
		Elemento elemCesped = new Elemento("Cesped", 0);
		Elemento elemTierra = new Elemento("Tierra", 0);
		elemCesped.asignarElemArriba(elemTierra);
		assertFalse(elemCesped.asignarElemArriba(elemTierra));
	}
	
	@Test
	public void testAsignarElementoAbajo() {
		Elemento elemCesped = new Elemento("Cesped", 0);
		Elemento elemTierra = new Elemento("Tierra", 0);
		elemCesped.asignarElemAbajo(elemTierra);
		assertFalse(elemCesped.asignarElemAbajo(elemTierra));
	}

}
