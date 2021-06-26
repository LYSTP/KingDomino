package swing;

import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import clases.Baraja;
import clases.Jugador;

public class ConsolaVista extends JPanel {
	private JTextArea textArea_1;
	private JTextArea mensajePosicion;
	private JTextArea mensajeGanador;
	private JButton bSaltearTurno;

	public ConsolaVista() throws IOException {
		textArea_1 = new JTextArea();
		mensajePosicion = new JTextArea();
		mensajeGanador = new JTextArea();
		bSaltearTurno = new JButton("Saltear Turno");
		setBounds(getVisibleRect());
		textArea_1.setBounds(197, 54, 488, 297);
		mensajePosicion.setBounds(197, 84, 488, 297);
		mensajeGanador.setBounds(197, 104, 488, 297);
		bSaltearTurno.addActionListener(new SalteaTurnoListener());
		add(textArea_1);
		add(mensajePosicion);
		//add(mensajeGanador);
		//add(bSaltearTurno);
		textArea_1.setEditable(false);
		mensajePosicion.setEditable(false);
	}

	public void jugadorTurno(Jugador jugador, Baraja baraja) {
		textArea_1.setText("");
		textArea_1.append("KINGDOMINO\n\n");
		textArea_1.append("Cantidad Dominos en baraja: " + baraja.getSizeDominos() + "\n\n");
		textArea_1.append("Turno del jugador: " + jugador.getId() + " " + jugador.getNombre() + "\n\n");
		if (jugador.getId() == 1) {
			textArea_1.append("Tablero IZQUIERDO" + "\n\n");
		} else {
			textArea_1.append("Tablero DERECHO" + "\n\n");
		}
		textArea_1.append("Elegir uno de los lados de los dominos disponibles para colocar");
	}

	public void mensajeDominoElemento(String string) {
		mensajePosicion.setText("");
		mensajePosicion.append(string);
	}

	public void limpiaConsola() {
		textArea_1.setText("");
		mensajePosicion.setText("");
		add(mensajePosicion);
	}

	public void mostrarGanador(List<Jugador> ganadores) {
		if (ganadores != null && !ganadores.isEmpty()) {
			mensajeGanador.append("El ganador es: " + ganadores.get(0));
			add(mensajeGanador);
		}
	}

}
