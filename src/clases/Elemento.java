package clases;

public class Elemento implements Comparable<Elemento> {

	private String descripcion;
	private int coronas;

	private Elemento elemIzquierda;
	private Elemento elemDerecha;
	private Elemento elemArriba;

	public String getDescripcion() {
		return descripcion;
	}

	// Agregado 23/05
	// Elemento deberia recibir el tipo y cantidad de coronas y no una descripcion
	public enum tiposElementos {
		CASTILLO, PASTIZAL, AGUA, CESPED, BOSQUE, MINA, TIERRA, CORONA, VACIO,
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private Elemento elemAbajo;

	public Elemento(tiposElementos tipo, int coronas) {
		this.descripcion = tipo.toString();
		this.coronas = coronas;
		this.elemAbajo = null;
		this.elemDerecha = null;
		this.elemIzquierda = null;
		this.elemArriba = null;
	}

	// Para saber si puedo unir un elemento
	public boolean puedeUnirDerecha() {
		return this.elemDerecha == null;
	}

	public boolean puedeUnirIzquierda() {
		return this.elemIzquierda == null;
	}

	public boolean puedeUnirArriba() {
		return this.elemArriba == null;
	}

	public boolean puedeUnirAbajo() {
		return this.elemAbajo == null;
	}

	// Unir elementos
	public boolean asignarElemIzq(Elemento elem) {
		boolean sal = false;

		if (this.elemIzquierda == null) {
			this.elemIzquierda = elem;
			sal = true;
		}

		return sal;
	}

	public boolean asignarElemDer(Elemento elem) {
		boolean sal = false;

		if (this.elemDerecha == null) {
			this.elemDerecha = elem;
			sal = true;
		}

		return sal;
	}

	public boolean asignarElemArriba(Elemento elem) {
		boolean sal = false;

		if (this.elemArriba == null) {
			this.elemArriba = elem;
			sal = true;
		}

		return sal;
	}

	public boolean asignarElemAbajo(Elemento elem) {
		boolean sal = false;

		if (this.elemAbajo == null) {
			this.elemAbajo = elem;
			sal = true;
		}

		return sal;
	}

	@Override
	public int compareTo(Elemento elemento) {
		if (elemento.getDescripcion().equals(tiposElementos.CASTILLO.toString()))
			return 0;

		return this.descripcion.compareTo(elemento.descripcion);
	}

	@Override
	public String toString() {
		return descripcion;
	}

	public boolean tieneCorona() {
		return this.coronas != 0;
	}

	public int getCoronas() {
		return coronas;
	}
}
