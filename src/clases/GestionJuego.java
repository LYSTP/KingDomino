package clases;

import java.util.List;

public class GestionJuego {

	List<Jugador> jugadores;
	Jugador jugadorEnTurno;
	Baraja baraja;

	public GestionJuego(List<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.baraja = new Baraja();
		this.jugadorEnTurno = jugadores.get(0);
	}

	public boolean quitarJugador(Jugador j) {
		this.jugadores.remove(j.getId());
		return true;
	}

	public List<Domino> darMano(int turno) {
		return this.baraja.repartir();
	}

	public boolean iniciarPartida() {
		return true;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public Baraja getBaraja() {
		return this.baraja;
	}

}
