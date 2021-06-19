package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import clases.Elemento.tiposElementos;

public class Baraja {

	private int cantDominos = 48;
	private int dominosRepartidos;
	private List<Domino> dominos = new ArrayList<Domino>();

	public void mezclar() {
		Random rndm = new Random();
		Collections.shuffle(dominos, rndm);

		this.dominosRepartidos = 0;
	}

	public List<Domino> repartir() {

		if (this.cantDominos - this.dominosRepartidos == 0)// si los dominos de la baraja = dominos repartidos
			return null; // no reparte

		List<Domino> salida = new ArrayList<Domino>();
		int cantDominos = 4; // se reparten 4 dominos en la mesa
//		int i = this.dominosRepartidos, cambiamos por 0 porque si no se va de los limites del array
		for (int i = 0; i < this.dominosRepartidos + cantDominos; i++) {
			salida.add(this.dominos.get(i));
		}

		// Remuevo mano de la Baraja
		for (Domino domino : salida) {
			dominos.remove(domino);
		}

		this.dominosRepartidos += cantDominos;

		Collections.sort(salida);
		return salida;
		// retorna las fichas que pudo repartir
	}

	public Baraja(int cant, ArrayList<Domino> dom) {
		this.cantDominos = cant;
		this.dominos = dom;
		mezclar();
	}

	public int getSizeDominos() {
		return this.dominos.size();
	}

	public List<Domino> getBaraja() {
		return dominos;
	}

}