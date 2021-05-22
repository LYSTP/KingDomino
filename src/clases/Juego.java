//package clases;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Juego {
//	
//	private Jugador JugadorEnTurno;
//	private List<Jugador> jugadores = new ArrayList<Jugador>();
//	private boolean juegoActivo;
//	private List<Sala> salas = new ArrayList<Sala>();
//
//	public Juego(Jugador jugador1, Jugador jugador2) {
//		jugadores.add(jugador1);
//		jugadores.add(jugador2);
//
//		this.juegoActivo = true;
//
//		setTurno(jugador1);
//		JugadorEnTurno = jugador1;
//	}
//
//	public Juego(Jugador jugador1, Jugador jugador2, Jugador jugador3) {
//		jugadores.add(jugador1);
//		jugadores.add(jugador2);
//		jugadores.add(jugador3);
//		this.juegoActivo = true;
//		setTurno(jugador1);
//		JugadorEnTurno = jugador1;
//	}
//	public Juego(Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4) {// se va a quitar
//		jugadores.add(jugador1);
//		jugadores.add(jugador2);
//		jugadores.add(jugador3);
//		jugadores.add(jugador4);
//		this.juegoActivo = true;
//		setTurno(jugador1);
//		JugadorEnTurno = jugador1;
//	}
//	
//	public Juego(List<Jugador> jugadores) {
//		setJugadores(jugadores);
//		this.juegoActivo = true;
//		setTurno(this.jugadores.get(0));
//		JugadorEnTurno = this.jugadores.get(0);
//	}
//	
//	public Juego(Sala sala) {
//		salas.add(sala);
//	}
//
//	private void setJugadores(List<Jugador> jugadores) {
//		this.jugadores = jugadores;
//	}
//	
//	public List<Jugador> getJugadores() {
//		return jugadores;
//	}
//	
//	private void setTurno(Jugador jugador) {
//		jugador.setTurno(true);
//		for (Jugador jug : jugadores) {
//			if (jugador != jug)
//				jug.setTurno(false);
//		}
//	}
//	
//	
//}
