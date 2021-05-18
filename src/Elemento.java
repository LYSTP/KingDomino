
public class Elemento implements Comparable<Elemento> {

	private String descripcion;
	private int coronas;

	public Elemento(String descripcion, int coronas) {
		this.descripcion = descripcion;
		this.coronas = coronas;
	}

	@Override
	public int compareTo(Elemento elemento) {

		return this.descripcion.compareTo(elemento.descripcion);
	}
	
	@Override
	public String toString() {
		return descripcion;
	}
}
