package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PosicionTableroListener implements ActionListener {

	private static String numeroBoton;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Has pulsado el botón " + e.getActionCommand());
		numeroBoton = e.getActionCommand();
	}

	public static String getNumeroBoton() {
		return numeroBoton;
	}

	public static  void setNumeroBoton(String numeroBoton) {
		numeroBoton = numeroBoton;
	}

}