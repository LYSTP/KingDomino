package clases;

import java.util.List;
import java.util.Scanner;

public class Ronda {

	public static void nuevaRonda(List<Jugador> jugadores, List<Domino> dominos) {
		for (Jugador jugador : jugadores) {

			turnoJugador(jugador, dominos);

			if (jugador.getDominoSeleccionado() != null) {
				CordenadasDomino coordenadaElementoIzquierdo = new CordenadasDomino();
				CordenadasDomino coordenadaElementoDerecho = new CordenadasDomino();

				System.out.println("Indique posición para elemento izquierdo del Domino ");
				System.out.println("X: ");
				Scanner sc_iz = new Scanner(System.in);
				coordenadaElementoIzquierdo.setX(sc_iz.nextInt());
				System.out.println("Y: ");
				coordenadaElementoIzquierdo.setY(sc_iz.nextInt());
				System.out.println("Indique posición para elemento derecho del Domino ");
				System.out.println("X: ");
				Scanner sc_der = new Scanner(System.in);
				coordenadaElementoDerecho.setX(sc_der.nextInt());
				System.out.println("Y: ");
				coordenadaElementoDerecho.setY(sc_der.nextInt());

				sc_iz.close();
				sc_der.close();

				jugador.posicionarDominoEnTablero(coordenadaElementoIzquierdo, coordenadaElementoDerecho);
			}

		}
	}

	private static void turnoJugador(Jugador jugador, List<Domino> dominos) {

		System.out.println("Elegir uno de los " + dominos.size() + " dominos disponibles");

		for (Domino domino : dominos) {
			System.out.println(domino.toString());
		}

		try {
			int entrada = new Scanner(System.in).nextInt();

			while (!(entrada >= 1 && entrada <= dominos.size())) {
				System.out.println("Entrada invalida, vuelva a ingresar un numero entre 1 y " + dominos.size());
				entrada = new Scanner(System.in).nextInt();
			}
			
			jugador.setDominoSeleccionado(dominos.get(entrada));

			dominos.remove(entrada - 1);

		} catch (Exception e) {

		}

	}

}
