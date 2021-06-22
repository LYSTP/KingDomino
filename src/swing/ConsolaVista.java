package swing;

import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import clases.Jugador;

public class ConsolaVista extends JPanel {
	private JTextArea textArea_1;
	private JTextArea mensajePosicion;

	public ConsolaVista() throws IOException {
		textArea_1 = new JTextArea();
		mensajePosicion = new JTextArea();
		setBounds(getVisibleRect());	
		textArea_1.setBounds(197, 54, 488, 297);
		mensajePosicion.setBounds(197, 84, 488, 297);
		add(textArea_1);
		add(mensajePosicion);
		textArea_1.setEditable(false);
		mensajePosicion.setEditable(false);
	}
	
	public void jugadorTurno(Jugador jugador) {	
		textArea_1.setText("");
		textArea_1.append("Turno del jugador: " + jugador.getId() + " " + jugador.getNombre() + "\n");
		textArea_1.append("Su tablero es el primero de la izquierda: " + "\n");
		textArea_1.append("Elegir elemento izquierdo de uno de los dominos disponibles");
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
	
	
}
