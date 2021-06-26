package swing;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import clases.Jugador;

import java.awt.BorderLayout;
import java.awt.TextArea;

public class VentanaGanador {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new VentanaGanador(null);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaGanador( List<Jugador> ganadores) {
		initialize(ganadores);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VentanaGanador window = new VentanaGanador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(List<Jugador> ganadores) {
		frame = new JFrame();
		frame.setBounds(700, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		//textArea.setText("El ganador es el jugador: " + ganadores.get(0).getNombre() + "Puntaje final: " + ganadores.get(0).getPuntos());
		textArea.setText("El ganador es el jugador: ");
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
	}

}
