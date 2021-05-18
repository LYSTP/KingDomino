import java.util.List;

public class Sala {
	private int id;
	private String descripcion;
	private List<Jugador> jugadores;
	private int cantPartipantes;

	public Sala(String descripcion) {
		this.descripcion = descripcion;
	}

	public Sala(String descripcion, Jugador jugador) {
		this.descripcion = descripcion;
		this.jugadores.add(jugador);
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public int getCantPartipantes() {
		return cantPartipantes;
	}

	boolean agregarJugador(Jugador j) {
		if (this.jugadores.size() <= this.cantPartipantes) {
			this.jugadores.add(j);
			return true;
		}
		return false;
	}

	boolean quitarJugador(Jugador j) {
		if (this.jugadores.size() > 1) {
			this.jugadores.remove(j);
			return true;
		}
		return false;
	}

}
