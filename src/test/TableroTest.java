package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clases.Baraja;
import clases.CordenadasDomino;
import clases.Domino;
import clases.Elemento;
import clases.Tablero;
import clases.Elemento.tiposElementos;
import clases.GestionJuego;
import clases.Jugador;

public class TableroTest {

//	@Test
//	public void crearTablero() {
//		Tablero t = new Tablero();
//		t.mostrarTablero();
//	}
//
//	@Test
//	public void colocarDominoEnTablero() {
//		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
//		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
//		Domino d = new Domino(ei, ed);
//
//		Tablero t = new Tablero();
//
//		assertTrue(t.colocarDomino(d, new CordenadasDomino(5, 4), new CordenadasDomino(6, 4)));
//	}
//
//	@Test
//	public void noEsPosibleColocarDominoEnTablero() {
//		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
//		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
//		Domino d = new Domino(ei, ed);
//
//		Elemento ei_1 = new Elemento(tiposElementos.AGUA, 0);
//		Elemento ed_1 = new Elemento(tiposElementos.BOSQUE, 0);
//		Domino d_1 = new Domino(ei_1, ed_1);
//
//		Tablero t = new Tablero();
//
//		assertTrue(t.colocarDomino(d, new CordenadasDomino(5, 4), new CordenadasDomino(6, 4)));
//		assertFalse(t.colocarDomino(d_1, new CordenadasDomino(7, 4), new CordenadasDomino(8, 4)));
//
//	}
//
//	@Test
//	public void noEsPosibleColocarDominoSobreOtroEnTablero() {
//		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
//		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
//		Domino d = new Domino(ei, ed);
//
//		Elemento ei_1 = new Elemento(tiposElementos.BOSQUE, 0);
//		Elemento ed_1 = new Elemento(tiposElementos.BOSQUE, 0);
//		Domino d_1 = new Domino(ei_1, ed_1);
//
//		Tablero t = new Tablero();
//
//		assertTrue(t.colocarDomino(d, new CordenadasDomino(5, 4), new CordenadasDomino(6, 4)));
//		assertFalse(t.colocarDomino(d_1, new CordenadasDomino(5, 4), new CordenadasDomino(6, 4)));
//
//	}
//
//	@Test
//	public void colocarDosDominoEnTablero() {
//		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
//		Elemento ed = new Elemento(tiposElementos.BOSQUE, 0);
//		Domino d = new Domino(ei, ed);
//
//		Elemento ei_1 = new Elemento(tiposElementos.BOSQUE, 0);
//		Elemento ed_1 = new Elemento(tiposElementos.BOSQUE, 0);
//		Domino d_1 = new Domino(ei_1, ed_1);
//
//		Tablero t = new Tablero();
//
//		assertTrue(t.colocarDomino(d, new CordenadasDomino(5, 4), new CordenadasDomino(6, 4)));
//		assertTrue(t.colocarDomino(d_1, new CordenadasDomino(7, 4), new CordenadasDomino(8, 4)));
//
//		t.mostrarTablero();
//	}

	@Test
	public void calcularGanador() {
		Elemento ei = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed = new Elemento(tiposElementos.BOSQUE, 3);
		Domino d = new Domino(ei, ed);
		Elemento ei_1 = new Elemento(tiposElementos.BOSQUE, 0);
		Elemento ed_1 = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d_1 = new Domino(ei_1, ed_1);

		Tablero t = new Tablero();

		t.colocarDomino(d, new CordenadasDomino(5, 4), new CordenadasDomino(6, 4));
		t.colocarDomino(d_1, new CordenadasDomino(5, 5), new CordenadasDomino(6, 5));
		t.mostrarTablero();

		Elemento ei1 = new Elemento(tiposElementos.AGUA, 2);
		Elemento ed1 = new Elemento(tiposElementos.AGUA, 0);
		Domino d1 = new Domino(ei1, ed1);
		Elemento ei_2 = new Elemento(tiposElementos.AGUA, 0);
		Elemento ed_2 = new Elemento(tiposElementos.TIERRA, 0);
		Domino d2 = new Domino(ei_2, ed_2);
		Elemento ei_3 = new Elemento(tiposElementos.BOSQUE, 0);
		Elemento ed_3 = new Elemento(tiposElementos.BOSQUE, 0);
		Domino d3 = new Domino(ei_3, ed_3);
		Tablero t1 = new Tablero();
		t1.colocarDomino(d1, new CordenadasDomino(5, 4), new CordenadasDomino(6, 4));
		t1.colocarDomino(d2, new CordenadasDomino(5, 3), new CordenadasDomino(6, 3));
		t1.colocarDomino(d3, new CordenadasDomino(4, 5), new CordenadasDomino(5, 5));
		t1.mostrarTablero();

		Jugador j1 = new Jugador(1, "Pedro");
		Jugador j2 = new Jugador(2, "Juan");
		j1.setTablero(t);
		j2.setTablero(t1);

		List<Jugador> lj = new ArrayList<Jugador>();
		lj.add(j1);
		lj.add(j2);
		GestionJuego g = new GestionJuego(lj);
		Baraja b = new Baraja();
		b.getBaraja().clear();
		g.setBaraja(b);
		g.iniciarPartida();
	}

}