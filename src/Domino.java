
public class Domino {
	
	private Elemento elemIzq;
	private Elemento elemDer;
	private boolean tieneRey;
	private int numero;
	
	
	public Domino(Elemento elemIzq, Elemento elemDer) {
		this.elemIzq = elemIzq;
		this.elemDer = elemDer;
	}


	public boolean puedenUnir(Domino domino) {
		boolean sal = false;
		
		if (this.elemDer.compareTo(domino.elemDer) == 0)
			sal = true;
		if (this.elemDer.compareTo(domino.elemIzq) == 0)
			sal = true;
		if (this.elemIzq.compareTo(domino.elemDer) == 0)
			sal = true;
		if (this.elemIzq.compareTo(domino.elemIzq) == 0)
			sal = true;
		
		
		return sal;
	}
	
	@Override
	public String toString() {
		return elemDer.toString() + " + " + elemIzq.toString();
	}
}
