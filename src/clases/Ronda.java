package clases;

import java.util.List;
import java.util.Scanner;

public class Ronda {
	
	static Scanner reader = new Scanner(System.in);

	public static void nuevaRonda(List<Jugador> jugadores, List<Domino> dominos) {
		for (Jugador jugador : jugadores) {

			turnoJugador(jugador, dominos);

			if (jugador.getDominoSeleccionado() != null) {
				CordenadasDomino coordenadaElementoIzquierdo = new CordenadasDomino();
				CordenadasDomino coordenadaElementoDerecho = new CordenadasDomino();

				System.out.println("Indique posición para elemento izquierdo del Domino ");
				System.out.println("X: ");
				//Scanner sc_iz = new Scanner(System.in);
				//coordenadaElementoIzquierdo.setX(sc_iz.nextInt());
				coordenadaElementoIzquierdo.setX(reader.nextInt());
				reader.nextLine();
				System.out.println("Y: ");
				//coordenadaElementoIzquierdo.setY(sc_iz.nextInt());
				coordenadaElementoIzquierdo.setY(reader.nextInt());
				reader.nextLine();
				System.out.println("Indique posición para elemento derecho del Domino ");
				System.out.println("X: ");
				//Scanner sc_der = new Scanner(System.in);
				//coordenadaElementoDerecho.setX(sc_der.nextInt());
				coordenadaElementoDerecho.setX(reader.nextInt());
				reader.nextLine();
				System.out.println("Y: ");
				//coordenadaElementoDerecho.setY(sc_der.nextInt());
				coordenadaElementoDerecho.setY(reader.nextInt());
				reader.nextLine();
				
				
				//sc_iz.close();
				//sc_der.close();

				if (jugador.posicionarDominoEnTablero(coordenadaElementoIzquierdo, coordenadaElementoDerecho)) {
					System.out.println("Se ubico el domino " + jugador.getDominoSeleccionado().toString() + " en ("
							+ coordenadaElementoIzquierdo.getX() + ", " + coordenadaElementoIzquierdo.getY() + ") ("
							+ coordenadaElementoDerecho.getX() + ", " + coordenadaElementoDerecho.getY() + ")");
				} else {
					System.out.println("No se pudo ubicar domino\n");
				}

				jugador.getTablero().mostrarTablero();
			}

		}
	}

	private static void turnoJugador(Jugador jugador, List<Domino> dominos) {

		System.out.println("Elegir uno de los " + dominos.size() + " dominos disponibles: \n");

		for (Domino domino : dominos) {
			System.out.println(domino.toString() + "\n");
		}

		Scanner sc = new Scanner(System.in);
		
		//int entrada = sc.nextInt();
		int entrada = reader.nextInt();

		while (!(entrada >= 1 && entrada <= dominos.size())) {
			System.out.println("Entrada invalida, vuelva a ingresar un numero entre 1 y " + dominos.size() + "\n");
			//entrada = sc.nextInt();
			entrada = reader.nextInt();
		}

		jugador.setDominoSeleccionado(dominos.get(entrada - 1));

		dominos.remove(entrada - 1);

		//sc.close();
		
		reader.nextLine();

	}

}
