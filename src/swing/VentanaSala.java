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
	private DominosVista dominoVista;
	private TableroVista tablero_1;
	private TableroVista tablero_2;

	public VentanaSala(List<Domino> mano, List<Jugador> jugadores) throws IOException {
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		setLayout(new GridLayout(1, 4, 50, 50));
		add(tablero_1 = new TableroVista(jugadores.get(0)));
		add(tablero_2 = new TableroVista(jugadores.get(1)));
		add(setDominoVista(new DominosVista(mano)));
		add(cv);
	}

	public ConsolaVista getCv() {
		return cv;
	}

	public void setCv(ConsolaVista cv) {
		this.cv = cv;
	}

	public DominosVista getDominoVista() {
		return dominoVista;
	}

	public DominosVista setDominoVista(DominosVista dominoVista) {
		this.dominoVista = dominoVista;
		return dominoVista;
	}

	public TableroVista getTablero_1() {
		return tablero_1;
	}

	public void setTablero_1(TableroVista tablero_1) {
		this.tablero_1 = tablero_1;
	}

	public TableroVista getTablero_2() {
		return tablero_2;
	}

	public void setTablero_2(TableroVista tablero_2) {
		this.tablero_2 = tablero_2;
	}

	
}
