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
		} ///
	}

	public boolean colocarDomino(Domino domino, CordenadasDomino elementoIzquierda, CordenadasDomino elementoDerecha) {

		if (esPosicionValida(domino, elementoIzquierda, elementoDerecha)) {
			tableroJugador[elementoIzquierda.getX()][elementoIzquierda.getY()] = domino.getElemIzquierdo();
			tableroJugador[elementoDerecha.getX()][elementoDerecha.getY()] = domino.getElemDerecho(); /// GENTE, ESTABA 2 VECES EL ELEMENTOIzquierda en el segundo jajajajaj
			return true;
		}
		return false;

	}

	// Comprueba por cada elemento del domino si posee elementos compatibles para
	// colocarlos, es decir mismo tipo o castillo.
	public boolean comprobarAdyaPorElem(Elemento elemento, CordenadasDomino coordenada) {

		//comparo arriba
		if (coordenada.getX()-1 >= 0 && tableroJugador[ coordenada.getX()-1][coordenada.getY()].toString() != tiposElementos.VACIO.toString()) {
			if (tableroJugador[ coordenada.getX()-1][coordenada.getY()].toString() == elemento.toString() || 
					tableroJugador[ coordenada.getX()-1][coordenada.getY()].toString() == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}
		
		//comparo a laizquierda
		if (coordenada.getY()-1 >= 0 && tableroJugador[coordenada.getX()][coordenada.getY()-1].toString() != tiposElementos.VACIO.toString()) { 
			if (tableroJugador[coordenada.getX()][coordenada.getY()-1].toString() == elemento.toString() || 
					tableroJugador[coordenada.getX()][coordenada.getY()-1].toString() == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}

		//comparo abajo
		if (coordenada.getY()+1 < 9 && tableroJugador[coordenada.getY()+1][coordenada.getY()].toString() != tiposElementos.VACIO.toString()) { 
			if (tableroJugador[coordenada.getY()+1][coordenada.getY()].toString() == elemento.toString() || 
					tableroJugador[coordenada.getY()+1][coordenada.getY()].toString() == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}
		
		//comparo a la derecha
		if (coordenada.getX()+1 < 9 && tableroJugador[coordenada.getX()][coordenada.getX()+1].toString() != tiposElementos.VACIO.toString()) { 
			if (tableroJugador[coordenada.getX()][coordenada.getX()+1].toString() == elemento.toString() || 
					tableroJugador[coordenada.getX()][coordenada.getX()+1].toString() == tiposElementos.CASTILLO.toString()) {
				return true;
			}
		}
		return false;
	}

	private boolean tieneElementoAdyacente(Domino domino, CordenadasDomino elementoIzquierda,
			CordenadasDomino elementoDerecha) {
		return comprobarAdyaPorElem(domino.getElemIzquierdo(), elementoIzquierda) || comprobarAdyaPorElem(domino.getElemDerecho(), elementoDerecha);
	} //Lo hace con los 2 lados...

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

	public void mostrarTablero() { // se arreglo el formato.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
					System.out.printf("%-10s",tableroJugador[i][j]);
			System.out.println();
		}
		System.out.println();
	}
}