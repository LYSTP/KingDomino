package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import clases.Baraja;
import clases.Domino;
import clases.Jugador;

public class DominosVista extends JPanel {

	private static final long serialVersionUID = 7659175651817738201L;
	List<Domino> mano;

	private String elementoIzquierdo;
	private String elementoDerecho;

	List<String> elementosLista = null;

	private JButton b1, b2, b3, b4, b5, b6, b7, b8;
	private JButton b12, b22, b33, b44, b55, b66, b77, b88;
	List<JButton> dominosAelegir = new ArrayList<JButton>();
	List<JButton> dominosTablero = new ArrayList<JButton>();

	private static Border grid1Border;

	public DominosVista(List<Domino> mano) throws IOException {
		setBounds(getVisibleRect());
		setLayout(new GridLayout(4, 2));
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");

		dominosAelegir.add(b1);
		dominosAelegir.add(b2);
		dominosAelegir.add(b3);
		dominosAelegir.add(b4);
		dominosAelegir.add(b5);
		dominosAelegir.add(b6);
		dominosAelegir.add(b7);
		dominosAelegir.add(b8);

		b12 = new JButton("1");
		b22 = new JButton("2");
		b33 = new JButton("3");
		b44 = new JButton("4");
		b55 = new JButton("5");
		b66 = new JButton("6");
		b77 = new JButton("7");
		b88 = new JButton("8");

		dominosTablero.add(b12);
		dominosTablero.add(b22);
		dominosTablero.add(b33);
		dominosTablero.add(b44);
		dominosTablero.add(b55);
		dominosTablero.add(b66);
		dominosTablero.add(b77);
		dominosTablero.add(b88);
		/*
		 * dominosTablero = new ArrayList<JButton>(dominosAelegir);
		 * dominosTablero.addAll(dominosAelegir);
		 */

		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		CompoundBorder line = new CompoundBorder(empty, blackLine);

		grid1Border = BorderFactory.createTitledBorder(line, "Dominos Disponibles");

		this.mano = mano;
		createButtonPanel();

		setBorder(grid1Border);
	}

	public void cargarDominosDisponibles(List<Domino> mano) {

		List<String> elementos = new ArrayList<>();

		for (Domino domino : mano) {

			elementoIzquierdo = domino.getElemIzquierdo().getDescripcion().toLowerCase() + "_"
					+ Integer.toString(domino.getElemIzquierdo().getCoronas());
			elementoDerecho = domino.getElemDerecho().getDescripcion().toLowerCase() + "_"
					+ Integer.toString(domino.getElemDerecho().getCoronas());

			elementos.add(elementoIzquierdo);
			elementos.add(elementoDerecho);

		}

		this.elementosLista = elementos;
	}

	public void createButtonPanel() throws IOException {
		String ruta, ruta_2;

		cargarDominosDisponibles(this.mano);

		// Color cuando se hace focus en algun elemento del tipo button, cuando hace
		UIManager.put("Button.focus", Color.red);
		int posElem = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {

				ruta = "DominoImg/" + this.elementosLista.get(posElem) + ".png";

				Image elementoDomino = ImageIO.read(new File(ruta));

				Image newimg = elementoDomino.getScaledInstance(310, 240, java.awt.Image.SCALE_SMOOTH);
				dominosAelegir.get(posElem).setIcon(new ImageIcon(newimg));
				dominosAelegir.get(posElem).addActionListener(new BotonPulsadoListener());

				add(dominosAelegir.get(posElem));

				// Para colocar elemento seleccioando en tablero
				ruta_2 = "DominoImgTablero/" + this.elementosLista.get(posElem) + ".png";
				Image elementoDominoTablero = ImageIO.read(new File(ruta_2));
				Image imgDominoTablero = elementoDominoTablero.getScaledInstance(100, 110, java.awt.Image.SCALE_SMOOTH);
				dominosTablero.get(posElem).setIcon(new ImageIcon(imgDominoTablero));

				posElem++;
				repaint();

			}

		}
	}

	public void retiraDominoElegido(int posicionImagen) {

		Image imgVacio;
		try {
			imgVacio = ImageIO.read(new File("DominoImg/vacio.png"));

			Image newimg = imgVacio.getScaledInstance(310, 240, java.awt.Image.SCALE_SMOOTH);

			this.dominosAelegir.get(posicionImagen).setIcon(new ImageIcon(newimg));

			if (posicionImagen == 0 || posicionImagen % 2 == 0) {

				this.dominosAelegir.get(posicionImagen + 1).setIcon(new ImageIcon(newimg));

			} else {
				this.dominosAelegir.get(posicionImagen - 1).setIcon(new ImageIcon(newimg));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cantidadBaraja(Baraja baraja) {

		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		CompoundBorder line = new CompoundBorder(empty, blackLine);

		grid1Border = BorderFactory.createTitledBorder(line, "Dominos Disponibles" + " | " + "Dominos en baraja: " + baraja.getSizeDominos());

		setBorder(grid1Border);
	}
	
	public void mostrarGanador(List<Jugador> ganadores) {
		JOptionPane.showMessageDialog(this, "El ganador es el jugador: " + ganadores.get(0).getNombre() + " con " + ganadores.get(0).getTablero().getPuntos() + " puntos");		
	}

	public void recargarDominos() throws IOException {
		createButtonPanel();
	}

	public List<JButton> getDominosAelegir() {
		return dominosAelegir;
	}

	public void setDominosAelegir(List<JButton> dominosAelegir) {
		this.dominosAelegir = dominosAelegir;
	}

	public List<JButton> getDominosTablero() {
		return dominosTablero;
	}

	public void setDominosTablero(List<JButton> dominosTablero) {
		this.dominosTablero = dominosTablero;
	}

	public List<Domino> getMano() {
		return mano;
	}

	public void setMano(List<Domino> mano) {
		this.mano = mano;
	}

}
