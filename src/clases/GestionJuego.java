package clases;

public class GestionJuego {
	
	public static void main(String[] args) {
		Jugador j1 = new Jugador(1,"Jose");
		Jugador j2 = new Jugador(2,"Juan");
		
		Sala sala = new Sala("Duelo 2vs2", j1);
		sala.agregarJugador(j2);
				
		Juego juego = new Juego(sala);
		
		
	}
	
	
}
