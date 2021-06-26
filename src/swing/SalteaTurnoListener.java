package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clases.Ronda;

public class SalteaTurnoListener implements ActionListener {

	private static boolean preciono;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Has pulsado el botón " + e.getActionCommand());
		setPreciono(true);
	}

	public static boolean getPreciono() {
		return preciono;
	}

	public static void setPreciono(boolean preciono) {
		SalteaTurnoListener.preciono = preciono;
	}

}
