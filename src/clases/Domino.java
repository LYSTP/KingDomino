package clases;

public class Domino implements Comparable<Domino> {

	private Elemento elemIzquierdo;
	private Elemento elemDerecho;
	private boolean tieneRey; // para una parte mas avanzada del proyecto
	private int numero;

	public Domino(Elemento elemIzquierdo, Elemento elemDerecho) {
		this.elemIzquierdo = elemIzquierdo;// se forman los dominos combinados
		this.elemDerecho = elemDerecho;

		this.elemDerecho.asignarElemIzq(elemIzquierdo);// llena el lado ocupado de cada elemento.
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

	public Integer getNumero() {
		return (Integer) numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return elemIzquierdo.toString() + " + " + elemDerecho.toString();
	}

	@Override
	public int compareTo(Domino o) {
		return this.numero - o.getNumero();
	}
}
