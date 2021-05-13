import java.util.List;

public class Partida {
	private List<Sala> salas;

	/// public void crearSala()
	public boolean verificarParticipantes(int cantidadParticipantes) {
		return cantidadParticipantes >= 2 && cantidadParticipantes <= 4 ? true : false;
	}

	public boolean inciarPartida(Sala s) {
		if(verificarParticipantes(s.getCantPartipantes())) {
			System.out.println("---PARTIDA INICIADA CORRECTAMENTE----");
			return true;
		}
			
		else {
			System.out.println("---LA PARTIDA NO SE PUDO INICIAR----");
			return false;
		}
		    
	}



}
