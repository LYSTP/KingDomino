package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalteaTurnoListener implements ActionListener {

	private static String preciono;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Has pulsado el botón " + e.getActionCommand());
		setPreciono(e.getActionCommand());
	}

	public static String getPreciono() {
		return preciono;
	}

	public static void setPreciono(String preciono) {
		SalteaTurnoListener.preciono = preciono;
	}

}
