
public class Domino {

	private Elemento elemIzquierdo;
	private Elemento elemDerecho;
	private boolean tieneRey;
	private int numero;

	public Domino(Elemento elemIzquierdo, Elemento elemDerecho) {
		this.elemIzquierdo = elemIzquierdo;
		this.elemDerecho = elemDerecho;

		this.elemDerecho.asignarElemIzq(elemIzquierdo);
		this.elemIzquierdo.asignarElemDer(elemDerecho);
	}

	public Domino(Elemento castillo) {
		this.elemIzquierdo = castillo;
		this.elemDerecho = elemIzquierdo;
	}

	public boolean puedenUnir(Domino domino) {
		boolean sal = false;

		if (this.elemDerecho.compareTo(domino.elemDerecho) == 0)
			sal = true;
		if (this.elemDerecho.compareTo(domino.elemIzquierdo) == 0)
			sal = true;
		if (this.elemIzquierdo.compareTo(domino.elemDerecho) == 0)
			sal = true;
		if (this.elemIzquierdo.compareTo(domino.elemIzquierdo) == 0)
			sal = true;

		return sal;
	}
	
	public Elemento getElemIzquierdo() {
		return elemIzquierdo;
	}
	
	public Elemento getElemDerecho() {
		return elemDerecho;
	}

	@Override
	public String toString() {
		return elemIzquierdo.toString() + " + " + elemDerecho.toString();
	}
}
