package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.CordenadasDomino;
import clases.Domino;
import clases.Elemento;
import clases.Tablero;
import clases.Elemento.tiposElementos;

public class TableroTest {

	@Test
	public void crearTablero() {
		Tablero t = new Tablero();
		t.mostrarTablero();
	}
	
	@Test
	public void colocarDominoEnTablero() {
		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d = new Domino(ei, ed);

		Tablero t = new Tablero();

		assertTrue(t.colocarDomino(d, new CordenadasDomino(5,4), new CordenadasDomino(6, 4)));	
	}
	
	@Test
	public void noEsPosibleColocarDominoEnTablero() {
		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d = new Domino(ei, ed);
		
		Elemento ei_1 = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed_1 = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d_1 = new Domino(ei_1, ed_1);

		Tablero t = new Tablero();

		assertTrue(t.colocarDomino(d, new CordenadasDomino(5,4), new CordenadasDomino(6, 4)));
		assertFalse(t.colocarDomino(d_1, new CordenadasDomino(7,4), new CordenadasDomino(8, 4)));
	
	}
	
	@Test
	public void noEsPosibleColocarDominoSobreOtroEnTablero() {
		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d = new Domino(ei, ed);
		
		Elemento ei_1 = new Elemento(tiposElementos.BOSQUE, 0);
		Elemento ed_1 = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d_1 = new Domino(ei_1, ed_1);

		Tablero t = new Tablero();

		assertTrue(t.colocarDomino(d, new CordenadasDomino(5,4), new CordenadasDomino(6, 4)));
		assertFalse(t.colocarDomino(d_1, new CordenadasDomino(5,4), new CordenadasDomino(6, 4)));
		
	}
	
	@Test
	public void colocarDosDominoEnTablero() {
		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d = new Domino(ei, ed);
		
		Elemento ei_1 = new Elemento(tiposElementos.BOSQUE, 0);
		Elemento ed_1 = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d_1 = new Domino(ei_1, ed_1);

		Tablero t = new Tablero();

		assertTrue(t.colocarDomino(d, new CordenadasDomino(5,4), new CordenadasDomino(6, 4)));
		assertTrue(t.colocarDomino(d_1, new CordenadasDomino(7,4), new CordenadasDomino(8, 4)));	
		
		t.mostrarTablero();
	}
	

}