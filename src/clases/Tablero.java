package clases;

import java.util.LinkedList;
import java.util.List;

public class Tablero {

	private List<Territorio> territorios; 
	// pensamos hacer una lista de territorios de elementos para no usar una matriz

	Domino castillo;

	public Tablero() {
		this.castillo = new Domino(new Elemento("Castillo", 0));
		this.territorios = new LinkedList<Territorio>();
	}

	public void agregarDomino(Domino dominoNuevo, Domino dominoTablero) {

		if (dominoTablero.puedenUnir(dominoNuevo)) {
			agregar(dominoNuevo);
		}
	}

	private void agregar(Domino dominoNuevo) {

	}

}
