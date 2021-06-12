package clases;

import java.util.ArrayList;
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
			obtenerGanador(calcularPuntajes());
		} else
			System.out.println("Cantidad de jugadores no valida.");
	}

	private List<Integer> calcularPuntajes() {
		List<Integer> puntajesFinales = new ArrayList<Integer>();

		for (Jugador jugador : jugadores) {
			System.out.println("Jugador " + jugador.getNombre());
			puntajesFinales.add(jugador.getTablero().puntajeTotal());
		}

		return puntajesFinales;
	}

	private List<Jugador> obtenerGanador(List<Integer> puntajesFinales) {
		List<Integer> ganaPorPuntos = obtenerGanadoresPorPuntos(puntajesFinales);
		List<Jugador> ganadores = new ArrayList<Jugador>(jugadores.size());

		if (ganaPorPuntos.size() == 1) {
			System.out.println("Ganó por puntos " + jugadores.get(ganaPorPuntos.get(0)).getNombre());
			ganadores.add(jugadores.get(ganaPorPuntos.get(0)));
			return ganadores;
		}

		List<Integer> ganadoresPorTerreno = obtenerGanadoresPorTerreno(ganaPorPuntos);

		if (ganadoresPorTerreno.size() == 1) {
			System.out.println("Ganó por terreno " + jugadores.get(ganadoresPorTerreno.get(0)).getNombre());
			ganadores.add(jugadores.get(ganadoresPorTerreno.get(0)));
			return ganadores;
		}

		List<Jugador> ganaPorCorona = obtenerGanadoresPorCantCoronas(ganadoresPorTerreno);

		if (ganaPorCorona.size() == 1) {
			System.out.println("Ganó por coronas " + ganaPorCorona.get(0).getNombre());
			ganadores.add(ganaPorCorona.get(0));
			return ganadores;
		}

		// Mas de un ganador por terreno
		System.out.println("No se puede desempatar");
		System.out.println("Los Ganadores son:");

		for (int i = 0; i < ganadoresPorTerreno.size(); i++) {
			System.out.println(jugadores.get(ganadoresPorTerreno.get(i)).getNombre());
			ganadores.add(jugadores.get(ganadoresPorTerreno.get(i)));
		}

		return ganadores;
	}

	private List<Integer> obtenerGanadoresPorPuntos(List<Integer> puntajesFinales) {
		int maxPuntaje = 0;
		List<Integer> ganadoresPorPunto = new ArrayList<Integer>();

		for (int i = 0; i < puntajesFinales.size(); i++) {
			Integer puntaje = puntajesFinales.get(i);
			if (puntaje > maxPuntaje) {
				maxPuntaje = puntaje;
				ganadoresPorPunto.clear();
				ganadoresPorPunto.add(i);
			} else {
				if (puntaje == maxPuntaje) {
					ganadoresPorPunto.add(i);
				}
			}
		}
		return ganadoresPorPunto;
	}

	private List<Integer> obtenerGanadoresPorTerreno(List<Integer> ganaPorPuntos) {
		// Si hay mas de un ganador por puntos, se define por cantidad de terreno
		int propiedadMasExtensa = 0;
		List<Integer> ganadoresPorTerreno = new ArrayList<Integer>();

		System.out.println("Empate");
		for (int i = 0; i < ganaPorPuntos.size(); i++) {
			int cantTerreno = jugadores.get(ganaPorPuntos.get(i)).getCantTerrenoColocado();
			System.out.println(jugadores.get(i).getNombre() + ":" + cantTerreno);
			if (cantTerreno > propiedadMasExtensa) {
				propiedadMasExtensa = cantTerreno;
				ganadoresPorTerreno.clear();
				ganadoresPorTerreno.add(i);
			} else {
				if (cantTerreno == propiedadMasExtensa) {
					ganadoresPorTerreno.add(i);
				}
			}
		}

		return ganadoresPorTerreno;
	}

	public List<Jugador> obtenerGanadoresPorCantCoronas(List<Integer> jugadores) {

		int maximo = Integer.MIN_VALUE;
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		for (Integer jugador : jugadores) {
			if (maximo < this.jugadores.get(jugador).getTablero().getCantCorona()) {
				maximo = this.jugadores.get(jugador).getTablero().getCantCorona();
				ganadores.clear();
				ganadores.add(this.jugadores.get(jugador));
			} else {
				if (maximo == this.jugadores.get(jugador).getTablero().getCantCorona())
					ganadores.add(this.jugadores.get(jugador));
			}
		}
		return ganadores;
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
		if (jugadores.size() >= 2 && jugadores.size() <= 4)
			return true;
		return false;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public Baraja getBaraja() {
		return this.baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

}
