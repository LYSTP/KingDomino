package swing;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Domino;
import clases.GestionJuego;
import clases.Jugador;

public class JuegoVista {

	private CardLayout cardLayout = new CardLayout(0, 0);
	private JFrame frame = new JFrame();
	JPanel panelLabels = new JPanel();
	private List<Domino> mano;
	private List<Jugador> jugadores;
	private Jugador jugador_1;
	private Jugador jugador_2;
	private VentanaSala vs;
	GestionJuego gestionJuego;

	public JuegoVista(GestionJuego gestionJuego) throws IOException {
		this.gestionJuego = gestionJuego;
		this.mano = gestionJuego.getMano();
		this.jugadores = gestionJuego.getJugadores();
		inicializarFrame();		
	}
	
	public JuegoVista() throws IOException{
		this.gestionJuego = gestionJuego;
		this.mano = gestionJuego.getMano();
		this.jugadores = gestionJuego.getJugadores();
		inicializarFrame();	
	}

	public static void main(String[] args) throws IOException {
		new JuegoVista();
	}

	private void añadir() throws IOException {
		panelLabels.add(vs = new VentanaSala(this.mano,this.jugadores), "4");
	}
	
	private void inicializarFrame() throws IOException {
		panelLabels.setLayout(cardLayout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Dimension del frame con la cual los elementos del tipo boton que forman la
		// matriz muestran bien la imagen
		frame.getContentPane().setPreferredSize(new Dimension(1800,1020));
		frame.setResizable(true);
		añadir();
		frame.add(panelLabels);
		frame.pack();
		frame.setVisible(true);
	}

	public VentanaSala getVs() {
		return vs;
	}

	public void setVs(VentanaSala vs) {
		this.vs = vs;
	}
	

}
