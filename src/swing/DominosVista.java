package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class DominosVista extends JPanel {

	private static final long serialVersionUID = 7659175651817738201L;
//	JButton[] dominos = new JButton[11];

	public DominosVista() throws IOException {
		setBounds(getVisibleRect());
		setLayout(new GridLayout(4, 2));
		createButtonPanel();
	}

	public void createButtonPanel() throws IOException {
		Image imgCastillo = ImageIO.read(new File("DominoImg/Castillo.png"));
		Image imgVacio = ImageIO.read(new File("DominoImg/Vacio.png"));
		// Color cuando se hace focus en algun elemento del tipo button, cuando hace
		// click con el mouse
		UIManager.put("Button.focus", Color.red);

		// Carga con imagen vacio y en el centro con la imagen castillo
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				JButton temp = new JButton();
				Image newimg = imgCastillo.getScaledInstance(290, 220, java.awt.Image.SCALE_SMOOTH);
				temp.setIcon(new ImageIcon(newimg));
				add(temp);
			}
		}
	}
}
