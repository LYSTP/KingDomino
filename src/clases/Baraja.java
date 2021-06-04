package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baraja {

	private int cantDominos;
	private int dominosRepartidos;
	private List<Domino> dominos = new ArrayList<Domino>();

	public void mezclar() {
		Random rndm = new Random();
		Collections.shuffle(dominos, rndm);

		this.dominosRepartidos = 0;
	}
	public Baraja(int cant,ArrayList<Domino> dom) {
		this.cantDominos=cant;
		this.dominos=dom;
		mezclar();
	}
	public List<Domino> repartir() {

		if (this.cantDominos - this.dominosRepartidos == 0)// si los dominos de la baraja = dominos repartidos
			return null; // no reparte

		List<Domino> salida = new ArrayList<Domino>();
		int cantDominos = 4; // se reparten 4 dominos en la mesa
		for (int i = this.dominosRepartidos; i < this.dominosRepartidos + cantDominos; i++) {
			salida.add(this.dominos.get(i));
		}

		this.dominosRepartidos += cantDominos;

		Collections.sort(salida);
		return salida;
		// retorna las fichas que pudo repartir
	}
	/*
	public Baraja() {
		
		Elemento elemCesped = new Elemento("Cesped", 0);
		Elemento elemTierra = new Elemento("Tierra", 0);
		Elemento elemAgua = new Elemento("Agua", 0);
		Elemento elemBosque = new Elemento("Bosque", 0);
		Elemento elemPastizal = new Elemento("Pastizal", 0);
		Elemento elemMina = new Elemento("Mina", 0);

		// Con 1 corona
		Elemento elemPastizalCorona = new Elemento("Pastizal", 1);
		Elemento elemBosqueCorona = new Elemento("Bosque", 1);
		Elemento elemAguaCorona = new Elemento("Agua", 1);
		Elemento elemCespedCorona = new Elemento("Cesped", 1);
		Elemento elemTierraCorona = new Elemento("Corona", 1);
		Elemento elemMinaCorona = new Elemento("Mina", 1);

		// con 2 coronas
		Elemento elemTierraCorona2 = new Elemento("Tierra", 2);
		Elemento elemCespedCorona2 = new Elemento("Cesped", 2);
		Elemento elemMinaCorona2 = new Elemento("Mina", 2);

		// 3 coronas
		Elemento elemMinaCorona3 = new Elemento("Mina", 3);

		// Solo agua
		Domino dom1 = new Domino(elemAgua, elemAgua);
		for (int i = 0; i < 3; i++) {
			dominos.add(dom1);
		}

		// Solo bosque
		Domino dom2 = new Domino(elemBosque, elemBosque);
		for (int i = 0; i < 4; i++) {
			dominos.add(dom2);
		}

		// Solo Pastizal
		Domino dom3 = new Domino(elemPastizal, elemPastizal);
		for (int i = 0; i < 2; i++) {
			dominos.add(dom3);
		}

		// Solo Cesped
		Domino dom4 = new Domino(elemCesped, elemCesped);
		for (int i = 0; i < 2; i++) {
			dominos.add(dom4);
		}

		// Pastizal con corona + tierra
		Domino dom5 = new Domino(elemPastizalCorona, elemTierra);
		dominos.add(dom5);

		// Bosque + cesped
		Domino dom6 = new Domino(elemBosque, elemCesped);
		dominos.add(dom6);

		// Pastizal con corona + mina
		Domino dom7 = new Domino(elemPastizalCorona, elemMina);
		dominos.add(dom7);

		// Pastizal con corona + cesped
		Domino dom8 = new Domino(elemPastizalCorona, elemCesped);
		dominos.add(dom8);

		// Pastizal + agua
		Domino dom9 = new Domino(elemPastizal, elemAgua);
		dominos.add(dom9);

		// Pastizal + tierra 2 coronas
		Domino dom10 = new Domino(elemPastizal, elemTierraCorona2);
		dominos.add(dom10);

		// Bosque corona + pastizal
		Domino dom11 = new Domino(elemBosqueCorona, elemPastizal);
		for (int i = 0; i < 4; i++) {
			dominos.add(dom11);
		}

		// Agua corona + pastizal
		Domino dom12 = new Domino(elemAguaCorona, elemPastizal);
		for (int i = 0; i < 2; i++) {
			dominos.add(dom12);
		}

		// Cesped 2 coronas + pastizal
		Domino dom13 = new Domino(elemCespedCorona2, elemPastizal);
		dominos.add(dom13);

		// Tierra 2 coronas + cesped
		Domino dom14 = new Domino(elemTierraCorona2, elemCesped);
		dominos.add(dom14);

		// Bosque corona + cesped
		Domino dom15 = new Domino(elemBosqueCorona, elemCesped);
		dominos.add(dom15);

		// Bosque corona + agua
		Domino dom16 = new Domino(elemBosqueCorona, elemAgua);
		dominos.add(dom16);

		// Cesped corona + pastizal
		Domino dom17 = new Domino(elemCespedCorona, elemPastizal);
		dominos.add(dom17);

		// Mina 2 coronas + tierra
		Domino dom18 = new Domino(elemMinaCorona2, elemTierra);
		for (int i = 0; i < 2; i++) {
			dominos.add(dom18);
		}

		// Agua corona + bosque
		Domino dom19 = new Domino(elemAguaCorona, elemBosque);
		for (int i = 0; i < 4; i++) {
			dominos.add(dom19);
		}

		// Pastizal + bosque
		Domino dom20 = new Domino(elemPastizal, elemBosque);
		dominos.add(dom20);

		// Solo tierra
		Domino dom21 = new Domino(elemTierra, elemTierra);
		dominos.add(dom21);

		// Pastizal + tierra
		Domino dom22 = new Domino(elemPastizal, elemTierra);
		dominos.add(dom22);

		// Pastizal corona + agua
		Domino dom23 = new Domino(elemPastizalCorona, elemAgua);
		dominos.add(dom23);

		// Tierra corona + pastizal
		Domino dom24 = new Domino(elemTierraCorona, elemPastizal);
		dominos.add(dom24);

		// Bosque + agua
		Domino dom25 = new Domino(elemBosque, elemAgua);
		dominos.add(dom25);

		// Cesped 2 coronas + agua
		Domino dom26 = new Domino(elemCespedCorona2, elemAgua);
		dominos.add(dom26);

		// Mina 3 coronas + pastizal
		Domino dom27 = new Domino(elemMinaCorona3, elemPastizal);
		dominos.add(dom27);

		// Mina 2 coronas + pastizal
		Domino dom28 = new Domino(elemMinaCorona2, elemPastizal);
		dominos.add(dom28);

		// Cesped + pastizal
		Domino dom29 = new Domino(elemPastizal, elemCesped);
		dominos.add(dom29);

		// Pastizal corona + bosque
		Domino dom30 = new Domino(elemPastizalCorona, elemBosque);
		dominos.add(dom30);

		// Cesped Corona + agua
		Domino dom31 = new Domino(elemCespedCorona, elemAgua);
		dominos.add(dom31);

		// Tierra corona + cesped
		Domino dom32 = new Domino(elemTierraCorona, elemCesped);
		dominos.add(dom32);

		// Mina corona + pastizal
		Domino dom33 = new Domino(elemMinaCorona, elemPastizal);
		dominos.add(dom33);

		int i = 1;
		for (Domino domino : dominos) {
			domino.setNumero(i);
			i++;
		}
		

		mezclar();// ok
	}
	*/

	public int getSizeDominos() {
		return this.dominos.size();
	}

	public List<Domino> getMazo() {
		return dominos;
	}
	
}
