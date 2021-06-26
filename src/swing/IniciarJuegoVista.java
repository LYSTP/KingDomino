package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Jugador;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class IniciarJuegoVista {

	private JFrame frame;

	public IniciarJuegoVista() {

	}

	public void bienvenida() {
		frame = new JFrame("Kingdomino");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		panel.setLayout(null);

		JLabel jugador1Label = new JLabel("Jugador 1");
		jugador1Label.setBounds(10, 10, 80, 25);
		panel.add(jugador1Label);

		JTextField jugador1Text = new JTextField(20);
		jugador1Text.setBounds(100, 10, 160, 25);
		panel.add(jugador1Text);

		JLabel jugador2Label = new JLabel("Jugador 2");
		jugador2Label.setBounds(10, 40, 80, 25);
		panel.add(jugador2Label);

		JTextField jugador2Text = new JTextField(20);
		jugador2Text.setBounds(100, 40, 160, 25);
		panel.add(jugador2Text);

		JButton loginButton = new JButton("Iniciar partida");

		List<Jugador> jugadores = new ArrayList<Jugador>();

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugadores.add(new Jugador(1, jugador1Text.getText()));
				jugadores.add(new Jugador(2, jugador2Text.getText()));
				frame.dispose();
			}
		});
		loginButton.setBounds(10, 80, 250, 25);
		panel.add(loginButton);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new IniciarJuegoVista().bienvenida();
	}
}
