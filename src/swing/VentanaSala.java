package swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VentanaSala extends JPanel {

	private static final long serialVersionUID = -2788412693894132693L;

	public VentanaSala() throws IOException {
		setPreferredSize(new Dimension(800, 600));
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		setLayout(new GridLayout(1, 3, 50, 50));
		add(new TableroVista());
		add(new TableroVista());
		add(new DominosVista());
	}
}
