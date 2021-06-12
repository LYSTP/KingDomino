package clases;

import java.util.ArrayList;
import java.util.List;

import clases.Elemento.tiposElementos;

public class Tablero {

	private List<Domino> dominos;
	private Elemento[][] tableroJugador = new Elemento[9][9];
	private int totalBoardScore = 0;
	private int cantTerrenoColocado = 0;
	private int cantCorona = 0;

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

	public void limitarTablero(CordenadasDomino elementoIzquierda, CordenadasDomino elementoDerecha) {

		int minimoEnX = Math.min(elementoIzquierda.getX(), elementoDerecha.getX());
		int maximoEnX = Math.max(elementoIzquierda.getX(), elementoDerecha.getX());
		int minimoEnY = Math.min(elementoIzquierda.getY(), elementoDerecha.getY());
		int maximoEnY = Math.max(elementoIzquierda.getY(), elementoDerecha.getY());

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j > minimoEnX + 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISP, 0);
				}
				if (j < maximoEnX - 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISP, 0);
				}
				if (i > minimoEnY + 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISP, 0);
				}
				if (i < maximoEnY - 4) {
					tableroJugador[j][i] = new Elemento(tiposElementos.NO_DISP, 0);
				}
			}
		}
	}

	public boolean colocarDomino(Domino domino, CordenadasDomino elementoIzquierda, CordenadasDomino elementoDerecha) {

		if (esPosicionValida(domino, elementoIzquierda, elementoDerecha)) {
			tableroJugador[elementoIzquierda.getX()][elementoIzquierda.getY()] = domino.getElemIzquierdo();
			tableroJugador[elementoDerecha.getX()][elementoDerecha.getY()] = domino.getElemDerecho();

			limitarTablero(elementoIzquierda, elementoDerecha);
			cantTerrenoColocado++;
			this.cantCorona += domino.getElemDerecho().getCoronas() + domino.getElemIzquierdo().getCoronas();
			return true;
		}
		return false;

	}

	// Comprueba por cada elemento del domino si posee elementos compatibles para
	// colocarlos, es decir mismo tipo o castillo.
	public boolean comprobarAdyaPorElem(Elemento elemento, CordenadasDomino coordenada) {

		// comparo arriba
		if (coordenada.getX() - 1 >= 0 && tableroJugador[coordenada.getX() - 1][coordenada.getY()]
				.toString() != tiposElementos.VACIO.toString()) {
			if (tableroJugador[coordenada.getX() - 1][coordenada.getY()].toString() == elemento.toString()
					|| tableroJugador[coordenada.getX() - 1][coordenada.getY()].toString() == tiposElementos.CASTILLO
							.toString()) {
				return true;
			}
		}

		// comparo a la izquierda
		if (coordenada.getY() - 1 >= 0 && tableroJugador[coordenada.getX()][coordenada.getY() - 1]
				.toString() != tiposElementos.VACIO.toString()) {
			if (tableroJugador[coordenada.getX()][coordenada.getY() - 1].toString() == elemento.toString()
					|| tableroJugador[coordenada.getX()][coordenada.getY() - 1].toString() == tiposElementos.CASTILLO
							.toString()) {
				return true;
			}
		}

		// comparo a la derecha
		if (coordenada.getY() + 1 < 9 && tableroJugador[coordenada.getX()][coordenada.getY() + 1]
				.toString() != tiposElementos.VACIO.toString()) {
			if (tableroJugador[coordenada.getX()][coordenada.getY() + 1].toString() == elemento.toString()
					|| tableroJugador[coordenada.getX()][coordenada.getY() + 1].toString() == tiposElementos.CASTILLO
							.toString()) {
				return true;
			}
		}

		// comparo abajo
		if (coordenada.getX() + 1 < 9 && tableroJugador[coordenada.getX() + 1][coordenada.getY()]
				.toString() != tiposElementos.VACIO.toString()) {
			if (tableroJugador[coordenada.getX() + 1][coordenada.getY()].toString() == elemento.toString()
					|| tableroJugador[coordenada.getX() + 1][coordenada.getY()].toString() == tiposElementos.CASTILLO
							.toString()) {
				return true;
			}
		}
		return false;
	}

	private boolean tieneElementoAdyacente(Domino domino, CordenadasDomino elementoIzquierda,
			CordenadasDomino elementoDerecha) {
		return comprobarAdyaPorElem(domino.getElemIzquierdo(), elementoIzquierda)
				|| comprobarAdyaPorElem(domino.getElemDerecho(), elementoDerecha);
	} // Lo hace con los 2 lados...

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

	public int puntajeTotal() {
		int acumPuntos = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int puntajePropiedad = calcularPuntajePreeliminar(i, j);
				acumPuntos += puntajePropiedad;
			}
		}

		System.out.println("Puntaje Final:" + acumPuntos);

		return acumPuntos;
	}

	private void puntajeTerritorios(String elementoTipoTerreno, int x, int y, int[] puntosPropiedades) {

		if (x >= 0 && x < tableroJugador.length && y >= 0 && y < tableroJugador[x].length) {
			Elemento elementoActual = tableroJugador[x][y];
			if (elementoActual == null)
				return;
			if (!elementoActual.isComputado()) {
				if (elementoActual.getDescripcion().equals(elementoTipoTerreno)) {
					elementoActual.setComputado(true);
					int acumPuntos = puntosPropiedades[0] + 1;
					puntosPropiedades[0] = acumPuntos;
					int cantCoronas = puntosPropiedades[1] + elementoActual.getCoronas();
					puntosPropiedades[1] = cantCoronas;
					// Derecha
					puntajeTerritorios(elementoTipoTerreno, x + 1, y, puntosPropiedades);

					// Izquierda
					puntajeTerritorios(elementoTipoTerreno, x - 1, y, puntosPropiedades);

					// Arriba
					puntajeTerritorios(elementoTipoTerreno, x, y + 1, puntosPropiedades);

					// Abajo
					puntajeTerritorios(elementoTipoTerreno, x, y - 1, puntosPropiedades);
				}
			}
		}
	}

	private int calcularPuntajePreeliminar(int x, int y) {

		Elemento elemento = tableroJugador[x][y];

		if (elemento == null)
			return 0;

		int[] puntosPropiedades = new int[2];
		puntosPropiedades[0] = 0;
		puntosPropiedades[1] = 0;

		puntajeTerritorios(elemento.getDescripcion(), x, y, puntosPropiedades);

		return (puntosPropiedades[0] * puntosPropiedades[1]);
	}

	public void mostrarTablero() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.printf("%-10s", tableroJugador[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	public int getCantTerrenoColocado() {
		return cantTerrenoColocado;
	}

	public int getCantCorona() {
		return cantCorona;
	}

	public void setCantCorona(int cantCorona) {
		this.cantCorona = cantCorona;
	}
}