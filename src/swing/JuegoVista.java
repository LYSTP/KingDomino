package swing;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JuegoVista {
	
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JFrame frame = new JFrame();
	JPanel panelContainer = new JPanel();
	
	public JuegoVista() throws IOException {
		inicializarFrame();	
	}
	
	public static void main(String[] args) throws IOException {
		new JuegoVista();
	}
	
	private void addComponentes() throws IOException {
		panelContainer.add(new VentanaSala(), "3");
	}

	private void inicializarFrame() throws IOException {
		panelContainer.setLayout(cardLayout);
		frame.setTitle("Kindomino");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension del frame con la cual los elementos del tipo boton que forman la matriz muestran bien la imagen
		frame.getContentPane().setPreferredSize(new Dimension(1800,960));
		frame.setSize(500, 303);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		addComponentes();
		frame.add(panelContainer);
		frame.pack();
		frame.setVisible(true);
	}

}
