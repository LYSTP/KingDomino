package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonPulsadoListener implements ActionListener {
	
	private static String numeroBoton;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Has pulsado el botón " + e.getActionCommand());
		try {
			Thread.sleep(200);
			numeroBoton = e.getActionCommand();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static String getNumeroBoton() {
		return numeroBoton;
	}

	public void setNumeroBoton(String numeroBoton) {
		this.numeroBoton = numeroBoton;
	}

}
