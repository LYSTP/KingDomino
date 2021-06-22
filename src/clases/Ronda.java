package clases;

import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import swing.BotonPulsadoListener;
import swing.JuegoVista;
import swing.PosicionTableroListener;
import swing.VentanaSala;

public class Ronda {

	static Scanner reader = new Scanner(System.in);

	private static int eleccionDomino = 0;

	public static void nuevaRonda(List<Jugador> jugadores, List<Domino> dominos) {
		
		
		JuegoVista juegoVista = null;
		try {
			juegoVista = new JuegoVista(jugadores, dominos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		for (Jugador jugador : jugadores) {
			jugador.getTablero().mostrarTablero();
			System.out.println();
						
			turnoJugador(jugador, dominos, juegoVista);
			
			System.out.println("Eligio el Domino: " + eleccionDomino);
			
			int posicionImagen = 0;
			
			switch (eleccionDomino) {	
			case 1:
				posicionImagen = 0;
				break;
			case 2:
				posicionImagen = 2;
				break;
			case 3:
				posicionImagen = 4;
				break;
			case 4:
				posicionImagen = 6;
				break;
			}
			
			//Recupero imagen elemento izquierdo de domino elegido para poder posicionar en tablero
			//Image elemIzquierdoSelec = (Image) juegoVista.getVs().getDominoVista().getDominosAelegir().get(posicionImagen).getIcon();
			
			juegoVista.getVs().getDominoVista().getDominosAelegir().get(posicionImagen).getIcon();


			if (jugador.getDominoSeleccionado() != null) {
				CordenadasDomino coordenadaElementoIzquierdo = new CordenadasDomino();
				CordenadasDomino coordenadaElementoDerecho = new CordenadasDomino();

				int c1, c2, f1, f2;
				int cont = 0;
				// Scanner reader = new Scanner(System.in);

				boolean state = false;

				while (state == false && cont < 5) {
					System.out.println("Indique posición para elemento izquierdo del Domino ");
					System.out.println("X: ");
					
					//Coordenadas elemento izquierdo
					juegoVista.getVs().getCv().mensajeDominoElemento("Indique posición para elemento izquierdo del Domino ");
					
					while(PosicionTableroListener.getNumeroBoton() == null) {
						
						 try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}
					
					String posicionIzquierdo = PosicionTableroListener.getNumeroBoton();
					
					String[] coordenadasIzquierdo;
					
					coordenadasIzquierdo = posicionIzquierdo.split(",");
										
					c1=Integer.parseInt(coordenadasIzquierdo[0]);
					
					//c1 = reader.nextInt();
					//reader.nextLine();
					
					
					System.out.println("Y: ");
					// coordenadaElementoIzquierdo.setY(sc_iz.nextInt());
					
					//f1 = reader.nextInt();
					//reader.nextLine();
					
					String[] coordenadasy;
					
					coordenadasy = coordenadasIzquierdo[1].split(" ");
					
					f1=Integer.parseInt(coordenadasy[1]);
					
					System.out.println("(X:" + c1 + ", " + "Y:" + f1 + ")");

					//Coordenadas elemento derecho
					juegoVista.getVs().getCv().mensajeDominoElemento("Indique posición para elemento derecho del Domino ");
										
					System.out.println("Indique posición para elemento derecho del Domino ");
					System.out.println("X: ");
					
					//Para que simule la pausa del ingreso por teclado
					//PosicionTableroListener.setNumeroBoton(null);					
					String PosicionAnterior = PosicionTableroListener.getNumeroBoton();
					
					while(PosicionTableroListener.getNumeroBoton() == PosicionAnterior) {
						
						 try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}
					
					String posicionDerecho= PosicionTableroListener.getNumeroBoton();
					
					String[] coordenadasDerecho;
					
					coordenadasDerecho = posicionDerecho.split(",");
										
					c2=Integer.parseInt(coordenadasDerecho[0]);
									
					//c2 = reader.nextInt();
					//reader.nextLine();
					
					System.out.println("Y: ");
					
					String[] coordenadasYder;
					
					coordenadasYder = coordenadasDerecho[1].split(" ");
					
					f2=Integer.parseInt(coordenadasYder[1]);
					
					System.out.println("(X:" + c2 + ", " + "Y:" + f2 + ")");
					
					//Se le suma uno a la posicion ya que es el elemento derecho (izquierdo mas 1 da el elemento derecho del domino a colocar)					
					//juegoVista.getVs().getTablero_1().getPosicionTablero().get(Integer.parseInt(juegoVista.getVs().getTablero_1().getMapPosiciones().get(PosicionTableroListener.getNumeroBoton()))).setIcon(juegoVista.getVs().getDominoVista().getDominosAelegir().get(posicionImagen + 1).getIcon());
			
					//f2 = reader.nextInt();
					//reader.nextLine();

					// verifico adyacencia
					if (((Math.abs(c1 - c2) == 1 && f1 == f2) || (Math.abs(f2 - f1) == 1 && c1 == c2))) {

						coordenadaElementoIzquierdo.setX(c1);
						coordenadaElementoIzquierdo.setY(f1);
						coordenadaElementoDerecho.setX(c2);
						coordenadaElementoDerecho.setY(f2);

						// verifico si se puede ubicar el domino
						if (jugador.posicionarDominoEnTablero(coordenadaElementoIzquierdo, coordenadaElementoDerecho)) {
							System.out.println("Se ubico el domino " + jugador.getDominoSeleccionado().toString()
									+ " en (" + coordenadaElementoIzquierdo.getX() + ", "
									+ coordenadaElementoIzquierdo.getY() + ") (" + coordenadaElementoDerecho.getX()
									+ ", " + coordenadaElementoDerecho.getY() + ")");
							state = true;
							
							//Pinto si esta todo ok los elementos
							juegoVista.getVs().getTablero_1().getPosicionTablero().get(Integer.parseInt(juegoVista.getVs().getTablero_1().getMapPosiciones().get(posicionIzquierdo))).setIcon(juegoVista.getVs().getDominoVista().getDominosAelegir().get(posicionImagen).getIcon());
							
							juegoVista.getVs().getTablero_1().getPosicionTablero().get(Integer.parseInt(juegoVista.getVs().getTablero_1().getMapPosiciones().get(posicionDerecho))).setIcon(juegoVista.getVs().getDominoVista().getDominosAelegir().get(posicionImagen + 1).getIcon());
							
							
							//Limpio consola de swing
							juegoVista.getVs().getCv().limpiaConsola();
							
						} else {
							jugador.getTablero().mostrarTablero();
							System.out.println("No se pudo ubicar domino\n");
							System.out.println("Cometiste " + ++cont + "/5 errores");
						}
					} else {
						jugador.getTablero().mostrarTablero();
						System.out.println("Cometiste " + ++cont + "/5 errores");
						System.out.println("Poner coordenadas adyacentes");
					}
				} // Agregar un if para verificar disponibilidad en el tablero.

				// sc_iz.close();
				// sc_der.close();
				// reader.close();
				jugador.getTablero().mostrarTablero();
			} else
				System.out.println("El jugador no ha seleccionado un domino");

		}

	}

	private static void turnoJugador(Jugador jugador, List<Domino> dominos, JuegoVista juegoVista) {

		System.out.println("Turno del jugador: " + jugador.getId() + " " + jugador.getNombre());

		System.out.println("Elegir uno de los " + dominos.size() + " dominos disponibles: \n");

		juegoVista.getVs().getCv().jugadorTurno(jugador);

		int i = 0;
		for (Domino domino : dominos) {
			i++;
			System.out.println(i + ")" + domino.toString());
		}
		System.out.println();

		// Para parte grafica se espera que seleccione un domino
		while (BotonPulsadoListener.getNumeroBoton() == null) {

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Integer.parseInt(BotonPulsadoListener.getNumeroBoton());
		System.out.println("ok");

//		int entrada = reader.nextInt();
//		reader.nextLine();
//		while (!(entrada >= 1 && entrada <= dominos.size())) {
//			System.out.println("Entrada invalida, vuelva a ingresar un numero entre 1 y " + dominos.size() + "\n");
//			// entrada = sc.nextInt();
//			entrada = reader.nextInt();
//			reader.nextLine();
//		}

		// int eleccionDomino = 0;

		switch (Integer.parseInt(BotonPulsadoListener.getNumeroBoton())) {

		case 1:
			eleccionDomino = 1;
			break;
		case 2:
			eleccionDomino = 1;
			break;
		case 3:
			eleccionDomino = 2;
			break;
		case 4:
			eleccionDomino = 2;
			break;
		case 5:
			eleccionDomino = 3;
			break;
		case 6:
			eleccionDomino = 3;
			break;
		case 7:
			eleccionDomino = 4;
			break;
		case 8:
			eleccionDomino = 4;
			break;
		}

		jugador.setDominoSeleccionado(dominos.get(eleccionDomino - 1));

		dominos.remove(eleccionDomino - 1);

		// reader.close();
	}

}
