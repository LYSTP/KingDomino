package swing;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Domino;

public class JuegoVista {

	private CardLayout cardLayout = new CardLayout(0, 0);
	private JFrame frame = new JFrame();
	JPanel panelLabels = new JPanel();
	private List<Domino> mano;

	public JuegoVista(List<Domino> mano) throws IOException {
		this.mano = mano;
		inicializarFrame();		
	}
	
	public JuegoVista() throws IOException{
		this.mano = mano;
		inicializarFrame();	
	}

	public static void main(String[] args) throws IOException {
		new JuegoVista();
	}

	private void añadir() throws IOException {
		panelLabels.add(new VentanaSala(this.mano), "3");
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


}
