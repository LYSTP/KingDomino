package swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VentanaSala extends JPanel {

	private static final long serialVersionUID = -2788412693894132693L;

	public VentanaSala() throws IOException {
		setPreferredSize(new Dimension(1920, 600));
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		setLayout(new GridLayout(1, 2, 50, 0));
		add(new TableroVista());
		add(new TableroVista());
	}
}
