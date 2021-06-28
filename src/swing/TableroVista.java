package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import clases.Baraja;
import clases.Jugador;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableroVista extends JPanel {

	private static final long serialVersionUID = 4208840669646898662L;
	private JTextArea textArea_1;

	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22,
			b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43,
			b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54, b55, b56, b57, b58, b59, b60, b61, b62, b63, b64,
			b65, b66, b67, b68, b69, b70, b71, b72, b73, b74, b75, b76, b77, b78, b79, b80, b81;

	List<JButton> posicionTablero = new ArrayList<JButton>();

	Map<String, String> mapPosiciones = new HashMap<String, String>();

	private static Border grid1Border;

	public TableroVista(Jugador jugador) throws IOException {
		// setBackground(Color.BLACK);

		mapPosiciones.put("0, 0", "0");
		mapPosiciones.put("0, 1", "1");
		mapPosiciones.put("0, 2", "2");
		mapPosiciones.put("0, 3", "3");
		mapPosiciones.put("0, 4", "4");
		mapPosiciones.put("0, 5", "5");
		mapPosiciones.put("0, 6", "6");
		mapPosiciones.put("0, 7", "7");
		mapPosiciones.put("0, 8", "8");

		mapPosiciones.put("1, 0", "9");
		mapPosiciones.put("1, 1", "10");
		mapPosiciones.put("1, 2", "11");
		mapPosiciones.put("1, 3", "12");
		mapPosiciones.put("1, 4", "13");
		mapPosiciones.put("1, 5", "14");
		mapPosiciones.put("1, 6", "15");
		mapPosiciones.put("1, 7", "16");
		mapPosiciones.put("1, 8", "17");

		mapPosiciones.put("2, 0", "18");
		mapPosiciones.put("2, 1", "19");
		mapPosiciones.put("2, 2", "20");
		mapPosiciones.put("2, 3", "21");
		mapPosiciones.put("2, 4", "22");
		mapPosiciones.put("2, 5", "23");
		mapPosiciones.put("2, 6", "24");
		mapPosiciones.put("2, 7", "25");
		mapPosiciones.put("2, 8", "26");

		mapPosiciones.put("3, 0", "27");
		mapPosiciones.put("3, 1", "28");
		mapPosiciones.put("3, 2", "29");
		mapPosiciones.put("3, 3", "30");
		mapPosiciones.put("3, 4", "31");
		mapPosiciones.put("3, 5", "32");
		mapPosiciones.put("3, 6", "33");
		mapPosiciones.put("3, 7", "34");
		mapPosiciones.put("3, 8", "35");

		mapPosiciones.put("4, 0", "36");
		mapPosiciones.put("4, 1", "37");
		mapPosiciones.put("4, 2", "38");
		mapPosiciones.put("4, 3", "39");
		mapPosiciones.put("4, 4", "40");
		mapPosiciones.put("4, 5", "41");
		mapPosiciones.put("4, 6", "42");
		mapPosiciones.put("4, 7", "43");
		mapPosiciones.put("4, 8", "44");

		mapPosiciones.put("5, 0", "45");
		mapPosiciones.put("5, 1", "46");
		mapPosiciones.put("5, 2", "47");
		mapPosiciones.put("5, 3", "48");
		mapPosiciones.put("5, 4", "49");
		mapPosiciones.put("5, 5", "50");
		mapPosiciones.put("5, 6", "51");
		mapPosiciones.put("5, 7", "52");
		mapPosiciones.put("5, 8", "53");

		mapPosiciones.put("6, 0", "54");
		mapPosiciones.put("6, 1", "55");
		mapPosiciones.put("6, 2", "56");
		mapPosiciones.put("6, 3", "57");
		mapPosiciones.put("6, 4", "58");
		mapPosiciones.put("6, 5", "59");
		mapPosiciones.put("6, 6", "60");
		mapPosiciones.put("6, 7", "61");
		mapPosiciones.put("6, 8", "62");

		mapPosiciones.put("7, 0", "63");
		mapPosiciones.put("7, 1", "64");
		mapPosiciones.put("7, 2", "65");
		mapPosiciones.put("7, 3", "66");
		mapPosiciones.put("7, 4", "67");
		mapPosiciones.put("7, 5", "68");
		mapPosiciones.put("7, 6", "69");
		mapPosiciones.put("7, 7", "70");
		mapPosiciones.put("7, 8", "71");

		mapPosiciones.put("8, 0", "72");
		mapPosiciones.put("8, 1", "73");
		mapPosiciones.put("8, 2", "74");
		mapPosiciones.put("8, 3", "75");
		mapPosiciones.put("8, 4", "76");
		mapPosiciones.put("8, 5", "77");
		mapPosiciones.put("8, 6", "78");
		mapPosiciones.put("8, 7", "79");
		mapPosiciones.put("8, 8", "80");

		b1 = new JButton("0, 0");
		b2 = new JButton("0, 1");
		b3 = new JButton("0, 2");
		b4 = new JButton("0, 3");
		b5 = new JButton("0, 4");
		b6 = new JButton("0, 5");
		b7 = new JButton("0, 6");
		b8 = new JButton("0, 7");
		b9 = new JButton("0, 8");

		b10 = new JButton("1, 0");
		b11 = new JButton("1, 1");
		b12 = new JButton("1, 2");
		b13 = new JButton("1, 3");
		b14 = new JButton("1, 4");
		b15 = new JButton("1, 5");
		b16 = new JButton("1, 6");
		b17 = new JButton("1, 7");
		b18 = new JButton("1, 8");

		b19 = new JButton("2, 0");
		b20 = new JButton("2, 1");
		b21 = new JButton("2, 2");
		b22 = new JButton("2, 3");
		b23 = new JButton("2, 4");
		b24 = new JButton("2, 5");
		b25 = new JButton("2, 6");
		b26 = new JButton("2, 7");
		b27 = new JButton("2, 8");

		b28 = new JButton("3, 0");
		b29 = new JButton("3, 1");
		b30 = new JButton("3, 2");
		b31 = new JButton("3, 3");
		b32 = new JButton("3, 4");
		b33 = new JButton("3, 5");
		b34 = new JButton("3, 6");
		b35 = new JButton("3, 7");
		b36 = new JButton("3, 8");

		b37 = new JButton("4, 0");
		b38 = new JButton("4, 1");
		b39 = new JButton("4, 2");
		b40 = new JButton("4, 3");
		b41 = new JButton("4, 4");
		b42 = new JButton("4, 5");
		b43 = new JButton("4, 6");
		b44 = new JButton("4, 7");
		b45 = new JButton("4, 8");

		b46 = new JButton("5, 0");
		b47 = new JButton("5, 1");
		b48 = new JButton("5, 2");
		b49 = new JButton("5, 3");
		b50 = new JButton("5, 4");
		b51 = new JButton("5, 5");
		b52 = new JButton("5, 6");
		b53 = new JButton("5, 7");
		b54 = new JButton("5, 8");

		b55 = new JButton("6, 0");
		b56 = new JButton("6, 1");
		b57 = new JButton("6, 2");
		b58 = new JButton("6, 3");
		b59 = new JButton("6, 4");
		b60 = new JButton("6, 5");
		b61 = new JButton("6, 6");
		b62 = new JButton("6, 7");
		b63 = new JButton("6, 8");

		b64 = new JButton("7, 0");
		b65 = new JButton("7, 1");
		b66 = new JButton("7, 2");
		b67 = new JButton("7, 3");
		b68 = new JButton("7, 4");
		b69 = new JButton("7, 5");
		b70 = new JButton("7, 6");
		b71 = new JButton("7, 7");
		b72 = new JButton("7, 8");

		b73 = new JButton("8, 0");
		b74 = new JButton("8, 1");
		b75 = new JButton("8, 2");
		b76 = new JButton("8, 3");
		b77 = new JButton("8, 4");
		b78 = new JButton("8, 5");
		b79 = new JButton("8, 6");
		b80 = new JButton("8, 7");
		b81 = new JButton("8, 8");

		posicionTablero.add(b1);
		posicionTablero.add(b2);
		posicionTablero.add(b3);
		posicionTablero.add(b4);
		posicionTablero.add(b5);
		posicionTablero.add(b6);
		posicionTablero.add(b7);
		posicionTablero.add(b8);
		posicionTablero.add(b9);
		posicionTablero.add(b10);
		posicionTablero.add(b11);
		posicionTablero.add(b12);
		posicionTablero.add(b13);
		posicionTablero.add(b14);
		posicionTablero.add(b15);
		posicionTablero.add(b16);
		posicionTablero.add(b17);
		posicionTablero.add(b18);
		posicionTablero.add(b19);
		posicionTablero.add(b20);
		posicionTablero.add(b21);
		posicionTablero.add(b22);
		posicionTablero.add(b23);
		posicionTablero.add(b24);
		posicionTablero.add(b25);
		posicionTablero.add(b26);
		posicionTablero.add(b27);
		posicionTablero.add(b28);
		posicionTablero.add(b29);
		posicionTablero.add(b30);
		posicionTablero.add(b31);
		posicionTablero.add(b32);
		posicionTablero.add(b33);
		posicionTablero.add(b34);
		posicionTablero.add(b35);
		posicionTablero.add(b36);
		posicionTablero.add(b37);
		posicionTablero.add(b38);
		posicionTablero.add(b39);
		posicionTablero.add(b40);
		posicionTablero.add(b41);
		posicionTablero.add(b42);
		posicionTablero.add(b43);
		posicionTablero.add(b44);
		posicionTablero.add(b45);
		posicionTablero.add(b46);
		posicionTablero.add(b47);
		posicionTablero.add(b48);
		posicionTablero.add(b49);
		posicionTablero.add(b50);
		posicionTablero.add(b51);
		posicionTablero.add(b52);
		posicionTablero.add(b53);
		posicionTablero.add(b54);
		posicionTablero.add(b55);
		posicionTablero.add(b56);
		posicionTablero.add(b57);
		posicionTablero.add(b58);
		posicionTablero.add(b59);
		posicionTablero.add(b60);
		posicionTablero.add(b61);
		posicionTablero.add(b62);
		posicionTablero.add(b63);
		posicionTablero.add(b64);
		posicionTablero.add(b65);
		posicionTablero.add(b66);
		posicionTablero.add(b67);
		posicionTablero.add(b68);
		posicionTablero.add(b69);
		posicionTablero.add(b70);
		posicionTablero.add(b71);
		posicionTablero.add(b72);
		posicionTablero.add(b73);
		posicionTablero.add(b74);
		posicionTablero.add(b75);
		posicionTablero.add(b76);
		posicionTablero.add(b77);
		posicionTablero.add(b78);
		posicionTablero.add(b79);
		posicionTablero.add(b80);
		posicionTablero.add(b81);

		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		CompoundBorder line = new CompoundBorder(empty, blackLine);

		grid1Border = BorderFactory.createTitledBorder(line,
				"Tablero del jugador: " + jugador.getId() + " " + jugador.getNombre());

		setLayout(new GridLayout(9, 9));
		setSize(new Dimension(100, 10));
		createButtonPanel();
		setBorder(grid1Border);

		setLayout(new GridLayout(9, 9));
		setSize(new Dimension(100, 10));
		createButtonPanel();
	}

	public void createButtonPanel() throws IOException {
		Image imgCastillo = ImageIO.read(new File("DominoImg/castillo.png"));
		Image imgVacio = ImageIO.read(new File("DominoImg/vacio.png"));
		Image newimgCastillo = imgCastillo.getScaledInstance(100, 110, java.awt.Image.SCALE_SMOOTH);
		Image newimgVacio = imgVacio.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

		// Color cuando se hace focus en algun elemento del tipo button, cuando hace
		// click con el mouse
		UIManager.put("Button.focus", Color.red);

		int posicion = 0;

		// Carga con imagen vacio y en el centro con la imagen castillo
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				posicionTablero.get(posicion).setPreferredSize(new Dimension(30, 30));

				posicionTablero.get(posicion).setIcon(new ImageIcon(newimgVacio));
				posicionTablero.get(posicion).addActionListener(new PosicionTableroListener());

				if (i == 4 && j == 4) {

					posicionTablero.get(posicion).setIcon(new ImageIcon(newimgCastillo));
				}

				add(posicionTablero.get(posicion));
				posicion++;
			}
		}
	}

	public void setearNoDisponible(int i, int j) {

		Image imgNoDispo;
		try {
			imgNoDispo = ImageIO.read(new File("DominoImgTablero/No_Disponible.png"));

			Image imgNoDisponible = imgNoDispo.getScaledInstance(75, 110, java.awt.Image.SCALE_SMOOTH);

			String cordenada = j + ", " + i;

			posicionTablero.get(Integer.parseInt(mapPosiciones.get(cordenada))).setIcon(new ImageIcon(imgNoDisponible));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void jugadorTurno(Jugador jugador) {

		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border greenLine = BorderFactory.createLineBorder(Color.GREEN,2);
		CompoundBorder line = new CompoundBorder(empty, greenLine);

		grid1Border = BorderFactory.createTitledBorder(line,
				"Tablero del jugador: " + jugador.getId() + " " + jugador.getNombre() + " | " + " Turno");

		setBorder(grid1Border);
	}
	
	//Limpia rotulo Turno
	public void jugadorFinTurno(Jugador jugador) {

		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		CompoundBorder line = new CompoundBorder(empty, blackLine);

		grid1Border = BorderFactory.createTitledBorder(line,
				"Tablero del jugador: " + jugador.getId() + " " + jugador.getNombre());

		setBorder(grid1Border);
	}

	public List<JButton> getPosicionTablero() {
		return posicionTablero;
	}

	public void setPosicionTablero(List<JButton> posicionTablero) {
		this.posicionTablero = posicionTablero;
	}

	public Map<String, String> getMapPosiciones() {
		return mapPosiciones;
	}

	public void setMapPosiciones(Map<String, String> mapPosiciones) {
		this.mapPosiciones = mapPosiciones;
	}

}
