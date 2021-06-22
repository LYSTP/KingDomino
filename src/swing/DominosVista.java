package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import clases.Domino;

public class DominosVista extends JPanel {

	private static final long serialVersionUID = 7659175651817738201L;
	List<Domino> mano;

	private String elementoIzquierdo;
	private String elementoDerecho;
	
	List<String> elementosLista = null;
	
	
	private JButton b1, b2, b3, b4, b5, b6, b7, b8;
	List<JButton> dominosAelegir = new ArrayList<JButton>();
	
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

		
		this.mano = mano;
		createButtonPanel();
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
		String ruta;

		cargarDominosDisponibles(this.mano);

		// Color cuando se hace focus en algun elemento del tipo button, cuando hace
		UIManager.put("Button.focus", Color.red);
		int posElem = 0;

		// Carga con imagen vacio y en el centro con la imagen castillo
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {

				ruta = "DominoImg/" + this.elementosLista.get(posElem) + ".png";

				Image elementoDomino = ImageIO.read(new File(ruta));
				
				Image newimg = elementoDomino.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH);
				dominosAelegir.get(posElem).setIcon(new ImageIcon(newimg));
				dominosAelegir.get(posElem).addActionListener(new BotonPulsadoListener());
				
				add(dominosAelegir.get(posElem));	
				
				posElem++;
				
			}
			
		}
	}
	
	
}
