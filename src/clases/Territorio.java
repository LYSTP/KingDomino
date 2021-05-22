package clases;
import java.util.LinkedList;
import java.util.List;

public class Territorio {

	private List<Elemento> elementos = new LinkedList<Elemento>();
	private String tipo;

	public Territorio(String tipo, Elemento elemento) {
		this.tipo = tipo;
		this.elementos.add(elemento);
	}

	public void agregarElemento(Elemento elemento) {
		this.elementos.add(elemento);
	}

	public int calculaPuntaje() {
		int cantCoronas = 0;
		for (Elemento elem : elementos) {
			if (elem.tieneCorona())
				cantCoronas += elem.getCoronas();
		}

		return cantCoronas * this.elementos.size();
	}
}
