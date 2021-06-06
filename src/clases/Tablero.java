package clases;

import java.util.List;

import clases.Elemento.tiposElementos;

public class Tablero {

	private List<Domino> dominos;
	private Elemento[][] tableroJugador = new Elemento[9][9];
	private int totalBoardScore = 0;

	// Se inicia un tablero con el castillo como pieza central
	public Tablero() {
		for (int i = 0; i < tableroJugador.length; i++) {
			for (int j = 0; j < tableroJugador.length; j++) {
				if ((i == 4) && (j == 4)) {
					// Coloca castillo al centro de la matriz
					tableroJugador[j][i] = new Elemento(tiposElementos.CASTILLO, 0);
				} else {
					// Carga las demas posiciones como vacias "disponibles"
					tableroJugador[j][i] = new Elemento(tiposElementos.VACIO, 0);
				}
			}
		}
	}

	public void limitarTablero() {

		int minimoEnX = 9;
		int maximoEnX = 0;
		int minimoEnY = 9;
		int maximoEnY = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (j < minimoEnX) {
					minimoEnX = j;
				}
				if (j > maximoEnX) {
					maximoEnX = j;
				}
				if (i < minimoEnY) {
					minimoEnY = i;
				}
				if (i > maximoEnY) {
					maximoEnY = i;
				}

			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j > minimoEnX + 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISPONIBLE, 0);
				}
				if (j < maximoEnX - 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISPONIBLE, 0);
				}
				if (i > minimoEnY + 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISPONIBLE, 0);
				}
				if (i < maximoEnY - 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISPONIBLE, 0);
				}
			}
		}
	}

	public boolean colocarDomino(Domino domino, CordenadasDomino elementoIzquierda, CordenadasDomino elementoDerecha) {

		if (esPosicionValida(domino, elementoIzquierda, elementoDerecha)) {
			tableroJugador[elementoIzquierda.getX()][elementoIzquierda.getY()] = domino.getElemIzquierdo();
			tableroJugador[elementoDerecha.getX()][elementoIzquierda.getY()] = domino.getElemDerecho();
			return true;
		}
		return false;

	}

	// Comprueba por cada elemento del domino si posee elementos compatibles para
	// colocarlos, es decir mismo tipo o castillo.
	public boolean comprobarAdyaPorElem(Domino domino, CordenadasDomino elemento) {

		String posicionOeste = tableroJugador[elemento.getX() - 1][elemento.getY()].toString();
		String posicionSur = tableroJugador[elemento.getX()][elemento.getY() - 1].toString();
		String posicionEste = tableroJugador[elemento.getX() + 1][elemento.getY()].toString();
		String posicionNorte = tableroJugador[elemento.getX()][elemento.getY() - 1].toString();
		
		if (elemento.getX() - 1 >= 0 && posicionOeste != tiposElementos.VACIO.toString()) {
			if (posicionOeste == domino.getElemIzquierdo().toString() || 
				posicionOeste == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}

		if (elemento.getY() - 1 >= 0 && posicionSur != tiposElementos.VACIO.toString()) {
			if (posicionSur == domino.getElemIzquierdo().toString() || 
				posicionSur == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}

		if (elemento.getX() + 1 < 9 && posicionEste != tiposElementos.VACIO.toString()) {
			if (posicionEste == domino.getElemIzquierdo().toString() || 
				posicionEste == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}

		if (elemento.getY() + 1 < 9 && posicionNorte != tiposElementos.VACIO.toString()) {
			if (posicionNorte == domino.getElemIzquierdo().toString() || 
				posicionNorte == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}
		return false;
	}

	private boolean tieneElementoAdyacente(Domino domino, CordenadasDomino elementoIzquierda,
			CordenadasDomino elementoDerecha) {
		return comprobarAdyaPorElem(domino, elementoIzquierda) || comprobarAdyaPorElem(domino, elementoDerecha);
	}

	private boolean esPosicionValida(Domino domino, CordenadasDomino elementoIzquierda,
			CordenadasDomino elementoDerecha) {
		/*
		 * valida si no hay elementos en la posicion seleccionada para ubicar domino en
		 * tablero y si adeamas tiene elementos en juego que parmitan colocar el domino
		 * (elementos de igual tipo)
		 */
		if (tableroJugador[elementoIzquierda.getX()][elementoIzquierda.getY()].toString() == tiposElementos.VACIO
				.toString()
				&& tableroJugador[elementoDerecha.getX()][elementoDerecha.getY()].toString() == tiposElementos.VACIO
						.toString()
				&& tieneElementoAdyacente(domino, elementoIzquierda, elementoDerecha)) {
			return true;
		}
		return false;

	}

	/*
	 * public void mostrarTablero() { for (int x = 0; x < this.tableroJugador.length
	 * - 1; x++) { System.out.print("|"); for (int y = 0; y <
	 * this.tableroJugador[x].length - 1; y++) { if
	 * (this.tableroJugador[x][y].getDescripcion() ==
	 * tiposElementos.CASTILLO.toString()) { System.out.print("CASTI"); } else {
	 * System.out.print(this.tableroJugador[x][y]); } if (y !=
	 * this.tableroJugador[x].length - 1) System.out.print("\t"); }
	 * System.out.println("|"); } }
	 */

	public void mostrarTablero() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (tableroJugador[i][j].getDescripcion() == "CASTILLO") {
					System.out.print("CASTI" + "\t");
				} else {
					System.out.print(tableroJugador[i][j] + "\t");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}