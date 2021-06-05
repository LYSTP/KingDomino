package clases;

import java.util.List;

public class Jugador {
	private int id;
	private String nombre;

	private Tablero tablero;

	private Domino dominoSeleccionado;

	private boolean esTurno = false;
	private int puntos = 0;

	public Jugador(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.tablero = new Tablero();
	}

	// De los 4 domino que se reparten (ordenados), se selecciona uno.
	public void seleccionarDomino(List<Domino> dominos, int numeroDominoOrden) {
		this.dominoSeleccionado = dominos.get(numeroDominoOrden);
	}

	public Domino getDominoSeleccionado() {
		return dominoSeleccionado;
	}

	public boolean posicionarDominoEnTablero(CordenadasDomino elementoIzquierda,
			CordenadasDomino elementoDerecha) {

		return this.tablero.colocarDomino(this.dominoSeleccionado, elementoIzquierda, elementoDerecha);

	}

	public int getPuntos() {
		return puntos;
	}

	public void setTurno(boolean val) {
		this.esTurno = val;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDominoSeleccionado(Domino domino) {
		this.dominoSeleccionado = domino;	
	}
	
	public Tablero getTablero() {
		return tablero;
	}

}
