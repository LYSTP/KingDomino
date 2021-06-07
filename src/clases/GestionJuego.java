package clases;

import java.util.Collections;
import java.util.List;

public class GestionJuego {

	List<Jugador> jugadores;
	Jugador jugadorEnTurno;
	Baraja baraja;
	boolean primerTurno = true;

	public GestionJuego(List<Jugador> jugadores) {
		this.jugadores = jugadores;
		Archivo a = new Archivo();
		this.baraja = a.leerArchivo("EntradaMazo/baraja.in");
		this.jugadorEnTurno = jugadores.get(0);
	}

	public boolean quitarJugador(Jugador j) {
		this.jugadores.remove(j.getId());
		return true;
	}

	public void iniciarPartida() {
		if (jugadores.size() >= 2 && jugadores.size() <= 4) {

			while (!baraja.getBaraja().isEmpty()) {
				ordenarJugadores();
				Ronda.nuevaRonda(jugadores, baraja.repartir());
			}
			// finaliza la partida
			obtenerGanador();
		} else
			System.out.println("Cantidad de jugadores no valida.");
	}

	public void ordenarJugadores() {
		if (primerTurno) {
			Collections.shuffle(jugadores);
			primerTurno = false;
		} else {
			Collections.sort(jugadores, (j1, j2) -> {
				return j1.getDominoSeleccionado().getNumero().compareTo(j2.getDominoSeleccionado().getNumero());
			});
		}
	}

	public List<Domino> darMano(int turno) {
		return this.baraja.repartir();
	}

	public int crearPartida() {
		// elejir modo de juego.
		return jugadores.size();
	}
	
	public boolean verificarParticipantes() {
		if(jugadores.size() >= 2 && jugadores.size() <= 4)
			return true;
		return false;
	}
	
	
/*	public void iniciarPartida() {	//Devolvera un jugador ganador.
		Jugador ganador;
		
		
		
		
	}*/

	public int obtenerGanador() {
		return 1;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public Baraja getBaraja() {
		return this.baraja;
	}

}
