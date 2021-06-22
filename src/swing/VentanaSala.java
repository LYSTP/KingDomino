package swing;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import clases.Domino;
import clases.Jugador;

public class VentanaSala extends JPanel {

	private static final long serialVersionUID = -2788412693894132693L;
	
	private ConsolaVista cv = new ConsolaVista();

	public VentanaSala(List<Domino> mano, List<Jugador> jugadores) throws IOException {
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		setLayout(new GridLayout(1, 4, 50, 50));
		add(new TableroVista(jugadores.get(0)));
		add(new TableroVista(jugadores.get(1)));
		add(new DominosVista(mano));
		add(cv);
	}

	public ConsolaVista getCv() {
		return cv;
	}

	public void setCv(ConsolaVista cv) {
		this.cv = cv;
	}
	
}
