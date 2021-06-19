package swing;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JuegoVista {

	private CardLayout cardLayout = new CardLayout(0, 0);
	private JFrame frame = new JFrame();
	JPanel panelLabels = new JPanel();

	public JuegoVista() throws IOException {
		inicializarFrame();
	}

	public static void main(String[] args) throws IOException {
		new JuegoVista();
	}

	private void añadir() throws IOException {
		panelLabels.add(new VentanaSala(), "3");
	}

	private void inicializarFrame() throws IOException {
		panelLabels.setLayout(cardLayout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Dimension del frame con la cual los elementos del tipo boton que forman la
		// matriz muestran bien la imagen
		frame.getContentPane().setPreferredSize(new Dimension(1800, 960));
		frame.setResizable(false);
		añadir();
		frame.add(panelLabels);
		frame.pack();
		frame.setVisible(true);
	}

}
