package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import clases.GestionJuego;
import clases.Jugador;

public class GestionJuegoTest {

	@Test
	public void testCrearGestionJuego() {
		Jugador j1 = new Jugador(1, "Pedro");
		Jugador j2 = new Jugador(2, "Carlos");
		List<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);

		GestionJuego gj = new GestionJuego(jugadores);
		assertNotNull(gj.getBaraja());
	}

	@Test
	public void testQuitarJugador() {
		Jugador j1 = new Jugador(1, "Pedro");
		Jugador j2 = new Jugador(2, "Carlos");
		List<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		GestionJuego gj = new GestionJuego(jugadores);
		int jugadoresAntes = gj.getJugadores().size();
		gj.quitarJugador(j1);
		assertEquals(jugadoresAntes - 1, gj.getJugadores().size());
	}
	
	@Test
	public void iniciarPartida() {		
		Jugador j1 = new Jugador(1, "Pedro");
		Jugador j2 = new Jugador(2, "Carlos");
		List<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		GestionJuego gj = new GestionJuego(jugadores);
		
		gj.iniciarPartida();
		
	}

}
