package clases;

import java.util.List;

import clases.Elemento.tiposElementos;

public class Tablero {

//		private List<Territorio> territorios; 
//		// pensamos hacer una lista de territorios de elementos para no usar una matriz
	//
//		Domino castillo;
	//
//		public Tablero() {
//			this.castillo = new Domino(new Elemento("Castillo", 0));
//			this.territorios = new LinkedList<Territorio>();
//		}
	//
//		public void agregarDomino(Domino dominoNuevo, Domino dominoTablero) {
	//
//			if (dominoTablero.puedenUnir(dominoNuevo)) {
//				agregar(dominoNuevo);
//			}
//		}
	//
//		private void agregar(Domino dominoNuevo) {
	//
//		}

	// Agregado 23/05
	private List<Domino> dominos;
	private Elemento[][] tableroJugador = new Elemento[10][10];
	private int totalBoardScore = 0;

	// Se inicia un tablero con el castillo como pieza central
	public Tablero() {
		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 8; j++) {
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

	public void mostrarTablero() {
		for (int x = 0; x < this.tableroJugador.length - 1; x++) {
			System.out.print("|");
			for (int y = 0; y < this.tableroJugador[x].length - 1; y++) {
				if (this.tableroJugador[x][y].getDescripcion() == tiposElementos.CASTILLO.toString()) {
					System.out.print("CASTI");
				} else {
					System.out.print(this.tableroJugador[x][y]);
				}
				if (y != this.tableroJugador[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}

}