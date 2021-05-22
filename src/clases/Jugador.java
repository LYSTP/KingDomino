package clases;

public class Jugador {
	private int id;
	private String nombre;
	private boolean esTurno = false;
	private int puntos = 0;
	
		
	public Jugador(int id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}
	
	public void setTurno(boolean val) {
		this.esTurno = val;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
