package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class TableroVista extends JPanel {

	private static final long serialVersionUID = 4208840669646898662L;
//	JButton[][] tablero = new JButton[9][9];

	public TableroVista() throws IOException {
		setBackground(Color.BLACK);
		setLayout(new GridBagLayout());
		setSize(new Dimension(100, 10));
		createButtonPanel();
	}

	public void createButtonPanel() throws IOException {
		Image imgCastillo = ImageIO.read(new File("DominoImg/Castillo.png"));
		Image imgVacio = ImageIO.read(new File("DominoImg/Vacio.png"));
		// Color cuando se hace focus en algun elemento del tipo button, cuando hace
		// click con el mouse
		UIManager.put("Button.focus", Color.red);

		// Carga con imagen vacio y en el centro con la imagen castillo
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JButton temp = new JButton();
				temp.setPreferredSize(new Dimension(30, 30));
				temp.setIcon(new ImageIcon(imgVacio));
				if (i == 4 && j == 4) {
					temp.setIcon(new ImageIcon(imgCastillo));
				}

				add(temp);
			}
		}
	}
}
