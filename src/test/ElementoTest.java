package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Domino;
import clases.Elemento;
import clases.Elemento.tiposElementos;

public class ElementoTest {

	@Test
	public void testCrearElementosCreanDomino() {
		Elemento ei = new Elemento(tiposElementos.MINA, 0);
		Elemento ed = new Elemento(tiposElementos.TIERRA, 0);
		Domino d = new Domino(ei, ed);

		assertEquals(tiposElementos.MINA.toString(), d.getElemIzquierdo().getDescripcion());
		assertEquals(tiposElementos.TIERRA.toString(), d.getElemDerecho().getDescripcion());
	}

	@Test
	public void testCrearElementoConCoronas() {
		Elemento elemMinaCorona3 = new Elemento(tiposElementos.MINA, 3);
		assertEquals(3, elemMinaCorona3.getCoronas());
	}

	@Test
	public void testAsignarElementoIzquierda() {
		Elemento elemCesped = new Elemento(tiposElementos.CESPED, 0);
		Elemento elemTierra = new Elemento(tiposElementos.TIERRA, 0);
		elemCesped.asignarElemIzq(elemTierra);
		assertFalse(elemCesped.asignarElemIzq(elemTierra));
	}

	@Test
	public void testAsignarElementoDerecha() {
		Elemento elemCesped = new Elemento(tiposElementos.CESPED, 0);
		Elemento elemTierra = new Elemento(tiposElementos.TIERRA, 0);
		elemCesped.asignarElemDer(elemTierra);
		assertFalse(elemCesped.asignarElemDer(elemTierra));
	}

	@Test
	public void testAsignarElementoArriba() {
		Elemento elemCesped = new Elemento(tiposElementos.CESPED, 0);
		Elemento elemTierra = new Elemento(tiposElementos.TIERRA, 0);
		elemCesped.asignarElemArriba(elemTierra);
		assertFalse(elemCesped.asignarElemArriba(elemTierra));
	}

	@Test
	public void testAsignarElementoAbajo() {
		Elemento elemCesped = new Elemento(tiposElementos.CESPED, 0);
		Elemento elemTierra = new Elemento(tiposElementos.TIERRA, 0);
		elemCesped.asignarElemAbajo(elemTierra);
		assertFalse(elemCesped.asignarElemAbajo(elemTierra));
	}

}