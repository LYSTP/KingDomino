package clases;

import java.util.List;
import java.util.Scanner;

public class Ronda {
	
	static Scanner reader = new Scanner(System.in);

	public static void nuevaRonda(List<Jugador> jugadores, List<Domino> dominos) {
		
		for (Jugador jugador : jugadores) {
			jugador.getTablero().mostrarTablero();
			System.out.println();
			turnoJugador(jugador, dominos);

			if (jugador.getDominoSeleccionado() != null) {
				CordenadasDomino coordenadaElementoIzquierdo = new CordenadasDomino();
				CordenadasDomino coordenadaElementoDerecho = new CordenadasDomino();

				int c1,c2,f1,f2;
				int cont = 0;
				//Scanner reader = new Scanner(System.in);
				
				boolean state = false;
				
				while(state == false && cont < 5) {
					System.out.println("Indique posición para elemento izquierdo del Domino ");
					System.out.println("X: ");
					//Scanner sc_iz = new Scanner(System.in);
					//coordenadaElementoIzquierdo.setX(sc_iz.nextInt());
					c1 = reader.nextInt();
					reader.nextLine();
					System.out.println("Y: ");
					//coordenadaElementoIzquierdo.setY(sc_iz.nextInt());
					f1 = reader.nextInt();
					reader.nextLine();
					System.out.println("Indique posición para elemento derecho del Domino ");
					System.out.println("X: ");
					//Scanner sc_der = new Scanner(System.in);
					//coordenadaElementoDerecho.setX(sc_der.nextInt());
					c2 = reader.nextInt();
					reader.nextLine();
					System.out.println("Y: ");
					//coordenadaElementoDerecho.setY(sc_der.nextInt());
					f2 = reader.nextInt();
					reader.nextLine();
					if( (( Math.abs(c1 - c2) == 1 && f1 == f2 ) || (Math.abs(f2 - f1) == 1 && c1 == c2))) {
						/// ya paso la adyacencia
						coordenadaElementoIzquierdo.setX(c1);
						coordenadaElementoIzquierdo.setY(f1);
						coordenadaElementoDerecho.setX(c2);
						coordenadaElementoDerecho.setY(f2);
						if (jugador.posicionarDominoEnTablero(coordenadaElementoIzquierdo, coordenadaElementoDerecho)) {
							System.out.println("Se ubico el domino " + jugador.getDominoSeleccionado().toString() + " en ("
									+ coordenadaElementoIzquierdo.getX() + ", " + coordenadaElementoIzquierdo.getY() + ") ("
									+ coordenadaElementoDerecho.getX() + ", " + coordenadaElementoDerecho.getY() + ")");
							state = true;
						} 
						else {
							jugador.getTablero().mostrarTablero();
							System.out.println("No se pudo ubicar domino\n");
							System.out.println("Cometiste " + ++cont + "/5 errores");
						}
					}
					else {
						jugador.getTablero().mostrarTablero();
						System.out.println("Cometiste " + ++cont + "/5 errores");
						System.out.println("Poner coordenadas adyacentes");
					}			
				} //Agregar un if para verificar disponibilidad en el tablero.
				
				//sc_iz.close();
				//sc_der.close();
				//reader.close();
				jugador.getTablero().mostrarTablero();
			}
			else
				System.out.println("El jugador no ha seleccionado un domino");

		}
	}

	private static void turnoJugador(Jugador jugador, List<Domino> dominos) {

		System.out.println("Turno del jugador: " + jugador.getId() + " " + jugador.getNombre());
		
		System.out.println("Elegir uno de los " + dominos.size() + " dominos disponibles: \n");
		int i=0;
		for (Domino domino : dominos) {
			i++;
			System.out.println(i + ")" + domino.toString());	
		}
		System.out.println();
	//	Scanner reader = new Scanner(System.in);
		
		//int entrada = sc.nextInt();
		int entrada = reader.nextInt();
		reader.nextLine();
		while (!(entrada >= 1 && entrada <= dominos.size())) {
			System.out.println("Entrada invalida, vuelva a ingresar un numero entre 1 y " + dominos.size() + "\n");
			//entrada = sc.nextInt();
			entrada = reader.nextInt();
			reader.nextLine();
		}

		jugador.setDominoSeleccionado(dominos.get(entrada - 1));

		dominos.remove(entrada - 1);

		//reader.close();
	}
}
